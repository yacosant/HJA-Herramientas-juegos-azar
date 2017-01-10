/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author Grupo 01
 */
public abstract class Jugador {
    
    protected ArrayList<Carta> cartas;
   
    public abstract Carta jugar();
    public void pasar(){
        
    }
    public void pedir(){
        
    }
    public abstract String getModo();
    
    public ArrayList<Carta> getCartas(){
        return cartas:
    }
    
    public void setCartas(ArrayList<Carta> c){
        cartas=(ArrayList<Carta>)c.clone();
    }
}
