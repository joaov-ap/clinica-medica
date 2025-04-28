package br.com.vidaplena.service;

import br.com.vidaplena.model.EspecialidadeMedico;
import br.com.vidaplena.model.Medico;
import br.com.vidaplena.model.Paciente;
import br.com.vidaplena.util.Validator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsultaService {
    private PacienteService pacienteService = new PacienteService();
    private MedicoService medicoService = new MedicoService();
    private List<Paciente> pacientes = pacienteService.getPacientes();
    private List<Medico> medicos = medicoService.getMedicos();
    private List<LocalDateTime> horariosDisponiveis = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void registerConsulta() {
        System.out.println("======== Agendamento de Consultas ========");
        System.out.print("Digite o CPF do paciente (000.000.000-00 ou 00000000000): ");
        String cpf = input.nextLine();
        Paciente paciente = getPacienteByCpf(cpf);

        Medico medico = getMedicoByEspecialidade();



    }

    private Paciente getPacienteByCpf(String cpf) {
        if (!Validator.isCpfValid(cpf)) {
            System.out.println("CPF inválido.");
            return null;
        }

        return pacientes.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().get();
    };

    private Medico getMedicoByEspecialidade() {
        int codigo;

        do {
            for (EspecialidadeMedico value : EspecialidadeMedico.values()) {
                System.out.println(value.getCodigo() + " - " + value.getNomeEspecialidade());
            }
            System.out.print("Escolha a especialidade do médico: ");
            codigo = input.nextInt();

        } while (codigo < 0 || codigo > EspecialidadeMedico.values().length);

        EspecialidadeMedico especialidade = EspecialidadeMedico.getEspecialidade(codigo);
        List<Medico> medicosFiltrados = medicos.stream()
                .filter(m -> m.getEspecialidades().contains(especialidade))
                .collect(Collectors.toList());
        if (medicosFiltrados.isEmpty()) {
            System.out.println("Nenhum médico com essa especialidade.");
            return null;
        }

        System.out.println("Médicos com Especialidade: " + especialidade);
        int userAnswer;
        do {
            int i = 1;
            for (Medico medicosFiltrado : medicosFiltrados) {
                System.out.println(i + " - " + medicosFiltrado.getNome() + " " + medicosFiltrado.getEspecialidades());
                i++;
            }

            System.out.print("Escolha um médico: ");
            userAnswer = input.nextInt();
        } while (userAnswer < 0 || userAnswer > medicosFiltrados.size());

        return medicosFiltrados.get(userAnswer-1);
    }
}

