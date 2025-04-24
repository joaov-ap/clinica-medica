package br.com.vidaplena.service;

import br.com.vidaplena.exception.EmailInvalidoException;
import br.com.vidaplena.model.EspecialidadeMedico;
import br.com.vidaplena.model.Medico;
import br.com.vidaplena.util.ArquivoUtils;
import br.com.vidaplena.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MedicoService {
    private final Scanner input = new Scanner(System.in);
    private List<Medico> medicos = new ArrayList<>();
    private final String MEDICOS_FOLDER = "src/br/com/vidaplena/data/medicos";

    public void menuMedico() {
        int userInput;
        do {
            System.out.println();
            System.out.println("======== Menu de Medicos ========");
            System.out.println("1 - Cadastrar Medico");
            System.out.println("2 - Editar Medico");
            System.out.println("3 - Excluir Medico");
            System.out.println("4 - Listar Medicos");
            System.out.println("5 - Buscar Medico por CRM");
            System.out.println("0 - Sair");
            System.out.print("Escolha sua opcao: ");

            userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (userInput) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    registerMedico();
                    break;
                case 2:
                    editMedico();
                    break;
                case 3:
                    deleteMedico();
                    break;
                case 4:
                    showMedicos();
                    break;
                case 5:
                    searchMedicoByCrm();
                    break;
                default:
                    System.out.println("Opcao Inválida.");
            }
        } while (userInput != 0);
    }

    private void registerMedico() {
        System.out.print("Digite o nome: ");
        String nome = input.nextLine();
        System.out.print("Digite o CRM (000000-00/UF ou 00000000UF): ");
        String crm = input.nextLine();

        if (!isCrmValid(crm)) {
            throw new IllegalArgumentException("CRM Inválido.");
        }

        List<EspecialidadeMedico> especialidades = especialidadeSelector();

        System.out.print("Digite o telefone: ");
        String telefone = input.nextLine();
        System.out.print("Digite o email: ");
        String email = input.nextLine();

        if (!Validator.isEmailValid(email)) {
            throw new EmailInvalidoException();
        }

        Medico medico = new Medico(nome, crm, especialidades, telefone, email);
        medicos.add(medico);
        ArquivoUtils.writeFile(MEDICOS_FOLDER, medico, medico.getNome());
        System.out.println();
        System.out.println("Medico: " + nome + ", cadastrado com sucesso.");
    }

    private void editMedico() {
        Medico medicoEscolhido = medicoSelector();

        if (medicoEscolhido != null) {
            System.out.println("====== Modo Edição ======");
            System.out.println("1 - Nome");
            System.out.println("2 - CRM");
            System.out.println("3 - Especialidades");
            System.out.println("4 - Telefone");
            System.out.println("5 - Email");
            System.out.println("0 - Sair");
            System.out.print("Escolha oque deseja editar: ");
            int editInput = input.nextInt();
            input.nextLine();

            switch (editInput) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    ArquivoUtils.deleteFile(MEDICOS_FOLDER, medicoEscolhido.getNome());
                    System.out.print("Digite o novo Nome: ");
                    String nome = input.nextLine();
                    medicoEscolhido.setNome(nome);
                    break;
                case 2:
                    System.out.print("Digite o novo CRM (000000-00/UF ou 00000000UF): ");
                    String crm = input.nextLine();
                    medicoEscolhido.setCrm(crm);
                    break;
                case 3:
                    System.out.print("Escolha as novas especialidades: ");
                    List<EspecialidadeMedico> especialidades = especialidadeSelector();
                    medicoEscolhido.setEspecialidades(especialidades);
                    break;
                case 4:
                    System.out.print("Digite o novo Telefone: ");
                    String telefone = input.nextLine();
                    medicoEscolhido.setTelefone(telefone);
                    break;
                case 5:
                    System.out.print("Digite o novo Email: ");
                    String email = input.nextLine();
                    medicoEscolhido.setEmail(email);
                    break;
                default:
                    System.out.println("Escolha inválida. Digite um número entre 1 e 5");
            }
            ArquivoUtils.writeFile(MEDICOS_FOLDER ,medicoEscolhido, medicoEscolhido.getNome());
        }
    }

    private void showMedicos() {
        if (!medicos.isEmpty()) {
            for (int i = 0; i < medicos.size(); i++) {
                System.out.println((i+1) + " - " + medicos.get(i).getNome());
            }
            return;
        }
        System.out.println("Nenhum médico encontrado.");
    }

    private void searchMedicoByCrm() {
        if (!medicos.isEmpty()) {
            System.out.print("Digite o CRM do médico (000000-00/UF ou 00000000UF): ");
            String crm = input.nextLine();
            System.out.println();
            Optional<Medico> medico = medicos.stream().filter(m -> m.getCrm().equals(crm)).findFirst();

            ArquivoUtils.readFile(MEDICOS_FOLDER, medico.get().getNome());
            return;
        }
        System.out.println("Nenhum médico encontrado");
    }

    private void deleteMedico() {
        Medico medico = medicoSelector();

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.println("Médico " + medico.getNome() + " deletado com sucesso.");
        ArquivoUtils.deleteFile(MEDICOS_FOLDER, medico.getNome());
        medicos.remove(medico);
    }

    private Medico medicoSelector() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return null;
        }

        int userInput;
        Medico medicoEscolhido = null;

        do {
            showMedicos();
            System.out.print("Digite o número do médico que deseja ou -1 para sair: ");
            userInput = input.nextInt();

            if (userInput > medicos.size() || userInput < 1) {
                System.out.println("Médico inválido. Escolha entre 1 e " + medicos.size());
            } else {
                medicoEscolhido = medicos.get(userInput - 1);
            }
        } while (userInput != 1);

        System.out.println("Saindo...");
        return medicoEscolhido;
    }

    private List<EspecialidadeMedico> especialidadeSelector() {
        List<EspecialidadeMedico> especialidadeMedicos = new ArrayList<>();
        int codigo = 0;

        do {
            System.out.println("Escolha as especialidades do Médico:");
            for (EspecialidadeMedico value : EspecialidadeMedico.values()) {
                if (value.getCodigo() == codigo) {
                    continue;
                }
                System.out.println(value.getCodigo() + " - " + value.getNomeEspecialidade());
            }
            System.out.print("Digite o número da especialidade que deseja adicionar ou -1 para sair: ");
            codigo = input.nextInt();
            input.nextLine();

            if (codigo < -1 || codigo > EspecialidadeMedico.values().length) {
                System.out.println("Codigo inválido, escolha um codigo entre 1 e " + EspecialidadeMedico.values().length);
            }

            if (codigo > 0 && codigo <= EspecialidadeMedico.values().length) {
                especialidadeMedicos.add(EspecialidadeMedico.getEspecialidade(codigo));
            }
            System.out.println();
        } while (codigo != -1);

        System.out.println("Saindo...");
        return especialidadeMedicos;
    }

    private boolean isCrmValid(String crm) {
        String regex = "^\\d{6}-?\\d{2}\\/?[A-Z]{2}$";
        boolean matches = Pattern.matches(regex, crm);
        return matches;
    }
}
