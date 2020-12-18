package io.codekaffee.cursomc.exceptions.nfex;

public class PedidoNotFoundException extends NotFoundException{

    public PedidoNotFoundException(){
        super("Pedido não Encontrado");
    }

    public PedidoNotFoundException(String message) {
        super(message);
    }

    public PedidoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
