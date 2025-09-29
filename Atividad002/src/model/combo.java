/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class combo {
    private String base;
    private String bebida;
    private String acompanamiento;
    private String extra;

    public combo(String base) {
        this.base = base;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public void setAcompanamiento(String acompanamiento) {
        this.acompanamiento = acompanamiento;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Combo [Base=" + base +
                ", Bebida=" + bebida +
                ", Acompañamiento=" + acompanamiento +
                ", Extra=" + extra + "]";
    }
}
