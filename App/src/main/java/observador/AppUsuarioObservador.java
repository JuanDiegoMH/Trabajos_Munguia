package observador;
import modelo.Pago;
public class AppUsuarioObservador implements Observador{
    @Override
    public void actualizar(Pago pago){
        System.out.println("[APP USUARIO] se proceso su pago de $/" + pago.getTotal());
    }
    
}
