package observador;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

public class SujetoPedido {
    private List<Observador> observadores = new ArrayList<>();

    public void agregar(Observador o) { observadores.add(o); }

    public void notificar(Pedido pedido) {
        for (Observador o : observadores) {
            o.actualizar(pedido);
        }
    }
}
