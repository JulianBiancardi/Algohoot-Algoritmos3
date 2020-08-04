package edu.fiuba.algo3.modelo.Opciones;

public class OpcionOrdenada implements Opcion {

    private String descripcion;
    private int posicion;
    private int posicionEsperada;

    public OpcionOrdenada(String descripcion, int posicion) {
        this.descripcion = descripcion;
        this.posicion = posicion;
    }

    public void setPosicionEsperada (int posicionEsperada){
        this.posicionEsperada = posicionEsperada;
    }

    @Override
    public boolean esCorrecta() {
        return (posicionEsperada == posicion);
    }
}
