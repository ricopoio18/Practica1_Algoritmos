package Juego21;

import DeckOfCards.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Juego21 {
    private ArrayList<Jugador> jugadores;
    private Dealer dealer;
    private Mazo mazo;
    private HashMap<String,Integer> puntuaciones;
    private HashMap<String, Boolean> ganadores;

    public Juego21() {
        jugadores = new ArrayList<Jugador>();
        dealer = new Dealer();
        mazo = new Mazo();
        puntuaciones = new HashMap<>();
        ganadores = new HashMap<>();
    }

    public boolean añadirJugadores(String nombre){
        if(jugadores.size() < 5){
            jugadores.add(new Jugador(nombre));
            return true;
        }
        return false;
    }



}

