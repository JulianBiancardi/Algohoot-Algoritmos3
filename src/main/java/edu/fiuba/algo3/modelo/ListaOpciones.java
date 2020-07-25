package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ListaOpciones {
    ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public void agregarOpcion(Opcion opcion) { opciones.add(opcion); }

    public int cantidadOpcionesCorrectas() {
        int contador = 0;
        for (Opcion opcionElegida : opciones) {
            if(opcionElegida.esCorrecta())
                contador++;
        }
        return contador;
    }

    public int cantidadOpcionesIncorrectas(){
        return opciones.size() - cantidadOpcionesCorrectas();
    }
}
