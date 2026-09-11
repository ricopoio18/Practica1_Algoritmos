package Juego21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VistaJuego21 {
    private Scanner scanner = new Scanner(System.in);

    public int pedirNumeroJugadores() {
        int cantidad;
        do {
            System.out.print("Número de jugadores (1-5): ");
            cantidad = scanner.nextInt();
            scanner.nextLine();
        } while (cantidad < 1 || cantidad > 5);

        return cantidad;
    }

    public String pedirNombreJugador(int numero) {
        System.out.print("Nombre jugador " + numero + ": ");
        return scanner.nextLine().trim();
    }

    public void mostrarInicioRonda(int ronda) {
        System.out.println("\n========================");
        System.out.println("       RONDA " + ronda);
        System.out.println("========================");
    }

    public void mostrarCartaVisibleDealer(Dealer dealer) {
        System.out.println("\nDealer: " + dealer.getMano());
    }

    public void mostrarEstadoJugador(
            Jugador jugador, int puntos) {

        System.out.println("\n" + jugador.getNombre());
        System.out.println(
                "Cartas: " + jugador.getMano());

        System.out.println(
                "Puntos: " + puntos);
    }

    public boolean pedirDecisionPedirCarta() {

        System.out.print("¿Quieres pedir otra carta? s/n: ");
        return scanner.nextLine().trim().equalsIgnoreCase("s");
    }

    public void mostrarMensajeExcedido(String nombre) {
        System.out.println(
                nombre + " se pasó de 21.");
    }

    public void mostrarInicioTurnoDealer() {
        System.out.println("\n--- Turno del Dealer ---");
    }

    public void mostrarEstadoDealer(Dealer dealer, int puntos) {
        System.out.println("Dealer: " + dealer.getMano() + " | Puntos: " + puntos
        );
    }

    public void mostrarDealerPideCarta() {
        System.out.println("El Dealer pide una carta...");
    }

    public void mostrarDealerSePlanta() {
        System.out.println("El Dealer se planta.");
    }

    public void mostrarResultadosFinales(Dealer dealer, ArrayList<Jugador> jugadores, HashMap<String, Integer> puntuaciones, HashMap<String, Boolean> ganadores) {

        System.out.println("\n--- Resultados ---");
        int puntosDealer = puntuaciones.get(dealer.getNombre());
        System.out.println("Dealer: " + puntosDealer + " puntos " + dealer.getMano());

        for (Jugador jugador : jugadores) {
            String nombre = jugador.getNombre();
            int puntosJugador = puntuaciones.get(nombre);

            String resultado;
            if (puntosJugador <= 21 && puntosJugador == puntosDealer) {
                resultado = "Empate";

            } else {
                resultado = ganadores.get(nombre) ? "Ganador" : "Perdedor";
            }

            System.out.println(nombre + ": " + puntosJugador + " puntos " + jugador.getMano() + " -> " + resultado);
        }
    }

    public boolean preguntarOtraRonda() {
        System.out.print("\n¿Quieres jugar otra ronda? s/n: ");
        return scanner.nextLine().trim().equalsIgnoreCase("s");
    }
}