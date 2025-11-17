package observador;

import modelo.Pedido;

public class LogObservador implements Observador {

    @Override
    public void actualizar(Pedido pedido) {
        // Registro simple en consola (simula un log)
        System.out.println("[LOG] Nuevo pedido registrado -> Cliente: " + pedido.getCliente()
                + " | Producto: " + pedido.getProducto().getNombre()
                + " | Total: S/ " + pedido.getTotal());
    }
}
