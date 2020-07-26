package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

public class Jugador {
    private final String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    public void agregarOpcion(Opcion opcion, Respuesta respuesta){ respuesta.agregarOpcion(opcion); }

    public void sumarPuntos(int puntaje) {
        puntos += puntaje;
    }

    public void restarPuntos(int puntaje) {
        puntos -= puntaje;
    }

    public int puntos() { return puntos; }

    public String nombre() { return nombre; }
}
