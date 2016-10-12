/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hja;

public class Carta {
   private char color;
   private int valor; 
   
    public Carta(int val, char col){
        valor= val;
        color=col;
    }
    
    public char getColor() {
        return color;
    }
    
    public int getValor() {
        return valor;
    }

   
}
