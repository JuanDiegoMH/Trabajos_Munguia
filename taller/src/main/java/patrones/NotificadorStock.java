package patrones;

import java.util.ArrayList;

public class NotificadorStock implements Sujeto {

    private ArrayList<Observador> observadores = new ArrayList<>();

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificar(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }
}
