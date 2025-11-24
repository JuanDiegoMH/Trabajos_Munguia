package observador;
import modelo.Pago;
public class ContabilidadObservador implements Observador{
    @Override
    public void actualizar(Pago pago){
        System.out.println("[CONTABILIDAD] Registrando pago de $/ " + pago.getTotal());
    }
}
