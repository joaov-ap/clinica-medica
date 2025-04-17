package br.com.vidaplena.util;

import br.com.vidaplena.model.Paciente;

import java.io.*;

public class ArquivoUtils {
    private static final String PACIENTES_FOLDER = "src/br/com/vidaplena/data";

    public static void writePacienteFile(Paciente paciente) {
        File arquivoPaciente = new File(PACIENTES_FOLDER, paciente.getNome().toUpperCase().replace(" ", "")+".txt");
        File rawPacienteFile = new File(PACIENTES_FOLDER, "RAW-"+paciente.getNome().toUpperCase().replace(" ", "")+".txt");

        try(FileWriter fileWriter = new FileWriter(arquivoPaciente);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            FileWriter fileWriterRaw = new FileWriter(rawPacienteFile);
            BufferedWriter bufferedWriterRaw = new BufferedWriter(fileWriterRaw)) {

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
        File arquivoPaciente = new File(PACIENTES_FOLDER, nomePaciente.toUpperCase().replace(" ",""));
        try(FileReader fileReader = new FileReader(arquivoPaciente);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readRawFileOnStart() {
        File pastaPaciente = new File(PACIENTES_FOLDER);
        String[] raws = pastaPaciente.list((file, s) -> s.startsWith("RAW"));

        if (raws != null) {
            for (String raw : raws) {
                for (int j = 0; j < raw.length(); j++) {
                    try (FileReader fileReader = new FileReader(raw);
                         BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                        String linha;

                        while ((linha = bufferedReader.readLine()) != null) {
                            System.out.println(linha);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
