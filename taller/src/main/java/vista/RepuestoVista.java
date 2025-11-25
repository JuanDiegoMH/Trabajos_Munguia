package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import controlador.RepuestoControlador;

public class RepuestoVista extends JFrame {

    private RepuestoControlador controlador = new RepuestoControlador();
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JTextField txtNombre, txtMarca, txtStock;

    public RepuestoVista() {
        setTitle("Gestión de Repuestos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelForm.add(txtMarca);

        panelForm.add(new JLabel("Stock:"));
        txtStock = new JTextField();
        panelForm.add(txtStock);

        JButton btnAgregar = new JButton("Agregar Repuesto");
        panelForm.add(btnAgregar);

        add(panelForm, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"ID","Nombre","Marca","Stock"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> agregar());
        cargar();
    }

    private void agregar() {
        controlador.registrarRepuesto(
                txtNombre.getText(),
                txtMarca.getText(),
                Integer.parseInt(txtStock.getText())
        );

        cargar();
        limpiar();
    }

    private void cargar() {
        modeloTabla.setRowCount(0);

        controlador.listarRepuestos().forEach(r -> {
            modeloTabla.addRow(new Object[]{
                r.getId(), r.getNombre(), r.getMarca(), r.getStock()
            });
        });
    }

    private void limpiar() {
        txtNombre.setText("");
        txtMarca.setText("");
        txtStock.setText("");
    }
}
