package edu.fiuba.algo3.modelo.Opciones;

public class OpcionCorrecta implements Opcion {

    private String descripcion;

    public OpcionCorrecta(String unaDescripcion) {
        this.descripcion = unaDescripcion;
    }

    @Override
    public boolean esCorrecta() {
        return true;
    }
}