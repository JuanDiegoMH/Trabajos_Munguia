package adaptador;

import legado.SistemaFacturacionAntiguo;
import modelo.Pedido;
import servicio.ServicioFactura;

public class AdaptadorFactura implements ServicioFactura {

    private SistemaFacturacionAntiguo sistemaAntiguo = new SistemaFacturacionAntiguo();

    @Override
    public void generarFactura(Pedido pedido) {
        sistemaAntiguo.crearFacturaAntigua(
                pedido.getCliente(),
                pedido.getProducto().getNombre(),
                pedido.getTotal()
        );
    }
}
