package observador;

import modelo.Pedido;

public class LogObservador implements Observador {
    @Override
    public void notificar(Pedido pedido) {
        System.out.println("Log: Pedido registrado de " + pedido.getCliente());
    }
}

