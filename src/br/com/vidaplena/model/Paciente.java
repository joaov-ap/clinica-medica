package br.com.vidaplena.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private String sexo;
    private String email;

    public Paciente() {
    }

    public Paciente(String nome, String cpf, String telefone, LocalDate dataNascimento, String sexo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Paciente" + "\nNome: " + this.nome + "\nCPF: "+ this.cpf + "\nTelefone: "
                + this.telefone + "\nData de Nascimento: " + this.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\nSexo: " + this.sexo + "\nEmail: " + this.email;
    }
}
