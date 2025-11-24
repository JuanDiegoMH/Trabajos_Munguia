package modelo;

public class ServicioBasico extends Servicio {

    private String detalleBasico;

    public ServicioBasico() {
        super();
        this.detalleBasico = "Servicio básico estándar";
    }

    public String getDetalleBasico() { return detalleBasico; }
    public void setDetalleBasico(String detalleBasico) { this.detalleBasico = detalleBasico; }
}
