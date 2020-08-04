package edu.fiuba.algo3.modelo.Entidades;

import java.util.Hashtable;

public class Puntuacion {
    private int puntos = 0;
    private final Hashtable<Integer, Multiplicador> multiplicadores = new Hashtable<>();
    private Multiplicador beneficioActual = Multiplicador.crearSinEfecto();

    public void agregarMultiplicador(int idMultiplicador, Multiplicador multiplicador) {
        multiplicadores.put(idMultiplicador, multiplicador);
    }

    public void utilizarMultiplicador(int idMultiplicador) {
        beneficioActual = multiplicadores.get(idMultiplicador);
        multiplicadores.replace(idMultiplicador, Multiplicador.crearSinEfecto());
    }

    public void modificarPuntosConMultiplicador(int factorModificacion, int aciertosJugador) {
        puntos = puntos + beneficioActual.obtenerPuntosBonificados(factorModificacion, aciertosJugador);
        beneficioActual = Multiplicador.crearSinEfecto();
    }

    public void modificarPuntos(int factorModificacion, int aciertosJugador) {
        puntos = puntos + factorModificacion*aciertosJugador;
    }

    public int obtenerPuntos() {
        return puntos;
    }

    public int cantidadMultiplicadores() {
        return multiplicadores.size();
    }

    public Multiplicador obtenerMultiplicadorDeId(int identificador) {
        return multiplicadores.get(identificador);
    }
}
