package edu.fiuba.algo3.modelo;

public class Jugador {
    private final String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    public void sumarPuntos(int puntaje) {
        puntos += puntaje;
    }

    public void restarPuntos(int puntaje) {
        puntos -= puntaje;
    }

    // POR AHORA sólo sirven para tests:

    public int puntos() {
        return puntos;
    }

    public String nombre() {
        return nombre;
    }
}
