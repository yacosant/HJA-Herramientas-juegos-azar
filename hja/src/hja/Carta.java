/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hja;

/**
 *
 * @author YVCX
 */


public class Carta {
   private char color;
   private char valor; 
   
    public Carta(char val, char col){
        valor= val;
        color=col;
    }
    
    public char getColor() {
        return color;
    }
    
    public char getValor() {
        return valor;
    }

   
}
