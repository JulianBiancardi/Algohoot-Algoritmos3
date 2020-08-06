package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exepciones.VoFSoloTieneDosOpcionesError;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;

public class VoF extends Pregunta {

    public VoF(String unEnunciado, ModoPregunta unModo, ListaOpciones opcionesPregunta)  {
        super(unEnunciado, unModo, opcionesPregunta);
        if(opcionesPregunta.tamaño() != 2)
            throw new VoFSoloTieneDosOpcionesError();
    }

    public static VoF conModoClasico(String unEnunciado, ListaOpciones opcionesPregunta){
        VoF pregunta = new VoF(unEnunciado,new Clasico(),opcionesPregunta);
        return pregunta;
    }
    public static VoF conModoPenalidad(String unEnunciado, ListaOpciones opcionesPregunta){
        VoF pregunta = new VoF(unEnunciado,new Penalidad(),opcionesPregunta);
        return pregunta;
    }
}