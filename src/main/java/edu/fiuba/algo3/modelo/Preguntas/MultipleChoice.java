package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;

public class MultipleChoice extends Pregunta {

    public MultipleChoice(String unEnunciado, ModoPregunta unModo, ListaOpciones opcionesPregunta) {
        // si ListaOpciones mayor a 5, o menor a 2: lanzo excepción
        super(unEnunciado, unModo, opcionesPregunta);
    }
}
