package edu.fiuba.algo3.modelo.Opciones;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String unaDescripcion) {
        super(unaDescripcion);
    }

    @Override
    public boolean esCorrecta() {
        return false;
    }
}