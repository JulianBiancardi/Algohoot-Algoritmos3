package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador implements Observable{
    private final String nombre;
    private int puntos;
    ArrayList<Observador> observadores = new ArrayList<Observador>();

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    public void sumarPuntos(int puntaje) {
        puntos += puntaje;
        notificarObservadores();
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


    @Override
    public void agregarObservador(Observador unObservador) {
        observadores.add(unObservador);
    }

    @Override
    public void notificarObservadores() {
        observadores.stream().forEach(observador -> observador.actualizar());
    }
}
