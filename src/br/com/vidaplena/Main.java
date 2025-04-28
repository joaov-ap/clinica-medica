package br.com.vidaplena;

import br.com.vidaplena.model.EspecialidadeMedico;
import br.com.vidaplena.model.Medico;
import br.com.vidaplena.service.MedicoService;
import br.com.vidaplena.service.PacienteService;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PacienteService pacienteService = new PacienteService();
        MedicoService medicoService = new MedicoService();
        System.out.println("Bem Vindo a clínica Vida Plena.");
//        pacienteService.menuPaciente();
    }
}
