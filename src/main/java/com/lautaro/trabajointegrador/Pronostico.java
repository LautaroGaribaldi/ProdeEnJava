/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautaro.trabajointegrador;

/**
 *
 * @author Lautaro
 */
public class Pronostico {
    
    private int apuesta;
    private Partido partido;

    public Pronostico() {
    }

    public Pronostico(int apuesta, Partido partido) {
        this.apuesta = apuesta;
        this.partido = partido;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }
    
    
    
    public ResultadoEnum resultado(){
       ResultadoEnum a = new ResultadoEnum(apuesta);
       return(a);
    }
}
