package observador;

import modelo.Pedido;

public class ClienteObservador implements Observador {
    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("[Notificacion->Cliente] Su pedido de " + pedido.getProducto().getNombre()
            + " por S/ " + pedido.getTotal() + " fue procesado.");
    }
}
