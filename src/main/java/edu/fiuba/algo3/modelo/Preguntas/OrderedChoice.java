package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.modelo.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;

public class OrderedChoice extends Pregunta{

    public OrderedChoice(String unEnunciado) {
        super(unEnunciado, new Clasico());
    }

    public void agregarOpcion(String descripcion){
        OpcionOrdenada opcion = new OpcionOrdenada(descripcion);
        opcion.setPosicionEsperada(cantidadOpciones());
        super.agregarOpcion(opcion);
        if(opcionesPregunta.size() > 5)
            throw new ChoiceTieneMaxCincoOpcionesError();
    }

    public int calcularCantidadOpcionesCorrectas(){ return opcionesPregunta.size();}

    public OpcionOrdenada obtenerOpcion(int posicion){ return (OpcionOrdenada) super.obtenerOpcion(posicion); }
}

