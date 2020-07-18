package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso {
    private boolean respuesta;
    private int puntaje;

    public VerdaderoFalso(boolean respuestaCorrecta) {
        respuesta = respuestaCorrecta;
        puntaje = 1;
    }

    public boolean evaluar(Respuesta unaRespuesta){

        return (respuesta == unaRespuesta.valor());
    }

    public void recibirRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if(evaluar(respuesta))
                respuesta.sumarPuntos(puntaje);
        }
    }

}
