
package pc1_pooii;
import controller.ProgramaController;
import view.ProgramaView;
public class PC1_POOII {
    public static void main(String[] args) {
ProgramaView vista = new ProgramaView();
ProgramaController controlador = new ProgramaController(vista);

     controlador.registrarPrograma("noticias", "07:00", "Carlos Pérez", 2024, "ATP");
        controlador.registrarPrograma("serie", "09:30", "María López", 2020, "PG13");
        controlador.registrarPrograma("deportes", "11:00", "Luis Torres", 2022, "ATP");

        controlador.mostrarProgramas();
    }   
}
