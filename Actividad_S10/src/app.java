
import fachada.FachadaPedido;
import impuesto.IGV18Estrategia;
import impuesto.ExoneradoEstrategia;
import modelo.Producto;
import observador.ClienteObservador;
import observador.InventarioObservador;
import observador.LogObservador;

public class app {

    public static void main(String[] args) {

        System.out.println("=== INICIO DEL SISTEMA ===");

        // Instancia de la fachada
        FachadaPedido fachada = new FachadaPedido();

        // Agregar observadores
        fachada.agregarObservador(new ClienteObservador());
        fachada.agregarObservador(new InventarioObservador());
        fachada.agregarObservador(new LogObservador());

        // Establecer estrategia de impuesto (ej. IGV 18%)
        fachada.establecerEstrategiaImpuesto(new IGV18Estrategia());
        // Si quieres exonerado, usa:
        // fachada.establecerEstrategiaImpuesto(new ExoneradoEstrategia());

        // Crear productos (asegúrate que el constructor de Producto sea (nombre, precio, stock))
        Producto hamburguesa = new Producto("Hamburguesa Clasica", 15.0, 20);
        Producto papas = new Producto("Papas Fritas", 8.0, 10);

        // Hilos: procesar pedidos en paralelo (usa lambdas para no depender de clases de hilo)
        Thread hilo1 = new Thread(() -> {
            fachada.procesarPedido("Juan Perez", hamburguesa, 2);
        }, "Hilo-Pedido-1");

        Thread hilo2 = new Thread(() -> {
            fachada.procesarPedido("Ana Gomez", papas, 1);
        }, "Hilo-Pedido-2");

        // Hilo adicional que simula tareas de notificación (opcional)
        Thread hiloNotificaciones = new Thread(() -> {
            try {
                Thread.sleep(300);
                System.out.println("[HILO NOTIFICACIONES] Ejecutando tareas de notificacion...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Hilo-Notificaciones");

        // Iniciar hilos
        hilo1.start();
        hilo2.start();
        hiloNotificaciones.start();

        // Esperar a que terminen
        try {
            hilo1.join();
            hilo2.join();
            hiloNotificaciones.join();
        } catch (InterruptedException e) {
            System.out.println("Error al sincronizar los hilos.");
            e.printStackTrace();
        }

        System.out.println("=== FIN DEL SISTEMA ===");
    }
}
