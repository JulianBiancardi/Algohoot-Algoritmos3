package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void test01SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaRespuestaCorrectaYFalla() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new PuntajeParcial());
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaChoiceConPuntajeParcialConUnRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new PuntajeParcial());
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new PuntajeParcial());
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionCorrecta("Brasil"));
        pregunta.agregarOpciones(new OpcionCorrecta("Chile"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }


    @Test
    public void test04SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaTres() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new PuntajeParcial());
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionCorrecta("Brasil"));
        pregunta.agregarOpciones(new OpcionCorrecta("Chile"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new PuntajeParcial());
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test06RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new PuntajeParcial());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Uruguay"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }


    @Test
    public void test07RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new PuntajeParcial());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionIncorrecta("España"));
        pregunta.agregarOpciones(new OpcionCorrecta("Colombia"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test08SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYFalla() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionIncorrecta("España"));
        pregunta.agregarOpciones(new OpcionCorrecta("Colombia"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test09SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Uruguay"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test10SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Uruguay"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionCorrecta("Venezuela"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test11SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Uruguay"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionCorrecta("Venezuela"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador.puntos());
    }

    @Test
    public void test12SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaTres() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Uruguay"));
        pregunta.agregarOpciones(new OpcionCorrecta("Perú"));
        pregunta.agregarOpciones(new OpcionCorrecta("Venezuela"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test13SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaTres() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Uruguay"));
        pregunta.agregarOpciones(new OpcionCorrecta("Perú"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Alemania"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Australia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        respuesta.agregarOpcion(opcionesPosibles.obtener(4));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test14SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaAciertaYFallaUnaVez() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Uruguay"));
        pregunta.agregarOpciones(new OpcionCorrecta("Perú"));
        pregunta.agregarOpciones(new OpcionCorrecta("Venezuela"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }


    @Test
    public void test15RecibeUnaListaDeRespuestasTodasIncorrectasYAmbosPierdenPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionIncorrecta("Portugal"));
        pregunta.agregarOpciones(new OpcionCorrecta("Bolivia"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta1.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), -2);
        assertEquals(jugador2.puntos(), -2);
    }

    @Test
    public void test16RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionCorrecta("Paraguay"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Dinamarca"));
        pregunta.agregarOpciones(new OpcionCorrecta("Perú"));
        pregunta.agregarOpciones(new OpcionCorrecta("Venezuela"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 2);
    }

    @Test
    public void test17RecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new ConPenalidad());
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Perú"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Australia"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta1.agregarOpcion(opcionesPosibles.obtener(3));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), -2);
        assertEquals(jugador2.puntos(), 2);
    }

    @Test
    public void test18SeCreaUnaPreguntaChoiceClasicoConUnaRespuestaCorrectaYFalla() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("España"));
        pregunta.agregarOpciones(new OpcionCorrecta("Chile"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Italia"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rumania"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test19SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("Sudafrica"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Suiza"));
        pregunta.agregarOpciones(new OpcionCorrecta("Bolivia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test20SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaRespuestaCorrectaYAciertaPeroFallaUna() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("Sudafrica"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Suiza"));
        pregunta.agregarOpciones(new OpcionCorrecta("Bolivia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test21SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaRespuestaCorrectaYAciertaPeroFallaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("Sudafrica"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Suiza"));
        pregunta.agregarOpciones(new OpcionCorrecta("Bolivia"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test22SeCreaUnaPreguntaChoiceConPuntajePacialConDosRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionCorrecta("Ecuador"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Malasia"));
        pregunta.agregarOpciones(new OpcionCorrecta("Costa Rica"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test23SeCreaUnaPreguntaChoiceConPuntajePacialConDosRespuestaCorrectaYAciertaUna() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionCorrecta("Ecuador"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Malasia"));
        pregunta.agregarOpciones(new OpcionCorrecta("Costa Rica"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test24SeCreaUnaPreguntaChoiceConPuntajePacialConDosRespuestaCorrectaYAciertaDosPeroFallaUna() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionCorrecta("Ecuador"));
        pregunta.agregarOpciones(new OpcionIncorrecta("China"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Malasia"));
        pregunta.agregarOpciones(new OpcionCorrecta("Costa Rica"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test25SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("EEUU"));
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionCorrecta("Brasil"));
        pregunta.agregarOpciones(new OpcionCorrecta("Puerto Rico"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test26SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaUna() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("EEUU"));
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionCorrecta("Brasil"));
        pregunta.agregarOpciones(new OpcionCorrecta("Puerto Rico"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test27SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaTresPeroFallaUna() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("EEUU"));
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionCorrecta("Brasil"));
        pregunta.agregarOpciones(new OpcionCorrecta("Puerto Rico"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test28SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("EEUU"));
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionCorrecta("Brasil"));
        pregunta.agregarOpciones(new OpcionCorrecta("Puerto Rico"));
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(1));
        respuesta.agregarOpcion(opcionesPosibles.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }


    @Test
    public void test29RecibeUnaListaDeRespuestasTodasIncorrectasYAmbosFallan(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionIncorrecta("Portugal"));
        pregunta.agregarOpciones(new OpcionCorrecta("Bolivia"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Egipto"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Rusia"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta1.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test30RecibeUnaListaDeRespuestasTodasCorrectasYAmbosAciertan(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionCorrecta("Paraguay"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Dinamarca"));
        pregunta.agregarOpciones(new OpcionCorrecta("Perú"));
        pregunta.agregarOpciones(new OpcionCorrecta("Venezuela"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta1.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta1.agregarOpcion(opcionesPosibles.obtener(3));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test31RecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        MultipleChoice pregunta = new MultipleChoice("Paises de América Latina", new Clasico());
        pregunta.agregarOpciones(new OpcionCorrecta("Argentina"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Japon"));
        pregunta.agregarOpciones(new OpcionCorrecta("Perú"));
        pregunta.agregarOpciones(new OpcionIncorrecta("Australia"));
        Respuesta respuesta1 = new Respuesta(jugador1);
        Respuesta respuesta2 = new Respuesta(jugador2);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta1.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta1.agregarOpcion(opcionesPosibles.obtener(2));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        respuesta2.agregarOpcion(opcionesPosibles.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 0);
    }

}