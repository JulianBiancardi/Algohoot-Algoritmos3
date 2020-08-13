package edu.fiuba.algo3.modelo.Entidades.Opciones;

import java.util.ArrayList;

public class Grupo {
    private final String nombre;
    private final ArrayList<OpcionGrupal> opciones = new ArrayList<>();

    public Grupo(String nombre){ this.nombre = nombre; }

    public void agregarOpcionGrupo(OpcionGrupal opcion){ opciones.add(opcion); }

    public int cantidadOpcionesCorrectas(){
        opciones.forEach(opcion -> opcion.setGrupoActual(nombre));
        return (int) opciones.stream().filter(OpcionGrupal::esCorrecta).count();
    }
}
