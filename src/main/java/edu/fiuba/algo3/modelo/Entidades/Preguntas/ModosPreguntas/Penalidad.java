package edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;

public class Penalidad extends ModoPregunta  {
    static final int PUNTAJE = 1;

    @Override
    public int calcularPuntos(Respuesta respuesta, int cantidadOpcionesCorrectaPregunta){
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();

        return PUNTAJE * (aciertos - errores);
    }

    @Override
    public boolean aceptaMultiplicador(){
        return true;
    }

    @Override
    public boolean aceptaExclusividad(){ return false; }
}