package br.com.vidaplena.model;

public enum EspecialidadeMedico {
    ALERGISTA_IMUNOLOGISTA("Alergista e Imunologista"),
    ANESTESIOLOGISTA("Anestesiologista"),
    ANGIOLOGISTA("Angiologista"),
    CARDIOLOGISTA("Cardiologista"),
    CIRURGIAO_CARDIOVASCULAR("Cirurgião Cardiovascular"),
    CIRURGIAO_DA_MAO("Cirurgião da Mão"),
    CIRURGIAO_CABECA_PESCOCO("Cirurgião de Cabeça e Pescoço"),
    CIRURGIAO_APARELHO_DIGESTIVO("Cirurgião do Aparelho Digestivo"),
    CIRURGIAO_GERAL("Cirurgião Geral"),
    CIRURGIAO_PEDIATRICO("Cirurgião Pediátrico"),
    CIRURGIAO_PLASTICO("Cirurgião Plástico"),
    CIRURGIAO_TORACICO("Cirurgião Torácico"),
    CIRURGIAO_VASCULAR("Cirurgião Vascular"),
    CLINICO_GERAL("Clínico Geral"),
    COLOPROCTOLOGISTA("Coloproctologista"),
    DERMATOLOGISTA("Dermatologista"),
    ENDOCRINOLOGISTA("Endocrinologista"),
    ENDOSCOPISTA("Endoscopista"),
    GASTROENTEROLOGISTA("Gastroenterologista"),
    GENETICISTA("Geneticista Médico"),
    GERIATRA("Geriatra"),
    GINECOLOGISTA_OBSTETRA("Ginecologista e Obstetra"),
    HEMATOLOGISTA("Hematologista"),
    HOMEOPATA("Homeopata"),
    INFECTOLOGISTA("Infectologista"),
    MASTOLOGISTA("Mastologista"),
    MEDICO_EMERGENCIA("Médico de Emergência"),
    MEDICO_FAMILIA_COMUNIDADE("Médico de Família e Comunidade"),
    MEDICO_TRABALHO("Médico do Trabalho"),
    MEDICO_ESPORTIVO("Médico do Esporte"),
    FISIATRA("Fisiatra"),
    INTENSIVISTA("Intensivista"),
    PERITO_MEDICO("Médico Legista ou Perito Médico"),
    MEDICO_NUCLEAR("Médico Nuclear"),
    SANITARISTA("Médico Sanitarista"),
    NEFROLOGISTA("Nefrologista"),
    NEUROCIRURGIAO("Neurocirurgião"),
    NEUROLOGISTA("Neurologista"),
    NUTROLOGO("Nutrólogo"),
    OFTALMOLOGISTA("Oftalmologista"),
    ONCOLOGISTA_CLINICO("Oncologista Clínico"),
    ORTOPEDISTA("Ortopedista e Traumatologista"),
    OTORRINOLARINGOLOGISTA("Otorrinolaringologista"),
    PATOLOGISTA("Patologista"),
    PATOLOGISTA_CLINICO("Patologista Clínico"),
    PEDIATRA("Pediatra"),
    PNEUMOLOGISTA("Pneumologista"),
    PSIQUIATRA("Psiquiatra"),
    RADIOLOGISTA("Radiologista"),
    RADIOTERAPEUTA("Radioterapeuta"),
    REUMATOLOGISTA("Reumatologista"),
    UROLOGISTA("Urologista"),
    MEDICO_TRAFEGO("Médico do Tráfego"),
    ACUPUNTURISTA("Acupunturista"),
    MEDICO_AEROESPACIAL("Médico Aeroespacial");

    private String nomeEspecialidade;

    EspecialidadeMedico(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
}
