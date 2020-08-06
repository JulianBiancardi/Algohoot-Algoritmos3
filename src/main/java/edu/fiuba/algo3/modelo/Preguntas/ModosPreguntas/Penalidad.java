package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public class Penalidad implements ModoPregunta {
    static final int PUNTAJE = 1;

    @Override
    public void modificarPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta) {
        int aciertosJugador = respuestaJugador.cantidadOpcionesCorrectas();
        int erroresJugador = respuestaJugador.cantidadOpcionesIncorrectas();

        respuestaJugador.modificarPuntosBonificadamente( PUNTAJE * aciertosJugador);
        respuestaJugador.modificarPuntosBonificadamente(-1 * PUNTAJE * erroresJugador);
    }
}