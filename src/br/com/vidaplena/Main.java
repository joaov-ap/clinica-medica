package br.com.vidaplena;

import br.com.vidaplena.service.PacienteService;
import br.com.vidaplena.util.ArquivoUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PacienteService pacienteService = new PacienteService();
        Scanner input = new Scanner(System.in);
        System.out.println("Bem Vindo a clínica Vida Plena.");
        ArquivoUtils.readRawPacienteFile(pacienteService.getPacientes());

        int userInput;

        do {
            System.out.println();
            System.out.println("======== Menu de Pacientes ========");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Editar Paciente");
            System.out.println("3 - Excluir Paciente");
            System.out.println("4 - Listar Pacientes");
            System.out.println("5 - Buscar Paciente por CPF");
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
                    pacienteService.cadastrarPaciente();
                    break;
                case 2:
                    pacienteService.editPaciente();
                    break;
                case 3:
                    pacienteService.deletePaciente();
                    break;
                case 4:
                    pacienteService.showPacientes();
                    break;
                case 5:
                    System.out.print("Digite o CPF do Paciente: ");
                    String cpf = input.nextLine();
                    pacienteService.searchPacienteByCpf(cpf);
                    break;
                default:
                    System.out.println("Opcao Inválida.");
            }
        } while (userInput != 0);

    }
}
