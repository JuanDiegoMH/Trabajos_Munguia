
package controller;
import builder.ProgramaBuilder;
import factory.ProgramaFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Programa;
import view.ProgramaView;

public class ProgramaController {
    private List<Programa> programas = new ArrayList<>();
    private ProgramaView view;
    
    public ProgramaController(ProgramaView view){
    this.view = view;
}
public void registrarPrograma(String tipo, String horario, String protagonista, int anio, String censura) {
        Programa base = ProgramaFactory.crearPrograma(tipo);
        Programa programa = new ProgramaBuilder(base)
                .agregarHorario(horario)
                .agregarProtagonista(protagonista)
                .agregarAnio(anio)
                .agregarCensura(censura)
                .build();

        programas.add(programa);
    }

    public void mostrarProgramas() {
        Collections.sort(programas);
        view.mostrarLista(programas);
    }
}
