package edu.fiuba.algo3.modelo.Entidades;

public class CriterioMultiplicador extends CriterioPuntuacion {

    public CriterioMultiplicador(int factorAumento, int factorDisminucion) {
        super(factorAumento, factorDisminucion);
    }

    public void puntuar(Puntuacion puntuacionJugador, int aciertosJugador) {
        puntuacionJugador.modificarPuntosConMultiplicador(factorAumento, aciertosJugador);
    }

    public void penalizar(Puntuacion puntuacionJugador, int erroresJugador) {
        puntuacionJugador.modificarPuntosConMultiplicador(-1*factorDisminucion, erroresJugador);
    }
}
