package edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Jugador;

public interface ModoPregunta {

    void modificarPuntos(Jugador jugador, int cantidadCorrectas, int aciertos, int errores);
}
