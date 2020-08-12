package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaGrupalTest {

    @Test
    public void test01CreoUnaRespuestaGrupalConDosOpcionesPorGrupoYAciertaCuatro() {
        String nombreGrupo1 = "Jugadores Argentinos";
        String nombreGrupo2 = "Jugadores Brasileros";
        GroupChoice pregunta = new GroupChoice("Separar en argentinos y brasileros",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Roman"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Ronaldo"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Messi"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Cafu"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));

        assertEquals(4, respuestaJugador.cantidadOpcionesCorrectas());
    }

    @Test
    public void test02CreoUnaRespuestaGrupalConDosOpcionesPorGrupoYAciertaTres() {
        String nombreGrupo1 = "Jugadores Argentinos";
        String nombreGrupo2 = "Jugadores Brasileros";
        GroupChoice pregunta = new GroupChoice("Separar en argentinos y brasileros",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Roman"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Ronaldo"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Messi"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Cafu"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));

        assertEquals(3, respuestaJugador.cantidadOpcionesCorrectas());
    }

    @Test
    public void test03CreoUnaRespuestaGrupalConDosOpcionesPorGrupoYAciertaDos() {
        String nombreGrupo1 = "Jugadores Argentinos";
        String nombreGrupo2 = "Jugadores Brasileros";
        GroupChoice pregunta = new GroupChoice("Separar en argentinos y brasileros",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Roman"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Ronaldo"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Messi"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Cafu"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));

        assertEquals(2, respuestaJugador.cantidadOpcionesCorrectas());
    }

    @Test
    public void test04CreoUnaRespuestaGrupalConDosOpcionesPorGrupoYAciertaUna() {
        String nombreGrupo1 = "Jugadores Argentinos";
        String nombreGrupo2 = "Jugadores Brasileros";
        GroupChoice pregunta = new GroupChoice("Separar en argentinos y brasileros",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Roman"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Ronaldo"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Messi"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Cafu"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(3));

        assertEquals(1, respuestaJugador.cantidadOpcionesCorrectas());
    }

    @Test
    public void test05CreoUnaRespuestaGrupalConDosOpcionesPorGrupoYNoAciertaNinguna() {
        String nombreGrupo1 = "Jugadores Argentinos";
        String nombreGrupo2 = "Jugadores Brasileros";
        GroupChoice pregunta = new GroupChoice("Separar en argentinos y brasileros",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Roman"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Ronaldo"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("Messi"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("Cafu"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(3));

        assertEquals(0, respuestaJugador.cantidadOpcionesCorrectas());
    }
}
