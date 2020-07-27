package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

abstract class Pregunta {
    protected String enunciado;
    protected int cantidadOpcionesCorrectas;
    protected ModoPregunta modo;

    public Pregunta(String unEnunciado, ModoPregunta unModo, ListaOpciones opcionesPregunta) {
        cantidadOpcionesCorrectas = opcionesPregunta.cantidadOpcionesCorrectas();
        modo = unModo;
        enunciado = unEnunciado;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            evaluarUnaRespuesta(respuesta);
        }
    }

    private void evaluarUnaRespuesta(Respuesta respuesta) {
        /* Si recibo una respuesta con
         *        cantidadOpcionesCorrectas() == 0
         *                     &&
         *        cantidadOpcionesIncorrectas() == 0
         *  ... lanzo excepción. Solo evalúo respuestas con a lo sumo una opción ingresada */
        modo.modificarPuntos(respuesta, cantidadOpcionesCorrectas);
    }
}