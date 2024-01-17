package org.example;

public class TransactionalSafeException extends RuntimeException {
    public TransactionalSafeException(String message) {
        super(message);
    }
}
