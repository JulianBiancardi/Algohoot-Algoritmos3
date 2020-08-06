package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;

public class Respuesta {
    private final ListaOpciones opcionesElegidas = new ListaOpciones();
    private final Jugador responsable;

    public Respuesta(Jugador jugador) {
        responsable = jugador;
    }

    public void agregarOpcion(Opcion opcion) {
        opcionesElegidas.agregarOpcion(opcion);
    }

    public void agregarOpcionOrdenada(OpcionOrdenada opcionOrdenada){
        opcionOrdenada.setPosicionEsperada(opcionesElegidas.tamaño()+1);
        opcionesElegidas.agregarOpcion(opcionOrdenada);
    }

    public int cantidadOpcionesCorrectas() {
        return opcionesElegidas.cantidadOpcionesCorrectas();
    }

    public int cantidadOpcionesIncorrectas() {
        return opcionesElegidas.cantidadOpcionesIncorrectas();
    }

    public void modificarPuntosBonificadamente(int puntaje) {
        responsable.modificarPuntosBonificadamente(puntaje);
    }

    public void modificarPuntos(int puntaje) {
        responsable.modificarPuntos(puntaje);
    }
}