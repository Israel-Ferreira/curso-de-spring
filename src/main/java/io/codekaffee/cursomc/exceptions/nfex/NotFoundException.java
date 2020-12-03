package io.codekaffee.cursomc.exceptions.nfex;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Objeto Não Encontrado");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
