package edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;

public class Clasico extends ModoPregunta{
    static final int PUNTAJE = 1;

    @Override
    public int calcularPuntos(Respuesta respuesta, int cantidadOpcionesCorrectaPregunta){
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();
        int puntosASumar = 0;

        if(aciertos == cantidadOpcionesCorrectaPregunta && errores == 0)
            puntosASumar = PUNTAJE;

        return puntosASumar;
    }

    @Override
    public boolean aceptaMultiplicador(){ return false; }

    @Override
    public boolean aceptaExclusividad(){ return true; }
}