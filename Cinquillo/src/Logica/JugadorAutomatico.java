/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;



/**
 *
 * @author Grupo 01
 */
public class JugadorAutomatico extends Jugador{

    @Override
    public Carta jugar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pasar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean buenasParaJugar(){
        
        boolean buena=false;
        
        for(int i =0; i<cartas.size();i++){
        
         if(cartas.get(i).getColor() == 'o')
          if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'o' 
          ||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'o' 
          ||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'o' 
          ||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'o')

           buena=true;

         if(cartas.get(i).getColor() == 'e')
          if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'e' 
          ||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'e' 
          ||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'e' 
          ||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'e')

           buena=true;

         if(cartas.get(i).getColor() == 'b')
          if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'b' 
          ||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'b' 
          ||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'b' 
          ||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'b')

           buena=true;

         if(cartas.get(i).getColor() == 'c')
          if(cartas.get(i).getValor() == 1 && cartas.get(i).getColor() == 'c' 
          ||cartas.get(i).getValor() == 2 && cartas.get(i).getColor() == 'c' 
          ||cartas.get(i).getValor() == 11 && cartas.get(i).getColor() == 'c' 
          ||cartas.get(i).getValor() == 12 && cartas.get(i).getColor() == 'c')

           buena=true;
        }
        
     return buena;
       }

    
}
