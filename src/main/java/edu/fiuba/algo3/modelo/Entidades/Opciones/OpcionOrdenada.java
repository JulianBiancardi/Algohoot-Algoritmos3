package edu.fiuba.algo3.modelo.Entidades.Opciones;

import com.google.gson.JsonObject;

public class OpcionOrdenada implements Opcion {
    private final String descripcion;
    private int posicionActual;
    private final int posicionEsperada;

    public OpcionOrdenada(String descripcion, int posicionEsperada) {
        this.descripcion = descripcion;
        this.posicionEsperada = posicionEsperada;
    }

    public void setPosicionActual(int posicion){ posicionActual = posicion; }

    @Override
    public boolean esCorrecta() {
        return (posicionEsperada == posicionActual);
    }

    public static OpcionOrdenada recuperar(JsonObject jsonObjectOpcion, int posicionEsperada) {
        String enunciado = jsonObjectOpcion.get("Descripcion").getAsString();

        return new OpcionOrdenada(enunciado, posicionEsperada);
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
