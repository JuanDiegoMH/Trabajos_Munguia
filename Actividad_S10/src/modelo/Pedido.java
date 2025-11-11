package modelo;

public class Pedido {
    private String cliente;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private double impuesto;
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
    public double getImpuesto() { return impuesto; }
    public double getTotal() { return total; }

    public void calcularMontos(double subtotal, double impuesto, double total) {
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
    }
}


