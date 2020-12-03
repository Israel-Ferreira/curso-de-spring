package io.codekaffee.cursomc.exceptions.nfex;

import io.codekaffee.cursomc.exceptions.nfex.NotFoundException;

public class ClienteNotFoundException extends NotFoundException {
    public ClienteNotFoundException() {
        super("Cliente não encontrado");
    }
}
