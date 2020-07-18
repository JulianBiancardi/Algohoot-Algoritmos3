package edu.fiuba.algo3.modelo;

public class Respuesta {
    private boolean valor;
    private Jugador jugador;

    public Respuesta(boolean valor,Jugador jugador) {
      this.valor = valor;
      this.jugador = jugador;
    }
    public boolean valor() {return valor;}

    public void sumarPuntos(int puntaje) {
        jugador.sumarPuntos(puntaje);
    }
}
