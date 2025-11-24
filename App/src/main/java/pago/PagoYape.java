package pago;
public class PagoYape implements MetodoPago{
public PagoYape(){}
    @Override
    public double calcularComision(double monto){
    return monto * 0.3;
    }
}
