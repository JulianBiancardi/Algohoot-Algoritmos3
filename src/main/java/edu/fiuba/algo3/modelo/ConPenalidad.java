package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;

public class ConPenalidad implements ModoPregunta {

    @Override
    public void evaluarRespuestas(ArrayList<Jugador> jugadores, Hashtable<Character, Opcion> opciones) {
        for (Jugador jugador : jugadores) {
            for (Character opcionElegida : jugador.getOpcionesElegidas()) {
                if(opciones.get(opcionElegida).esCorrecta()) {
                    jugador.sumarPuntos(PUNTAJE);
                } else {
                    jugador.restarPuntos(PUNTAJE);
                }
            }
        }
    }
}
