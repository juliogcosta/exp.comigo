package br.com.comigo.autenticacao.exception;

public class InconsistentUserRegisterException extends Exception {
    private static final long serialVersionUID = 1L;

    public InconsistentUserRegisterException(String message) {
        super(message);
    }

    public InconsistentUserRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
}
