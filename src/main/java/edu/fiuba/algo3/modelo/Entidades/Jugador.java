package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;

import java.util.ArrayList;

public class Jugador implements Observable {
    private final String nombre;
    private int puntajeJugador;
    ArrayList<Observador> observadores = new ArrayList<Observador>();
    private Multiplicador multiplicadorDoble = Multiplicador.crearConFactor(2);
    private Multiplicador multiplicadorTriple = Multiplicador.crearConFactor(3);
    private Multiplicador multiplicadorActivo = Multiplicador.crearSinEfecto();

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntajeJugador = 0;
    }

    public void modificarPuntosBonificadamente(int puntos) {
        this.modificarPuntos(multiplicadorActivo.obtenerPuntosBonificados(puntos));
        multiplicadorActivo = Multiplicador.crearSinEfecto();
    }

    public void modificarPuntos(int puntaje) {
        puntajeJugador = puntajeJugador + puntaje;
        notificarObservadores();
    }

    public void utilizarMultiplicadorDoble() {
        multiplicadorActivo = multiplicadorDoble;
        multiplicadorDoble = Multiplicador.crearSinEfecto();
    }

    public void utilizarMultiplicadorTriple() {
        multiplicadorActivo = multiplicadorTriple;
        multiplicadorTriple = Multiplicador.crearSinEfecto();
    }

    public int puntos() {
        return puntajeJugador;
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
