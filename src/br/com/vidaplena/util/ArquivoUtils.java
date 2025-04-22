package br.com.vidaplena.util;

import br.com.vidaplena.model.Paciente;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ArquivoUtils {
    public static void writeFile(String folderPath, Object object, String fileName) {
        File file = new File(folderPath, fileName.toUpperCase().replace(" ", "")+".txt");

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            file.createNewFile();
            bufferedWriter.write(object.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile(String folderPath, String fileName) {
        File file = new File(folderPath, fileName.toUpperCase().replace(" ","")+".txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFileOnStart(String folderPath, List<Paciente> pacientes) {
        File filesFolder = new File(folderPath);
        String[] files = filesFolder.list();
        String regex = "[\\w ]+: ";

        if (files.length == 0) {
            System.out.println("Nada para carregar.");
            return;
        }

        for (String raw : files) {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filesFolder+"/"+raw))) {
                bufferedReader.readLine();
                String nome = bufferedReader.readLine().replaceAll(regex, "");
                String cpf = bufferedReader.readLine().replaceAll(regex, "");
                String telefone = bufferedReader.readLine().replaceAll(regex, "");
                String dataNascimento = bufferedReader.readLine().replaceAll(regex, "");
                String sexo = bufferedReader.readLine().replaceAll(regex, "");
                String email = bufferedReader.readLine().replaceAll(regex, "");
                pacientes.add(new Paciente(nome, cpf, telefone, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), sexo, email));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Pacientes Carregados.");
    }

    public static void deleteFile(String folderPath, String fileName) {
        File file = new File(folderPath, fileName.toUpperCase().replace(" ","")+".txt");
        if (!file.exists()) {
            System.out.println("Arquivo inexistente.");
            return;
        }
        file.delete();
    }

}
