package mvc;

import factory.ComboFactory;
import builder.ComboBuilder;
import model.Combo;
import java.util.Scanner;

public class ComboController {
    private ConsoleView view;
    private Scanner scanner;

    public ComboController(ConsoleView view) {
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        view.mostrarMensaje("Bienvenido a la cadena de comida rapida.");
        view.mostrarMensaje("Seleccione tipo de combo: (hamburguesa, pollo, vegetariano)");
        String tipo = scanner.nextLine();

        ComboFactory factory = new ComboFactory();
        Combo comboBase = factory.crearCombo(tipo);

        ComboBuilder builder = new ComboBuilder(comboBase);

        view.mostrarMensaje("Seleccione bebida:");
        builder.agregarBebida(scanner.nextLine());

        view.mostrarMensaje("Seleccione acompañamiento:");
        builder.agregarAcompanamiento(scanner.nextLine());

        view.mostrarMensaje("Seleccione extra:");
        builder.agregarExtra(scanner.nextLine());

        Combo comboFinal = builder.build();
        view.mostrarMensaje("Resumen del pedido: " + comboFinal);
    }
}
