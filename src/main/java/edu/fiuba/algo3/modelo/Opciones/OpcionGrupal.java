package edu.fiuba.algo3.modelo.Opciones;

public class OpcionGrupal implements Opcion {
    private String descripcion;
    private String grupoEsperado;
    private String grupoActual;

    public OpcionGrupal(String unaDescripcion){
        descripcion = unaDescripcion;
    }

    public boolean esCorrecta(){ return (grupoActual == grupoEsperado); }

    public void setGrupoEsperado(String nombre){ grupoEsperado = nombre; }

    public void setGrupoActual(String nombre){ grupoActual = nombre; }
}
