package edu.fiuba.algo3.modelo.Entidades;

import java.util.ArrayList;

public class SistemaTurnos {
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private int turnoActual;

    public SistemaTurnos (){
        turnoActual = 0;
    }

    public void agregarJugador (Jugador jugador){
        jugadores.add(jugador);
    }

    public void siguienteTurno(){
        turnoActual++;
        if(turnoActual == jugadores.size())
            turnoActual = 0;
    }

    public boolean terminoRonda(){
        return (turnoActual == 0);
    }

    public Jugador jugadorActual(){
        return jugadores.get(turnoActual);
    }
}