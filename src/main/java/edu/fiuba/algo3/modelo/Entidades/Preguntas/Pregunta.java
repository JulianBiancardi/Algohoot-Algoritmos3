package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Excepciones.RespuestasInsuficientesError;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
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
        if(respuestas.size() == 0){
            throw new RespuestasInsuficientesError();
        }
        modo.evaluarRespuestas(respuestas, calcularCantidadOpcionesCorrectas());
    }

    public boolean aceptaMultiplicador(){ return modo.aceptaMultiplicador(); }

    public void activarExclusividad() {
        if(!modo.aceptaExclusividad())
            throw new PreguntaNoAceptaExclusividadError();
        modo = new Exclusividad(modo);
    }

    public abstract int calcularCantidadOpcionesCorrectas();

    public String getEnunciado(){
        return enunciado;
    }

    public abstract int cantidadOpciones();
}