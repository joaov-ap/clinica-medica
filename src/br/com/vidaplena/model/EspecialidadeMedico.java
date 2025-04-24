package br.com.vidaplena.model;

public enum EspecialidadeMedico {
    ALERGISTA_IMUNOLOGISTA(1, "Alergista e Imunologista"),
    ANESTESIOLOGISTA(2, "Anestesiologista"),
    ANGIOLOGISTA(3, "Angiologista"),
    CARDIOLOGISTA(4, "Cardiologista"),
    CIRURGIAO_CARDIOVASCULAR(5, "Cirurgião Cardiovascular"),
    CIRURGIAO_DA_MAO(6, "Cirurgião da Mão"),
    CIRURGIAO_CABECA_PESCOCO(7, "Cirurgião de Cabeça e Pescoço"),
    CIRURGIAO_APARELHO_DIGESTIVO(8, "Cirurgião do Aparelho Digestivo"),
    CIRURGIAO_GERAL(9, "Cirurgião Geral"),
    CIRURGIAO_PEDIATRICO(10, "Cirurgião Pediátrico"),
    CIRURGIAO_PLASTICO(11, "Cirurgião Plástico"),
    CIRURGIAO_TORACICO(12, "Cirurgião Torácico"),
    CIRURGIAO_VASCULAR(13, "Cirurgião Vascular"),
    CLINICO_GERAL(14, "Clínico Geral"),
    COLOPROCTOLOGISTA(15, "Coloproctologista"),
    DERMATOLOGISTA(16, "Dermatologista"),
    ENDOCRINOLOGISTA(17, "Endocrinologista"),
    ENDOSCOPISTA(18, "Endoscopista"),
    GASTROENTEROLOGISTA(19, "Gastroenterologista"),
    GENETICISTA(20, "Geneticista Médico"),
    GERIATRA(21, "Geriatra"),
    GINECOLOGISTA_OBSTETRA(22, "Ginecologista e Obstetra"),
    HEMATOLOGISTA(23, "Hematologista"),
    HOMEOPATA(24, "Homeopata"),
    INFECTOLOGISTA(25, "Infectologista"),
    MASTOLOGISTA(26, "Mastologista"),
    MEDICO_EMERGENCIA(27, "Médico de Emergência"),
    MEDICO_FAMILIA_COMUNIDADE(28, "Médico de Família e Comunidade"),
    MEDICO_TRABALHO(29, "Médico do Trabalho"),
    MEDICO_ESPORTIVO(30, "Médico do Esporte"),
    FISIATRA(31, "Fisiatra"),
    INTENSIVISTA(32, "Intensivista"),
    PERITO_MEDICO(33, "Médico Legista ou Perito Médico"),
    MEDICO_NUCLEAR(34, "Médico Nuclear"),
    SANITARISTA(35, "Médico Sanitarista"),
    NEFROLOGISTA(36, "Nefrologista"),
    NEUROCIRURGIAO(37, "Neurocirurgião"),
    NEUROLOGISTA(38, "Neurologista"),
    NUTROLOGO(39, "Nutrólogo"),
    OFTALMOLOGISTA(40, "Oftalmologista"),
    ONCOLOGISTA_CLINICO(41, "Oncologista Clínico"),
    ORTOPEDISTA(42, "Ortopedista e Traumatologista"),
    OTORRINOLARINGOLOGISTA(43, "Otorrinolaringologista"),
    PATOLOGISTA(44, "Patologista"),
    PATOLOGISTA_CLINICO(45, "Patologista Clínico"),
    PEDIATRA(46, "Pediatra"),
    PNEUMOLOGISTA(47, "Pneumologista"),
    PSIQUIATRA(48, "Psiquiatra"),
    RADIOLOGISTA(49, "Radiologista"),
    RADIOTERAPEUTA(50, "Radioterapeuta"),
    REUMATOLOGISTA(51, "Reumatologista"),
    UROLOGISTA(52, "Urologista"),
    MEDICO_TRAFEGO(53, "Médico do Tráfego"),
    ACUPUNTURISTA(54, "Acupunturista"),
    MEDICO_AEROESPACIAL(55, "Médico Aeroespacial");

    private int codigo;
    private String nomeEspecialidade;

    EspecialidadeMedico(int codigo, String nomeEspecialidade) {
        this.codigo = codigo;
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public static EspecialidadeMedico getEspecialidade(int codigo) {
        for (EspecialidadeMedico e : values()) {
            if (e.codigo == codigo) {
                return e;
            }
        }
        return null;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    @Override
    public String toString() {
        return this.nomeEspecialidade;
    }
}
