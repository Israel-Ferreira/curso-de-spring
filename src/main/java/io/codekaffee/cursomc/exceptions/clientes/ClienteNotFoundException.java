package io.codekaffee.cursomc.exceptions.clientes;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException() {
        super("Cliente não encontrado");
    }

    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
