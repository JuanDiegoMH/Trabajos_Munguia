package fachada;

import adaptador.AdaptadorFactura;
import impuesto.EstrategiaImpuesto;
import modelo.Pedido;
import modelo.Producto;
import observador.Observador;
import observador.SujetoPedido;
import repositorio.PedidoRepositorio;
import servicio.ServicioFactura;
import servicio.ServicioPedido;
import servicio.ServicioStock;

public class FachadaPedido {

    private ServicioStock servicioStock = new ServicioStock();
    private ServicioPedido servicioPedido = new ServicioPedido();
    private ServicioFactura servicioFactura = new ServicioFactura(new AdaptadorFactura());

    private PedidoRepositorio repositorio = new PedidoRepositorio();

    private EstrategiaImpuesto estrategiaImpuesto;

    public void establecerEstrategiaImpuesto(EstrategiaImpuesto estrategia) {
        this.estrategiaImpuesto = estrategia;
    }

    private SujetoPedido sujeto = new SujetoPedido();

    public void agregarObservador(Observador obs) {
        sujeto.agregar(obs);
    }

    public void procesarPedido(String cliente, Producto producto, int cantidad) {

        System.out.println("\n🟦 PROCESANDO PEDIDO…");

        if (!servicioStock.validarStock(producto, cantidad)) {
            System.out.println("❌ ERROR: Stock insuficiente.");
            return;
        }

        Pedido pedido = new Pedido(cliente, producto, cantidad);

        double subtotal = producto.getPrecio() * cantidad;
        double impuesto = estrategiaImpuesto.calcular(subtotal);
        double total = subtotal + impuesto;

        pedido.establecerMontos(subtotal, impuesto, total);

        servicioPedido.registrarPedido(pedido);
        servicioFactura.generarFactura(pedido);
        repositorio.guardar(pedido);

        sujeto.notificarTodos(pedido);

        mostrarComprobante(pedido);
    }

    private void mostrarComprobante(Pedido pedido) {
        System.out.println("\n🧾===== COMPROBANTE =====");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto().getNombre());
        System.out.println("Cantidad: " + pedido.getCantidad());
        System.out.println("Subtotal: S/ " + pedido.getSubtotal());
        System.out.println("Impuesto: S/ " + pedido.getImpuesto());
        System.out.println("Total: S/ " + pedido.getTotal());
        System.out.println("=========================\n");
    }
}
