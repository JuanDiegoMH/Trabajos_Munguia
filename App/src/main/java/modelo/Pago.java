package modelo;
import pago.MetodoPago;
public class Pago {
    
    private double monto;
    private double comision;
    private double total;
    
    public Pago(double monto, MetodoPago metodo){
    
    this.monto = monto;
    this.comision = metodo.calcularComision(monto);
    this.total = monto + comision;
    }
    
    public double getMonto(){return monto;}
    public double getComision(){return comision; }
    public double getTotal(){return total; }
    
}
