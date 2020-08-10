package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

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
    public void evaluarRespuestas(ArrayList<Respuesta> respuestas, int cantidadOpcionesCorrectasPregunta) {
        int cantidadRespuestasCompletamenteCorrectas = (int) respuestas.stream()
                .filter(respuesta -> esCompletamenteCorrecta(respuesta, cantidadOpcionesCorrectasPregunta)).count();

        if (cantidadRespuestasCompletamenteCorrectas == 1 && exclusividadesActivadas != 0) {
            Respuesta respuestaCompletamenteCorrecta = respuestas.stream().max(Comparator.comparing(Respuesta::cantidadOpcionesCorrectas)).get();
            int puntosAIncrementar = modoOriginal.calcularPuntos(respuestaCompletamenteCorrecta, cantidadOpcionesCorrectasPregunta);
            respuestaCompletamenteCorrecta.modificarPuntos(puntosAIncrementar * 2 * exclusividadesActivadas);
        }
        exclusividadesActivadas = 0;
    }

    private boolean esCompletamenteCorrecta(Respuesta respuesta, int cantidadOpcionesCorrectaDeLaPregunta) {
        return (respuesta.cantidadOpcionesIncorrectas() == 0) && (respuesta.cantidadOpcionesCorrectas() == cantidadOpcionesCorrectaDeLaPregunta);
    }

    @Override
    public int calcularPuntos(Respuesta respuesta, int cantidadOpcionesCorrectasDeLaPregunta) {
        return modoOriginal.calcularPuntos(respuesta, cantidadOpcionesCorrectasDeLaPregunta);
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
