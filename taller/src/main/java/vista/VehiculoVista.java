package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import controlador.VehiculoControlador;

public class VehiculoVista extends JFrame {

    private VehiculoControlador controlador = new VehiculoControlador();
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JTextField txtIdCliente, txtPlaca, txtMarca, txtModelo, txtAnio;

    public VehiculoVista() {
        setTitle("Gestión de Vehículos");
        setSize(650, 420);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // FORMULARIO
        JPanel panelForm = new JPanel(new GridLayout(6,2,10,10));
        panelForm.add(new JLabel("ID Cliente:"));
        txtIdCliente = new JTextField();
        panelForm.add(txtIdCliente);

        panelForm.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        panelForm.add(txtPlaca);

        panelForm.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelForm.add(txtMarca);

        panelForm.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panelForm.add(txtModelo);

        panelForm.add(new JLabel("Año:"));
        txtAnio = new JTextField();
        panelForm.add(txtAnio);

        JButton btnAgregar = new JButton("Agregar Vehículo");
        panelForm.add(btnAgregar);

        add(panelForm, BorderLayout.NORTH);

        // TABLA
        modeloTabla = new DefaultTableModel(new String[]{"ID","Cliente","Placa","Marca","Modelo","Año"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> agregarVehiculo());
        cargarTabla();
    }

    private void agregarVehiculo() {
        controlador.registrarVehiculo(
                Integer.parseInt(txtIdCliente.getText()),
                txtPlaca.getText(),
                txtMarca.getText(),
                txtModelo.getText(),
                Integer.parseInt(txtAnio.getText())
        );

        cargarTabla();
        limpiarFormulario();
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        controlador.listarVehiculos().forEach(v -> {
            modeloTabla.addRow(new Object[]{
                    v.getId(), v.getIdCliente(), v.getPlaca(), v.getMarca(),
                    v.getModelo(), v.getAnio()
            });
        });
    }

    private void limpiarFormulario() {
        txtIdCliente.setText("");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
    }
}
