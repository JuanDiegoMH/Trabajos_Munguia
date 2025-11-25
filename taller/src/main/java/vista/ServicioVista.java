package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import controlador.ServicioControlador;
import modelo.TipoServicio;

public class ServicioVista extends JFrame {

    private ServicioControlador controlador = new ServicioControlador();

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JTextField txtIdVehiculo, txtDescripcion, txtCosto, txtEstado;
    private JComboBox<TipoServicio> cbTipo;

    public ServicioVista() {
        setTitle("Gestión de Servicios");
        setSize(700, 450);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // FORMULARIO
        JPanel panelForm = new JPanel(new GridLayout(6,2,10,10));

        panelForm.add(new JLabel("ID Vehículo:"));
        txtIdVehiculo = new JTextField();
        panelForm.add(txtIdVehiculo);

        panelForm.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelForm.add(txtDescripcion);

        panelForm.add(new JLabel("Tipo de Servicio:"));
        cbTipo = new JComboBox<>(TipoServicio.values());
        panelForm.add(cbTipo);

        panelForm.add(new JLabel("Costo:"));
        txtCosto = new JTextField();
        panelForm.add(txtCosto);

        panelForm.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panelForm.add(txtEstado);

        JButton btnAgregar = new JButton("Registrar Servicio");
        panelForm.add(btnAgregar);

        add(panelForm, BorderLayout.NORTH);

        // TABLA
        modeloTabla = new DefaultTableModel(new String[]{
                "ID","Vehículo","Descripción","Tipo","Costo","Fecha","Estado"
        }, 0);

        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> registrarServicio());
        cargarTabla();
    }

    private void registrarServicio() {
        controlador.registrarServicio(
                Integer.parseInt(txtIdVehiculo.getText()),
                txtDescripcion.getText(),
                (TipoServicio) cbTipo.getSelectedItem(),
                Double.parseDouble(txtCosto.getText()),
                txtEstado.getText()
        );

        cargarTabla();
        limpiar();
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        controlador.listarServicios().forEach(s -> {
            modeloTabla.addRow(new Object[]{
                    s.getId(), s.getIdVehiculo(), s.getDescripcion(),
                    s.getTipo(), s.getCosto(), s.getFecha(), s.getEstado()
            });
        });
    }

    private void limpiar() {
        txtIdVehiculo.setText("");
        txtDescripcion.setText("");
        txtCosto.setText("");
        txtEstado.setText("");
    }
}
