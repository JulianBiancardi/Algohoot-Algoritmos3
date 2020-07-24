package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private ArrayList<Opcion> opciones;
    static final int PUNTAJE = 1;

    public Pregunta (String unEnunciado, ArrayList<Opcion> listaOpciones) {
        enunciado = unEnunciado;
        opciones = listaOpciones;
    }

    public void evaluarRespuestas (ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if(respuesta.esCorrecta()) {
                respuesta.sumarPuntos(PUNTAJE);
            }
        }
    }
}
