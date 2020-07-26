package edu.fiuba.algo3.modelo;

public class Clasico implements ModoPregunta {

    static final int PUNTAJE = 1;

    @Override
    public void modificarPuntos(Jugador jugador, int cantidadCorrectas, int aciertos, int errores){
        if(cantidadCorrectas == aciertos)
            jugador.sumarPuntos(PUNTAJE);
    }
}

