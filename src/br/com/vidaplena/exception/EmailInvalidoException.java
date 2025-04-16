package br.com.vidaplena.exception;

public class EmailInvalidoException extends RuntimeException{
    public EmailInvalidoException() {
        super("Email Inválido.");
    }

    public EmailInvalidoException(String message) {
        super(message);
    }
}
