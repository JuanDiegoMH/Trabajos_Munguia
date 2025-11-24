package modelo;

public class ServicioComplejo extends Servicio {

    private String diagnostico;
    private int horasTrabajo;

    public ServicioComplejo() {
        super();
        this.diagnostico = "Sin diagnóstico";
        this.horasTrabajo = 0;
    }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public int getHorasTrabajo() { return horasTrabajo; }
    public void setHorasTrabajo(int horasTrabajo) { this.horasTrabajo = horasTrabajo; }
}
