package servicio;

import modelo.Producto;

public class ServicioStock {
    public boolean validarStock(Producto producto, int cantidad) {
        return cantidad > 0 && producto.getStock() >= cantidad;
    }
}
