package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Juego {
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final ArrayList<Ronda> rondas = new ArrayList<>();
    private final SistemaTurnos sistemaTurnos = new SistemaTurnos();
    private int rondaActual;
    private final static int cantidadRondas = 6;

    public Juego () throws IOException {
        LectorPreguntas lectorPreguntas = new LectorPreguntas();
        ArrayList<Pregunta> preguntas = lectorPreguntas.leerPreguntas();
        Collections.shuffle(preguntas);

        for(int i = 0; i < cantidadRondas; i++){
            rondas.add(new Ronda(preguntas.get(i)));
        }
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
        sistemaTurnos.agregarJugador(jugador);
    }

    public void siguienteRonda(){
        rondaActual++;
    }

    public boolean hayRondaSiguiente(){
        return (rondaActual != rondas.size()-1);
    }

    public boolean terminoRonda(){
        return (sistemaTurnos.terminoRonda());
    }

    public void siguienteTurno(){
        sistemaTurnos.siguienteTurno();
    }

    public Jugador turnoDe(){
        return sistemaTurnos.obtenerTurno();
    }

    public Ronda obtenerRondaActual() {
        return rondas.get(rondaActual);
    }

    public void evaluarRespuestas() {
        obtenerRondaActual().evaluarPregunta();
    }

    public ArrayList<Jugador> obtenerJugadores() {
        return jugadores;
    }
}
