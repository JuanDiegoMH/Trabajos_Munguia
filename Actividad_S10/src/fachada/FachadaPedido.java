package fachada;

import adaptador.AdaptadorFactura;
import impuesto.EstrategiaImpuesto;
import legado.SistemaFacturacionAntiguo;
import modelo.Pedido;
import modelo.Producto;
import repositorio.PedidoRepositorio;
import servicio.*;

public class FachadaPedido {
    private ServicioStock servicioStock = new ServicioStock();
    private ServicioPedido servicioPedido = new ServicioPedido();
    private ServicioFactura servicioFactura;
    private PedidoRepositorio repositorio = new PedidoRepositorio();
    private EstrategiaImpuesto estrategiaImpuesto;

    public FachadaPedido() {
        servicioFactura = new AdaptadorFactura(new SistemaFacturacionAntiguo());
    }

    public void setEstrategiaImpuesto(EstrategiaImpuesto estrategia) {
        this.estrategiaImpuesto = estrategia;
    }

    public void procesarPedido(String cliente, Producto producto, int cantidad) {
        System.out.println("Procesando pedido...");

        if (!servicioStock.validarStock(producto, cantidad)) {
            System.out.println("Error: cantidad inválida o sin stock suficiente.");
            return;
        }

        if (estrategiaImpuesto == null) {
            System.out.println("No se ha definido una estrategia de impuesto.");
            return;
        }

        Pedido pedido = new Pedido(cliente, producto, cantidad);
        double subtotal = producto.getPrecio() * cantidad;
        double impuesto = estrategiaImpuesto.calcular(subtotal);
        double total = subtotal + impuesto;
        pedido.calcularMontos(subtotal, impuesto, total);

        servicioPedido.registrarPedido(pedido);
        servicioFactura.generarFactura(pedido);
        repositorio.guardar(pedido);

        mostrarComprobante(pedido);
    }

    private void mostrarComprobante(Pedido pedido) {
        System.out.println("\n=== COMPROBANTE DE PAGO ===");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto().getNombre());
        System.out.println("Cantidad: " + pedido.getCantidad());
        System.out.println("Subtotal: S/ " + pedido.getSubtotal());
        System.out.println("Impuesto: S/ " + pedido.getImpuesto());
        System.out.println("Total: S/ " + pedido.getTotal());
        System.out.println("=============================");
    }

    public void mostrarPedidosGuardados() {
        System.out.println("\nPedidos registrados en el repositorio:");
        for (Pedido p : repositorio.obtenerTodos()) {
            System.out.println("- " + p.getCliente() + " compró " + p.getProducto().getNombre() + " (Total: S/ " + p.getTotal() + ")");
        }
    }
}
