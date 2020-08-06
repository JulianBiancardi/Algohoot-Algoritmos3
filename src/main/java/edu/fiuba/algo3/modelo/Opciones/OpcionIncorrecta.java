package edu.fiuba.algo3.modelo.Opciones;

public class OpcionIncorrecta implements Opcion {

    private String descripcion;

    public OpcionIncorrecta(String unaDescripcion) {
        this.descripcion = unaDescripcion;
    }

    @Override
    public boolean esCorrecta() {
        return false;
    }
}