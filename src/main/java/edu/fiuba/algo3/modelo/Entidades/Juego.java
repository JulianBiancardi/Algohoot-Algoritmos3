package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
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

        //Creo un par de preguntas para testear el sistema de turnos del juego
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("China", false);
        pregunta.agregarOpcion("Egipto", false);
        pregunta.agregarOpcion("Rusia", false);
        agregarRonda(pregunta);

        VoF vof = VoF.conModoClasico("La guitarra tiene 6 cuerdas",true);
        agregarRonda(vof);

        vof = VoF.conModoClasico("Vamos a aprobar?",false);
        agregarRonda(vof);
/*
        OrderedChoice ordered = new OrderedChoice("Cual fue la mejor frase del Pache?");
        ordered.agregarOpcion("Aplicar Beneficio");
        ordered.agregarOpcion("Correctamente Estricta");
        ordered.agregarOpcion("Messi");
        ordered.agregarOpcion("Exclusividad esta Potente");
        ordered.agregarOpcion("Me voy a tomar algo..");
        agregarRonda(ordered);
*/
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
}
