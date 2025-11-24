package pago;
public class PagoTarjeta implements MetodoPago{
    public PagoTarjeta(){}
    @Override
    public double calcularComision(double monto){
    return monto * 0.05; // 5%
    }
}
