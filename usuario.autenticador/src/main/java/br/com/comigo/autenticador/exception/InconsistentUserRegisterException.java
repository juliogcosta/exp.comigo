package br.com.comigo.autenticador.exception;

public class InconsistentUserRegisterException extends Exception {
    private static final long serialVersionUID = 1L;

    public InconsistentUserRegisterException(String message) {
        super(message);
    }

    public InconsistentUserRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
}
