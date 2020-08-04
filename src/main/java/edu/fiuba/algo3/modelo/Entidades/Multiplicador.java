package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Excepciones.MultiplicadorCreadoConFactorInvalidoExcepcion;

public class Multiplicador {
    private final int multiplicidad;

    private Multiplicador(int factor) {
        this.multiplicidad = factor;
    }

    public static Multiplicador crearConFactor(int factor) {
        if(factor < 1){
            throw new MultiplicadorCreadoConFactorInvalidoExcepcion();
        }
        return new Multiplicador(factor);
    }

    public static Multiplicador crearSinEfecto() {
        return new Multiplicador(1);
    }

    public int obtenerPuntosBonificados(int factorAumento, int aciertosJugador) {
        return multiplicidad*factorAumento*aciertosJugador;
    }
}
