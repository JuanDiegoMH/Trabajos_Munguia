package vista;

import javax.swing.*;
import java.awt.*;
import controlador.ServicioControlador;

public class ReporteVista extends JFrame {

    private ServicioControlador controlador = new ServicioControlador();
    private JTextArea txtArea;

    public ReporteVista() {
        setTitle("Reporte de Servicios");
        setSize(600, 450);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);

        JButton btnGenerar = new JButton("Generar Reporte");
        add(btnGenerar, BorderLayout.SOUTH);

        btnGenerar.addActionListener(e -> generar());
    }

    private void generar() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE DE SERVICIOS ===\n\n");

        controlador.listarServicios().forEach(s -> {
            sb.append("ID: ").append(s.getId()).append("\n")
              .append("Vehículo: ").append(s.getIdVehiculo()).append("\n")
              .append("Descripción: ").append(s.getDescripcion()).append("\n")
              .append("Tipo: ").append(s.getTipo()).append("\n")
              .append("Costo: ").append(s.getCosto()).append("\n")
              .append("Fecha: ").append(s.getFecha()).append("\n")
              .append("Estado: ").append(s.getEstado()).append("\n")
              .append("-----------------------------\n");
        });

        txtArea.setText(sb.toString());
    }
}
