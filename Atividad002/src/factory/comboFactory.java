package factory;

import model.combo;

public class comboFactory {
    public combo crearcombo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hamburguesa":
                return new combo("Hamburguesa");
            case "pollo":
                return new combo("Pollo");
            case "vegetariano":
                return new combo("Vegetariano");
            default:
                throw new IllegalArgumentException("Tipo de combo no válido: " + tipo);
        }
    }
}

