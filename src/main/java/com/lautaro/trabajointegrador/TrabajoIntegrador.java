/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.lautaro.trabajointegrador;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lautaro
 */
public class TrabajoIntegrador {

    public static void main(String[] args) {

        //Definicion de ronda,partidos y equipos.
        Ronda r1 = new Ronda(1);
        Partido p1 = new Partido(1);
        Partido p2 = new Partido(2);
        Partido p3 = new Partido(3);
        Equipo e1 = new Equipo("Racing", 2, "Goles de Rojas y gordona");
        Equipo e2 = new Equipo("Independiente", 1, "Altos Pechofrio");
        Equipo e3 = new Equipo("Boca", 1, "Gol de villa");
        Equipo e4 = new Equipo("River", 1, "gol de alguna gallina");
        Equipo e5 = new Equipo("Lanus", 1, "gol de algun lanuniense");
        Equipo e6 = new Equipo("Banfield", 2, "gol de algun banfielano");

        Ronda r2 = new Ronda(2);
        Partido p4 = new Partido(4);
        Partido p5 = new Partido(5);
        Partido p6 = new Partido(6);
        Equipo e7 = new Equipo("Talleres de escalada", 2, "Goles de Rojas y gordona");
        Equipo e8 = new Equipo("Belgrano", 1, "Altos Pechofrio");
        Equipo e9 = new Equipo("Ferro", 1, "Gol de villa");
        Equipo e10 = new Equipo("San lorenzo", 1, "gol de alguna gallina");
        Equipo e11 = new Equipo("Temperley", 1, "gol de algun lanuniense");
        Equipo e12 = new Equipo("Los andes", 2, "gol de algun banfielano");

        // Lleno mis partidos con equipos y mi ronda con partidos.
        p1.getEquipos().add(e1);
        p1.getEquipos().add(e2);
        p2.getEquipos().add(e3);
        p2.getEquipos().add(e4);
        p3.getEquipos().add(e5);
        p3.getEquipos().add(e6);
        r1.getPartidos().add(p1);
        r1.getPartidos().add(p2);
        r1.getPartidos().add(p3);

        p4.getEquipos().add(e7);
        p4.getEquipos().add(e8);
        p5.getEquipos().add(e9);
        p5.getEquipos().add(e10);
        p6.getEquipos().add(e11);
        p6.getEquipos().add(e12);
        r2.getPartidos().add(p4);
        r2.getPartidos().add(p5);
        r2.getPartidos().add(p6);
        //
        ArrayList<Ronda> rondas = new ArrayList(); // defino una coleccion de rondas
        rondas.add(r1); //agrego mi ronda
        rondas.add(r2);

        //Definicion cantidad de Jugadores
        int cantidad = validarCantidadJugadores(JOptionPane.showInputDialog("Bienvenido al Prode, cuantas personas van a jugar?"));

        // creo un array con la cantidad de jugadores definida antes.
        Jugador[] jugadores = crearJugadores(cantidad, rondas);

        //Muestro los jugadores
        mostrarJugadores(jugadores);

        System.out.println("");

        System.out.println("-----------------------------------------------------------------");

        // Comienza la logica de partidos.
        System.out.println("Empiezan los partidos!");
        simularRonda(rondas, jugadores); // Simula los partidos y agrega los puntos

    }

    public static void simularRonda(ArrayList<Ronda> rondas, Jugador[] jugadores) {
        //Variables auxiliares
        int nroPartido;
        int resultado;
        String equipo1;
        String equipo2;
        String equipoGanador;
        //Variables auxiliares
        for (int z = 0; z < rondas.size(); z++) {
            Ronda rondaActual = rondas.get(z);
            System.out.println("Ronda numero: " + rondaActual.nro);
            for (int i = 0; i < rondaActual.getPartidos().size(); i++) {
                nroPartido = rondaActual.getPartidos().get(i).nro; // extraigo el nro de partido
                resultado = rondaActual.getPartidos().get(i).resultado().resultado;    // Extraigo el resultado del partido
                rondaActual.getPartidos().get(i).mostrarPartido();
                System.out.println("");
                if (resultado != 2) {   // si el resultado no es 2, veo quien fue el ganador
                    equipoGanador = rondaActual.getPartidos().get(i).getEquipos().get(resultado).nombre; // Extraigo nombre ganador
                    System.out.println("El ganador es " + equipoGanador + "!");
                    System.out.println("");
                } else {
                    System.out.println("Es un empate!");    // sino es un empate.
                    System.out.println("");
                }
                mostrarApuesta(jugadores, nroPartido);  // extraigo la logica de simulacion a la de sumar puntos.

                System.out.println("-----------------------------------------------------------------");
            }
        }
        System.out.println("Ranking:");
        System.out.println("");
        mostrarPuntos(jugadores);

    }

    public static void mostrarApuesta(Jugador[] jugadores, int nroPartido) {
        Jugador jugadorActual;
        String nombreApuesta;
        String nombreJugador;
        int apuesta;
        for (int j = 0; j < jugadores.length; j++) {
            jugadorActual = jugadores[j];  // extraigo el jugador actual
            apuesta = jugadorActual.apuesta.get((nroPartido - 1)).getApuesta();    // extraigo apuesta del jugador acutal
            nombreJugador = jugadorActual.getNombreJugador();   //Extraigo el nombre del jugador actual
            if (apuesta != 2) {  // si apuesta es diferente de 2 el aposto por un equipo en concreto.
                nombreApuesta = jugadorActual.apuesta.get((nroPartido - 1)).getPartido().getEquipos().get(apuesta).nombre;  // extraigo nombre del equipo apostado
                System.out.println(nombreJugador + " aposto por " + nombreApuesta);
                System.out.println("");
            } else {
                System.out.println(nombreJugador + " aposto por empate");  // sino aposto por empate
                System.out.println("");
            }
        }
    }

    public static Jugador[] crearJugadores(int cantidadJugadores, ArrayList<Ronda> rondas) {
        Jugador jugadores[] = new Jugador[cantidadJugadores];

        for (int i = 0; i < jugadores.length; i++) {
            String nombreJugador = JOptionPane.showInputDialog("Ingrese nombre del jugador:");
            //System.out.println(nombreJugador);
            //Valido si me paso un nombre valido
            while (nombreJugador.equals("")) {
                System.out.println("Ingresa un nombre!");
                nombreJugador = JOptionPane.showInputDialog("Ingrese nombre del jugador:");
            }
            jugadores[i] = new Jugador((i + 1), nombreJugador, 0);

            for (int j = 0; j < rondas.size(); j++) {
                ArrayList<Partido> partidos = rondas.get(j).getPartidos();
                for (int x = 0; x < partidos.size(); x++) {
                    String equipo1 = partidos.get(x).getEquipos().get(0).nombre;
                    String equipo2 = partidos.get(x).getEquipos().get(1).nombre;
                    String eleccion = (JOptionPane.showInputDialog("Partido" + equipo1 + " vs " + equipo2 + "Elige: \n gana " + equipo1 + ": 0. gana " + equipo2 + ": 1. empate: 2"));
                    //Valido si ingreso un valor correcto.
                    while ((!eleccion.equals("0")) && (!eleccion.equals("1")) && (!eleccion.equals("2"))) {
                        System.out.println("Valor ingresado no valido!");
                        eleccion = (JOptionPane.showInputDialog("Partido" + equipo1 + " vs " + equipo2 + "Elige: \n gana " + equipo1 + ": 0. gana " + equipo2 + ": 1. empate: 2"));
                    }
                    int apuesta = Integer.parseInt(eleccion);

                    Pronostico a1 = new Pronostico(apuesta, partidos.get(x));
                    jugadores[i].apuesta.add(a1);

                }
            }

        }
        return (jugadores);

    }

    public static void mostrarJugadores(Jugador[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i].mostrarJugador();
            System.out.println("");
        }
    }

    public static void mostrarPuntos(Jugador[] jugadores) {

        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i].puntos();
        }
        ordenarPorPuntaje(jugadores);

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Puntos de " + jugadores[i].getNombreJugador() + ": " + jugadores[i].getPuntosObtenidos());
            System.out.println("");
            System.out.println("");
        }
    }

    public static boolean esNumero(String eleccion) {
        if (eleccion == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(eleccion);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void ordenarPorPuntaje(Jugador[] jugadores) {
        int index;
        int contador;
        boolean estaOrdenado = false;

        while (!estaOrdenado) {
            contador = 0;
            index = 0;
            estaOrdenado = true;
            for (; contador < jugadores.length - 1; contador++) {
                if (jugadores[index].getPuntosObtenidos() < jugadores[index + 1].getPuntosObtenidos()) {
                    Jugador auxiliar = jugadores[index + 1];
                    jugadores[index + 1] = jugadores[index];
                    jugadores[index] = auxiliar;
                    estaOrdenado = false;
                }

                index = index + 1;
            }
        }
    }

    public static int validarCantidadJugadores(String eleccion) {
        String cantidadEleccion = eleccion;
        while (!esNumero(cantidadEleccion) || Integer.parseInt(cantidadEleccion) <= 0) {
            System.out.println(" Debes ingresar un numero valido!");
            cantidadEleccion = JOptionPane.showInputDialog("Bienvenido al Prode, cuantas personas van a jugar?");
        }
        return (Integer.parseInt( cantidadEleccion));
    }
}
