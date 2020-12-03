package io.codekaffee.cursomc.exceptions.nfex;


public class EstadoNotFoundException extends NotFoundException {
    public EstadoNotFoundException() {
        super("Estado não encontrado");
    }
}
