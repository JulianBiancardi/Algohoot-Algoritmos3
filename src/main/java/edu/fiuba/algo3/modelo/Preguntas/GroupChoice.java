package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;

public class GroupChoice extends Pregunta{
    private String nombreGrupo1;
    private String nombreGrupo2;

    public GroupChoice(String enunciado, String nombreGrupo1, String nombreGrupo2){
        super(enunciado, new Clasico(), new ListaOpciones());
        this.enunciado = enunciado;
        this.nombreGrupo1 = nombreGrupo1;
        this.nombreGrupo2 = nombreGrupo2;
    }

    private void agregarOpcionAGrupo(OpcionGrupal opcion, String nombreGrupo){
        opcion.setGrupoEsperado(nombreGrupo);
        opcionesPregunta.agregarOpcion(opcion);
        cantidadOpcionesCorrectas++;
    }

    public void agregarOpcionGrupo1(OpcionGrupal opcion){
        agregarOpcionAGrupo(opcion, nombreGrupo1);
    }

    public void agregarOpcionGrupo2(OpcionGrupal opcion){
        agregarOpcionAGrupo(opcion, nombreGrupo2);
    }

    public Opcion obtenerOpcion(int posicion){
        return opcionesPregunta.obtener(posicion);
    }
}
