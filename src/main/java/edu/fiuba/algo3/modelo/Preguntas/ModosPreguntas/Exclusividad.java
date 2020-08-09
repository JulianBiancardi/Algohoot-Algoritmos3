package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Multiplicador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* *
 *
 *  No rompería LSP
 *  pues, solo agregué funcionalidad {Decorador} al 'modoOriginal' en 'evaluarRespuestas'
 *
 *
 * */

public class Exclusividad extends ModoPregunta {
    private static int exclusividadesActivadas = 0;
    private final ModoPregunta modoOriginal;

    public Exclusividad(ModoPregunta modoOriginal) {
        this.modoOriginal = modoOriginal;
        exclusividadesActivadas++;
    }

    public void evaluarRespuestas(ArrayList<Respuesta> respuestasTotales, int cantidadOpcionesCorrectaDeLaPregunta) {
        // Si hay más de 1 Respuesta Estrictamente Correcta, 0 errores, y aciertos idem que cantidad correcta de la pregunta
        //...NO le asignarias exclusividad a NINGUN JUGADOR !!!

        List<Respuesta> respuestasEstrictamenteCorrectas = respuestasTotales
                .stream()
                .filter(unaRespuesta -> esCorrectamenteEstricta(unaRespuesta, cantidadOpcionesCorrectaDeLaPregunta))
                .collect(Collectors.toList());

        if(respuestasEstrictamenteCorrectas.size() == 1 && exclusividadesActivadas != 0) {
            Respuesta respuestaAdmiteExclusividad = respuestasEstrictamenteCorrectas.get(0);
            respuestaAdmiteExclusividad.agregarExclusividad(Multiplicador.crearMultiplicadorDeFactor( 2 * exclusividadesActivadas ));
        }

        modoOriginal.evaluarRespuestas(respuestasTotales, cantidadOpcionesCorrectaDeLaPregunta);
        exclusividadesActivadas = 0;
    }

    private boolean esCorrectamenteEstricta(Respuesta unaRespuesta, int cantidadOpcionesCorrectaDeLaPregunta) {
        return (unaRespuesta.cantidadOpcionesIncorrectas() == 0) && (unaRespuesta.cantidadOpcionesCorrectas() == cantidadOpcionesCorrectaDeLaPregunta);
    }

    @Override
    public void modificarPuntos(Respuesta respuestaJugador, int cantidadOpcionesCorrectasDeLaPregunta) {
        modoOriginal.modificarPuntos(respuestaJugador, cantidadOpcionesCorrectasDeLaPregunta);
    }

    @Override
    public boolean aceptaMultiplicador() {
        return modoOriginal.aceptaMultiplicador();
    }
}
