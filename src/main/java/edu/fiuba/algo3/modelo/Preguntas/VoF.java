package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;

public class VoF extends Pregunta {

    public VoF(String unEnunciado, ModoPregunta unModo)  {
        super(unEnunciado, unModo);
    }

    public static VoF conModoClasico(String unEnunciado){
        VoF pregunta = new VoF(unEnunciado, new Clasico());
        return pregunta;
    }

    public static VoF conModoPenalidad(String unEnunciado){
        VoF pregunta = new VoF(unEnunciado, new Penalidad());
        return pregunta;
    }

    public void agregarOpcion(OpcionBinaria opcion){
        super.agregarOpcion(opcion);
    }

    public OpcionBinaria obtenerOpcion(int posicion){
        return (OpcionBinaria) super.obtenerOpcion(posicion);
    }

    public int calcularCantidadOpcionesCorrectas(){
        return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count();
    }
}