package impuesto;

public class IGV18Estrategia implements EstrategiaImpuesto {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.18;
    }
}
