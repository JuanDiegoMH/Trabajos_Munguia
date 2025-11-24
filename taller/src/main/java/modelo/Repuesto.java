package modelo;

public class Repuesto {

    private int id;
    private String nombre;
    private String marca;
    private int stock;

    public Repuesto(int id, String nombre, String marca, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
    }

    public Repuesto() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return nombre + " (" + marca + ")";
    }
}
