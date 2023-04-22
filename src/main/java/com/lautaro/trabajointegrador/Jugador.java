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
public class Jugador {

    public int nroJugador;
    private String nombreJugador;
    private int puntosObtenidos;
    public ArrayList<Pronostico> apuesta = new ArrayList();

    public Jugador() {
    }

    public Jugador(int nroJugador, String nombreJugador, int puntosObtenidos) {
        this.nroJugador = nroJugador;
        this.nombreJugador = nombreJugador;
        this.puntosObtenidos = puntosObtenidos;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public void mostrarJugador() {
        System.out.println("Mostrando datos del jugador numero " + nroJugador + ":");
        System.out.println("nombre: " + nombreJugador);
        int eleccion;
        String ganador;
        if (apuesta.isEmpty()) {
            System.out.println("");
            System.out.println("Todavia no ah realizado apuestas.");
        } else {
            System.out.println("Apuestas realizadas:");
            System.out.println("");
            for (int i = 0; i < apuesta.size(); i++) {
                eleccion = apuesta.get(i).getApuesta();
                
                if (eleccion != 2) {
                    ganador = apuesta.get(i).getPartido().getEquipos().get(eleccion).nombre;
                    System.out.println((i + 1) + ". " + ganador);
                } else {
                    System.out.println((i+1) +". Empate");
                }
            }
        }
        System.out.println("Puntos obtenidos: " + puntosObtenidos);
    }
    
    public void puntos(){
        
        for(int i = 0; i< apuesta.size();i++){
            int apuestaRealizada = apuesta.get(i).resultado().resultado;
            int resultadoPartido = apuesta.get(i).getPartido().resultado().resultado;
            //System.out.println("apuesta realizada:" + apuestaRealizada);
            //System.out.println("resultado partido:" + resultadoPartido);
            
            if(apuestaRealizada == resultadoPartido){
                puntosObtenidos = puntosObtenidos + 1;
            }
        }
    }
}
