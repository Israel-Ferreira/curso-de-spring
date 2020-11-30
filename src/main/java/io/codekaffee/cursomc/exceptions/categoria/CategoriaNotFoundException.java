package io.codekaffee.cursomc.exceptions.categoria;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException() {
        super("Categoria não encontrada");
    }

    public CategoriaNotFoundException(String message) {
        super(message);
    }
}
