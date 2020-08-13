package edu.fiuba.algo3.modelo.Excepciones;

public class NombreVacioError extends RuntimeException {
    public NombreVacioError() {
    }

    public NombreVacioError(String mensajeError) {
        super(mensajeError);
    }
}
