
import fachada.FachadaPedido;
import impuesto.*;
import modelo.Producto;

public class app {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop Lenovo", 2500.00, 5);
        Producto producto2 = new Producto("Mouse Logitech", 100.00, 10);

        FachadaPedido fachada = new FachadaPedido();

        System.out.println("=== Pedido con IGV 18% ===");
        fachada.setEstrategiaImpuesto(new IGV18Estrategia());
        fachada.procesarPedido("Juan Pérez", producto1, 2);

        System.out.println("\n=== Pedido exonerado de IGV ===");
        fachada.setEstrategiaImpuesto(new ExoneradoEstrategia());
        fachada.procesarPedido("Ana Torres", producto2, 1);

        fachada.mostrarPedidosGuardados();
    }
}
