package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class ModoPregunta {

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas, int calcularCantidadOpcionesCorrectas){
        for (Respuesta respuesta : respuestas) {
            int puntos = calcularPuntos(respuesta, calcularCantidadOpcionesCorrectas);
            respuesta.modificarPuntos(puntos);
        }
    }

    public abstract int calcularPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta);

    public abstract boolean aceptaMultiplicador();

    public abstract boolean aceptaExclusividad();
}