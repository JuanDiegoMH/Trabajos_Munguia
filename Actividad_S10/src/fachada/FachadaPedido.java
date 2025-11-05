package fachada;

import adaptador.AdaptadorFactura;
import legado.SistemaFacturacionAntiguo;
import modelo.Pedido;
import modelo.Producto;
import servicio.*;

public class FachadaPedido {
    private ServicioStock servicioStock = new ServicioStock();
    private ServicioImpuesto servicioImpuesto = new ServicioImpuesto();
    private ServicioPedido servicioPedido = new ServicioPedido();
    private ServicioFactura servicioFactura;

    public FachadaPedido() {
        servicioFactura = new AdaptadorFactura(new SistemaFacturacionAntiguo());
    }

    public void procesarPedido(String cliente, Producto producto, int cantidad) {
        System.out.println("🔹 Procesando pedido...");

        if (!servicioStock.validarStock(producto, cantidad)) {
            System.out.println("❌ Error: cantidad inválida o sin stock suficiente.");
            return;
        }

        Pedido pedido = new Pedido(cliente, producto, cantidad);
        double subtotal = producto.getPrecio() * cantidad;
        double igv = servicioImpuesto.calcularIGV(subtotal);
        double total = subtotal + igv;
        pedido.calcularMontos(subtotal, igv, total);

        servicioPedido.registrarPedido(pedido);
        servicioFactura.generarFactura(pedido);

        mostrarComprobante(pedido);
    }

    private void mostrarComprobante(Pedido pedido) {
        System.out.println("\n=== COMPROBANTE DE PAGO ===");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto().getNombre());
        System.out.println("Cantidad: " + pedido.getCantidad());
        System.out.println("Subtotal: S/ " + pedido.getSubtotal());
        System.out.println("IGV (18%): S/ " + pedido.getIgv());
        System.out.println("Total: S/ " + pedido.getTotal());
        System.out.println("=============================");
    }
}

