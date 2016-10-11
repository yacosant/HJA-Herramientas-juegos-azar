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
public class Hja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carta[] cartas= new Carta[5];
        cartas[0]= new Carta('A','d');
        cartas[1]= new Carta('B','d');
        cartas[2]= new Carta('C','d');
        cartas[3]= new Carta('E','d');
        cartas[4]= new Carta('F','d');
        
        Archivo.guardar(cartas);
        
    }
    
}
