package patrones;

public interface Sujeto {
    void agregarObservador(Observador o);
    void quitarObservador(Observador o);
    void notificar(String mensaje);
}
