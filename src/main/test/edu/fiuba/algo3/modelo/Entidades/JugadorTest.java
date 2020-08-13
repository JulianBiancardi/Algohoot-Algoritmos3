package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Excepciones.MultiplicadorYaUtilizadoError;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaMultiplicadorError;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorTest {

    @Test
    public void test00ElJugadorSeCreaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        assertEquals("LeoProgramador", jugador.nombre());
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test01ElJugadorSumaPuntosCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        jugador.modificarPuntos(3);
        assertEquals(3, jugador.puntos());
        jugador.modificarPuntos(2);
        assertEquals(5, jugador.puntos());
    }

    @Test
    public void test02ElJugadorPuedeUtilizarMultiplicadorDobleEnVoFConPenalidad(){
        Jugador jugador = new Jugador("Lionel Messi");
        VoF pregunta = VoF.conModoPenalidad("Argentina ganó mundial 2014",false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        jugador.activarMultiplicadorDoble(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test03JugadorUtilizaMultiplicadoDobleEnChoiceConPenalidadYFunciona(){
        Jugador jugador = new Jugador("Lionel Messi");
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("1986", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        jugador.activarMultiplicadorDoble(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test04ElJugadorNoPuedeUtilizarMultiplicadorDobleEnVoFClasico(){
        Jugador jugador = new Jugador("Lionel Messi");
        VoF pregunta = VoF.conModoClasico("Argentina ganó mundial 2014",false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        assertThrows(PreguntaNoAceptaMultiplicadorError.class,
                () -> {
                    jugador.activarMultiplicadorDoble(respuestaJugador);
                });
    }

    @Test
    public void test05JugadorUtilizaMultiplicadoDobleDosVecesYlanzaExepcion(){
        Jugador jugador = new Jugador("Lionel Messi");
        // Pregunta 1
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("1986", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);
        jugador.activarMultiplicadorDoble(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);
        // Pregunta 2
        pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Brasil");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("2002", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuesta2Jugador = new Respuesta(jugador, pregunta);
        respuesta2Jugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta2Jugador);

        assertThrows(MultiplicadorYaUtilizadoError.class,
                () -> {
                    jugador.activarMultiplicadorDoble(respuesta2Jugador);
                });
    }

    @Test
    public void test06JugadorNoPuedeUtilizarMultiplicadorTripleEnChoiceParcial(){
        Jugador jugador = new Jugador("Lionel Messi");
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("1986", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        assertThrows(PreguntaNoAceptaMultiplicadorError.class,
                () -> {
                    jugador.activarMultiplicadorDoble(respuestaJugador);
                });
    }

    @Test
    public void test07ElJugadorPuedeUtilizarMultiplicadorTripleEnVoFConPenalidad(){
        Jugador jugador = new Jugador("Lionel Messi");
        VoF pregunta = VoF.conModoPenalidad("Argentina ganó el mundial del 78",true);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        jugador.activarMultiplicadorTriple(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test08JugadorUtilizaMultiplicadoTripleEnChoiceConPenalidadYFunciona(){
        Jugador jugador = new Jugador("Lionel Messi");
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("1986", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        jugador.activarMultiplicadorTriple(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test09ElJugadorNoPuedeUtilizarExclusividadEnVoFConPenalidad(){
        Jugador jugador = new Jugador("Lionel Messi");
        VoF pregunta = VoF.conModoPenalidad("Argentina ganó mundial 2014",false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        assertThrows(PreguntaNoAceptaExclusividadError.class,
                () -> {
                    jugador.activarExclusividad(respuestaJugador);
                });
    }

    @Test
    public void test10JugadorNoPuedeUtilizaExclusividadEnChoiceConPenalidad(){
        Jugador jugador = new Jugador("Lionel Messi");
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("1986", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        assertThrows(PreguntaNoAceptaExclusividadError.class,
                () -> {
                    jugador.activarExclusividad(respuestaJugador);
                });
    }

    @Test
    public void test11JugadorUtilizaMultiplicadoTripleDosVecesYLanzaExcepcion(){
        Jugador jugador = new Jugador("Lionel Messi");
        // Pregunta 1
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("1986", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);
        jugador.activarMultiplicadorTriple(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);
        // Pregunta 2
        pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Brasil");
        pregunta.agregarOpcion("2010", false);
        pregunta.agregarOpcion("2002", true);
        pregunta.agregarOpcion("2014", false);
        pregunta.agregarOpcion("2006", false);
        Respuesta respuesta2Jugador = new Respuesta(jugador, pregunta);
        respuesta2Jugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta2Jugador);

        assertThrows(MultiplicadorYaUtilizadoError.class,
                () -> {
                    jugador.activarMultiplicadorTriple(respuesta2Jugador);
                });
    }
}

