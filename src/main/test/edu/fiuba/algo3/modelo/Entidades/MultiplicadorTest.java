package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Excepciones.MultiplicadorYaUtilizadoError;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicadorTest {

    @Test
    public void test01MultiplicadorSePuedeCrearSinEfectoObteniendoPuntosSinModificar() {
        Multiplicador multiplicador = Multiplicador.crearMultiplicadorNulo();

        int puntajeObtenido = multiplicador.aplicarMultiplicador(10);
        assertEquals(10, puntajeObtenido);
    }

    @Test
    public void test02MultiplicadorDobleModificaPuntosCorrectamente(){
        Multiplicador multiplicador = Multiplicador.crearMultiplicadorDoble();

        int puntajeObtenido = multiplicador.aplicarMultiplicador(10);

        assertEquals(10 * 2, puntajeObtenido);
    }

    @Test
    public void test03MultiplicadorTripleModificaPuntosCorrectamente(){
        Multiplicador multiplicador = Multiplicador.crearMultiplicadorTriple();

        int puntajeObtenido = multiplicador.aplicarMultiplicador(10);

        assertEquals(10 * 3, puntajeObtenido);
    }

    @Test
    public void test04MultiplicadorDevuelveErrorAlSerUtilizadoDosVeces() {
        Jugador jugador = new Jugador("Fede");
        VoF pregunta = VoF.conModoPenalidad("Pregunta de prueba");
        Respuesta respuesta = new Respuesta(jugador, pregunta);
        jugador.utilizarMultiplicadorDoble(respuesta);

        assertThrows(MultiplicadorYaUtilizadoError.class,
                () -> {
                    jugador.utilizarMultiplicadorDoble(respuesta);
                });
    }
}
