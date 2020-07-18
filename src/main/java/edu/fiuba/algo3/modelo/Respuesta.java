package edu.fiuba.algo3.modelo;

public class Respuesta {
    private final boolean valor;
    private final Jugador responsable;

    public Respuesta(boolean valor, Jugador jugador) {
      this.valor = valor;
      responsable = jugador;
    }
    public boolean valor() { return valor; }

    public Jugador responsable() { return responsable; }

    public void sumarPuntos(int puntaje) {
        responsable.sumarPuntos(puntaje);
    }
}
