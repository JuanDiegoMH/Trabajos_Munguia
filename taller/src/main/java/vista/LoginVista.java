package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controlador.LoginControlador;

public class LoginVista extends JFrame {

    private LoginControlador loginControlador = new LoginControlador();

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public LoginVista() {
        setTitle("Inicio de Sesión - Taller Mecánico");
        setSize(350, 230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblUsuario = new JLabel("Usuario:");
        JLabel lblPassword = new JLabel("Contraseña:");
        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();

        btnIngresar = new JButton("Ingresar");

        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblPassword);
        panel.add(txtPassword);

        add(panel, BorderLayout.CENTER);
        add(btnIngresar, BorderLayout.SOUTH);

        btnIngresar.addActionListener(e -> autenticar());
    }

    private void autenticar() {
        String usuario = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());

        if (loginControlador.autenticar(usuario, pass)) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + usuario);
            new MenuPrincipal().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }
}
