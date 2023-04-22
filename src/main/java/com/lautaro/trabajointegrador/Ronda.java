/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautaro.trabajointegrador;

import java.util.ArrayList;

/**
 *
 * @author Lautaro
 */
public class Ronda {
    public int nro;
    private ArrayList<Partido> partidos = new ArrayList();

    public Ronda() {
    }

    public Ronda(int nro) {
        this.nro = nro;
    }
    
    public void mostrarRonda(){
        System.out.println("Ronda numero: " + nro);
        for(int i = 0; i< partidos.size();i++){
        partidos.get(i).mostrarPartido();
        }
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
    
}
