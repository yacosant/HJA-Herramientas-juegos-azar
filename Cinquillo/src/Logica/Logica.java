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
    private int extremoOrosBajo=-10,extremoOrosAlto=-10,extremoBastosBajo=-10,extremoBastosAlto=-10,
    			extremoCopasBajo=-10,extremoCopasAlto=-10,extremoEspadasBajo=-10,extremoEspadasAlto=-10;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ArrayList<Carta> baraja = new ArrayList<Carta>();
    private boolean hayGanador = false;
    private boolean bots[] =  {false,false,false,false};
    
    
    public Logica(){
        crearBaraja();
        //repartir();
    }
    
    
    public int partida(){
    	hayGanador = ganador();
    	while(!hayGanador){
                if(jugadores.get(jugActual).getModo()== "Humano"){
                    return jugActual;
                }
                else{
                    jugadores.get(jugActual).jugar();
                }
    		
    		if(!hayGanador) pasarTurno();
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
    
    public int encontrarJugInicial(){
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
	
	public boolean esPosible(Carta c){
		boolean posible = false;
		int valor = c.getValor();
		char color = c.getColor();
		
		if(!esCinco(c)){
			if(color == 'o'){
				if(valor-1 == extremoOrosAlto){
					posible = true;
					extremoOrosAlto=valor;
				}else if(valor+1 == extremoOrosBajo){
					posible = true;
					extremoOrosBajo=valor;
				}
                        }
			else if(color == 'b'){
				if(valor-1 == extremoBastosAlto){
					posible = true;
					extremoBastosAlto=valor;
				}else if(valor+1 == extremoBastosBajo){
					posible = true;
					extremoBastosBajo=valor;
				}
                        }
			else if(color == 'e'){
				if(valor-1 == extremoEspadasAlto){
					posible = true;
					extremoEspadasAlto=valor;
				}else if(valor+1 == extremoEspadasBajo){
					posible = true;
					extremoEspadasBajo=valor;
				}
                        }
			else if(color == 'c'){
				if(valor-1 == extremoCopasAlto){
					posible = true;
					extremoCopasAlto=valor;
				}else if(valor+1 == extremoCopasBajo){
					posible = true;
					extremoCopasBajo=valor;
				}
                        }
                        else posible=false;
		}else
			posible = true;
		
		return posible;
	}
	
	private boolean esCinco(Carta c){
		
		boolean cinco = false;
		
		if(c.getValor() == 5){
			cinco = true;
			char col = c.getColor();
			
			if(col == 'o'){
				extremoOrosAlto = 5;
				extremoOrosBajo = 5;
			}else if(col == 'b'){
				extremoBastosAlto = 5;
				extremoBastosBajo = 5;
			}else if(col == 'e'){
				extremoEspadasAlto = 5;
				extremoOrosBajo = 5;
			}else{
				extremoCopasAlto = 5;
				extremoCopasBajo = 5;
			}
		}
		
		return cinco;
		
	}

    
    private ArrayList<Integer> ContarCuantasPaloJug(int jugador){
    	  ArrayList<Integer> contadorFinal = new ArrayList<Integer>();
    	  ArrayList<Carta> cartas = jugadores.get(jugActual).getCartas();
    	  int cont = 0, contadorOro = 0, contadorBastos= 0, contadorEspadas = 0, contadorCopas = 0;
    	  while (cartas.size() > cont){
    	   if (cartas.get(cont).getColor() == 'o')
    	    contadorOro++;
    	   if (cartas.get(cont).getColor() == 'b')
    	    contadorBastos++;
    	   if (cartas.get(cont).getColor() == 'c')
    	    contadorCopas++;
    	   if (cartas.get(cont).getColor() == 'e')
    	    contadorEspadas++;
    	   cont++;
    	  }
    	  
    	  contadorFinal.add(contadorOro);
    	  contadorFinal.add(contadorBastos);
    	  contadorFinal.add(contadorCopas);
    	  contadorFinal.add(contadorEspadas);
    	  
    	  return contadorFinal;
    }
}
