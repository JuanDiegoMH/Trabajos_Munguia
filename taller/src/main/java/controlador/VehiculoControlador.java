package controlador;

import java.util.ArrayList;
import dao.VehiculoDAO;
import modelo.Vehiculo;

public class VehiculoControlador {

    private VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void registrarVehiculo(int idCliente, String placa, String marca, String modelo, int anio) {
        Vehiculo vehiculo = new Vehiculo(0, idCliente, placa, marca, modelo, anio);
        vehiculoDAO.agregar(vehiculo);
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return vehiculoDAO.listar();
    }

    public Vehiculo buscarVehiculo(int id) {
        return vehiculoDAO.buscarPorId(id);
    }

    public boolean actualizarVehiculo(int id, int idCliente, String placa, String marca, String modelo, int anio) {
        Vehiculo vehiculo = new Vehiculo(id, idCliente, placa, marca, modelo, anio);
        return vehiculoDAO.actualizar(vehiculo);
    }

    public boolean eliminarVehiculo(int id) {
        return vehiculoDAO.eliminar(id);
    }

    public ArrayList<Vehiculo> listarPorCliente(int idCliente) {
        return vehiculoDAO.listarPorCliente(idCliente);
    }
}
