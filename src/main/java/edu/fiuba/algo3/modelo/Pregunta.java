package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;

abstract class Pregunta {
    protected String enunciado;
    protected Hashtable<Character, Opcion> opciones = new Hashtable<Character, Opcion>();
    protected Character idOpcion = 'A';
    protected ModoPregunta modo;

    public void evaluarRespuestas (ArrayList<Jugador> jugadores) {

        modo.evaluarRespuestas(jugadores, opciones);
    }
}
