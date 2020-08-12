package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;

public class GroupChoice extends Pregunta{
    private final String nombreGrupo1;
    private final String nombreGrupo2;

    public GroupChoice(String enunciado, String nombreGrupo1, String nombreGrupo2){
        super(enunciado, new Clasico());
        this.nombreGrupo1 = nombreGrupo1;
        this.nombreGrupo2 = nombreGrupo2;
    }

    private void agregarOpcionAGrupo(OpcionGrupal opcion, String nombreGrupo){
        opcion.setGrupoEsperado(nombreGrupo);
        super.agregarOpcion(opcion);
    }

    public int calcularCantidadOpcionesCorrectas(){
        return cantidadOpciones();
    }

    public void agregarOpcionGrupo1(OpcionGrupal opcion){
        agregarOpcionAGrupo(opcion, nombreGrupo1);
    }

    public void agregarOpcionGrupo2(OpcionGrupal opcion){
        agregarOpcionAGrupo(opcion, nombreGrupo2);
    }

    public OpcionGrupal obtenerOpcion(int posicion){
        return (OpcionGrupal) super.obtenerOpcion(posicion);
    }
}
