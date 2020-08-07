package edu.fiuba.algo3.modelo.Opciones;

import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private ArrayList<OpcionGrupal> opciones = new ArrayList<>();

    public Grupo(String nombre){
        this.nombre = nombre;
    }

    public void agregarOpcionGrupo(OpcionGrupal opcion){
        opcion.setGrupoActual(nombre);
        opciones.add(opcion);
    }

    public int cantidadOpcionesCorrectas(){
        for(OpcionGrupal opcion: opciones){
            opcion.setGrupoActual(nombre);
        }
        return (int) opciones.stream().filter(opcion -> opcion.esCorrecta()).count();
    }
}
