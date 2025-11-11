package impuesto;

public class ExoneradoEstrategia implements EstrategiaImpuesto {
    @Override
    public double calcular(double subtotal) {
        return 0.0;
    }
}
