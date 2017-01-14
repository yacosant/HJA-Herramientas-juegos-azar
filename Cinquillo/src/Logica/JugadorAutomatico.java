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

	private Carta mejorCarta(){

		Carta mejorOpcion = null;
		int cont = 0;
		boolean cartasAltas = false;
		if(cincoDeOros()){
			for(int i = 0;i< cartas.size();i++)
				if(cartas.get(i).getValor() == 5 && cartas.get(i).getColor() == 'o')
					mejorOpcion = cartas.get(i);
		}else{
			for(int i = 0; i < cartas.size();i++){
				if(cartas.get(i).getValor() > 5){
					
				}else if(cartas.get(i).getValor() < 5){
					
				}else{}//esto es si tienes un 5 para abrir la partida
			}
		}
		return mejorOpcion;

	}

	private boolean cartasAltas(char c){
		boolean altas = false;
		int extOroA,extEspA,extBastA,extCopasA;
		
		extOroA = log.extremoA('o');
		extEspA = log.extremoA('e');
		extBastA = log.extremoA('b');
		extCopasA = log.extremoA('c');
		
		for(int i = 0; i < cartas.size() && !altas;i++){
			if(c == 'o')
				if(cartas.get(i).getColor() == 'o' && cartas.get(i).getValor() > extOroA+2)
					altas = true;
			else if(c == 'e')
				if(cartas.get(i).getColor() == 'e' && cartas.get(i).getValor() > extEspA+2)
					altas = true;
			else if(c == 'b')
				if(cartas.get(i).getColor() == 'b' && cartas.get(i).getValor() > extBastA+2)
					altas = true;
			else
				if(cartas.get(i).getColor() == 'c' && cartas.get(i).getValor() > extCopasA+2)
					altas = true;
			
		}
		return altas;
	}
	
	private boolean cartaBajas(char c){
		boolean altas = false;
		int extOroB,extEspB,extBastB,extCopasB;
		

		extOroB = log.extremoB('o');
		extEspB = log.extremoB('e');
		extBastB = log.extremoB('b');
		extCopasB = log.extremoB('c');
		
		for(int i = 0; i < cartas.size() && !altas;i++){
			if(c == 'o')
				if(cartas.get(i).getColor() == 'o' && cartas.get(i).getValor() > extOroB-2)
					altas = true;
			else if(c == 'e')
				if(cartas.get(i).getColor() == 'e' && cartas.get(i).getValor() > extEspB-2)
					altas = true;
			else if(c == 'b')
				if(cartas.get(i).getColor() == 'b' && cartas.get(i).getValor() > extBastB-2)
					altas = true;
			else
				if(cartas.get(i).getColor() == 'c' && cartas.get(i).getValor() > extCopasB-2)
					altas = true;
			
		}
		return altas;
	}
	
	private int numCartasAltas(char c){
		int altas = 0;
		int extOroA,extEspA,extBastA,extCopasA;
		
		extOroA = log.extremoA('o');
		extEspA = log.extremoA('e');
		extBastA = log.extremoA('b');
		extCopasA = log.extremoA('c');
		
		for(int i = 0; i < cartas.size();i++){
			if(c == 'o')
				if(cartas.get(i).getColor() == 'o' && cartas.get(i).getValor() > extOroA+2)
					altas++;
			else if(c == 'e')
				if(cartas.get(i).getColor() == 'e' && cartas.get(i).getValor() > extEspA+2)
					altas++;
			else if(c == 'b')
				if(cartas.get(i).getColor() == 'b' && cartas.get(i).getValor() > extBastA+2)
					altas++;
			else
				if(cartas.get(i).getColor() == 'c' && cartas.get(i).getValor() > extCopasA+2)
					altas++;
			
		}
		return altas;
	}
	
	private int numCartaBajas(char c){
		int altas = 0;
		int extOroB,extEspB,extBastB,extCopasB;
		

		extOroB = log.extremoB('o');
		extEspB = log.extremoB('e');
		extBastB = log.extremoB('b');
		extCopasB = log.extremoB('c');
		
		for(int i = 0; i < cartas.size();i++){
			if(c == 'o')
				if(cartas.get(i).getColor() == 'o' && cartas.get(i).getValor() > extOroB-2)
					altas++;
			else if(c == 'e')
				if(cartas.get(i).getColor() == 'e' && cartas.get(i).getValor() > extEspB-2)
					altas++;
			else if(c == 'b')
				if(cartas.get(i).getColor() == 'b' && cartas.get(i).getValor() > extBastB-2)
					altas++;
			else
				if(cartas.get(i).getColor() == 'c' && cartas.get(i).getValor() > extCopasB-2)
					altas++;
			
		}
		return altas;
	}
	
	private boolean cincoDeOros(){
		boolean empezar = false;
		
		for(int i = 0;i<cartas.size() && !empezar;i++)
			if(cartas.get(i).getValor() == 5 && cartas.get(i).getColor() == 'o')
				empezar = true;
		
		
		return empezar;
	}
}
