package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;

public class RespuestaGrupal extends Respuesta{
    private ListaOpciones lista1 = new ListaOpciones();
    private ListaOpciones lista2 = new ListaOpciones();
    private String nombreGrupo1;
    private String nombreGrupo2;

    public RespuestaGrupal(Jugador jugador, String nombreGrupo1, String nombreGrupo2){
        super(jugador);
        this.nombreGrupo1 = nombreGrupo1;
        this.nombreGrupo2 = nombreGrupo2;
    }

    public void agregarOpcionLista1(OpcionGrupal opcion){
        opcion.setGrupoActual(nombreGrupo1);
        lista1.agregarOpcion(opcion);
    }

    public void agregarOpcionLista2(OpcionGrupal opcion){
        opcion.setGrupoActual(nombreGrupo2);
        lista2.agregarOpcion(opcion);
    }

    @Override
    public int cantidadOpcionesCorrectas() {
        return (lista1.cantidadOpcionesCorrectas() + lista2.cantidadOpcionesCorrectas());
    }
}
