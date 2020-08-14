package edu.fiuba.algo3.modelo.Entidades.Opciones;

import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;

public class OpcionGrupal implements Opcion {
    private String descripcion;
    private String grupoEsperado;
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

    public void setGrupoEsperado(String nombre){ grupoEsperado = nombre; }

    public void setGrupoActual(String nombre){
        grupoActual = nombre;
    }
}
