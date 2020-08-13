package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Excepciones.OrderedTieneMaxCincoOpcionesError;

public class OrderedChoice extends Pregunta{

    public OrderedChoice(String unEnunciado) {
        super(unEnunciado, new Clasico());
    }

    public void agregarOpcion(String descripcion){
        OpcionOrdenada opcion = new OpcionOrdenada(descripcion);
        opcion.setPosicionEsperada(cantidadOpciones());
        super.agregarOpcion(opcion);
        if(opcionesPregunta.size() > 5)
            throw new OrderedTieneMaxCincoOpcionesError();
    }

    public int calcularCantidadOpcionesCorrectas(){ return opcionesPregunta.size();}

    public OpcionOrdenada obtenerOpcion(int posicion){ return (OpcionOrdenada) super.obtenerOpcion(posicion); }
}

