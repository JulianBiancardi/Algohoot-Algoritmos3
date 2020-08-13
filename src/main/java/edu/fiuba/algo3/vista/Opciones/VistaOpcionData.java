package edu.fiuba.algo3.vista.Opciones;


import javafx.scene.paint.Color;

public class VistaOpcionData {
    private Color colorBoton;
    private int fila;
    private int columna;

    public VistaOpcionData(int fila,int columna, Color colorBotono){
        this.fila = fila;
        this.columna = columna;
        this.colorBoton = colorBotono;
    }

    public Color getColor() {
        return colorBoton;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
