package controlador;

import java.util.HashMap;

public class LoginControlador {

    private HashMap<String, String> usuarios = new HashMap<>();

    public LoginControlador() {
        // Usuarios de ejemplo
        usuarios.put("admin", "1234");
        usuarios.put("juan", "1111");
        usuarios.put("usuario", "0000");
    }

    public boolean autenticar(String usuario, String password) {
        if (!usuarios.containsKey(usuario)) return false;
        return usuarios.get(usuario).equals(password);
    }

    public void registrarUsuario(String usuario, String password) {
        usuarios.put(usuario, password);
    }
}
