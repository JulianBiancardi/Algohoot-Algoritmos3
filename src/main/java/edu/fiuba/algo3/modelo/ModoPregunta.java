package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;

public interface ModoPregunta {
    static final int PUNTAJE = 1;

    void evaluarRespuestas(ArrayList<Jugador> jugadores, Hashtable<Character, Opcion> opciones);
}
