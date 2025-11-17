package hilos;

public class HiloGenerarFactura extends Thread {

    @Override
    public void run() {
        System.out.println("[HILO FACTURAS] Generando facturas...");
    }
}

