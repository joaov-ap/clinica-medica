package br.com.vidaplena.model;

import java.util.List;
import java.util.regex.Pattern;

public class Medico {
    private String nome;
    private String crm;
    private List<EspecialidadeMedico> especialidades;
    private String telefone;
    private String email;

    public Medico() {
    }

    public Medico(String nome, String crm, List<EspecialidadeMedico> especialidades, String telefone, String email) {
        this.nome = nome;
        this.crm = crm;
        this.especialidades = especialidades;
        this.telefone = telefone;
        this.email = email;
    }

    private boolean validaCrm(String crm) {
        String regex = "^\\d{6}-\\d{2}\\/[A-Z]{2}$";
        boolean matches = Pattern.matches(regex, crm);
        return matches;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidades=" + especialidades +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public List<EspecialidadeMedico> getEspecialidades() {
        return especialidades;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
