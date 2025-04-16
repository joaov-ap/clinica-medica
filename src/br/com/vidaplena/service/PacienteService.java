package br.com.vidaplena.service;

import br.com.vidaplena.exception.CpfInvalidoException;
import br.com.vidaplena.exception.EmailInvalidoException;
import br.com.vidaplena.model.Paciente;
import br.com.vidaplena.util.Validator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public void testeArquivo() {
        Paciente paciente = cadastrarPaciente();
        pacientes.add(paciente);
        File pastaPacientes = new File("src/br/com/vidaplena/data");
        pastaPacientes.mkdir();
        File arquivoPaciente = new File(pastaPacientes,paciente.getDataNascimento()+"-"+paciente.getNome().toUpperCase().replace(" ", ""));


        try(FileWriter fileWriter = new FileWriter(arquivoPaciente);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            arquivoPaciente.createNewFile();
            bufferedWriter.write(paciente.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Paciente cadastrarPaciente() {
        System.out.print("Digite seu Nome: ");
        String nome = input.nextLine();

        System.out.print("Digite seu CPF (000.000.000-00 ou 00000000000): ");
        String cpf = input.nextLine();

        if (!Validator.isCpfValid(cpf)) {
            throw new CpfInvalidoException();
        }

        System.out.print("Digite seu Telefone: ");
        String telefone = input.nextLine();

        System.out.print("Digite sua Data de Nascimento (00/00/0000 ou 00000000): ");
        String dataNascimento = input.nextLine();

        LocalDate dataNasc = Validator.formatedDate(dataNascimento);

        System.out.println("1 - Feminino");
        System.out.println("2 - Masculino");
        System.out.println("3 - Outro");
        System.out.println("4 - Prefiro não dizer");
        System.out.print("Escolha seu Genero: ");
        int genero = input.nextInt();
        String sexo = "";
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
                break;
        }

        System.out.print("Digite seu Email: ");
        String email = input.nextLine();

        if (!Validator.isEmailValid(email)) {
            throw new EmailInvalidoException();
        }

        return new Paciente(nome, cpf, telefone, dataNasc, sexo, email);
    }

    private boolean isCpfDuplicated(String cpf) {
        if (!pacientes.isEmpty()) {
            for (Paciente paciente : pacientes) {
                if (paciente.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        return false;
    }
}
