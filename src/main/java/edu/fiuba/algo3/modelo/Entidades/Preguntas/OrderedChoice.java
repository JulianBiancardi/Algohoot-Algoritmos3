package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Excepciones.OrderedTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.stage.Stage;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    private final ArrayList<OpcionOrdenada> opcionesPregunta = new ArrayList<>();

    public OrderedChoice(String unEnunciado) {
        super(unEnunciado, new Clasico());
    }

    private void agregarOpcion(OpcionOrdenada opcion){
        opcionesPregunta.add(opcion);
    }

    public void nuevaOpcion(String descripcion){
        if(cantidadOpciones() == 5)
            throw new OrderedTieneMaxCincoOpcionesError();
        agregarOpcion(new OpcionOrdenada(descripcion, cantidadOpciones()));
    }

    public int calcularCantidadOpcionesCorrectas(){ return opcionesPregunta.size(); }

    public OpcionOrdenada obtenerOpcion(int posicion){
        return (OpcionOrdenada) opcionesPregunta.get(posicion);
    }

    public int cantidadOpciones() {
        return opcionesPregunta.size();
    }

    //public OpcionOrdenada obtenerOpcion(int posicion){ return (OpcionOrdenada) super.obtenerOpcion(posicion); }

    public void crearVista(Stage stage, VistaPrincipal vistaPrincipal){
        //vistaPrincipal.crearVistaMultipleChoice(stage,this);

    }
}

