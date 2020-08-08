package edu.fiuba.algo3.modelo.Entidades;

public class Multiplicador {
    private final int multiplicidad;

    private Multiplicador(int factor) {
        this.multiplicidad = factor;
    }

    public static Multiplicador crearMultiplicadorNulo(){ return new Multiplicador(1); }

    public static Multiplicador crearMultiplicadorDoble(){ return new Multiplicador(2); }

    public static Multiplicador crearMultiplicadorTriple(){ return new Multiplicador(3); }

    public static Multiplicador crearMultiplicadorCuadruple(){ return new Multiplicador(4); }

    public int aplicarMultiplicador(int puntaje){
        return puntaje * multiplicidad;
    }
}