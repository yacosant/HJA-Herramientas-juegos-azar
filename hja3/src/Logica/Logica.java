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
    
    private ArrayList<Carta> baraja = new ArrayList<Carta>();
    private Combo jugadores[] =  new Combo[6];
    
    public String randomJug(int i){
        //i es el numero del jugador 
        String cartas;
        Carta c,c2;
        c=getCartaRandom();
        c2=getCartaRandom();
        
        jugadores[i]= new Combo(c,c2);
        
        return ""+c.getValor()+c.getColor()+","+c2.getValor()+c2.getColor();
    }
    
    
    private Carta getCartaRandom(){
        Random rnd = new Random();
        int i= (int) (rnd.nextDouble() * baraja.size());
        Carta c;
        c= baraja.get(i);
        baraja.remove(i);
        return c;
    }
}
