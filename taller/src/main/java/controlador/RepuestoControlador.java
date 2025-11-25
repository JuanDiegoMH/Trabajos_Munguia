package controlador;

import java.util.ArrayList;
import dao.RepuestoDAO;
import modelo.Repuesto;

public class RepuestoControlador {

    private RepuestoDAO repuestoDAO = new RepuestoDAO();

    public void registrarRepuesto(String nombre, String marca, int stock) {
        Repuesto repuesto = new Repuesto(0, nombre, marca, stock);
        repuestoDAO.agregar(repuesto);
    }

    public ArrayList<Repuesto> listarRepuestos() {
        return repuestoDAO.listar();
    }

    public Repuesto buscarRepuesto(int id) {
        return repuestoDAO.buscarPorId(id);
    }

    public boolean actualizarRepuesto(int id, String nombre, String marca, int stock) {
        Repuesto repuesto = new Repuesto(id, nombre, marca, stock);
        return repuestoDAO.actualizar(repuesto);
    }

    public boolean eliminarRepuesto(int id) {
        return repuestoDAO.eliminar(id);
    }
}
