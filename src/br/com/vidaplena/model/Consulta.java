package br.com.vidaplena.model;

import java.time.LocalDateTime;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private EspecialidadeMedico especialidade;
    private LocalDateTime dataHora;

    public Consulta() {
    }

    public Consulta(Paciente paciente, Medico medico, EspecialidadeMedico especialidade, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.especialidade = especialidade;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", especialidade=" + especialidade +
                ", dataHora=" + dataHora +
                '}';
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public EspecialidadeMedico getEspecialidade() {
        return especialidade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
