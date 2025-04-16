package br.com.vidaplena.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isCpfValid(String cpf) {
        String regex = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$";
        boolean matches = Pattern.matches(regex, cpf);

        String cleanCpf = cpf.replaceAll("[.-]+", "");
        String[] splitedCpf = cleanCpf.split("");
        return cpfDigit(splitedCpf, 1) == Integer.parseInt(splitedCpf[9]) && cpfDigit(splitedCpf, 2) == Integer.parseInt(splitedCpf[10]);
    }

    public static boolean isEmailValid(String email) {
        String regex = "([\\w\\.-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        boolean matches = Pattern.matches(regex, email);

        return matches;
    }

    public static LocalDate formatedDate(String date) {
        if (!isDateValid(date)) {
            throw new DateTimeException("Formato inválido. Use (00/00/0000 ou 00000000");
        }

        String dataFormatada = "";
        String[] dataSplit = date.split("");
        if (dataSplit.length == 8) {
            for (int i = 0; i < dataSplit.length; i++) {
                dataFormatada += dataSplit[i];
                if (i == 1) {
                    dataFormatada += "/";
                }

                if (i == 3) {
                    dataFormatada += "/";
                }
            }
            return LocalDate.parse(dataFormatada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        }
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static boolean isDateValid(String date) {
        String regex = "(0[\\d]|[12][\\d]|3[01])\\/?(0[\\d]|1[0,1,2])\\/?(19|20)\\d{2}";
        boolean matches = Pattern.matches(regex, date);

        return matches;
    }

    private static int cpfDigit(String[] splitedCpf, int value) {
        int digit = 0;

        switch (value) {
            case 1:
                digit = Integer.parseInt(splitedCpf[0]) * 10 + Integer.parseInt(splitedCpf[1]) * 9 + Integer.parseInt(splitedCpf[2]) * 8 +
                        Integer.parseInt(splitedCpf[3]) * 7 + Integer.parseInt(splitedCpf[4]) * 6 + Integer.parseInt(splitedCpf[5]) * 5 + Integer.parseInt(splitedCpf[6]) * 4 +
                        Integer.parseInt(splitedCpf[7]) * 3 + Integer.parseInt(splitedCpf[8]) * 2;
                break;
            case 2:
                digit = Integer.parseInt(splitedCpf[0]) * 11 + Integer.parseInt(splitedCpf[1]) * 10 + Integer.parseInt(splitedCpf[2]) * 9 +
                        Integer.parseInt(splitedCpf[3]) * 8 + Integer.parseInt(splitedCpf[4]) * 7 + Integer.parseInt(splitedCpf[5]) * 6 + Integer.parseInt(splitedCpf[6]) * 5 +
                        Integer.parseInt(splitedCpf[7]) * 4 + Integer.parseInt(splitedCpf[8]) * 3 + Integer.parseInt(splitedCpf[9]) * 2;
                break;
        }

        digit %= 11;
        digit = 11 - digit;

        if (digit >= 10) {
            digit = 0;
        }

        return digit;
    }
}