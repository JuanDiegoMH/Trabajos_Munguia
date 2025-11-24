package dao;

import java.util.ArrayList;
import modelo.Cliente;

public class ClienteDAO {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private int idAutoIncrement = 1;

    public void agregar(Cliente cliente) {
        cliente.setId(idAutoIncrement++);
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> listar() {
        return listaClientes;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean actualizar(Cliente clienteActualizado) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == clienteActualizado.getId()) {
                listaClientes.set(i, clienteActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        return listaClientes.removeIf(c -> c.getId() == id);
    }
}
