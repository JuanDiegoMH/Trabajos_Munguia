package patrones;

import modelo.TipoServicio;

public class TipoServicioFactory {

    public static TipoServicio obtenerTipo(String nombre) {
        switch (nombre.toLowerCase()) {
            case "mantenimiento":
                return TipoServicio.MANTENIMIENTO;

            case "reparación":
                return TipoServicio.REPARACION;

            case "diagnóstico":
                return TipoServicio.DIAGNOSTICO;

            default:
                return TipoServicio.DIAGNOSTICO;
        }
    }
}
