/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Gui.Tablero;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Grupo 01
 */
public class Logica {
    private int jugActual=-1;
    private int extremoOrosBajo=5,extremoOrosAlto=5,extremoBastosBajo=-10,extremoBastosAlto=-10,
    			extremoCopasBajo=-10,extremoCopasAlto=-10,extremoEspadasBajo=-10,extremoEspadasAlto=-10;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ArrayList<Carta> baraja = new ArrayList<Carta>();
    private boolean hayGanador = false;
    private boolean bots[] =  {false,false,false,false};
    private boolean primeraVez=true;
    private Carta carta =null;
    
    public Logica(){
        crearBaraja();
        //repartir();
    }
    
    public void partida(){
        encontrarJugInicial(); 
        boolean bot=bots[jugActual];
        partida(bot);
    }
    
    public int partida(boolean bot){
     //boolean bot=false;
     int aux;
   /* if(primeraVez){
        encontrarJugInicial(); 
        bot=bots[jugActual];
    }
    *///en partida();
   
    /*else if(!bots[jugActual]){
    
        if(jugActual==0)aux=3;
    else aux=jugActual-1;
    bot=bots[aux];
    }
    else  bot=bots[jugActual];
     */
       if(!hayGanador ){//&& bot){
            Tablero.actualizaTurno(jugActual); 
            
                hayGanador = ganador();
                if(bot){//jugadores.get(jugActual).getModo()== "Automatico"){
                   
                    jugadores.get(jugActual).jugar();
                   if(!primeraVez || bot){
                    if(!hayGanador) {
                   // pasarTurno();
                      //Tablero.actualizaTurno(jugActual); 
                      
                    }
                   }
                 /*  if(!primeraVez && jugActual!=3)jugActual++;
                   else if(!primeraVez)jugActual=0;*/
                   Tablero.actualizaTurno(jugActual); 
                }
               
                Tablero.siguienteEsbot(bots[jugActual]);
                Tablero.bloquearPasar(!bots[jugActual]);
    	}
    	if(primeraVez) primeraVez=false;
    	return jugActual;
    }
    
    
    public void siguiente(){
        
        
    }    
    public void addJugador(){
    	jugadores.add(new JugadorHumano());
    }
    
    public void addJugadorAutomatico(int i){
       jugadores.add(new JugadorAutomatico(this, i));
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
    
    public void pasarTurno(){
    	switch(jugActual){
    	case 0 : jugActual =1; break;
    	case 1 : jugActual =2; break;
    	case 2 : jugActual =3; break;
    	default : jugActual =0;
        }
    }
    
    private boolean ganador(){
    	hayGanador=jugadores.get(jugActual).getCartas().size() == 0;
        return hayGanador;
    }
    
    public boolean getGanador(){
         return hayGanador;
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
	        
        public String esPosible(Carta c,boolean borrar){
            String msg=null;
		boolean posible = false;
		int valor = c.getValor();
		char color = c.getColor();
		
		if(!esCinco(c)){

				if(color == 'o'){

					if(extremoOrosAlto==7 && valor==10){
						posible=true;
						if(borrar)extremoOrosAlto = valor;
					}
					
					else if(valor-1 == extremoOrosAlto){
						posible = true;
						if(borrar)extremoOrosAlto=valor;
					}else if(valor+1 == extremoOrosBajo){
						posible = true;
						if(borrar)extremoOrosBajo=valor;
					}
				}
				
				
				else if(color == 'b'){
					
					if(extremoBastosAlto==7 && valor==10){
						posible=true;
						if(borrar)extremoBastosAlto = valor;
					}
                                        
					else if(valor-1 == extremoBastosAlto){
						posible = true;
						if(borrar)extremoBastosAlto=valor;
					}else if(valor+1 == extremoBastosBajo){
						posible = true;
						if(borrar)extremoBastosBajo=valor;
					}
				}
				
				else if(color == 'e'){
					
					if(extremoEspadasAlto==7 && valor==10){
						posible=true;
						if(borrar)extremoEspadasAlto = valor;
					}
					
                                        else if(valor-1 == extremoEspadasAlto){
						posible = true;
						if(borrar)extremoEspadasAlto=valor;
					}else if(valor+1 == extremoEspadasBajo){
						posible = true;
						if(borrar)extremoEspadasBajo=valor;
					}
				}
				else if(color == 'c'){
					
					if(extremoCopasAlto==7 && valor==10){
						posible=true;
						if(borrar)extremoCopasAlto = valor;
					}
					
					else if(valor-1 == extremoCopasAlto){
						posible = true;
						if(borrar)extremoCopasAlto=valor;
					}else if(valor+1 == extremoCopasBajo){
						posible = true;
						if(borrar)extremoCopasBajo=valor;
					}
				}
				else posible=false;
			
		}else
			posible = true;


		if(posible){
			if(borrar)
				if(!borrarCarta(c,jugActual)) msg="No es tu turno aún.";
			//pasarTurno(); no llamar aqui porque en cada comprobacioon baila el turno.
		}
                else msg="No puedes jugar esa carta ahora mismo.";
		return msg;
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
				extremoEspadasBajo = 5;
			}else{
				extremoCopasAlto = 5;
				extremoCopasBajo = 5;
			}
		}
		
		return cinco;
		
	}
    
    protected boolean borrarCarta(Carta c, int jug){
        boolean encontrado=false;
        int i=0;
        ArrayList<Carta> cartas = jugadores.get(jug).getCartas();
        
        while(!encontrado && i<cartas.size()){
            encontrado = (c.getValor()== cartas.get(i).getValor() && c.getColor()== cartas.get(i).getColor());
            i++;
        }
        if(encontrado){
        	carta = cartas.get(i-1);
        	cartas.remove(i-1);
        }
        return encontrado;
    }
   
    public Carta getCarta(){
    	return carta;
    }
    
     public int extremoA(char c){
    	int extremo;
    	
    	if(c == 'o')
    		extremo = extremoOrosAlto;
    	else if(c == 'b')
    		extremo = extremoBastosAlto;
    	else if(c == 'e')
    		extremo = extremoEspadasAlto;
    	else
    		extremo = extremoCopasAlto;
    	
    	return extremo;
    }
    
    public int extremoB(char c){
    	int extremo;
    	
    	if(c == 'o')
    		extremo = extremoOrosBajo;
    	else if(c == 'b')
    		extremo = extremoBastosBajo;
    	else if(c == 'e')
    		extremo = extremoEspadasBajo;
    	else
    		extremo = extremoCopasBajo;
    	
    	return extremo;
    }

    
}
