package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class Pregunta {
    protected String enunciado;
    protected ArrayList<Opcion> opcionesPregunta = new ArrayList<>();
    protected ModoPregunta modo;

    public Pregunta(String unEnunciado, ModoPregunta unModo) {
        enunciado = unEnunciado;
        modo = unModo;
    }

    public abstract int calcularCantidadOpcionesCorrectas();

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

        modo.modificarPuntos(respuesta, calcularCantidadOpcionesCorrectas());
    }

    public void agregarOpcion(Opcion opcion) { opcionesPregunta.add(opcion); }

    public Opcion obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    public int cantidadOpciones(){
        return opcionesPregunta.size();
    }

    public boolean aceptaMultiplicador(){ return modo.aceptaMultiplicador(); }

    public String getEnunciado(){
        return enunciado;
    }

}