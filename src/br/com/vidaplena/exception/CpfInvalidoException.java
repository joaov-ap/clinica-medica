package br.com.vidaplena.exception;

public class CpfInvalidoException extends RuntimeException{
    public CpfInvalidoException() {
        super("Cpf Inválido.");
    }

    public CpfInvalidoException(String message) {
        super(message);
    }
}
