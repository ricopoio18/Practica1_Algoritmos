package Juego21;

import DeckOfCards.CartaInglesa;

import java.util.ArrayList;
import java.util.HashMap;

public class Juego21 {

    private ArrayList<Jugador> jugadores;
    private Dealer dealer;
    private HashMap<String, Integer> puntuaciones;
    private HashMap<String, Boolean> ganadores;

    public Juego21() {
        jugadores = new ArrayList<>();
        dealer = new Dealer();
        puntuaciones = new HashMap<>();
        ganadores = new HashMap<>();
    }

    public boolean añadirJugadores(String nombre) {
        if (jugadores.size() < 5) {
            jugadores.add(new Jugador(nombre));
            return true;
        }

        return false;
    }

    public void repartirCartasIniciales() {
        for (int i = 0; i < 2; i++) {
            for (Jugador jugador : jugadores) {
                CartaInglesa carta = dealer.repartirCarta();
                if (carta != null) {
                    carta.makeFaceUp();
                    jugador.añadirCartas(carta);
                }
            }

            CartaInglesa cartaDealer = dealer.repartirCarta();

            if (cartaDealer != null) {
                if (i == 0) {
                    cartaDealer.makeFaceUp();
                } else {
                    cartaDealer.makeFaceDown();
                }
                dealer.añadirCartas(cartaDealer);
            }
        }
    }

    public boolean pedirCartaJugador(Jugador jugador) {

        if (EvaluacionPuntos.estaExcedido(EvaluacionPuntos.obtenerTotalPuntos(jugador))) {
            return false;
        }

        CartaInglesa carta = dealer.repartirCarta();

        if (carta != null) {
            carta.makeFaceUp();
            return jugador.añadirCartas(carta);
        }

        return false;
    }

    public void revelarCartasDealer() {

        for (CartaInglesa carta : dealer.getMano()) {
            carta.makeFaceUp();
        }
    }

    public CartaInglesa pedirCartaDealer() {
        CartaInglesa carta = dealer.repartirCarta();
        if (carta != null) {
            carta.makeFaceUp();
            dealer.añadirCartas(carta);
        }

        return carta;
    }

    public boolean dealerDebePedir() {
        return EvaluacionPuntos.obtenerTotalPuntos(dealer) < 17;
    }

    public void determinarGanadores() {
        int puntosDealer = EvaluacionPuntos.obtenerTotalPuntos(dealer);puntuaciones.put(dealer.getNombre(), puntosDealer);

        for (Jugador jugador : jugadores) {
            int puntosJugador = EvaluacionPuntos.obtenerTotalPuntos(jugador);puntuaciones.put(jugador.getNombre(), puntosJugador);
            boolean victoria = EvaluacionPuntos.esVictoria(puntosJugador, puntosDealer);
            ganadores.put(jugador.getNombre(), victoria);
        }
    }

    public void reiniciarRonda() {
        for (Jugador jugador : jugadores) {
            jugador.limpiarMano();
        }

        dealer.limpiarMano();
        dealer.reiniciarMazo();
        puntuaciones.clear();
        ganadores.clear();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public HashMap<String, Integer> getPuntuaciones() {
        return puntuaciones;
    }

    public HashMap<String, Boolean> getGanadores() {
        return ganadores;
    }
}