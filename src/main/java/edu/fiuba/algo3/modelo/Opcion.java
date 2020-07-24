package edu.fiuba.algo3.modelo;

public class Opcion {
    private String descripcion;
    private boolean esCorrecta;

    public Opcion(String unaDescripcion, boolean correcta) {
        descripcion = unaDescripcion;
        esCorrecta = correcta;
    }

    public boolean esCorrecta() { return esCorrecta; }
}
