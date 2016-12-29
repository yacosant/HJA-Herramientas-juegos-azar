/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Grupo 01
 */
public class Logica {
    private int numJug;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ArrayList<Carta> baraja = new ArrayList<Carta>();
    private ArrayList<Carta> pozo = new ArrayList<Carta>();
    
    
    public Logica(){
        crearBaraja();
    }
    
    public void partida(){
        int cont=0;
        //saca el que tenga 5 de oros. cont++;
        
        while(cont<40){
            for(int i=0; i<jugadores.size(); i++){
                
            }
        }
        
    }
    public void addJugador(){
        jugadores.add(new JugadorHumano());
    }
    
    public void addJugadorAutomatico(){
       jugadores.add(new JugadorAutomatico());
    }
    
    public void reset(){
        jugadores.clear();
    }

    public void setNumJug(int numJug) {
        this.numJug = numJug;
    }
    
    private int cartasPorJugador(){
       int num=10;
        switch(numJug){
            case 4: num=10; break;
            case 5: num=8; break;
            case 6: num=6; break;
            default: num=10;
        }
        return num;
    }
    
    private void repartir(){
        ArrayList<Carta> c  = new ArrayList<Carta>();
        int num=cartasPorJugador();
        for(int i=0; i<jugadores.size();i++){
            c=random(num);
            jugadores.get(i).setCartas(c);
        }
    }
    
    private ArrayList<Carta> random(int num){
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        Carta c;
        Random rnd = new Random();
        int r;
        for(int i=0; i<num;i++){
            r = (int) (rnd.nextDouble() * baraja.size());
            c= baraja.get(r);
            baraja.remove(r);
            cartas.add(c);
        }
        
        return cartas;
    } 
    
    private void crearBaraja() {
        
        baraja.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                if (i == 0) {
                    baraja.add(new Carta(j, 'o'));
                } else if (i == 1) {
                    baraja.add(new Carta(j, 'c'));
                } else if (i == 2) {
                    baraja.add(new Carta(j, 'e'));
                } else {
                    baraja.add(new Carta(j, 'b'));
                }
            }
        }
    }
}
