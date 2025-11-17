package servicio;

import impuesto.EstrategiaImpuesto;

public class ServicioImpuesto {

    private EstrategiaImpuesto estrategia;

    public void establecerEstrategia(EstrategiaImpuesto estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double subtotal) {
        if (estrategia == null) {
            throw new IllegalStateException("No se ha establecido una estrategia de impuesto.");
        }
        return estrategia.calcular(subtotal);
    }
}
