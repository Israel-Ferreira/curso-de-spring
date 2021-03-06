package io.codekaffee.cursomc.exceptions.nfex;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException() {
        super("Categoria não encontrada");
    }

    public CategoriaNotFoundException(String message) {
        super(message);
    }


    public CategoriaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
