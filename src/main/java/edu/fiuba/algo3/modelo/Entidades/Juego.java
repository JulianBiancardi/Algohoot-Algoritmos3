package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

public class Juego {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Ronda> rondas = new ArrayList<>();
    private SistemaTurnos sistemaTurnos = new SistemaTurnos();
    //private Iterator<Ronda> iteradorRonda;
    private int iteradorRonda;

    public Juego (){
        /*
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares", nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo2("3");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo2("5");
        agregarRonda(pregunta);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor");
        pregunta.nuevaOpcion("Primero");
        pregunta.nuevaOpcion("Segundo");
        pregunta.nuevaOpcion("Tercero");
        pregunta.nuevaOpcion("Cuarto");
        agregarRonda(pregunta);
*/

        //Creo un par de preguntas para testear el sistema de turnos del juego
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Chile", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        agregarRonda(pregunta);

        VoF vof = VoF.conModoPenalidad("La guitarra tiene 6 cuerdas",true);
        agregarRonda(vof);

        iteradorRonda = 0 ;

    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
        sistemaTurnos.agregarJugador(jugador);
    }

    public int cantidadJugadores(){
        return jugadores.size();
    }

    public void agregarRonda(Pregunta pregunta) {
        rondas.add(new Ronda(pregunta));
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
