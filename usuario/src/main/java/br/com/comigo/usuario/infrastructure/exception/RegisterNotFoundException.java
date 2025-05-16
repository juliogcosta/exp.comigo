package br.com.comigo.usuario.infrastructure.exception;

public class RegisterNotFoundException extends Exception {
    public RegisterNotFoundException(String message) {
        super(message);
    }
}