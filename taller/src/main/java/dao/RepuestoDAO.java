package dao;

import java.util.ArrayList;
import modelo.Repuesto;

public class RepuestoDAO {

    private ArrayList<Repuesto> listaRepuestos = new ArrayList<>();
    private int idAutoIncrement = 1;

    public void agregar(Repuesto repuesto) {
        repuesto.setId(idAutoIncrement++);
        listaRepuestos.add(repuesto);
    }

    public ArrayList<Repuesto> listar() {
        return listaRepuestos;
    }

    public Repuesto buscarPorId(int id) {
        for (Repuesto r : listaRepuestos) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    public boolean actualizar(Repuesto repuestoActualizado) {
        for (int i = 0; i < listaRepuestos.size(); i++) {
            if (listaRepuestos.get(i).getId() == repuestoActualizado.getId()) {
                listaRepuestos.set(i, repuestoActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        return listaRepuestos.removeIf(r -> r.getId() == id);
    }
}

