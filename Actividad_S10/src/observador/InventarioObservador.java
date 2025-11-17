package observador;

import modelo.Pedido;

public class InventarioObservador implements Observador {

    @Override
    public void actualizar(Pedido pedido) {

        System.out.println("[INVENTARIO] Se actualizo el inventario por el pedido de "
                + pedido.getCliente() + " - Producto: " + pedido.getProducto().getNombre()
                + " | Cantidad: " + pedido.getCantidad());
    }
}
