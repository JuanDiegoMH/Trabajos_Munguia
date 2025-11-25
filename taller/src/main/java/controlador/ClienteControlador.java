package controlador;

import java.util.ArrayList;
import dao.ClienteDAO;
import modelo.Cliente;

public class ClienteControlador {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void registrarCliente(String nombre, String dni, String telefono, String direccion) {
        Cliente cliente = new Cliente(0, nombre, dni, telefono, direccion);
        clienteDAO.agregar(cliente);
    }

    public ArrayList<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarPorId(id);
    }

    public boolean actualizarCliente(int id, String nombre, String dni, String telefono, String direccion) {
        Cliente cliente = new Cliente(id, nombre, dni, telefono, direccion);
        return clienteDAO.actualizar(cliente);
    }

    public boolean eliminarCliente(int id) {
        return clienteDAO.eliminar(id);
    }
}
