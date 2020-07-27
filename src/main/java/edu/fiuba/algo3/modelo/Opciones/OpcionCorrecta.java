package edu.fiuba.algo3.modelo.Opciones;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String unaDescripcion) {
        super(unaDescripcion);
    }

    @Override
    public boolean esCorrecta() {
        return true;
    }
}