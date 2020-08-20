package edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import java.util.ArrayList;

public abstract class ModoPregunta {

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas, int cantidadOpcionesCorrectaPregunta){
        for (Respuesta respuesta : respuestas) {
            int puntosASumar = calcularPuntos(respuesta, cantidadOpcionesCorrectaPregunta);
            respuesta.modificarPuntosJugador(puntosASumar);
        }
    }

    public abstract int calcularPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectaPregunta);

    public abstract boolean aceptaMultiplicador();

    public abstract boolean aceptaExclusividad();

    public abstract String nombre();
}