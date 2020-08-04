package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Respuesta;

public class Clasico implements ModoPregunta {
    static final int PUNTAJE = 1;

    @Override
    public void modificarPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta) {
        int aciertosJugador = respuestaJugador.cantidadOpcionesCorrectas();
        int erroresJugador = respuestaJugador.cantidadOpcionesIncorrectas();

        if(aciertosJugador == cantidadOpcionesCorrectasDeLaPregunta && erroresJugador == 0)
            respuestaJugador.puntuarJugador(PUNTAJE);
    }
}