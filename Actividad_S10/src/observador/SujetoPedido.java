package observador;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

public class SujetoPedido {
    private List<Observador> observadores = new ArrayList<>();

    public void agregar(Observador obs) {
        observadores.add(obs);
    }

    public void notificarTodos(Pedido pedido) {
        for (Observador obs : observadores) {
            obs.notificar(pedido);
        }
    }
}

