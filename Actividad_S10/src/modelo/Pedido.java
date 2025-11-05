package modelo;

public class Pedido {
    private String cliente;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private double igv;
    private double total;

    public Pedido(String cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }
    public double getIgv() { return igv; }
    public double getTotal() { return total; }

    public void calcularMontos(double subtotal, double igv, double total) {
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }
}

