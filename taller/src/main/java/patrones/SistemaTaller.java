package patrones;

public class SistemaTaller {

    private static SistemaTaller instancia;

    private SistemaTaller() {}

    public static SistemaTaller getInstancia() {
        if (instancia == null) {
            instancia = new SistemaTaller();
        }
        return instancia;
    }

    public void iniciar() {
        System.out.println("Sistema del taller iniciado correctamente.");
    }
}
