package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;

public class VoF extends Pregunta {

    public VoF(String unEnunciado, ModoPregunta unModo, ListaOpciones opcionesPregunta) {
        // si ListaOpciones NO ES 2: lanzo excepción
        super(unEnunciado, unModo, opcionesPregunta);
    }
}