package edu.fiuba.algo3.modelo.Entidades;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Juego {


    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Ronda> rondas = new ArrayList<>();
    private SistemaTurnos sistemaTurnos = new SistemaTurnos();
    //private Iterator<Ronda> iteradorRonda;
    private int iteradorRonda;


    private final int cantidadRondas = 6;
    private final LectorPreguntas lectorPreguntas = new LectorPreguntas();

    ArrayList<Pregunta> preguntas = new ArrayList<>();

    public Juego () throws IOException {

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

    public int cantidadJugadores(){
        return jugadores.size();
    }

    public void agregarRonda(Pregunta pregunta) {
        //rondas.add(new Ronda(pregunta));
        //iteradorRonda = rondas.iterator();
    }

    public int cantidadRondas(){
        return rondas.size();
    }

    public void siguienteRonda(){

        //rondaActual = iteradorRonda.next();
        iteradorRonda++;
    }

    public boolean hayRondaSiguiente(){
        return (iteradorRonda != rondas.size()-1);
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
        return rondas.get(iteradorRonda);
    }

    public void evaluarRespuestas() {
        obtenerRondaActual().evaluarPregunta();
    }

    public ArrayList<Jugador> obtenerJugadores() {
        return jugadores;
    }
}
