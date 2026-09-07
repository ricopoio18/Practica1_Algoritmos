package Juego21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VistaJuego21 {
    private Scanner scanner = new Scanner(System.in);

    public int pedirNumeroJugadores() {
        System.out.print("Número de jugadores (1-5): ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        return cantidad;
    }

    public String pedirNombreJugador(int numero) {
        System.out.print("Nombre jugador " + numero + ": ");
        return scanner.nextLine().trim();
    }

    public void mostrarEstadoJugador(Jugador jugador, int puntos) {
        System.out.println("\n" + jugador.getNombre() + "Cartas: " + jugador.getMano() + "\nPuntos: " + puntos);
    }

    public boolean pedirDecisionPedirCarta() {
        System.out.print("¿Quieres pedir otra carta? s/n: ");
        return scanner.nextLine().trim().equalsIgnoreCase("s");
    }

    public void mostrarMensajeExcedido(String nombre) {
        System.out.println(nombre + " se pasa de 21");
    }

    public void mostrarResultadosFinales(Dealer dealer, ArrayList<Jugador> jugadores,
                                         HashMap<String, Integer> puntuaciones,
                                         HashMap<String, Boolean> ganadores) {
        System.out.println("\n--- Resultados ---");
        System.out.println("Dealer: " + puntuaciones.get(dealer.getNombre()) + " puntos (" + dealer.getMano() + ")");

        for (Jugador jugador : jugadores) {
            String nombre = jugador.getNombre();
            int pts = puntuaciones.get(nombre);
            boolean gano = ganadores.get(nombre);
            System.out.println(nombre + ": " + pts + " puntos -> " + (gano ? "Ganador" : "Perdedor"));
        }
    }
}