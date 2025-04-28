package br.com.vidaplena.model;

import java.util.List;

public class Medico {
    private String nome;
    private String crm;
    private List<EspecialidadeMedico> especialidades;
    private String telefone;
    private String email;
    private List<Consulta> consultas;

    public Medico() {
    }

    public Medico(String nome, String crm, List<EspecialidadeMedico> especialidades, String telefone, String email) {
        this.nome = nome;
        this.crm = crm;
        this.especialidades = especialidades;
        this.telefone = telefone;
        this.email = email;
    }

    public Medico(String nome, String crm, List<EspecialidadeMedico> especialidades, String telefone, String email, List<Consulta> consultas) {
        this(nome, crm, especialidades, telefone, email);
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Medico" +
                "\nNome: " + this.nome +
                "\nCRM: " + this.crm +
                "\nEspecialidade(s): " + this.especialidades.toString() +
                "\nTelefone: " + this.telefone +
                "\nEmail: " + this.email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<EspecialidadeMedico> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<EspecialidadeMedico> especialidades) {
        this.especialidades = especialidades;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
