package hilos;

public class HiloNotificaciones extends Thread {

    @Override
    public void run() {
        System.out.println("[HILO NOTIFICACIONES] Enviando notificaciones...");
    }
}
