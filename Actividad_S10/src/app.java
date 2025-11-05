import fachada.FachadaPedido;
import modelo.Producto;

public class app {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop Lenovo", 2500.00, 5);
        Producto producto2 = new Producto("Mouse Logitech", 100.00, 10);

        FachadaPedido fachada = new FachadaPedido();

        fachada.procesarPedido("Juan Perez", producto1, 2);
        System.out.println("\n-------------------------------\n");
        fachada.procesarPedido("Ana Torres", producto2, 1);
    }
}
