package hilos;

public class HiloProcesarPedido extends Thread {

    @Override
    public void run() {
        System.out.println("[HILO PEDIDOS] Procesando pedidos...");
    }
}
