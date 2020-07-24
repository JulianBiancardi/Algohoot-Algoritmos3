package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface ModoPregunta {
    static final int PUNTAJE = 1;

    void evaluarRespuestas(ArrayList<Respuesta> respuestas);
}
