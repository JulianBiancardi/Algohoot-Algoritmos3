package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.CriterioMultiplicador;
import edu.fiuba.algo3.modelo.Entidades.CriterioPuntuacion;
import edu.fiuba.algo3.modelo.Entidades.Respuesta;

public class Penalidad implements ModoPregunta {
    private final static int factorAumento = 1;
    private final static int factorDisminucion = 1;

    private final CriterioPuntuacion criterioPuntuacion = new CriterioMultiplicador(factorAumento, factorDisminucion);

    @Override
    public void modificarPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta) {
        int aciertosJugador = respuestaJugador.cantidadOpcionesCorrectas();
        int erroresJugador = respuestaJugador.cantidadOpcionesIncorrectas();

        respuestaJugador.puntuarJugador(criterioPuntuacion, aciertosJugador);
        respuestaJugador.penalizarJugador(criterioPuntuacion, erroresJugador);
    }
}