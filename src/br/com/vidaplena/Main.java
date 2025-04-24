package br.com.vidaplena;

import br.com.vidaplena.service.MedicoService;
import br.com.vidaplena.service.PacienteService;

public class Main {
    public static void main(String[] args) {
        PacienteService pacienteService = new PacienteService();
        MedicoService medicoService = new MedicoService();
        System.out.println("Bem Vindo a clínica Vida Plena.");
//        pacienteService.menuPaciente();

        medicoService.menuMedico();
    }
}
