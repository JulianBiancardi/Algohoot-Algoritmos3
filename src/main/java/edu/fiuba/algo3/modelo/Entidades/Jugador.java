package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Excepciones.MultiplicadorYaUtilizadoError;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaExclusividad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class Jugador implements Observable {
    private final String nombre;
    private int puntajeJugador;
    private final Multiplicador multiplicadorDoble = Multiplicador.crearMultiplicadorDoble();
    private final Multiplicador multiplicadorTriple = Multiplicador.crearMultiplicadorTriple();
    private final ArrayList<Multiplicador> multiplicadoresRestantes = new ArrayList<>();
    ArrayList<Observador> observadores = new ArrayList<>();
    private int oportunidadesDeExclusividad = 2;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntajeJugador = 0;
        multiplicadoresRestantes.add(multiplicadorDoble);
        multiplicadoresRestantes.add(multiplicadorTriple);
    }

    public void modificarPuntos(int puntaje) {
        puntajeJugador = puntajeJugador + puntaje;
        notificarObservadores();
    }

    public int puntos() {
        return puntajeJugador;
    }

    public String nombre() {
        return nombre;
    }

    @Override
    public void agregarObservador(Observador unObservador) {
        observadores.add(unObservador);
    }

    @Override
    public void notificarObservadores() {
        observadores.stream().forEach(observador -> observador.actualizar());
    }

    private void agregarMultiplicador(Respuesta respuesta, Multiplicador multiplicador){
        if(!multiplicadoresRestantes.contains(multiplicador)){
            throw new MultiplicadorYaUtilizadoError();
        }
        respuesta.agregarMultiplicador(multiplicador);
        multiplicadoresRestantes.remove(multiplicador);
    }

    public void utilizarMultiplicadorDoble(Respuesta respuesta){
        agregarMultiplicador(respuesta, multiplicadorDoble);
    }

    public void utilizarMultiplicadorTriple(Respuesta respuesta){ agregarMultiplicador(respuesta, multiplicadorTriple); }

    public Pregunta obtenerExclusividadEnLaPregunta(Pregunta pregunta) {
        if(pregunta.aceptaMultiplicador())
            throw new PreguntaNoAceptaExclusividadError();

        if(oportunidadesDeExclusividad > 0){
            oportunidadesDeExclusividad--;
            return new PreguntaExclusividad(pregunta);
        }
        return pregunta;
    }
}