package edu.fiuba.algo3.modelo;

public class ConPenalidad implements ModoPregunta {

    static final int PUNTAJE = 1;

    @Override
    public void modificarPuntos(Jugador jugador, int cantidadCorrectas, int aciertos, int errores){
        jugador.sumarPuntos(PUNTAJE * aciertos);
        jugador.restarPuntos(PUNTAJE * errores);
    }
}
