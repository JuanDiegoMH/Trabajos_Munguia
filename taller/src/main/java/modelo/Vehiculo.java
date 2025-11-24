package modelo;

public class Vehiculo {

    private int id;
    private int idCliente;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;

    public Vehiculo(int id, int idCliente, String placa, String marca, String modelo, int anio) {
        this.id = id;
        this.idCliente = idCliente;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public Vehiculo() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    @Override
    public String toString() {
        return placa + " (" + marca + " " + modelo + ")";
    }
}
