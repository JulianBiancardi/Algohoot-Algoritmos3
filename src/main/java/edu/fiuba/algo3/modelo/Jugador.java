package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    public Respuesta responder(boolean valor){
        return (new Respuesta(valor,this));
    }

    public void sumarPuntos(int puntaje) {
        puntos += puntaje;
    }

    public int puntos() {return puntos;}
}