package edu.fiuba.algo3.modelo;

public abstract class Opcion {
    private String descripcion;

    public Opcion(String unaDescripcion) {
        descripcion = unaDescripcion;
    }

    public abstract boolean esCorrecta();
}
