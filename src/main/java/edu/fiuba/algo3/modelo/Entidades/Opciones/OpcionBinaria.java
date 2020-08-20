package edu.fiuba.algo3.modelo.Entidades.Opciones;

import com.google.gson.JsonObject;

public class OpcionBinaria implements Opcion{
    private final String descripcion;
    private final boolean valor;

    public OpcionBinaria(String descripcion, boolean valor){
        this.descripcion = descripcion;
        this.valor = valor;
    }

    @Override
    public boolean esCorrecta() {
        return valor;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    //JSON
    public static OpcionBinaria recuperar(JsonObject jsonObjectOpcion) {
        String enunciado = jsonObjectOpcion.get("Descripcion").getAsString();
        boolean valor = jsonObjectOpcion.get("Valor").getAsBoolean();

        return new OpcionBinaria(enunciado, valor);
    }
}
