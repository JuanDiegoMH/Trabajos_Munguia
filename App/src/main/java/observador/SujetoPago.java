package observador;
import java.util.ArrayList;
import java.util.List;
import modelo.Pago;


public class SujetoPago {
    private List<Observador> observadores = new ArrayList<>();
    
    public synchronized void agregar(Observador obs){
      observadores.add(obs);
    }
    public void notificar(Pago pago){
    
    for (Observador o : observadores){
        o.actualizar(pago);
    }
    }
}
