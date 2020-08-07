package edu.fiuba.algo3.modelo.Entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    /*
    @Test
    public void test01ElJugadorPuedeUtilizarMultiplicadorDobleEnVoFConPenalidad(){
        // Arrange
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
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
    public void test02JugadorUtilizaMultiplicadorDobleEnVoFClasicoNoHaceEfectoAlEvaluarSuRespuesta(){
        // Arrange
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        Pregunta pregunta = VoF.conModoClasico("Argentina ganó mundial 2014", listaOpcionesPregunta);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
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
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("No");
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Si");
        OpcionIncorrecta opcionIncorrecta2 = new OpcionIncorrecta("No No No");
        OpcionIncorrecta opcionIncorrecta3 = new OpcionIncorrecta("No lo se Rick");
        ListaOpciones listaOpciones = new ListaOpciones();
        listaOpciones.agregarOpcion(opcionCorrecta);
        listaOpciones.agregarOpcion(opcionIncorrecta1);
        listaOpciones.agregarOpcion(opcionIncorrecta2);
        listaOpciones.agregarOpcion(opcionIncorrecta3);

        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Argentina ganó mundial 1986", listaOpciones);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta);
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
        jugador.utilizarMultiplicadorDoble();
        pregunta.evaluarRespuestas(respuestas);

        // Assert
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test05ElJugadorPuedeUtilizarMultiplicadorTripleEnVoFConPenalidad(){
        // Arrange
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        Pregunta pregunta = VoF.conModoPenalidad("Argentina ganó mundial 2014", listaOpcionesPregunta);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0));
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
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
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
    public void test07JugadorUtilizaMultiplicadoTripleEnChoiceConPenalidadYFunciona(){
        // Arrange
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("No");
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Si");
        OpcionIncorrecta opcionIncorrecta2 = new OpcionIncorrecta("No No No");
        OpcionIncorrecta opcionIncorrecta3 = new OpcionIncorrecta("No lo se Rick");
        ListaOpciones listaOpciones = new ListaOpciones();
        listaOpciones.agregarOpcion(opcionCorrecta);
        listaOpciones.agregarOpcion(opcionIncorrecta1);
        listaOpciones.agregarOpcion(opcionIncorrecta2);
        listaOpciones.agregarOpcion(opcionIncorrecta3);

        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Argentina ganó mundial 1986", listaOpciones);
        Jugador jugador = new Jugador("Lionel Messi");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta);
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
    */


}

