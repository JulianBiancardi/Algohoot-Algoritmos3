package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exepciones.ChoiceTieneEntreDosYCincoOpcionesError;
import edu.fiuba.algo3.modelo.Exepciones.VoFSoloTieneDosOpcionesError;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.PuntajeParcial;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta {

    private MultipleChoice(String unEnunciado, ModoPregunta unModo) {

        super(unEnunciado, unModo);
        /*
        if(opcionesPregunta.tamaño() < 2  || opcionesPregunta.tamaño() > 5)
            throw new ChoiceTieneEntreDosYCincoOpcionesError();
        */
    }

    public static MultipleChoice conModoClasico(String unEnunciado){ return new MultipleChoice(unEnunciado, new Clasico()); }

    public static MultipleChoice conModoPenalidad(String unEnunciado){ return new MultipleChoice(unEnunciado, new Penalidad()); }

    public static MultipleChoice conModoPuntajeParcial(String unEnunciado){ return new MultipleChoice(unEnunciado, new PuntajeParcial()); }

    public void agregarOpcion(String descripcion,boolean esCorrecta){
        OpcionBinaria opcion = new OpcionBinaria(descripcion,esCorrecta);
        super.agregarOpcion(opcion);
    }

    public OpcionBinaria obtenerOpcion(int posicion){ return (OpcionBinaria) super.obtenerOpcion(posicion); }

    public int calcularCantidadOpcionesCorrectas(){ return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count(); }
}
