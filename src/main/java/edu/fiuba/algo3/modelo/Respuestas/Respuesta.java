package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Multiplicador;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaMultiplicadorError;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.ArrayList;

public class Respuesta {
    protected ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
    private final Jugador responsable;
    private final Pregunta preguntaReferenciada;
    private Multiplicador multiplicadorActual = Multiplicador.crearMultiplicadorNulo();

    public Respuesta(Jugador jugador, Pregunta pregunta) {
        responsable = jugador;
        preguntaReferenciada = pregunta;
    }

    public void agregarOpcion(Opcion opcion) {
        opcionesElegidas.add(opcion);
    }

    public int cantidadOpcionesCorrectas() { return (int) opcionesElegidas.stream().filter(Opcion::esCorrecta).count(); }

    public int cantidadOpcionesIncorrectas() { return (int) opcionesElegidas.stream().filter(opcion -> !opcion.esCorrecta()).count(); }

    public void modificarPuntos(int puntaje) {
        responsable.modificarPuntos(multiplicadorActual.aplicarMultiplicador(puntaje));
    }

    public void agregarMultiplicador(Multiplicador multiplicador){
        if(!preguntaReferenciada.aceptaMultiplicador()){
            throw new PreguntaNoAceptaMultiplicadorError();
        }
        multiplicadorActual = multiplicador;
    }

    public void activarExclusividad() { preguntaReferenciada.activarExclusividad(); }

}