package edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;

public class PuntajeParcial extends ModoPregunta{
    static final int PUNTAJE = 1;
    static final String nombre = "PuntajeParcial";

    @Override
    public int calcularPuntos(Respuesta respuesta, int cantidadOpcionesCorrectaPregunta){
        int aciertos = respuesta.cantidadOpcionesCorrectas();
        int errores = respuesta.cantidadOpcionesIncorrectas();
        int puntosASumar = 0;

        if(errores == 0)
            puntosASumar = PUNTAJE * aciertos;

        return puntosASumar;
    }

    @Override
    public boolean aceptaMultiplicador() {
        return false;
    }

    @Override
    public boolean aceptaExclusividad(){ return true; }

    public String nombre(){
        return nombre;
    }
}