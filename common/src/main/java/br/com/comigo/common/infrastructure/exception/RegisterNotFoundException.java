package br.com.comigo.common.infrastructure.exception;

public class RegisterNotFoundException extends Exception {
    public RegisterNotFoundException(String message) {
        super(message);
    }
}