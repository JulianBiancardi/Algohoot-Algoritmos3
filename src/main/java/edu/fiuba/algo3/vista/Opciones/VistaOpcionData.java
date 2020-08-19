package edu.fiuba.algo3.vista.Opciones;

import javafx.scene.image.Image;

public class VistaOpcionData {
    private final String urlImagen;
    private final int fila;
    private final int columna;

    public VistaOpcionData(int fila, int columna, String url){
        this.fila = fila;
        this.columna = columna;
        urlImagen = url;
    }

    public Image getImagen(){
        return new Image(urlImagen);
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }
}
