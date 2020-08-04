package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.CriterioPuntuacion;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Respuesta;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    Integer identificadorDoble = 1;
    Integer identificadorTriple = 2;

    @Test
    public void test01ElJugadorPuedeUsarMultiplicadorAUnaPreguntaPenalizadaBonificandoseSuPunPuntajeAlEvaluarSuRespuesta() {
        // Arrange
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("No");
        VoF pregunta = VoF.crearEnModoPenalizado("Argentina ganó mundial 2014", opcionCorrecta);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta);
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicador(identificadorDoble);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(2, jugador.puntos());
    }


    @Test
    public void test02JugadorCuandoUtilizaMismoMultiplicadorDobleParaDosPreguntasDiferentesPenalizadasSeAplicaraBeneficioMultiplicativoConUnaSolaPreguntala() {
        // Arrange
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("No");
        VoF pregunta_1 = VoF.crearEnModoPenalizado("Argentina ganó mundial 2014", opcionCorrecta);
        VoF pregunta_2 = VoF.crearEnModoPenalizado("Argentina ganó mundial 2014", opcionCorrecta);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta);
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        Integer puntosEsperadosPorPregunta_1 = 2;
        Integer puntosEsperadosPorPregunta_2 = 1;

        //Act
        jugador.utilizarMultiplicador(identificadorDoble);
        pregunta_1.evaluarRespuestas(respuestas);

        jugador.utilizarMultiplicador(identificadorDoble);
        pregunta_2.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(puntosEsperadosPorPregunta_1 + puntosEsperadosPorPregunta_2, jugador.puntos());
    }

    @Test
    public void test03JugadorCuandoUtilizaMultiplicadoEnPreguntaDeModoClasicaNoHaceEfectoAlEvaluarSuRespuesta() {
        // Arrange
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("No");
        VoF pregunta = VoF.crearEnModoClasico("Argentina ganó mundial 2014", opcionCorrecta);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta);
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicador(identificadorDoble);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03JugadorCuandoUtilizaMultiplicadoEnPreguntaDeModoParcialNoHaceEfectoAlEvaluarSuRespuesta() {
        // Arrange
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("No");
        OpcionCorrecta opcionIncorrecta = new OpcionCorrecta("Si");
        ListaOpciones listaOpciones = new ListaOpciones();
        listaOpciones.agregarOpcion(opcionCorrecta);
        listaOpciones.agregarOpcion(opcionIncorrecta);

        MultipleChoice pregunta = MultipleChoice.crearEnModoParcial("Argentina ganó mundial 2014", listaOpciones);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta);
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        // Act
        jugador.utilizarMultiplicador(identificadorDoble);
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test04ElJugadorCuentaConIdentificadorParaMultiplicadorDoble() {
        assertEquals(identificadorDoble, Jugador.identificadorMultiplicadorDoble());
    }

    @Test
    public void test05ElJugadorCuentaConIdentificadorParaMultiplicadorTriple() {
        assertEquals(identificadorTriple, Jugador.identificadorMultiplicadorTriple());
    }

    @Test
    public void test06ElJugadorCuentaConDosMultiplicadoresIniciales() {
        Jugador jugador = new Jugador("Lionel Messi");
        assertEquals(2, jugador.cantidadMultiplicadores());
    }
    @Test
    public void test07ElJugadorEmpiezaConPuntajeInicialNulo() {
        Jugador jugador = new Jugador("LeoProgramador");
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test08SePuedePuntuarJugadorConCriterioPuntuacionSumandoPuntaje() {
        Jugador jugador = new Jugador("LeoProgramador");
        jugador.puntuarJugador(new CriterioPuntuacion(1,1), 1);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test09SePuedePenalizarJugadorConCriterioPuntuacionQueandoPuntajeNegativo() {
        Jugador jugador = new Jugador("LeoProgramador");
        jugador.penalizarJugador(new CriterioPuntuacion(1,3), 1);
        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test10ElJugadorSeLePuedeAsignarUnNombreString() {
        Jugador jugador = new Jugador("LeoProgramador");
        assertEquals("LeoProgramador", jugador.nombre());
    }
}
