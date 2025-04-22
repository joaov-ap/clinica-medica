package br.com.vidaplena.service;

import br.com.vidaplena.exception.CpfInvalidoException;
import br.com.vidaplena.exception.EmailInvalidoException;
import br.com.vidaplena.model.Paciente;
import br.com.vidaplena.util.ArquivoUtils;
import br.com.vidaplena.util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);
    private final String PACIENTES_FOLDER = "src/br/com/vidaplena/data";

    public void cadastrarPaciente() {
        System.out.print("Digite seu Nome: ");
        String nome = input.nextLine();

        System.out.print("Digite seu CPF (000.000.000-00 ou 00000000000): ");
        String cpf = input.nextLine();

        if (!Validator.isCpfValid(cpf)) {
            throw new CpfInvalidoException();
        }

        if (isCpfDuplicated(cpf)) {
            System.out.println("Esse CPF ja esta cadastrado no sistema.");
            return;
        }

        System.out.print("Digite seu Telefone: ");
        String telefone = input.nextLine();

        System.out.print("Digite sua Data de Nascimento (00/00/0000 ou 00000000): ");
        String dataNascimento = input.nextLine();

        LocalDate dataNasc = Validator.formatedDate(dataNascimento);

        String sexo = generoSelector();

        System.out.print("Digite seu Email: ");
        String email = input.nextLine();

        if (!Validator.isEmailValid(email)) {
            throw new EmailInvalidoException();
        }

        Paciente paciente = new Paciente(nome, cpf, telefone, dataNasc, sexo, email);
        pacientes.add(paciente);
        ArquivoUtils.writeFile(PACIENTES_FOLDER ,paciente, paciente.getNome());
        System.out.println();
        System.out.println("Paciente: " + nome + ", cadastrado com sucesso.");
    }

    public void showPacientes() {
        if (!pacientes.isEmpty()) {
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println((i+1) + " - " + pacientes.get(i).getNome());
            }
            return;
        }
        System.out.println("Nenhum paciente cadastrado.");
    }

    public void searchPacienteByCpf() {
        if (!pacientes.isEmpty()) {
            System.out.print("Digite o CPF do Paciente: ");
            String cpf = input.nextLine();
            System.out.println();
            pacientes.stream().filter(p -> p.getCpf().equals(cpf)).forEach(System.out::println);
            return;
        }
        System.out.println("Nenhum paciente cadastrado.");
    }

    public void deletePaciente() {
        Paciente paciente = pacienteSelector();

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Paciente " + paciente.getNome() + " deletado com sucesso.");
        ArquivoUtils.deleteFile(PACIENTES_FOLDER, paciente.getNome());
        pacientes.remove(paciente);
    }

    public void editPaciente() {
        Paciente pacienteEscolhido = pacienteSelector();

        if (pacienteEscolhido != null) {
            System.out.println("====== Modo Edição ======");
            System.out.println("1 - Nome");
            System.out.println("2 - CPF");
            System.out.println("3 - Telefone");
            System.out.println("4 - Data de Nascimento");
            System.out.println("5 - Sexo");
            System.out.println("6 - Email");
            System.out.println("0 - Sair");
            System.out.print("Escolha oque deseja editar: ");
            int editInput = input.nextInt();
            input.nextLine();

            switch (editInput) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.print("Digite o novo Nome: ");
                    String nome = input.nextLine();
                    pacienteEscolhido.setNome(nome);
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    String cpf = input.nextLine();
                    pacienteEscolhido.setCpf(cpf);
                    break;
                case 3:
                    System.out.print("Digite o novo Telefone: ");
                    String telefone = input.nextLine();
                    pacienteEscolhido.setTelefone(telefone);
                    break;
                case 4:
                    System.out.print("Digite a nova Data de Nascimento (00/00/0000 ou 00000000): ");
                    String dataNascimento = input.nextLine();
                    LocalDate dataNasc = Validator.formatedDate(dataNascimento);
                    pacienteEscolhido.setDataNascimento(dataNasc);
                    break;
                case 5:
                    pacienteEscolhido.setSexo(generoSelector());
                    break;
                case 6:
                    System.out.print("Digite o novo Email: ");
                    String email = input.nextLine();
                    pacienteEscolhido.setEmail(email);
                    break;
                default:
                    System.out.println("Escolha inválida. Digite um número entre 1 e 6");
            }
            ArquivoUtils.writeFile(PACIENTES_FOLDER ,pacienteEscolhido, pacienteEscolhido.getNome());
        }
    }

    private boolean isCpfDuplicated(String cpf) {
        if (!pacientes.isEmpty()) {
            for (Paciente paciente : pacientes) {
                if (paciente.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }
        System.out.println("Nenhum paciente cadastrado.");
        return false;
    }

    private String generoSelector() {
        int genero;
        String sexo = "";
        do {
            System.out.println();
            System.out.println("1 - Feminino");
            System.out.println("2 - Masculino");
            System.out.println("3 - Outro");
            System.out.println("4 - Prefiro não dizer");
            System.out.print("Escolha seu Genero: ");
            genero = input.nextInt();
            input.nextLine();

            switch (genero) {
                case 1:
                    sexo = "Feminino";
                    break;
                case 2:
                    sexo = "Masculino";
                    break;
                case 3:
                    sexo = "Outro";
                    break;
                case 4:
                    sexo = "Prefiro não dizer";
                    break;
                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 4.");
            }
        } while (genero > 4);

        return sexo;
    }

    private Paciente pacienteSelector() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return null;
        }

        int userInput;;
        Paciente pacienteEscolhido = null;

        do {
            System.out.println();
            showPacientes();
            System.out.print("Digite o número do paciente que deseja ou -1 para sair: ");
            userInput = input.nextInt();

            if (userInput == -1) {
                System.out.println("Saindo...");
                return null;
            }

            pacienteEscolhido = pacientes.get(userInput - 1);

            if ((userInput-1) > pacientes.size()) {
                System.out.println("Paciente inválido. Escolha entre 1 e " + pacientes.size());
            }
        } while ((userInput-1) > pacientes.size());

        return pacienteEscolhido;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
