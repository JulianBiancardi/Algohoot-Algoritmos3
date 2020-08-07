package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.ArrayList;

public class Respuesta {
    protected ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
    private final Jugador responsable;

    public Respuesta(Jugador jugador) {
        responsable = jugador;
    }

    public void agregarOpcion(Opcion opcion) {
        opcionesElegidas.add(opcion);
    }

    public int cantidadOpcionesCorrectas() {
        return (int) opcionesElegidas.stream().filter(Opcion::esCorrecta).count();
    }

    public int cantidadOpcionesIncorrectas() {
        return (int) opcionesElegidas.stream().filter(opcion -> !opcion.esCorrecta()).count();
    }

    public void modificarPuntosBonificadamente(int puntaje) {
        responsable.modificarPuntosBonificadamente(puntaje);
    }

    public void modificarPuntos(int puntaje) {
        responsable.modificarPuntos(puntaje);
    }
}