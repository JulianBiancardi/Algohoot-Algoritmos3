package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class Pregunta {
    protected String enunciado;
    protected ListaOpciones opciones = new ListaOpciones(); //Esto capaz vuela!
    protected ModoPregunta modo;

    public ListaOpciones obtenerOpciones(){ return opciones; }

    public abstract void evaluarRespuesta(Respuesta respuesta);

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas) {
            evaluarRespuesta(respuesta);
        }
    }
}
