package edu.fiuba.algo3.modelo.Entidades.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Grupo;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;

public class RespuestaGrupal extends Respuesta{
    private final Grupo grupo1;
    private final Grupo grupo2;

    public RespuestaGrupal(Jugador jugador, Pregunta pregunta, String nombreGrupo1, String nombreGrupo2){
        super(jugador, pregunta);
        grupo1 = new Grupo(nombreGrupo1);
        grupo2 = new Grupo(nombreGrupo2);
    }

    private void agregarOpcionALista(OpcionGrupal opcion, Grupo grupo){ grupo.agregarOpcionGrupo(opcion); }

    public void agregarOpcionGrupo1(OpcionGrupal opcion){
        agregarOpcionALista(opcion, grupo1);
    }

    public void agregarOpcionGrupo2(OpcionGrupal opcion){
        agregarOpcionALista(opcion, grupo2);
    }

    @Override
    public int cantidadOpcionesCorrectas() { return (grupo1.cantidadOpcionesCorrectas() + grupo2.cantidadOpcionesCorrectas()); }
}
