package Juego21;

public class ControladorJuego21 {
    private Juego21 modelo;
    private VistaJuego21 vista;

    public ControladorJuego21(Juego21 modelo, VistaJuego21 vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarJuego() {
        // 1. Configuración inicial
        int numJugadores = vista.pedirNumeroJugadores();
        for (int i = 1; i <= numJugadores; i++) {
            String nombre = vista.pedirNombreJugador(i);
            modelo.añadirJugadores(nombre);
        }

        // 2. Reparto de cartas
        modelo.repartirCartasIniciales();

        // 3. Turno de jugadores
        for (Jugador jugador : modelo.getJugadores()) {
            ejecutarTurno(jugador);
        }

        // 4. Turno del Dealer y cálculo de ganadores
        modelo.jugarTurnoDealer();
        modelo.determinarGanadores();

        // 5. Presentación de resultados
        vista.mostrarResultadosFinales(
                modelo.getDealer(),
                modelo.getJugadores(),
                modelo.getPuntuaciones(),
                modelo.getGanadores()
        );
    }

    private void ejecutarTurno(Jugador jugador) {
        while (true) {
            int puntos = EvaluacionPuntos.obtenerTotalPuntos(jugador);
            vista.mostrarEstadoJugador(jugador, puntos);

            if (puntos >= 21) {
                if (puntos > 21) {
                    vista.mostrarMensajeExcedido(jugador.getNombre());
                }
                break;
            }

            if (vista.pedirDecisionPedirCarta()) {
                modelo.pedirCartaJugador(jugador);
            } else {
                break;
            }
        }
    }

    // Método principal para arrancar la aplicación
    public static void main(String[] args) {
        Juego21 modelo = new Juego21();
        VistaJuego21 vista = new VistaJuego21();
        ControladorJuego21 controlador = new ControladorJuego21(modelo, vista);

        controlador.iniciarJuego();
    }
}