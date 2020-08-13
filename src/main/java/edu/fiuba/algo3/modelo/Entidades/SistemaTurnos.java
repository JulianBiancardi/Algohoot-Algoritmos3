package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Exepciones.MultiplicadorYaUtilizadoError;

import java.util.ArrayList;

public class SistemaTurnos {
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private int index;

    public SistemaTurnos (){
        index = 0;
    }

    public void agregarJugador (Jugador jugador){
        jugadores.add(jugador);
    }

    public void siguienteTurno(){
        index++;
        if(index == jugadores.size())
            index = 0;
    }

    public boolean terminoRonda(){
        return (index == 0);
    }

    public Jugador obtenerTurno(){
        return jugadores.get(index);
    }
}