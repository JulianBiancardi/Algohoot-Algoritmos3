package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Grupo;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;

public class RespuestaGrupal extends Respuesta{
    private Grupo grupo1;
    private Grupo grupo2;

    public RespuestaGrupal(Jugador jugador, String nombreGrupo1, String nombreGrupo2){
        super(jugador);
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
