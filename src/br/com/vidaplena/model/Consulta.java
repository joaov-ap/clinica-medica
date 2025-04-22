package br.com.vidaplena.model;

import java.time.LocalDateTime;

public class Consulta {
    private Paciente paciente;
    private String nomeMedico;
    private String especialidade;
    private LocalDateTime dataHora;

    public Consulta() {
    }

    public Consulta(Paciente paciente, String nomeMedico, String especialidade, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "paciente=" + paciente +
                ", nomeMedico='" + nomeMedico + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
