package hilo;
import observador.Observador;
import observador.SujetoPago;

public class HiloAgregarObservador extends Thread{
    
    private SujetoPago sujeto;
    private Observador observador;
    
    public HiloAgregarObservador(SujetoPago sujeto, Observador observador){
    
    this.sujeto = sujeto;
    this.observador = observador;
    }
    
    @Override
    public void run() {
        System.out.println("[HILO] Agregando observador...");
        System.out.println("[HILO] Observador agregado exitosamente.");
    }
}
