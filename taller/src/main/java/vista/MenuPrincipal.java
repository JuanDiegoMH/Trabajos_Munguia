package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menú Principal - Taller Mecánico");
        setSize(400, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnClientes = new JButton("Gestión de Clientes");
        JButton btnVehiculos = new JButton("Gestión de Vehículos");
        JButton btnServicios = new JButton("Gestión de Servicios");
        JButton btnRepuestos = new JButton("Gestión de Repuestos");
        JButton btnReportes = new JButton("Reportes");

        add(btnClientes);
        add(btnVehiculos);
        add(btnServicios);
        add(btnRepuestos);
        add(btnReportes);

        btnClientes.addActionListener(e -> new ClienteVista().setVisible(true));
        btnVehiculos.addActionListener(e -> new VehiculoVista().setVisible(true));
        btnServicios.addActionListener(e -> new ServicioVista().setVisible(true));
        btnRepuestos.addActionListener(e -> new RepuestoVista().setVisible(true));
        btnReportes.addActionListener(e -> new ReporteVista().setVisible(true));
    }
}
