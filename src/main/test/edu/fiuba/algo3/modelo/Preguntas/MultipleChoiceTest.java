package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultipleChoiceTest {

    @Test
    public void test00() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Corea", false));
        pregunta.agregarOpcion(new OpcionBinaria("Uruguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Colombia", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }


    @Test
    public void test01SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaRespuestaCorrectaYErra() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(2)); //elijo una incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }


    @Test
    public void test02SeCreaUnaPreguntaChoiceConPuntajeParcialConUnRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(0)); //elijo la única correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Alemania", false));
        pregunta.agregarOpcion(new OpcionBinaria("Brasil", true));
        pregunta.agregarOpcion(new OpcionBinaria("Chile", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }


    @Test
    public void test04SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaTres() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Alemania", false));
        pregunta.agregarOpcion(new OpcionBinaria("Brasil", true));
        pregunta.agregarOpcion(new OpcionBinaria("Chile", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test05PuntajeParcialRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06PuntajeParcialRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test07PuntajeParcailRecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("España", false));
        pregunta.agregarOpcion(new OpcionBinaria("Colombia", true));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test08SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYFalla() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("España", false));
        pregunta.agregarOpcion(new OpcionBinaria("Colombia", true));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));

        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-1, jugador.puntos());

    }

    @Test
    public void test09SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test10SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("Uruguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test11SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("Uruguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador.puntos());
    }

    @Test
    public void test12SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaTres() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("Uruguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Peru", true));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test13SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaTres() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("Uruguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Peru", true));
        pregunta.agregarOpcion(new OpcionBinaria("Alemania", false));
        pregunta.agregarOpcion(new OpcionBinaria("Australia", false));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(4));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test14SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaAciertaYFallaUnaVez() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("Uruguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Peru", true));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test15ConPenalidadRecibeUnaListaDeRespuestasTodasIncorrectasYAmbosPierdenPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Portugal", false));
        pregunta.agregarOpcion(new OpcionBinaria("Bolivia", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador1.puntos());
        assertEquals(-2, jugador2.puntos());
    }

    @Test
    public void test16ConPenalidadRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Paraguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Dinamarca", false));
        pregunta.agregarOpcion(new OpcionBinaria("Perú", true));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", true));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test17ConPenalidadRecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Uruguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test18SeCreaUnaPreguntaChoiceClasicoConUnaRespuestaCorrectaYFalla() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Portugal", false));
        pregunta.agregarOpcion(new OpcionBinaria("Bolivia", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test19SeCreaUnaPreguntaChoiceClasicoConUnaRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Sudafrica", false));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Suiza", false));
        pregunta.agregarOpcion(new OpcionBinaria("Bolivia", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test20SeCreaUnaPreguntaChoiceChoiceClasicoConUnaRespuestaCorrectaYAciertaPeroFallaUna() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Sudafrica", false));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Suiza", false));
        pregunta.agregarOpcion(new OpcionBinaria("Bolivia", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test21SeCreaUnaPreguntaChoiceChoiceClasicoConUnaRespuestaCorrectaYAciertaPeroFallaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Sudafrica", false));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Suiza", false));
        pregunta.agregarOpcion(new OpcionBinaria("Bolivia", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test22SeCreaUnaPreguntaChoiceChoiceClasicoConDosRespuestaCorrectaYAciertaLasDos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Ecuador", true));
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Malasia", false));
        pregunta.agregarOpcion(new OpcionBinaria("Costa Rica", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test23SeCreaUnaPreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaUnaPeroNoSumaPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Ecuador", true));
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Malasia", false));
        pregunta.agregarOpcion(new OpcionBinaria("Costa Rica", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test24SeCreaUnaPreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaDosPeroFallaUna() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Ecuador", true));
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Malasia", false));
        pregunta.agregarOpcion(new OpcionBinaria("Costa Rica", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test25SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("EEUU", false));
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Brasil", true));
        pregunta.agregarOpcion(new OpcionBinaria("Costa Rica", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test26SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaUnaYNoSumaPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("EEUU", false));
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Brasil", true));
        pregunta.agregarOpcion(new OpcionBinaria("Costa Rica", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test27SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaTresPeroFallaUna() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("EEUU", false));
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Brasil", true));
        pregunta.agregarOpcion(new OpcionBinaria("Costa Rica", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test28SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaDosPeroNoSumaPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("EEUU", false));
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Brasil", true));
        pregunta.agregarOpcion(new OpcionBinaria("Costa Rica", true));
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test29ClasicoRecibeUnaListaDeRespuestasTodasIncorrectasYAmbosFallan(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("China", false));
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Egipto", false));
        pregunta.agregarOpcion(new OpcionBinaria("Rusia", false));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test30ClasicaRecibeUnaListaDeRespuestasTodasCorrectasYAmbosAciertan(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Paraguay", true));
        pregunta.agregarOpcion(new OpcionBinaria("Dinamarca", false));
        pregunta.agregarOpcion(new OpcionBinaria("Perú", true));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", true));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test31ClasicaRecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion(new OpcionBinaria("Argentina", true));
        pregunta.agregarOpcion(new OpcionBinaria("Japon", false));
        pregunta.agregarOpcion(new OpcionBinaria("Perú", true));
        pregunta.agregarOpcion(new OpcionBinaria("Venezuela", false));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
    /*
    @Test
    public void test32SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaOpcionYLanzaExcepcion() {
        
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));

        assertThrows(ChoiceTieneEntreDosYCincoOpcionesError.class,
                () -> {
                    MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
                });
    }

    @Test
    public void test33SeCreaUnaPreguntaChoiceConPenalidadConSeisOpcionesYLanzaExcepcion() {
        
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("España"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Colombia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Guatemala"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Australia"));

        assertThrows(ChoiceTieneEntreDosYCincoOpcionesError.class,
                () -> {
                    MultipleChoice.conModoPenalidad("Paises de América Latina");
                });
    }

    @Test
    public void test34SeCreaUnaPreguntaChoiceClasicoConNingunaOpcionYLanzaExcepcion() {
        

        assertThrows(ChoiceTieneEntreDosYCincoOpcionesError.class,
                () -> {
                    MultipleChoice.conModoClasico("Paises de América Latina");
                });
    }
    */
}