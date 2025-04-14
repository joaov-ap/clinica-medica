package br.com.vidaplena.util;

import br.com.vidaplena.exception.CpfInvalidoException;

import java.util.regex.Pattern;

public class Validator {
    public static boolean isCpfValid(String cpf) {
        String regex = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$";
        boolean matches = Pattern.matches(regex, cpf);

        if (!matches) {
            throw new CpfInvalidoException();
        }

        String cleanCpf = cpf.replaceAll("[.-]+", "");
        String[] splitedCpf = cleanCpf.split("");
        return cpfFirstDigit(splitedCpf) == Integer.parseInt(splitedCpf[9]) && cpfSecondDigit(splitedCpf) == Integer.parseInt(splitedCpf[10]);
    };

    public static boolean isEmailValid(String email) {
        String regex = "([\\w\\.-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        boolean matches = Pattern.matches(regex, email);

        return matches;
    }

    private static int cpfFirstDigit(String[] splitedCpf) {
        int secondDigit = Integer.valueOf(splitedCpf[0]) * 10 + Integer.valueOf(splitedCpf[1]) * 9 + Integer.valueOf(splitedCpf[2]) * 8 +
                Integer.valueOf(splitedCpf[3]) * 7 + Integer.valueOf(splitedCpf[4]) * 6 + Integer.valueOf(splitedCpf[5]) * 5 + Integer.valueOf(splitedCpf[6]) * 4 +
                Integer.valueOf(splitedCpf[7]) * 3 + Integer.valueOf(splitedCpf[8]) * 2;

        secondDigit %= 11;
        secondDigit = 11 - secondDigit;

        if (secondDigit >= 10) {
            secondDigit = 0;
        }

        return secondDigit;
    };

    private static int cpfSecondDigit(String[] splitedCpf) {
        int secondDigit = Integer.valueOf(splitedCpf[0]) * 11 + Integer.valueOf(splitedCpf[1]) * 10 + Integer.valueOf(splitedCpf[2]) * 9 +
                Integer.valueOf(splitedCpf[3]) * 8 + Integer.valueOf(splitedCpf[4]) * 7 + Integer.valueOf(splitedCpf[5]) * 6 + Integer.valueOf(splitedCpf[6]) * 5 +
                Integer.valueOf(splitedCpf[7]) * 4 + Integer.valueOf(splitedCpf[8]) * 3 + Integer.valueOf(splitedCpf[9]) * 2;

        secondDigit %= 11;
        secondDigit = 11 - secondDigit;

        if (secondDigit >= 10) {
            secondDigit = 0;
        }

        return secondDigit;
    };

}
