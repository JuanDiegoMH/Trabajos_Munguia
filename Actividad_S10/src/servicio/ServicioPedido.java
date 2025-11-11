package servicio;

import modelo.Pedido;

public class ServicioPedido {
    public void registrarPedido(Pedido pedido) {
        pedido.getProducto().reducirStock(pedido.getCantidad());
        System.out.println("✅ Pedido registrado para el cliente: " + pedido.getCliente());
    }
}
