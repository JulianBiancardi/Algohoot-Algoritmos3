package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.CriterioPuntuacion;
import edu.fiuba.algo3.modelo.Entidades.Respuesta;

public class Clasico implements ModoPregunta {
    private final static int factorAumento = 1;
    private final static int factorDisminucion = 0;

    private final CriterioPuntuacion criterioPuntuacion = new CriterioPuntuacion(factorAumento, factorDisminucion);

    @Override
    public void modificarPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta) {
        int aciertosJugador = respuestaJugador.cantidadOpcionesCorrectas();
        int erroresJugador = respuestaJugador.cantidadOpcionesIncorrectas();

        if(aciertosJugador == cantidadOpcionesCorrectasDeLaPregunta && erroresJugador == 0)
            respuestaJugador.puntuarJugador(criterioPuntuacion, 1);
    }
}