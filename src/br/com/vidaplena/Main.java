package br.com.vidaplena;

import br.com.vidaplena.util.Validator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem Vindo a clínica Vida Plena.");

        // Teste CPF
        System.out.println(Validator.isCpfValid("145.382.206-20"));
        System.out.println(Validator.isCpfValid("145.382.206-21"));

        // Teste Email
        System.out.println();
        System.out.println(Validator.isEmailValid("luffy@gmail.com"));
        System.out.println(Validator.isEmailValid("zoro.123@hotmail.com"));
        System.out.println(Validator.isEmailValid("#!sanji@email.com.br"));
    }
}
