package com.mycompany.app;
import hilo.HiloAgregarObservador;
import modelo.Pago;
import observador.*;
import pago.*;
import servicio.ProcesadorPago;


public class App {

    public static void main(String[] args) {
        SujetoPago sujeto = new SujetoPago();
        ProcesadorPago procesador = new ProcesadorPago(sujeto);
        
        new HiloAgregarObservador(sujeto, new AppUsuarioObservador()).start();
        new HiloAgregarObservador(sujeto, new ContabilidadObservador()).start();
        
        try { Thread.sleep(300); 
        } catch(Exception e) {
        e.printStackTrace();
        }
        
        procesador.setMetodoPago(new PagoYape());
        procesador.procesar(50);
        
        procesador.setMetodoPago(new PagoTarjeta());
        procesador.procesar(100);
        
        procesador.setMetodoPago(new PagoEfectivo());
        procesador.procesar(20);
            
            }
}
