package br.com.vidaplena.service;

import br.com.vidaplena.exception.CpfInvalidoException;
import br.com.vidaplena.model.Paciente;
import br.com.vidaplena.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public Paciente cadastrarPaciente() {
        System.out.print("Digite seu Nome: ");
        String nome = input.nextLine();

        System.out.print("Digite seu CPF (000.000.000-00 ou 00000000000): ");
        String cpf = input.nextLine();

        if (!Validator.isCpfValid(cpf)) {
            throw new CpfInvalidoException();
        }

        System.out.print("Digite seu Telefone (DDD912345678): ");
        String telefone = input.nextLine();

        System.out.print("Digite sua Data de Nascimento (00/00/0000 ou 00000000): ");
        String dataNascimento = input.nextLine();

        System.out.println("1 - Feminino");
        System.out.println("2 - Masculino");
        System.out.println("3 - Outro");
        System.out.println("4 - Prefiro não dizer");
        System.out.print("Escolha seu Genero:");
        String genero = input.nextLine();

        System.out.print("Digite seu Email: ");
        String email = input.nextLine();

        return new Paciente();
    }

    private boolean isCpfDuplicated(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
