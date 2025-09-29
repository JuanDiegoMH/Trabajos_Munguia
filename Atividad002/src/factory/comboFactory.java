package factory;

import model.Combo;

public class comboFactory {
    public Combo crearcombo(String tipo) {
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

