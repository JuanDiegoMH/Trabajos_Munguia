package observador;

import modelo.Pedido;

public class InventarioObservador implements Observador {
    @Override
    public void notificar(Pedido pedido) {
        System.out.println("Inventario actualizado: Se redujo stock del producto " + pedido.getProducto().getNombre());
    }
}
