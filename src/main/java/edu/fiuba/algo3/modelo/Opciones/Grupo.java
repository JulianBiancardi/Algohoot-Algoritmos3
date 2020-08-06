package edu.fiuba.algo3.modelo.Opciones;

public class Grupo {
    private String nombre;
    private ListaOpciones opciones;

    public Grupo(String nombre){
        this.nombre = nombre;
        opciones = new ListaOpciones();
    }

    public void agregarOpcionGrupo(OpcionGrupal opcion){
        opcion.setGrupoActual(nombre);
        opciones.agregarOpcion(opcion);
    }

    public int cantidadOpcionesCorrectas(){
        return opciones.cantidadOpcionesCorrectas();
    }
}
