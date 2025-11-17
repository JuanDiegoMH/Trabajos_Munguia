package fachada;

import adaptador.AdaptadorFactura;
import impuesto.EstrategiaImpuesto;
import modelo.Pedido;
import modelo.Producto;
import observador.Observador;
import observador.SujetoPedido;
import repositorio.PedidoRepositorio;
import servicio.ServicioFactura;
import servicio.ServicioImpuesto;
import servicio.ServicioPedido;
import servicio.ServicioStock;

public class FachadaPedido {

    private ServicioStock servicioStock = new ServicioStock();
    private ServicioPedido servicioPedido = new ServicioPedido();

    private ServicioFactura servicioFactura = new AdaptadorFactura();

    private ServicioImpuesto servicioImpuesto = new ServicioImpuesto();
    private PedidoRepositorio repositorio = new PedidoRepositorio();
    private SujetoPedido sujeto = new SujetoPedido();

    public void agregarObservador(Observador obs) {
        sujeto.agregar(obs);
    }

    public void establecerEstrategiaImpuesto(EstrategiaImpuesto estrategia) {
        servicioImpuesto.establecerEstrategia(estrategia);
    }

    public void procesarPedido(String cliente, Producto producto, int cantidad) {

        System.out.println("-- Procesando pedido --");

        // 1. Validación de stock
        if (!servicioStock.validar(producto, cantidad)) {
            System.out.println("ERROR: No hay stock suficiente o cantidad inválida.");
            return;
        }

        Pedido pedido = new Pedido(cliente, producto, cantidad);

        double subtotal = producto.getPrecio() * cantidad;
        double impuesto = servicioImpuesto.calcular(subtotal);
        double total = subtotal + impuesto;

        pedido.setSubtotal(subtotal);
        pedido.setImpuesto(impuesto);
        pedido.setTotal(total);
        servicioStock.descontar(producto, cantidad);

        servicioPedido.registrar(pedido);

        servicioFactura.generarFactura(pedido);

        repositorio.guardar(pedido);

        sujeto.notificar(pedido);
    }
}
