package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public class Clasico extends ModoPregunta{
    static final int PUNTAJE = 1;

    @Override
    public int calcularPuntos(Respuesta respuesta, int cantidadOpcionesCorrectasDeLaPregunta){
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();
        int puntosASumar = 0;

        if(aciertos == cantidadOpcionesCorrectasDeLaPregunta && errores == 0)
            puntosASumar = PUNTAJE;

        return puntosASumar;
    }

    @Override
    public boolean aceptaMultiplicador(){ return false; }

    @Override
    public boolean aceptaExclusividad(){ return true; }
}