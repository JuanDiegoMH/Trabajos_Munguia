package servicio;

import modelo.Pago;
import pago.MetodoPago;
import observador.SujetoPago;
public class ProcesadorPago {
    private MetodoPago metodo;
    private SujetoPago sujeto;
    
    public ProcesadorPago(SujetoPago sujeto){
        this.sujeto = sujeto;
    }
    
    public void setMetodoPago(SujetoPago sujeto){
    
    this.metodo = metodo;
    }
    
    public Pago procesar(double monto){
        Pago pago = new Pago(monto, metodo);
        sujeto.notificar(pago);
        return pago;
    }
    
}
