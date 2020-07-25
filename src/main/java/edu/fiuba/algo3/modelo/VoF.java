package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VoF extends Pregunta {

    public VoF (String unEnunciado, ModoPregunta unModo) {

        modo = unModo;
        enunciado = unEnunciado;
    }

    public void agregarOpciones(Opcion unaOpcion) {
        opciones.put(idOpcion, unaOpcion);
        idOpcion++;
        if (opciones.size() > 2) {
            //ErrorSuperoElMaximoDeOpciones
        }
    }
}
