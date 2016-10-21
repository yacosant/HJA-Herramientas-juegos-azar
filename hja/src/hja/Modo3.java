/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hja;

import java.util.ArrayList;

/**
 *
 * @author YVCX
 */
public class Modo3 {
    private ArrayList<Carta> cartas;
    private int peso;
    private int jugador;
    
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public int getPeso() {
        return peso;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }
    
}
