package edu.fiuba.algo3.modelo.Entidades.Opciones;

import com.google.gson.JsonObject;

public class OpcionBinaria implements Opcion{
    private String descripcion;
    private boolean valor;

    public OpcionBinaria(String unaDescripcion, boolean valor){
        descripcion = unaDescripcion;
        this.valor = valor;
    }

    @Override
    public boolean esCorrecta() {
        return valor;
    }


    public static OpcionBinaria recuperar(JsonObject jsonObjectOpcion) {
        String enunciado = jsonObjectOpcion.get("Descripcion").getAsString();
        boolean valor = jsonObjectOpcion.get("Valor").getAsBoolean();

        OpcionBinaria opcion = new OpcionBinaria(enunciado, valor);

        return opcion;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
