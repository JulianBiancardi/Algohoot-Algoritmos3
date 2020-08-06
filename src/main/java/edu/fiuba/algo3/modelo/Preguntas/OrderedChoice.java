package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ModoPregunta;

public class OrderedChoice extends Pregunta{
    public OrderedChoice(String unEnunciado, ListaOpciones opcionesPregunta) {
        super(unEnunciado,new Clasico(),opcionesPregunta);
    }
}

