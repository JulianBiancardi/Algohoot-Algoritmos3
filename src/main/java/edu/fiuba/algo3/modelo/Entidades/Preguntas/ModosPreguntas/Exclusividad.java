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
    public void evaluarRespuestas(ArrayList<Respuesta> respuestas, int cantidadOpcionesCorrectaPregunta) {
        int cantidadRespuestasCompletamenteCorrectas = (int) respuestas.stream()
                .filter(respuesta -> esCompletamenteCorrecta(respuesta, cantidadOpcionesCorrectaPregunta)).count();

        if (cantidadRespuestasCompletamenteCorrectas == 1 && exclusividadesActivadas != 0) {
            Respuesta respuestaCompletamenteCorrecta = respuestas.stream().max(Comparator.comparing(Respuesta::cantidadOpcionesCorrectas)).get();
            int puntosAIncrementar = modoOriginal.calcularPuntos(respuestaCompletamenteCorrecta, cantidadOpcionesCorrectaPregunta);
            respuestaCompletamenteCorrecta.modificarPuntosJugador(puntosAIncrementar * 2 * exclusividadesActivadas);
        }
        exclusividadesActivadas = 0;
    }

    private boolean esCompletamenteCorrecta(Respuesta respuesta, int cantidadOpcionesCorrectaDeLaPregunta) {
        return (respuesta.cantidadOpcionesIncorrectas() == 0) && (respuesta.cantidadOpcionesCorrectas() == cantidadOpcionesCorrectaDeLaPregunta);
    }

    @Override
    public int calcularPuntos(Respuesta respuesta, int cantidadOpcionesCorrectaPregunta) {
        return modoOriginal.calcularPuntos(respuesta, cantidadOpcionesCorrectaPregunta);
    }

    @Override
    public boolean aceptaMultiplicador() {
        return modoOriginal.aceptaMultiplicador();
    }

    @Override
    public boolean aceptaExclusividad() {
        return modoOriginal.aceptaExclusividad();
    }
}
