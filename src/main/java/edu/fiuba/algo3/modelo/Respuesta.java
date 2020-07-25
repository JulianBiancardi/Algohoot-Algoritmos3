package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
    private ListaOpciones opcionesElegidas = new ListaOpciones();

    private final Jugador responsable;

    public Respuesta(Jugador jugador) { responsable = jugador; }

    public void agregarOpcion(Opcion opcion) { opcionesElegidas.agregarOpcion(opcion); }

    //public ListaOpciones opciones()  { return opcionesElegidas; }

   public Jugador responsable() { return responsable; }

   public int cantidadOpcionesCorrectas() { opcionesElegidas.cantidadOpcionesCorrectas(); }

   public int cantidadOpcionesIncorrectas() { opcionesElegidas.cantidadOpcionesIncorrectas(); }


}