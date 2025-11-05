
package factory;

import model.*;

public class ProgramaFactory {
    public static Programa crearPrograma(String tipo){
        switch (tipo.toLowerCase()) {
            case "noticias":
                return new ProgramaNoticias();
                
            case "serie":
                return new ProgramaSerie();
                
            case "deportes":
                return new ProgramaDeportes();
                
            default:
                throw new IllegalArgumentException("no valido");
        }
    }
    
}
