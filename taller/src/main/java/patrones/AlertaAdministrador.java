package patrones;

import javax.swing.JOptionPane;

public class AlertaAdministrador implements Observador {

    @Override
    public void actualizar(String mensaje) {
        JOptionPane.showMessageDialog(null, 
                "ALERTA DEL SISTEMA:\n" + mensaje,
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
    }
}
