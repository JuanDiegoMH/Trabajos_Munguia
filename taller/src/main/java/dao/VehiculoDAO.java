package dao;

import java.util.ArrayList;
import modelo.Vehiculo;

public class VehiculoDAO {

    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private int idAutoIncrement = 1;

    public void agregar(Vehiculo vehiculo) {
        vehiculo.setId(idAutoIncrement++);
        listaVehiculos.add(vehiculo);
    }

    public ArrayList<Vehiculo> listar() {
        return listaVehiculos;
    }

    public Vehiculo buscarPorId(int id) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    public ArrayList<Vehiculo> listarPorCliente(int idCliente) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : listaVehiculos) {
            if (v.getIdCliente() == idCliente) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public boolean actualizar(Vehiculo vehiculoActualizado) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getId() == vehiculoActualizado.getId()) {
                listaVehiculos.set(i, vehiculoActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        return listaVehiculos.removeIf(v -> v.getId() == id);
    }
}
