package edu.fiuba.algo3.modelo.Entidades.Opciones;

public class OpcionBinaria implements Opcion{
    private String descripcion;
    private boolean valor;

    public OpcionBinaria(String unaDescripcion, boolean valor){
        descripcion = unaDescripcion;
        this.valor = valor;
    }

    @Override
    public boolean esCorrecta() {
        return valor;
    }
}
