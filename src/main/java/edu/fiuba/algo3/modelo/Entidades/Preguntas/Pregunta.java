package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Exclusividad;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import java.util.ArrayList;

public abstract class Pregunta {
    protected String enunciado;
    public ModoPregunta modo;

    public Pregunta(String unEnunciado, ModoPregunta unModo) {
        enunciado = unEnunciado;
        modo = unModo;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        modo.evaluarRespuestas(respuestas, calcularCantidadOpcionesCorrectas());
    }

    public abstract int cantidadOpciones();

    public abstract int calcularCantidadOpcionesCorrectas();

    //Bonificaciones
    public boolean aceptaMultiplicador(){ return modo.aceptaMultiplicador(); }

    public void activarExclusividad() {
        if(!modo.aceptaExclusividad())
            throw new PreguntaNoAceptaExclusividadError();
        modo = new Exclusividad(modo);
    }

    //Getters
    public String enunciado(){
        return enunciado;
    }

    public String modo() {
        return modo.nombre();
    }

    public abstract String tipo();
}