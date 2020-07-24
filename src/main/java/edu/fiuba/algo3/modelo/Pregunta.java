package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class Pregunta {
    protected String enunciado;
    protected ArrayList<Opcion> opciones;
    protected ModoPregunta modo;

    public void evaluarRespuestas (ArrayList<Respuesta> respuestas) {
        modo.evaluarRespuestas(respuestas);
    }
}
