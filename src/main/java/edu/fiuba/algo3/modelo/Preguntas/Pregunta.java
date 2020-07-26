package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

abstract class Pregunta {
    protected String enunciado;
    protected ListaOpciones opciones = new ListaOpciones();
    protected int cantidadCorrectas;
    protected ModoPregunta modo;

    public ListaOpciones obtenerOpciones(){ return opciones; }

    protected abstract void evaluarRespuesta(Respuesta respuesta);

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas){
        for (Respuesta respuesta : respuestas) {
            evaluarRespuesta(respuesta);
        }
    }
}
