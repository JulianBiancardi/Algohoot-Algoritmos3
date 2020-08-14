package edu.fiuba.algo3.modelo.Entidades.Opciones;

public class OpcionOrdenada implements Opcion {
    private String descripcion;
    private int posicionActual;
    private int posicionEsperada;

    public OpcionOrdenada(String descripcion, int posicionEsperada) {
        this.descripcion = descripcion;
        this.posicionEsperada = posicionEsperada;
    }

    public void setPosicionEsperada (int posicionEsperada){
        this.posicionEsperada = posicionEsperada;
    }

    public void setPosicionActual(int posicion){ posicionActual = posicion; }

    @Override
    public boolean esCorrecta() {
        return (posicionEsperada == posicionActual);
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
