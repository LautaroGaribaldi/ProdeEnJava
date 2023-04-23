/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautaro.trabajointegrador;

/**
 *
 * @author Lautaro
 */
public class Equipo {
    public String nombre;
    public int goles;
    public String descripccion;

    public Equipo() {
    }

    public Equipo(String nombre, int goles, String descripccion) {
        this.nombre = nombre;
        this.goles = goles;
        this.descripccion = descripccion;
    }
    
    
    public void mostrarEquipo(){
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("Goles realizados: " + goles);
        System.out.println("Autores de los goles: " + descripccion);
    }
}
