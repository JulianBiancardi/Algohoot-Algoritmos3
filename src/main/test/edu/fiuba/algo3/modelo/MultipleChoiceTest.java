package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.PuntajeParcial;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void test01SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaRespuestaCorrectaYErra() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2)); //elijo la 2
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);


        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaChoiceConPuntajeParcialConUnRespuestaCorrectaYAcierta() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaDos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Brasil"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Chile"));
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }


    @Test
    public void test04SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaTres() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Brasil"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Chile"));
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test05PuntajeParcialRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(3));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06PuntajeParcialRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test07PuntajeParcailRecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("España"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Colombia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test08SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYFalla() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("España"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Colombia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-1, jugador.puntos());

    }

    @Test
    public void test09SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYAcierta() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Uruguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test10SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaDos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Uruguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Venezuela"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test11SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaDos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Uruguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Venezuela"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador.puntos());
    }

    @Test
    public void test12SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaTres() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Uruguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Perú"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Venezuela"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test13SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaTres() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Uruguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Perú"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Alemania"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Australia"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(4));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test14SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaAciertaYFallaUnaVez() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Uruguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Perú"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Venezuela"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test15ConPenalidadRecibeUnaListaDeRespuestasTodasIncorrectasYAmbosPierdenPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Portugal"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Bolivia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador1.puntos());
        assertEquals(-2, jugador2.puntos());
    }

    @Test
    public void test16ConPenalidadRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Paraguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Dinamarca"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Perú"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Venezuela"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test17ConPenalidadRecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Perú"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Australia"));
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(3));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test18SeCreaUnaPreguntaChoiceClasicoConUnaRespuestaCorrectaYFalla() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("España"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Chile"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Italia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rumania"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test19SeCreaUnaPreguntaChoiceClasicoConUnaRespuestaCorrectaYAcierta() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Sudafrica"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Suiza"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Bolivia"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test20SeCreaUnaPreguntaChoiceChoiceClasicoConUnaRespuestaCorrectaYAciertaPeroFallaUna() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Sudafrica"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Suiza"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Bolivia"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test21SeCreaUnaPreguntaChoiceChoiceClasicoConUnaRespuestaCorrectaYAciertaPeroFallaDos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Sudafrica"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Suiza"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Bolivia"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test22SeCreaUnaPreguntaChoiceChoiceClasicoConDosRespuestaCorrectaYAciertaLasDos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Ecuador"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Malasia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Costa Rica"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test23SeCreaUnaPreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaUnaPeroNoSumaPuntos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Ecuador"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Malasia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Costa Rica"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test24SeCreaUnaPreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaDosPeroFallaUna() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Ecuador"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("China"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Malasia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Costa Rica"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test25SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAcierta() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("EEUU"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Brasil"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Puerto Rico"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test26SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaUnaYNoSumaPuntos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("EEUU"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Brasil"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Puerto Rico"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test27SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaTresPeroFallaUna() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("EEUU"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Brasil"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Puerto Rico"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test28SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaDosPeroNoSumaPuntos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("EEUU"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Brasil"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Puerto Rico"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1));
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test29ClasicoRecibeUnaListaDeRespuestasTodasIncorrectasYAmbosFallan(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Portugal"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Bolivia"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Egipto"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Rusia"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test30ClasicaRecibeUnaListaDeRespuestasTodasCorrectasYAmbosAciertan(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Paraguay"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Dinamarca"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Perú"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Venezuela"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(3));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test31ClasicaRecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Argentina"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Japon"));
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Perú"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Australia"));
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(2));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0));
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }
}