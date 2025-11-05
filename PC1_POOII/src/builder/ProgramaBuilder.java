/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;

import model.Programa;

public class ProgramaBuilder {
    private Programa programa;
    public ProgramaBuilder(Programa programa){
        this.programa = programa;
    }
    public ProgramaBuilder agregarHorario(String horario){
        programa.setHorarioInicio(horario);
        return this;
    }
    public ProgramaBuilder agregarProtagonista(String protagonista){
        programa.setProtagonista(protagonista);
        return this;
    }
    public ProgramaBuilder agregarAnio(int anio){
        programa.setAnioProduccion(anio);
        return this;
    }   
    public ProgramaBuilder agregarCensura(String censura){
        programa.setCensura(censura);
        return this;
    }    
    public Programa build(){
        return programa;
    }
    
}
