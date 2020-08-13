package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Excepciones.RespuestasInsuficientesError;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Exclusividad;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class Pregunta {
    protected String enunciado;
    protected ArrayList<Opcion> opcionesPregunta = new ArrayList<>();
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

    public void agregarOpcion(Opcion opcion) { opcionesPregunta.add(opcion); }

    public boolean aceptaMultiplicador(){ return modo.aceptaMultiplicador(); }

    public void activarExclusividad() {
        if(!modo.aceptaExclusividad())
            throw new PreguntaNoAceptaExclusividadError();
        modo = new Exclusividad(modo);
    }

    public abstract int calcularCantidadOpcionesCorrectas();

    public Opcion obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    public int cantidadOpciones(){
        return opcionesPregunta.size();
    }

    public String getEnunciado(){
        return enunciado;
    }

    public abstract void crearVista(Stage stage, VistaPrincipal vistaPrincipal);
}