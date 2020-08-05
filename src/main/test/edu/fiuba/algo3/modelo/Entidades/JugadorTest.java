package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01ElJugadorPuedeUtilizarMultiplicadorParaUsarEnUnaPreguntaPenalizadaBonificandoseSuPunPuntajeAlEvaluarSuRespuesta(){
        // Arrange
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        Pregunta pregunta = VoF.conModoPenalidad("Argentina ganó mundial 2014", listaOpcionesPregunta);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorDoble();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test02JugadorCuandoUtilizaMultiplicadorEnPreguntaDeModoClasicaNoHaceEfectoAlEvaluarSuRespuesta(){
        // Arrange
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        Pregunta pregunta = VoF.conModoClasico("Argentina ganó mundial 2014", listaOpcionesPregunta);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorTriple();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03JugadorCuandoUtilizaMultiplicadoEnPreguntaDeModoParcialNoHaceEfectoAlEvaluarSuRespuesta(){
        // Arrange
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("No");
        OpcionCorrecta opcionIncorrecta = new OpcionCorrecta("Si");
        ListaOpciones listaOpciones = new ListaOpciones();
        listaOpciones.agregarOpcion(opcionCorrecta);
        listaOpciones.agregarOpcion(opcionIncorrecta);

        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Argentina ganó mundial 2014", listaOpciones);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta);
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicadorTriple();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test04ElJugadorSeCreaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        assertEquals("LeoProgramador", jugador.nombre());
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test05ElJugadorSumaPuntosCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        jugador.modificarPuntos(3);
        assertEquals(3, jugador.puntos());
        jugador.modificarPuntos(2);
        assertEquals(5, jugador.puntos());
    }

}

