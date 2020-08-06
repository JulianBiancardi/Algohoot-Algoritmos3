package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exepciones.ChoiceTieneEntreDosYCincoOpcionesError;
import edu.fiuba.algo3.modelo.Exepciones.VoFSoloTieneDosOpcionesError;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.PuntajeParcial;

public class MultipleChoice extends Pregunta {

    public MultipleChoice(String unEnunciado, ModoPregunta unModo, ListaOpciones opcionesPregunta) {
        super(unEnunciado, unModo, opcionesPregunta);
        if(opcionesPregunta.tamaño() < 2  || opcionesPregunta.tamaño() > 5)
            throw new ChoiceTieneEntreDosYCincoOpcionesError();
    }

    public static MultipleChoice conModoClasico(String unEnunciado, ListaOpciones opcionesPregunta){
        MultipleChoice pregunta = new MultipleChoice(unEnunciado,new Clasico(),opcionesPregunta);
        return pregunta;
    }
    public static MultipleChoice conModoPenalidad(String unEnunciado, ListaOpciones opcionesPregunta){
        MultipleChoice pregunta = new MultipleChoice(unEnunciado,new Penalidad(),opcionesPregunta);
        return pregunta;
    }
    public static MultipleChoice conModoPuntajeParcial(String unEnunciado, ListaOpciones opcionesPregunta){
        MultipleChoice pregunta = new MultipleChoice(unEnunciado,new PuntajeParcial(),opcionesPregunta);
        return pregunta;
    }
}
