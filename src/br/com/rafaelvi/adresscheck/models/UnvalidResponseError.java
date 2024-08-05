package br.com.rafaelvi.adresscheck.models;

public class UnvalidResponseError extends RuntimeException {
    private String message;

    public UnvalidResponseError(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
