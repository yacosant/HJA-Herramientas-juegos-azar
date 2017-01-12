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
    private int jugActual;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ArrayList<Carta> baraja = new ArrayList<Carta>();
    private boolean hayGanador = false;
    private boolean bots[] =  {false,false,false,false};
    
    
    public Logica(){
        crearBaraja();
        //repartir();
    }
    
    
    public int partida(){
    	
    	while(!hayGanador){

    		jugadores.get(jugActual).jugar();
    		hayGanador = ganador();

    		if(!hayGanador)
    			pasarTurno();
    	}
    	
    	return jugActual;
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

    public void repartir(){
        ArrayList<Carta> c  = new ArrayList<Carta>();
        for(int i=0; i<jugadores.size();i++){
            c=random(10);
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
            for (int j = 1; j < 13; j++) {
                if(j==8) j=10;
                
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
    
    private int encontrarJugInicial(){
    	boolean inicio = false;
    	int i = 0, j;
    	Carta c;
    	
    	while(!inicio && i < jugadores.size()){
    		j = 0;
    		while(j<jugadores.get(i).getCartas().size()){
    			c=jugadores.get(i).getCartas().get(j);
    			if(c.getValor() == 5 && c.getColor() == 'o'){
    				inicio=true;
    			}
    			j++;
    		}
    		i++;
    		
    	}
    	jugActual = i-1;
    	
    	return i-1;
    }
    
    private void pasarTurno(){
    	switch(jugActual){

    	case 0 : jugActual =1; break;
    	case 1 : jugActual =2; break;
    	case 2 : jugActual =3; break;
    	default : jugActual =0;

    	}
    }
    
    private boolean ganador(){
    	return jugadores.get(jugActual).getCartas().size() == 0;
    }


	public void marcarBot(int i) {
            bots[i]=true;
	}


	public boolean esBot(int i) {
            return bots[i];
	}


	public Jugador getJugador(int i) {
		return jugadores.get(i);
	}

}
