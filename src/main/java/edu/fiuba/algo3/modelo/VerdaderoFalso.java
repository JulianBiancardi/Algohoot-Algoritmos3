package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso implements Pregunta {
    private final boolean respuesta;
    static final int PUNTAJE = 1;

    public VerdaderoFalso(boolean respuestaCorrecta) {
        respuesta = respuestaCorrecta;
    }

    public boolean evaluar(Respuesta unaRespuesta){

        return (respuesta == unaRespuesta.valor());
    }

    public void recibirRespuestas(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if(evaluar(respuesta))
                respuesta.sumarPuntos(PUNTAJE);
        }
    }

    public boolean respuesta(){
        return respuesta;
    }

}
