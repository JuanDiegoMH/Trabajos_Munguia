package observador;

import modelo.Pedido;

public interface Observador {
    void notificar(Pedido pedido);
}


