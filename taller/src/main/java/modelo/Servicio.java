package modelo;

import java.time.LocalDate;

public class Servicio {

    private int id;
    private int idVehiculo;
    private String descripcion;
    private TipoServicio tipo;
    private double costo;
    private LocalDate fecha;
    private String estado;

    public Servicio(int id, int idVehiculo, String descripcion, TipoServicio tipo, double costo, LocalDate fecha, String estado) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Servicio() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(int idVehiculo) { this.idVehiculo = idVehiculo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public TipoServicio getTipo() { return tipo; }
    public void setTipo(TipoServicio tipo) { this.tipo = tipo; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return descripcion + " (" + tipo + ")";
    }
}
