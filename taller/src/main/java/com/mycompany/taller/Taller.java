package com.mycompany.taller;

import patrones.SistemaTaller;
import patrones.NotificadorStock;
import patrones.AlertaAdministrador;
import vista.LoginVista;

public class Taller {

    public static void main(String[] args) {

        // Activar Singleton
        SistemaTaller sistema = SistemaTaller.getInstancia();
        sistema.iniciar();

        // Activar Patron Observer
        NotificadorStock notificador = new NotificadorStock();
        AlertaAdministrador admin = new AlertaAdministrador();
        notificador.agregarObservador(admin);

        // Notificación inicial de prueba
        notificador.notificar("Sistema iniciado correctamente. Todo listo.");

        // Lanzar interfaz gráfica
        LoginVista login = new LoginVista();
        login.setVisible(true);
    }
}
