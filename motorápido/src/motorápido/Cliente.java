package motorápido;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;

    public Cliente(int idCliente, String nombre, String dni, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
