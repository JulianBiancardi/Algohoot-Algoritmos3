package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.Opcion;

public class Respuesta {
    private final ListaOpciones opcionesElegidas = new ListaOpciones();
    private final Jugador responsable;

    public Respuesta(Jugador jugador) {
        responsable = jugador;
    }

    public void agregarOpcion(Opcion opcion) {
        opcionesElegidas.agregarOpcion(opcion);
    }

    public int cantidadOpcionesCorrectas() {
        return opcionesElegidas.cantidadOpcionesCorrectas();
    }

    public int cantidadOpcionesIncorrectas() {
        return opcionesElegidas.cantidadOpcionesIncorrectas();
    }

    public void puntuarJugador(int puntaje) {
        responsable.sumarPuntos(puntaje);
    }

    public void penalizarJugador(int puntaje) {
        responsable.restarPuntos(puntaje);
    }
}