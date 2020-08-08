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
    public void test01JugadoresUsanExclusividadActivandoseEfectoX4EnChoiseClasicoPeroAciertanCorrectamenteAmbosYNoAfectaPuntaje(){
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


        /*
        * jugador.activarExclusividad(respuesta)
        * */
        // Act
        Pregunta preguntaExclusiva = jugador1.obtenerExclusividadEnLaPregunta(pregunta);
        Pregunta preguntaExclusivaFinal = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva);

        preguntaExclusivaFinal.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test02SeAplicaExclusividadAModoPenalidadYLanzaExcepcion(){
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
                    jugador1.obtenerExclusividadEnLaPregunta(pregunta);
                });
    }

    @Test
    public void test03JugadoresUsanExclusividadActivandoseEfectoX4EnChoiseClasicoYSoloUnoAciertaCorrectamenteTodasAsignandoseX4Puntos(){
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
        Pregunta preguntaExclusiva = jugador1.obtenerExclusividadEnLaPregunta(pregunta);
       // Pregunta preguntaExclusivaFinal = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva);

        preguntaExclusiva.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(2, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }


    @Test
    public void test04JugadoresUsanExclusividadActivandoseEfectoX4EnChoiseParcialPeroSoloElQueMasOpcionesAcertoLasPreguntasSeLeAplicaraElPuntaje(){
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
        Pregunta preguntaExclusiva = jugador1.obtenerExclusividadEnLaPregunta(pregunta);
        Pregunta preguntaExclusivaFinal = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva);

        preguntaExclusivaFinal.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(12, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test05ExclusividadDejaDeHacerEfectoALTercerUso(){
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

        //  Primer uso -- x4 activado
        Pregunta preguntaExclusiva = jugador1.obtenerExclusividadEnLaPregunta(pregunta);
        Pregunta preguntaExclusivaFinal = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva);

        preguntaExclusivaFinal.evaluarRespuestas(respuestas);

        assertEquals(12, jugador1.puntos());
        assertEquals(1, jugador2.puntos());

        // Segundo Uso -- x4 activado
        Pregunta preguntaExclusiva2 = jugador1.obtenerExclusividadEnLaPregunta(preguntaExclusivaFinal);
        Pregunta preguntaExclusivaFinal2 = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva2);

        preguntaExclusivaFinal2.evaluarRespuestas(respuestas);

        assertEquals(24, jugador1.puntos());
        assertEquals(2, jugador2.puntos());

        // Tercer Uso -- No hace efecto
        Pregunta preguntaExclusiva3 = jugador1.obtenerExclusividadEnLaPregunta(preguntaExclusivaFinal2);
        Pregunta preguntaExclusivaFinal3 = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva3);

        preguntaExclusivaFinal3.evaluarRespuestas(respuestas);

        assertEquals(27, jugador1.puntos());
        assertEquals(3, jugador2.puntos());
    }

    @Test
    public void test07DiferentesUsosExclusividad(){
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

        //  Primer uso - x2 activado por jugador1
        Pregunta preguntaExclusiva = jugador1.obtenerExclusividadEnLaPregunta(pregunta);

        preguntaExclusiva.evaluarRespuestas(respuestas);

        assertEquals(6, jugador1.puntos());
        assertEquals(1, jugador2.puntos());

        // Segundo Uso -- x4 activado por activarse mutuamente jugador1 y jugador2. jugador1 se quedó sin exclusividad
        Pregunta preguntaExclusiva2 = jugador1.obtenerExclusividadEnLaPregunta(preguntaExclusiva);
        Pregunta preguntaExclusivaFinal2 = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva2);

        preguntaExclusivaFinal2.evaluarRespuestas(respuestas);

        assertEquals(18, jugador1.puntos());
        assertEquals(2, jugador2.puntos());

        // Tercer Uso -- x2 activado --  jugador2 se quedó sin exclusividad
        Pregunta preguntaExclusiva3 = jugador1.obtenerExclusividadEnLaPregunta(preguntaExclusivaFinal2);
        Pregunta preguntaExclusivaFinal3 = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva3);

        preguntaExclusivaFinal3.evaluarRespuestas(respuestas);

        assertEquals(24, jugador1.puntos());
        assertEquals(3, jugador2.puntos());

        // Cuarto Uso -- jugadores se quedaron sin exclusividad
        Pregunta preguntaExclusiva4 = jugador1.obtenerExclusividadEnLaPregunta(preguntaExclusivaFinal3);
        Pregunta preguntaExclusivaFinal4 = jugador2.obtenerExclusividadEnLaPregunta(preguntaExclusiva4);

        preguntaExclusivaFinal4.evaluarRespuestas(respuestas);

        assertEquals(27, jugador1.puntos());
        assertEquals(4, jugador2.puntos());


    }


}