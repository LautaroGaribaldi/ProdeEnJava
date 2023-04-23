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
    private String nombre;
    private int goles;
    private String descripccion;

    public Equipo() {
    }

    public Equipo(String nombre, int goles, String descripccion) {
        this.nombre = nombre;
        this.goles = goles;
        this.descripccion = descripccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }
    
    
    
    
    public void mostrarEquipo(){
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("Goles realizados: " + goles);
        System.out.println("Autores de los goles: " + descripccion);
    }
}
