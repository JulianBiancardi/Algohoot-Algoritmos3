package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01ElJugadorPuedeUtilizarMultiplicadorDobleEnVoFConPenalidad(){
        // Arrange
        VoF pregunta = VoF.conModoPenalidad("Argentina ganó mundial 2014");
        pregunta.agregarOpcion(new OpcionBinaria("Verdadero", true));
        pregunta.agregarOpcion(new OpcionBinaria("Falso", false));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorDoble();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test02JugadorUtilizaMultiplicadorDobleEnVoFClasicoNoHaceEfectoAlEvaluarSuRespuesta(){
        // Arrange
        VoF pregunta = VoF.conModoClasico("Argentina ganó mundial 2014");
        pregunta.agregarOpcion(new OpcionBinaria("Verdadero", false));
        pregunta.agregarOpcion(new OpcionBinaria("Falso", true));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorDoble();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03JugadorUtilizaMultiplicadoDobleEnChoiceConPenalidadYFunciona(){
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        pregunta.agregarOpcion(new OpcionBinaria("2014", false));
        pregunta.agregarOpcion(new OpcionBinaria("2006", false));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorDoble();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test04JugadorUtilizaMultiplicadoDobleEnModoParcialNoHaceEfectoAlEvaluarSuRespuesta(){
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorDoble();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test05ElJugadorPuedeUtilizarMultiplicadorTripleEnVoFConPenalidad(){
        // Arrange
        VoF pregunta = VoF.conModoPenalidad("Argentina ganó el mundial del 78");
        pregunta.agregarOpcion(new OpcionBinaria("Verdadero", true));
        pregunta.agregarOpcion(new OpcionBinaria("Falso", false));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorTriple();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test06JugadorUtilizaMultiplicadorTripleEnVoFClasicoNoHaceEfectoAlEvaluarSuRespuesta(){
        // Arrange
        VoF pregunta = VoF.conModoClasico("Argentina ganó mundial 2014");
        pregunta.agregarOpcion(new OpcionBinaria("Verdadero", true));
        pregunta.agregarOpcion(new OpcionBinaria("Falso", false));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorTriple();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test07JugadorUtilizaMultiplicadoTripleEnChoiceConPenalidadYFunciona(){
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        pregunta.agregarOpcion(new OpcionBinaria("2014", false));
        pregunta.agregarOpcion(new OpcionBinaria("2006", false));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorTriple();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test08JugadorUtilizaMultiplicadoTripleEnModoParcialNoHaceEfectoAlEvaluarSuRespuesta(){
        // Arrange
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Mundiales Ganados por Argentina");
        pregunta.agregarOpcion(new OpcionBinaria("2010", false));
        pregunta.agregarOpcion(new OpcionBinaria("1986", true));
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorDoble();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test09ElJugadorSeCreaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        assertEquals("LeoProgramador", jugador.nombre());
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test10ElJugadorSumaPuntosCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        jugador.modificarPuntos(3);
        assertEquals(3, jugador.puntos());
        jugador.modificarPuntos(2);
        assertEquals(5, jugador.puntos());
    }
}

