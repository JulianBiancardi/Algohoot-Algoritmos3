package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class ModoPregunta {

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas, int calcularCantidadOpcionesCorrectas){
        for (Respuesta respuesta : respuestas) {
            modificarPuntos(respuesta, calcularCantidadOpcionesCorrectas);
        }
    }

    public abstract void modificarPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta);

    public abstract boolean aceptaMultiplicador();

}