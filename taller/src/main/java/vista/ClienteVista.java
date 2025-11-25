package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import controlador.ClienteControlador;

public class ClienteVista extends JFrame {

    private ClienteControlador controlador = new ClienteControlador();
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JTextField txtNombre, txtDni, txtTelefono, txtDireccion;

    public ClienteVista() {
        setTitle("Gestión de Clientes");
        setSize(600, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Formulario
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panelForm.add(txtDni);

        panelForm.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelForm.add(txtTelefono);

        panelForm.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelForm.add(txtDireccion);

        JButton btnAgregar = new JButton("Agregar Cliente");
        panelForm.add(btnAgregar);

        add(panelForm, BorderLayout.NORTH);

        // Tabla
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "DNI", "Teléfono", "Dirección"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> agregarCliente());
        cargarTabla();
    }

    private void agregarCliente() {
        controlador.registrarCliente(
                txtNombre.getText(),
                txtDni.getText(),
                txtTelefono.getText(),
                txtDireccion.getText()
        );

        cargarTabla();
        limpiarFormulario();
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        controlador.listarClientes().forEach(c -> {
            modeloTabla.addRow(new Object[]{
                    c.getId(), c.getNombre(), c.getDni(), c.getTelefono(), c.getDireccion()
            });
        });
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }
}
