package factory;

import model.Combo;

public class ComboFactory {
    public Combo crearCombo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hamburguesa":
                return new Combo("Hamburguesa");
            case "pollo":
                return new Combo("Pollo");
            case "vegetariano":
                return new Combo("Vegetariano");
            default:
                throw new IllegalArgumentException("Tipo de combo no válido: " + tipo);
        }
    }
}

