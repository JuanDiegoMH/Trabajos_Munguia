package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

public class PedidoRepositorio {
    private List<Pedido> pedidos = new ArrayList<>();

    public void guardar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> obtenerTodos() {
        return pedidos;
    }
}
