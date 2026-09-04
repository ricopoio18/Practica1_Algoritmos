package Juego21;

import DeckOfCards.*;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<CartaInglesa> mano;
    private String nombre;
    private int puntuacion;
    private boolean ganador;
    private boolean deal;

    public Jugador(String nombre, int puntuacion) {
        mano = new ArrayList<>();
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        ganador = false;
        deal = false;
    }

    public Jugador(){
        mano = new ArrayList<>();
        nombre = "Jotaro";
        puntuacion = 0;
        ganador = false;
        deal = false;
    }

    public boolean añadirCartas(CartaInglesa carta){
        if(puntuacion > 21){
            return false;
        }
        mano.add(carta);
        return true;
    }

    public void setDeal(boolean deal){
        this.deal = deal;
    }

    public void setGanador(){
        this.ganador = true;
    }

    public void setPuntos(int puntos){
        puntuacion += puntos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public boolean getDeal(){
        return deal;
    }

    public boolean getGanador(){
        return ganador;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<CartaInglesa> getMano(){
        return mano;
    }



}
