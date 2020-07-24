package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta {

    public MultipleChoice (String unEnunciado, ArrayList<Opcion> listaOpciones, ModoPregunta unModo) {
        if (2 < listaOpciones.size() &&  listaOpciones.size() > 6) {
            //
        }

        modo = unModo;
        enunciado = unEnunciado;
        opciones = listaOpciones;
    }
}
