import fachada.FachadaPedido;
import hilos.HiloGenerarFactura;
import hilos.HiloNotificaciones;
import hilos.HiloProcesarPedido;
import impuesto.IGV18Estrategia;
import impuesto.ExoneradoEstrategia;
import modelo.Producto;
import observador.ClienteObservador;
import observador.InventarioObservador;
import observador.LogObservador;

public class app {

    public static void main(String[] args) {

        System.out.println("\n====== SISTEMA DE PEDIDOS Y FACTURACIÓN ======\n");

        // Crear la fachada
        FachadaPedido fachada = new FachadaPedido();

        // Estrategia de impuesto
        fachada.establecerEstrategiaImpuesto(new IGV18Estrategia());

        // Observadores (Observer)
        fachada.agregarObservador(new ClienteObservador());
        fachada.agregarObservador(new InventarioObservador());
        fachada.agregarObservador(new LogObservador());

        // Productos de ejemplo
        Producto hamburguesa = new Producto("Hamburguesa Clásica", 15.00, 20);
        Producto papas = new Producto("Papas Fritas", 8.00, 10);
        Producto gaseosa = new Producto("Gaseosa 500ml", 5.00, 30);

        // Hilos
        Thread hiloProcesar = new Thread(new HiloProcesarPedido(fachada, "Juan", hamburguesa, 2));
        Thread hiloFactura = new Thread(new HiloGenerarFactura());
        Thread hiloNotificaciones = new Thread(new HiloNotificaciones());

        // Iniciar hilos
        hiloProcesar.start();
        hiloFactura.start();
        hiloNotificaciones.start();

        try {
            hiloProcesar.join();
            hiloFactura.join();
            hiloNotificaciones.join();
        } catch (InterruptedException e) {
            System.out.println("Error al sincronizar los hilos.");
        }

        System.out.println("\n===== FIN DEL PROCESO =====");
    }
}
