package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

public class RespuestaOrdenada extends Respuesta {

    public RespuestaOrdenada(Jugador jugador, Pregunta pregunta){
        super(jugador, pregunta);
    }

    @Override
    public int cantidadOpcionesCorrectas() {
        int posicionActual = 0;
        for(Opcion opcion: opcionesElegidas){
            ((OpcionOrdenada) opcion).setPosicionActual(posicionActual);
            posicionActual++;
        }
        return super.cantidadOpcionesCorrectas();
    }
}
