package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.stage.Stage;

public class OrderedChoice extends Pregunta{

    public OrderedChoice(String unEnunciado) {
        super(unEnunciado, new Clasico());
    }

    public void agregarOpcion(OpcionOrdenada opcion){
        opcion.setPosicionEsperada(cantidadOpciones());
        super.agregarOpcion(opcion);
    }

    public int calcularCantidadOpcionesCorrectas(){ return opcionesPregunta.size();}

    public OpcionOrdenada obtenerOpcion(int posicion){ return (OpcionOrdenada) super.obtenerOpcion(posicion); }

    public void crearVista(Stage stage, VistaPrincipal vistaPrincipal){
        //vistaPrincipal.crearVistaMultipleChoice(stage,this);
    }
}

