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
        return cpfDigit(splitedCpf, 1) == Integer.parseInt(splitedCpf[9]) && cpfDigit(splitedCpf, 2) == Integer.parseInt(splitedCpf[10]);
    };

    public static boolean isEmailValid(String email) {
        String regex = "([\\w\\.-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        boolean matches = Pattern.matches(regex, email);

        return matches;
    }

    private static int cpfDigit(String[] splitedCpf, int value) {
        int digit = 0;
        if (value == 1) {
            digit = Integer.valueOf(splitedCpf[0]) * 10 + Integer.valueOf(splitedCpf[1]) * 9 + Integer.valueOf(splitedCpf[2]) * 8 +
                    Integer.valueOf(splitedCpf[3]) * 7 + Integer.valueOf(splitedCpf[4]) * 6 + Integer.valueOf(splitedCpf[5]) * 5 + Integer.valueOf(splitedCpf[6]) * 4 +
                    Integer.valueOf(splitedCpf[7]) * 3 + Integer.valueOf(splitedCpf[8]) * 2;
        } else if (value == 2) {
            digit = Integer.valueOf(splitedCpf[0]) * 11 + Integer.valueOf(splitedCpf[1]) * 10 + Integer.valueOf(splitedCpf[2]) * 9 +
                    Integer.valueOf(splitedCpf[3]) * 8 + Integer.valueOf(splitedCpf[4]) * 7 + Integer.valueOf(splitedCpf[5]) * 6 + Integer.valueOf(splitedCpf[6]) * 5 +
                    Integer.valueOf(splitedCpf[7]) * 4 + Integer.valueOf(splitedCpf[8]) * 3 + Integer.valueOf(splitedCpf[9]) * 2;
        }

        digit %= 11;
        digit = 11 - digit;

        if (digit >= 10) {
            digit = 0;
        }

        return digit;
    };

}
