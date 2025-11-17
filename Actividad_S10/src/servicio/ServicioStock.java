package servicio;

import modelo.Producto;

public class ServicioStock {

    public boolean validar(Producto producto, int cantidad) {
        return cantidad > 0 && producto.getStock() >= cantidad;
    }

    public void descontar(Producto producto, int cantidad) {
        producto.reducirStock(cantidad);
    }
}
