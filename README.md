# 🏥 Clínica+ — Sistema de Gerenciamento de Clínica Médica (Java)

Projeto desenvolvido como exercício prático para consolidar conhecimentos em Java Core. O sistema simula o gerenciamento básico de uma clínica médica, com funcionalidades como cadastro de pacientes, agenda de consultas, relatórios e persistência de dados em arquivos.

---

## 📌 Funcionalidades

- ✅ Cadastro, listagem, edição e exclusão de **pacientes**
- ✅ Validação de **CPF** e **e-mail** com expressões regulares (Regex)
- ✅ Agendamento, cancelamento e remarcação de **consultas**
- ✅ Cadastro de **médicos** e especialidades
- ✅ Relatórios:
    - Consultas por data
    - Pacientes atendidos por mês
- ✅ Armazenamento de dados em arquivos `.txt` ou `.csv`
- ✅ Interface de linha de comando (CLI)
- ✅ Tratamento de exceções e validações de entrada

---

## 🛠️ Tecnologias e Conceitos Utilizados

- **Java 8+** (Java SE 8 ou superior)
- **Orientação a Objetos (OOP)**
- **Tratamento de Exceções**
- **API `java.time`** (`LocalDate`, `LocalDateTime`, `DateTimeFormatter`)
- **Regex** para validação de entrada
- **Leitura e escrita de arquivos**
- **Separação por pacotes** (`model`, `service`, `util`, `data`, etc.)
- Interface via **Scanner / CLI**

---

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/joaov-ap/clinica-medica.git
   cd clinica-medica
	```
2.  Compile os arquivos `.java`:
    ```bash
    javac src/**/*.java
    ```
3.  Execute o programa:
    ```bash
    java src/Main
    ```


> 📁 O projeto está organizado por pacotes. A pasta `data` armazena os arquivos `.txt/.csv` de persistência de dados.

----------

## 👨‍💻 Objetivo do Projeto

Este sistema foi desenvolvido como um projeto de prática para aplicar os fundamentos aprendidos durante os estudos de Java. Ele simula um cenário real de uma clínica médica, com desafios comuns como validação de dados, agendamento com regras de negócio, separação de responsabilidades e persistência sem banco de dados.

----------

## 📂 Estrutura de Pastas

```
src/
├── model/        # Classes de domínio (Paciente, Medico, Consulta)
├── service/      # Lógica de negócio
├── util/         # Validadores, leitura de arquivos, utils gerais
├── data/         # Arquivos persistidos (.txt ou .csv)
└── Main.java     # Ponto de entrada do sistema

```

----------

