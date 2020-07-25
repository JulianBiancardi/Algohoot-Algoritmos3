package edu.fiuba.algo3.modelo;

public class ConPenalidad implements ModoPregunta {

    @Override
    public void modificarPuntos(Jugador jugador, int correctas, int incorrectas){
        if(incorrectas == 0)
            jugador.sumarPuntos(cantidad);
        else
            jugador.restarPuntos(cantidad);
    }
}
