package edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class ModoPregunta {
    protected String nombre;

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas, int cantidadOpcionesCorrectaPregunta){
        for (Respuesta respuesta : respuestas) {
            int puntos = calcularPuntos(respuesta, cantidadOpcionesCorrectaPregunta);
            respuesta.modificarPuntosJugador(puntos);
        }
    }

    public abstract int calcularPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectaPregunta);

    public abstract boolean aceptaMultiplicador();

    public abstract boolean aceptaExclusividad();

    public abstract String nombre();
}