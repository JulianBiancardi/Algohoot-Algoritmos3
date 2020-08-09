package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Exclusividad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class Pregunta {
    protected String enunciado;
    protected ArrayList<Opcion> opcionesPregunta = new ArrayList<>();
    public ModoPregunta modo;

    public Pregunta(String unEnunciado, ModoPregunta unModo) {
        enunciado = unEnunciado;
        modo = unModo;
    }

    public abstract int calcularCantidadOpcionesCorrectas();

    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        modo.evaluarRespuestas(respuestas, calcularCantidadOpcionesCorrectas());
    }

    public void agregarOpcion(Opcion opcion) { opcionesPregunta.add(opcion); }

    public Opcion obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    public int cantidadOpciones(){
        return opcionesPregunta.size();
    }

    public boolean aceptaMultiplicador(){ return modo.aceptaMultiplicador(); }

    public void activarExclusividad() {
        if(this.aceptaMultiplicador())
            throw new PreguntaNoAceptaExclusividadError();
        modo = new Exclusividad(modo);
    }
}