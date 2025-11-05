package motorápido;

import java.util.Date;

public class Servicio {
    private int idServicio;
    private String tipo;
    private String descripcion;
    private double costo;
    private Date fecha;

    public Servicio(int idServicio, String tipo, String descripcion, double costo, Date fecha) {
        this.idServicio = idServicio;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }
}
