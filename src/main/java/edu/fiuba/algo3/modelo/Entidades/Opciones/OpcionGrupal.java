package edu.fiuba.algo3.modelo.Entidades.Opciones;

public class OpcionGrupal implements Opcion {
    private String descripcion;
    private String grupoEsperado;
    private String grupoActual;

    public OpcionGrupal(String unaDescripcion, String nombreGrupo){
        descripcion = unaDescripcion;
        grupoEsperado = nombreGrupo;
    }

    public void setGrupoEsperado(String nombre){ grupoEsperado = nombre; }

    public void setGrupoActual(String nombre){
        grupoActual = nombre;
    }

    public boolean esCorrecta(){ return grupoActual.equals(grupoEsperado); }

}
