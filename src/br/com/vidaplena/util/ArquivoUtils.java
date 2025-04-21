package br.com.vidaplena.util;

import br.com.vidaplena.model.Paciente;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class ArquivoUtils {
    private static final String PACIENTES_FOLDER = "src/br/com/vidaplena/data";

    public static void writePacienteFile(Paciente paciente) {
        File arquivoPaciente = new File(PACIENTES_FOLDER, paciente.getNome().toUpperCase().replace(" ", "")+".txt");
        File rawPacienteFile = new File(PACIENTES_FOLDER, "RAW-"+paciente.getNome().toUpperCase().replace(" ", "")+".txt");

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivoPaciente));
            BufferedWriter bufferedWriterRaw = new BufferedWriter(new FileWriter(rawPacienteFile))) {

            arquivoPaciente.createNewFile();
            rawPacienteFile.createNewFile();
            bufferedWriter.write(paciente.toString());
            bufferedWriterRaw.write(paciente.rawPaciente());
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readPacienteFile(String nomePaciente) {
        File arquivoPaciente = new File(PACIENTES_FOLDER, nomePaciente.toUpperCase().replace(" ","")+".txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivoPaciente))) {
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readRawPacienteFile(List<Paciente> pacientes) {
        File filesFolder = new File(PACIENTES_FOLDER);
        String[] files = filesFolder.list((File, fileName) -> fileName.startsWith("RAW-"));

        if (files.length == 0) {
            System.out.println("Nada para carregar.");
            return;
        }

        for (String raw : files) {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filesFolder+"/"+raw))) {
                String nome = bufferedReader.readLine();
                String cpf = bufferedReader.readLine();
                String telefone = bufferedReader.readLine();
                String dataNascimento = bufferedReader.readLine();
                String sexo = bufferedReader.readLine();
                String email = bufferedReader.readLine();
                pacientes.add(new Paciente(nome, cpf, telefone, LocalDate.parse(dataNascimento), sexo, email));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Pacientes Carregados.");
    }

    public static void deleteFile(String nomePaciente) {
        File arquivoPaciente = new File(PACIENTES_FOLDER, nomePaciente.toUpperCase().replace(" ","")+".txt");
        File rawArquivoPaciente = new File(PACIENTES_FOLDER, "RAW-"+nomePaciente.toUpperCase().replace(" ","")+".txt");
        if (!arquivoPaciente.exists()) {
            System.out.println("Arquivo inexistente.");
            return;
        }
        arquivoPaciente.delete();
        rawArquivoPaciente.delete();
    }

}
