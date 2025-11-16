package hilos;

public class HiloNotificaciones extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Hilo enviando notificaciones del sistema...");
            Thread.sleep(800);
            System.out.println("Notificaciones enviadas.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
