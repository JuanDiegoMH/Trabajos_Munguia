
package model;

public abstract class Programa implements Comparable<Programa>{
    private String nombre;
    private String horarioInicio;
    private String protagonista;
    private int anioProduccion;
    private String censura;
    
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}
    
    public String getHorarioInicio(){return horarioInicio;}
    public void setHorarioInicio(String horarioInicio){this.horarioInicio=horarioInicio;}
    
    
    public String getProtagonista(){return protagonista;}
    public void setProtagonista(String protagonista){this.protagonista=protagonista;}
    
    public int getAnioProduccion(){return anioProduccion;}
    public void setAnioProduccion(int anioProduccion){this.anioProduccion=anioProduccion;}
    
    public String getCensura(){return censura;}
    public void setCensura(String censura){this.censura=censura;}
    
    @Override
    public int compareTo(Programa p){
       return this.horarioInicio.compareTo(p.horarioInicio);
    }
    
    @Override
    public String toString(){
        return horarioInicio + " - " + nombre + "("+ anioProduccion+")- Censura: "+censura;
    }
}
