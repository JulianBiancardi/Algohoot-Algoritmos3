package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.modelo.Entidades.Opciones.*;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.ModoPregunta;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.PuntajeParcial;

public class MultipleChoice extends Pregunta {

    private MultipleChoice(String unEnunciado, ModoPregunta unModo) {
        super(unEnunciado, unModo);
    }

    public static MultipleChoice conModoClasico(String unEnunciado){ return new MultipleChoice(unEnunciado, new Clasico()); }

    public static MultipleChoice conModoPenalidad(String unEnunciado){ return new MultipleChoice(unEnunciado, new Penalidad()); }

    public static MultipleChoice conModoPuntajeParcial(String unEnunciado){ return new MultipleChoice(unEnunciado, new PuntajeParcial()); }

    public void agregarOpcion(String descripcion, boolean esCorrecta){
        OpcionBinaria opcion = new OpcionBinaria(descripcion, esCorrecta);
        super.agregarOpcion(opcion);
        if(opcionesPregunta.size() > 5)
            throw new ChoiceTieneMaxCincoOpcionesError();
    }

    public OpcionBinaria obtenerOpcion(int posicion){ return (OpcionBinaria) super.obtenerOpcion(posicion); }

    public int calcularCantidadOpcionesCorrectas(){ return (int) opcionesPregunta.stream().filter(Opcion::esCorrecta).count(); }

    public void crearVista(Stage stage, VistaPrincipal vistaPrincipal){
        vistaPrincipal.crearVistaMultipleChoice(stage,this);
    }
}
