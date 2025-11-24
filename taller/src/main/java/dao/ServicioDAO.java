package dao;

import java.util.ArrayList;
import modelo.Servicio;

public class ServicioDAO {

    private ArrayList<Servicio> listaServicios = new ArrayList<>();
    private int idAutoIncrement = 1;

    public void agregar(Servicio servicio) {
        servicio.setId(idAutoIncrement++);
        listaServicios.add(servicio);
    }

    public ArrayList<Servicio> listar() {
        return listaServicios;
    }

    public Servicio buscarPorId(int id) {
        for (Servicio s : listaServicios) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public ArrayList<Servicio> listarPorVehiculo(int idVehiculo) {
        ArrayList<Servicio> resultado = new ArrayList<>();
        for (Servicio s : listaServicios) {
            if (s.getIdVehiculo() == idVehiculo) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public boolean actualizar(Servicio servicioActualizado) {
        for (int i = 0; i < listaServicios.size(); i++) {
            if (listaServicios.get(i).getId() == servicioActualizado.getId()) {
                listaServicios.set(i, servicioActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        return listaServicios.removeIf(s -> s.getId() == id);
    }
}
