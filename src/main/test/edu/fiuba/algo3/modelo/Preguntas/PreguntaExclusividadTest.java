package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaExclusividadTest {

    @Test
    public void test01JugadoresUsanExclusividadActivandoseEfectoX4EnChoiseClasicoPeroAciertanCorrectamenteAmbosYNoAfectaPuntaje() {
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        pregunta.agregarOpcion(new OpcionBinaria("2014", false));
        pregunta.agregarOpcion(new OpcionBinaria("2006", false));
        Jugador jugador1 = new Jugador("Lionel Messi");
        Jugador jugador2 = new Jugador("Lionel Messi");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        // Act
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test02SeAplicaExclusividadAModoPenalidadYLanzaExcepcion() {
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        pregunta.agregarOpcion(new OpcionBinaria("2014", true));
        pregunta.agregarOpcion(new OpcionBinaria("2006", true));
        Jugador jugador1 = new Jugador("Lionel Messi");
        Jugador jugador2 = new Jugador("Lionel Messi");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        assertThrows(PreguntaNoAceptaExclusividadError.class,
                () -> {
                    jugador1.activarExclusividad(respuestaJugador1);
                });
    }

    @Test
    public void test03JugadoresUsanExclusividadActivandoseEfectoX4EnChoiseClasicoYSoloUnoAciertaCorrectamenteTodasAsignandoseX4Puntos() {
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        pregunta.agregarOpcion(new OpcionBinaria("2014", true));
        pregunta.agregarOpcion(new OpcionBinaria("2006", true));
        Jugador jugador1 = new Jugador("Lionel Messi");
        Jugador jugador2 = new Jugador("Lionel Messi");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        // Act
        jugador1.activarExclusividad(respuestaJugador1);
        jugador2.activarExclusividad(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(4, jugador1.puntos()); // en Choise Clasico, solo suma +1 punto si todas correcta.. por ende +4 pts!
        assertEquals(0, jugador2.puntos());
    }


    @Test
    public void test04JugadoresUsanExclusividadActivandoseEfectoX4EnChoiseParcialAsignadosePuntajeAlQueRespondioTodas() {
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        pregunta.agregarOpcion(new OpcionBinaria("2014", true));
        pregunta.agregarOpcion(new OpcionBinaria("2006", true));
        Jugador jugador1 = new Jugador("Lionel Messi");
        Jugador jugador2 = new Jugador("Lionel Messi");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        // Act
        jugador1.activarExclusividad(respuestaJugador1);
        jugador2.activarExclusividad(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(12, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test05JugadoresUsanExclusividadActivandoseEfectoX4EnChoiseParcialPeroRespondenTodasExceptoAlgunasEntoncesNoHaceEfectoExclusividad() {
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        pregunta.agregarOpcion(new OpcionBinaria("2014", true));
        pregunta.agregarOpcion(new OpcionBinaria("2006", true));
        Jugador jugador1 = new Jugador("Lionel Messi");
        Jugador jugador2 = new Jugador("Lionel Messi");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        // Act
        jugador1.activarExclusividad(respuestaJugador1);
        jugador2.activarExclusividad(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(2, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

}