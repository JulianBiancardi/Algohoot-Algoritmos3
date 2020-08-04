package edu.fiuba.algo3.modelo.Entidades;

public class CriterioPuntuacion {
    protected int factorAumento;
    protected int factorDisminucion;

    public CriterioPuntuacion(int factorAumento, int factorDisminucion) {
        this.factorAumento = factorAumento;
        this.factorDisminucion = factorDisminucion;
    }

    public void puntuar(Puntuacion puntuacionJugador, int aciertosJugador){
        puntuacionJugador.modificarPuntos(factorAumento, aciertosJugador);
    }

    public void penalizar(Puntuacion puntuacionJugador, int erroresJugador) {
        puntuacionJugador.modificarPuntos(-1*factorDisminucion, erroresJugador);
    }

    public int obtenerFactorAumento() {
        return factorAumento;
    }

    public int obtenerFactorDisminucion() {
        return factorDisminucion;
    }
}
