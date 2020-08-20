package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaOrdenada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    @Test
    public void test01PreguntaGroupChoiceJugadorRespondeBien() {
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares", nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo2("3");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo2("5");

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02PreguntaGroupChoiceJugadorRespondeMal() {
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares", nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo2("3");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo2("5");

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test03PreguntaMultipleChoiceClasicoJugadorRespondeBien() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Quien esta ido?");
        pregunta.nuevaOpcion("Julian", true);
        pregunta.nuevaOpcion("Leo", false);
        pregunta.nuevaOpcion("Joaco", true);

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test04PreguntaMultipleChoiceClasicoJugadorRespondeMal() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Quien esta ido?");
        pregunta.nuevaOpcion("Julian", true);
        pregunta.nuevaOpcion("Leo", false);
        pregunta.nuevaOpcion("Joaco", true);

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test05PreguntaVoFConPenalidadJugadorRespondeBien() {
        VoF pregunta = VoF.conModoPenalidad("Soy LeoProgrmador", true);

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test06PreguntaVoFConPenalidadJugadorRespondeMal() {
        VoF pregunta = VoF.conModoPenalidad("Soy LeoProgrmador", true);

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07PreguntaOrderedChoiceJugadorRespondeBien() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor");
        pregunta.nuevaOpcion("Martin");
        pregunta.nuevaOpcion("Julian");
        pregunta.nuevaOpcion("Joaco");
        pregunta.nuevaOpcion("Leo");

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08PreguntaOrderedChoiceJugadorRespondeMal() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor");
        pregunta.nuevaOpcion("Martin");
        pregunta.nuevaOpcion("Julian");
        pregunta.nuevaOpcion("Joaco");
        pregunta.nuevaOpcion("Leo");

        Ronda ronda = new Ronda(pregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ronda.agregarRespuesta(respuestaJugador);

        ronda.evaluarPregunta();
        assertEquals(0, jugador.puntos());
    }
}
