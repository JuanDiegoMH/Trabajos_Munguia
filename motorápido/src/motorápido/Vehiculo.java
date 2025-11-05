package motorápido;

public class Vehiculo {
    private int idVehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;

    
    public Vehiculo(int idVehiculo, String placa, String marca, String modelo, int anio) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }
}