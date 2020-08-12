package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Juego {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Ronda> rondas = new ArrayList<>();
    private SistemaTurnos sistemaTurnos = new SistemaTurnos();

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
        sistemaTurnos.agregarJugador(jugador);
    }

    public int cantidadJugadores(){
        return jugadores.size();
    }

    public void agregarRonda(Pregunta pregunta){
        rondas.add(new Ronda(pregunta));
    }

    public int cantidadRondas(){
        return rondas.size();
    }

    public Pregunta obtenerPregunta (){
        Ronda ronda = rondas.get(rondas.size() - 1);
        rondas.remove(rondas.size() - 1);
        return ronda.obtenerPregunta();
    }

    public boolean hayRondasDisponibles(){
        return (rondas.size() != 0);
    }

    public void siguienteTurno(){
        sistemaTurnos.siguienteTurno();
    }

    public Jugador turnoDe(){
        return sistemaTurnos.obtenerTurno();
    }

    //No contemplo caso empate
    public Jugador obtenerGanador(){
        Jugador jugadorAux = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if(jugador.puntos() > jugadorAux.puntos())
                jugadorAux = jugador;
        }
        return jugadorAux;
    }

}
