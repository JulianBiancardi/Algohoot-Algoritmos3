package edu.fiuba.algo3.modelo;

public class PuntajeParcial implements ModoPregunta {
    static final int PUNTAJE = 1;

    @Override
    public void modificarPuntos(Jugador jugador, int cantidadCorrectas, int aciertos, int errores){
        if(errores == 0)
            jugador.sumarPuntos(PUNTAJE * aciertos);
    }
}
