package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    private final ArrayList<OpcionGrupal> opcionesPregunta = new ArrayList<>();
    private final String nombreGrupo1;
    private final String nombreGrupo2;

    public GroupChoice(String enunciado, String nombreGrupo1, String nombreGrupo2){
        super(enunciado, new Clasico());
        this.nombreGrupo1 = nombreGrupo1;
        this.nombreGrupo2 = nombreGrupo2;
    }

    private void agregarOpcionAGrupo(String descripcion, String nombreGrupo){
        opcionesPregunta.add(new OpcionGrupal(descripcion, nombreGrupo));
    }

    public int calcularCantidadOpcionesCorrectas(){
        return cantidadOpciones();
    }

    public void nuevaOpcionGrupo1(String descripcion){
        agregarOpcionAGrupo(descripcion, nombreGrupo1);
    }

    public void nuevaOpcionGrupo2(String descripcion){
        agregarOpcionAGrupo(descripcion, nombreGrupo2);
    }

    public OpcionGrupal obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    public int cantidadOpciones(){
        return opcionesPregunta.size();
    }
}
