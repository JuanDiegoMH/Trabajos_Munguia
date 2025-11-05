// Proyecto: Sistema de Gestión de Servicios - MotoRápido Perú
// Lenguaje: Java
// Autor: Grupo 7
// Avance: 20%

package motorápido;

import java.util.Date;

public class Motorapido  {
    public static void main(String[] args) {
        
        // VARIABLES PRINCIPALES
        int idCliente;
        String nombreCliente;
        String dniCliente;
        String telefonoCliente;
        String direccionCliente;

        int idVehiculo;
        String placaVehiculo;
        String marcaVehiculo;
        String modeloVehiculo;
        int anioVehiculo;

        int idServicio;
        String tipoServicio;
        String descripcionServicio;
        double costoServicio;
        Date fechaServicio;

        Cliente cliente1 = new Cliente(1, "Juan Diego Munguia", "73214568", "987654321", "Lima");
        Vehiculo moto1 = new Vehiculo(1, "ABC-456", "Yamaha", "FZ25", 2022);
        Servicio servicio1 = new Servicio(1, "Mantenimiento general", "Cambio de aceite y revisión general", 120.0, new Date());
        
        System.out.println("Cliente: " + cliente1.getNombre());
        System.out.println("Vehículo: " + moto1.getMarca() + " - " + moto1.getPlaca());
        System.out.println("Servicio: " + servicio1.getTipo() + " - S/ " + servicio1.getCosto());
    }
}

