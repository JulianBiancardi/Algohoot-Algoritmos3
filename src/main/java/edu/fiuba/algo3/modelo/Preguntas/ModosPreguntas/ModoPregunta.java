package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public interface ModoPregunta {
    void modificarPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta);

    boolean aceptaMultiplicador();
}