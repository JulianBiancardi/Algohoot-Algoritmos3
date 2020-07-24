package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VoF extends Pregunta {

    public VoF (String unEnunciado, ArrayList<Opcion> listaOpciones, ModoPregunta unModo) {
        if (listaOpciones.size() != 2) {
            //
        }

        modo = unModo;
        enunciado = unEnunciado;
        opciones = listaOpciones;
    }
}
