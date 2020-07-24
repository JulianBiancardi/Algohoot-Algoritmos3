package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Clasico implements ModoPregunta {

    @Override
    public void evaluarRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if(respuesta.esCorrecta()) {
                respuesta.sumarPuntos(PUNTAJE);
            }
        }
    }
}
