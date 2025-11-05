
package view;
import java.util.List;
import model.Programa;

public class ProgramaView {
        public void mostrarLista(List<Programa> programas) {
        System.out.println("=== LISTA DE PROGRAMAS ===");
        for (Programa p : programas) {
            System.out.println(p.toString());
        }
        System.out.println("\nCantidad total de programas: " + programas.size());
    }
}
