package hilos;

import fachada.FachadaPedido;
import modelo.Producto;

public class HiloProcesarPedido extends Thread {

    private FachadaPedido fachada;
    private String cliente;
    private Producto producto;
    private int cantidad;

    public HiloProcesarPedido(FachadaPedido fachada, String cliente, Producto producto, int cantidad) {
        this.fachada = fachada;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        System.out.println("Hilo procesando pedido...");
        fachada.procesarPedido(cliente, producto, cantidad);
    }
}
