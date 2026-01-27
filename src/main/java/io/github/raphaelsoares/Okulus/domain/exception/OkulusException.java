package io.github.raphaelsoares.Okulus.domain.exception;


public abstract class OkulusException extends RuntimeException {

    protected OkulusException(String message) {
        super(message);
    }

    protected OkulusException(String message, Throwable cause) {
        super(message, cause);
    }

}

