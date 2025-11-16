package observador;

import modelo.Pedido;

public class ClienteObservador implements Observador {
    @Override
    public void notificar(Pedido pedido) {
        System.out.println("Notificación al Cliente: Su pedido ha sido procesado. Total: S/ " + pedido.getTotal());
    }
}

