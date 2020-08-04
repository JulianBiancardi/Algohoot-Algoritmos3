package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.RespuestaJugadorSinOpcionIngresadaExcepcion;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Entidades.Respuesta;

import java.util.ArrayList;

public abstract class Pregunta {
    protected String enunciado;
    protected int cantidadOpcionesCorrectas;
    protected ModoPregunta modo;

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            evaluarUnaRespuesta(respuesta);
        }
    }
    private void evaluarUnaRespuesta(Respuesta respuesta) {
        if(respuesta.cantidadOpcionesCorrectas() == 0 && respuesta.cantidadOpcionesIncorrectas() == 0)
            throw new RespuestaJugadorSinOpcionIngresadaExcepcion();
        modo.modificarPuntos(respuesta, cantidadOpcionesCorrectas);
    }
}