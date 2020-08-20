package edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import java.util.ArrayList;
import java.util.Comparator;

public class Exclusividad extends ModoPregunta {
    private static int exclusividadesActivadas = 0;
    private final ModoPregunta modoOriginal;

    public Exclusividad(ModoPregunta modoOriginal) {
        this.modoOriginal = modoOriginal;
        exclusividadesActivadas++;
    }

    @Override
    public void evaluarRespuestas(ArrayList<Respuesta> respuestas, int opcionesCorrectasPregunta) {
        int respuestasCorrectas = (int)respuestas.stream().filter(respuesta -> esCorrecta(respuesta, opcionesCorrectasPregunta)).count();

        if (respuestasCorrectas == 1 && exclusividadesActivadas != 0) {
            Respuesta respuestaCorrecta = respuestas.stream().max(Comparator.comparing(Respuesta::cantidadOpcionesCorrectas)).get();
            int puntosASumar = modoOriginal.calcularPuntos(respuestaCorrecta, opcionesCorrectasPregunta);
            respuestaCorrecta.modificarPuntosJugador(puntosASumar * 2 * exclusividadesActivadas);
        }
        exclusividadesActivadas = 0;
    }

    private boolean esCorrecta(Respuesta respuesta, int opcionesCorrectasPregunta) {
        return (respuesta.cantidadOpcionesIncorrectas() == 0) && (respuesta.cantidadOpcionesCorrectas() == opcionesCorrectasPregunta);
    }

    @Override
    public int calcularPuntos(Respuesta respuesta, int opcionesCorrectasPregunta) {
        return modoOriginal.calcularPuntos(respuesta, opcionesCorrectasPregunta);
    }

    @Override
    public boolean aceptaMultiplicador() {
        return modoOriginal.aceptaMultiplicador();
    }

    @Override
    public boolean aceptaExclusividad() {
        return modoOriginal.aceptaExclusividad();
    }

    @Override
    public String nombre(){
        return modoOriginal.nombre();
    }
}
