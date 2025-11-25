package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import dao.ServicioDAO;
import modelo.Servicio;
import modelo.TipoServicio;

public class ServicioControlador {

    private ServicioDAO servicioDAO = new ServicioDAO();

    public void registrarServicio(int idVehiculo, String descripcion, TipoServicio tipo, double costo, String estado) {
        Servicio servicio = new Servicio(
                0,
                idVehiculo,
                descripcion,
                tipo,
                costo,
                LocalDate.now(),
                estado
        );

        servicioDAO.agregar(servicio);
    }

    public ArrayList<Servicio> listarServicios() {
        return servicioDAO.listar();
    }

    public Servicio buscarServicio(int id) {
        return servicioDAO.buscarPorId(id);
    }

    public boolean actualizarServicio(int id, int idVehiculo, String descripcion, TipoServicio tipo, double costo, String estado) {
        Servicio servicio = new Servicio(
                id,
                idVehiculo,
                descripcion,
                tipo,
                costo,
                LocalDate.now(),
                estado
        );
        return servicioDAO.actualizar(servicio);
    }

    public boolean eliminarServicio(int id) {
        return servicioDAO.eliminar(id);
    }

    public ArrayList<Servicio> listarServiciosPorVehiculo(int idVehiculo) {
        return servicioDAO.listarPorVehiculo(idVehiculo);
    }
}
