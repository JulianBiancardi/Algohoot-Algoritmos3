package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private ArrayList<Character> opcionesElegidas = new ArrayList<Character>();
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    public void responder (Character unaOpcion) { opcionesElegidas.add(unaOpcion); }

    public ArrayList<Character> getOpcionesElegidas () { return opcionesElegidas; }

    public void sumarPuntos(int puntaje) {
        puntos += puntaje;
    }

    public void restarPuntos(int puntaje) {
        puntos -= puntaje;
    }

    public int puntos() { return puntos; }

    public String nombre() { return nombre; }
}
