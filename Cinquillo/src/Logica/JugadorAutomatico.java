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
    private Logica log;
    private HebraJugador h;
    @Override
    public Carta jugar() {
       h= new HebraJugador(log);
       return log.getJugador(3).getCartas().get(0);
    }

    @Override
    public void pasar() {
        if(h!=null){
			h.interrupt();
			h=null;
		} 
    }

    @Override
    public String getModo() {
       return "Automatico";}

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
