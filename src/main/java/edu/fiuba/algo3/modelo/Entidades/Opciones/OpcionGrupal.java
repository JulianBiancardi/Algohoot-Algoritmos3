package edu.fiuba.algo3.modelo.Entidades.Opciones;

import com.google.gson.JsonObject;

public class OpcionGrupal implements Opcion {
    private final String descripcion;
    private final String grupoEsperado;
    private String grupoActual;

    public OpcionGrupal(String unaDescripcion, String nombreGrupo){
        descripcion = unaDescripcion;
        grupoEsperado = nombreGrupo;
    }

    public boolean esCorrecta(){ return grupoActual.equals(grupoEsperado); }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    public void setGrupoActual(String nombre){
        grupoActual = nombre;
    }

    public static OpcionGrupal recuperar(JsonObject jsonObjectOpcion, String grupo) {
        String enunciado = jsonObjectOpcion.get("Descripcion").getAsString();

        OpcionGrupal opcion = new OpcionGrupal(enunciado, grupo);

        return opcion;
    }
}
