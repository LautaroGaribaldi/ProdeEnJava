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
public class Partido {

    public int nro;
    private ArrayList<Equipo> equipos = new ArrayList(2);

    public Partido() {
    }

    public Partido(int nro) {
        this.nro = nro;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ResultadoEnum resultado() {
        int goles1 = equipos.get(0).goles;
        int goles2 = equipos.get(1).goles;
        int diferenciaGoles = goles1 - goles2;
        int resultado;
        if (diferenciaGoles > 0) {
            resultado = 0;
        } else if (diferenciaGoles < 0) {
            resultado = 1;
        } else {
            resultado = 2;
        }
        ResultadoEnum resultadoPartido = new ResultadoEnum(resultado);

        return (resultadoPartido);
    }

    public void mostrarPartido() {
        System.out.println("Partido numero: " + nro);
        System.out.println("");
        System.out.println(equipos.get(0).nombre + " VS " + equipos.get(1).nombre);
        System.out.println(equipos.get(0).nombre + " goles: " + equipos.get(0).goles);
        System.out.println(equipos.get(1).nombre + " goles: " + equipos.get(1).goles);
    }

}
