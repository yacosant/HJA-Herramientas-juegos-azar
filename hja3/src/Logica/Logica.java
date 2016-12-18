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

	private ArrayList<Carta> board = new ArrayList<Carta>();
	private ArrayList<Carta> baraja = new ArrayList<Carta>();
	private Jugador jugadores[] =  new Jugador[6];
	double NUM_VUELTAS = 600000;
	

	private int estado=0;

	public Logica(){
            crearBaraja();
            //randomBoard();      //solo en debugueo
            //generarJugadores(); //solo en debugueo
            
	}
        
        public void crearBaraja(){
            baraja.clear();
            for(int i=0;i<4;i++)
                for(int j = 2;j<=14;j++){
                        if(i==0)
                                baraja.add(new Carta(j,'h'));
                        else if(i==1)
                                baraja.add(new Carta(j,'d'));
                        else if(i==2)
                                baraja.add(new Carta(j,'c'));
                        else
                                baraja.add(new Carta(j,'s'));
                }
        }
        
        private void generarJugadores(){
            jugadores[0] = new Jugador(getCartaRandom(baraja),getCartaRandom(baraja));
            jugadores[1] = new Jugador(getCartaRandom(baraja),getCartaRandom(baraja));
            jugadores[2] = new Jugador(getCartaRandom(baraja),getCartaRandom(baraja));
            jugadores[3] = new Jugador(getCartaRandom(baraja),getCartaRandom(baraja));
            jugadores[4] = new Jugador(getCartaRandom(baraja),getCartaRandom(baraja));
            jugadores[5] = new Jugador(getCartaRandom(baraja),getCartaRandom(baraja));
        }
        
        public String randomBoard(){
           String s="";
           Carta c;
            for(int i=0; i<5; i++){
                c=getCartaRandom(baraja);
                board.add(c);
                s+=intToChar(c.getValor())+c.getColor();
                if(i!=4)s+=",";
            }
           return s;
        }
        
	public String randomJug(int i){
		//i es el numero del jugador 
		String cartas;
		Carta c,c2;
		c=getCartaRandom(this.baraja);
		c2=getCartaRandom(this.baraja);

		jugadores[i]= new Jugador(c,c2);

		return ""+intToChar(c.getValor())+c.getColor()+","+intToChar(c2.getValor())+c2.getColor();
	}


	private Carta getCartaRandom(ArrayList<Carta> baraja){
		Random rnd = new Random();
		int i= (int) (rnd.nextDouble() * baraja.size());
		Carta c;
		c= baraja.get(i);
		baraja.remove(i);
		return c;
	}

        public double[] mirarGanador(){
            for(int i=0; i<NUM_VUELTAS;i++){
                switch(estado){
                    case 0: mirarGanadorPreFlop(); break;
                    case 1: mirarGanadorFlop(); break;
                    case 2: mirarGanadorTurn(); break;
                    case 3: mirarGanadorRiver(); estado=-2; break;
                }
            }
            estado++;
            return calcularPorcentajes();
        }
        
        public void comprobarTotal(){

        	int j = 0;
        	for(int i=0; i<NUM_VUELTAS;i++){

        		if(j==0)
        			mirarGanadorPreFlop();
        		else if(j==1)
        			mirarGanadorFlop();
        		else if(j==2)
        			mirarGanadorTurn();
        		else if(j==3)
        			mirarGanadorRiver();
        	}

        	double h = jugadores[0].getVictorias()/NUM_VUELTAS;
        	double o = jugadores[1].getVictorias()/NUM_VUELTAS;
        	double s = jugadores[2].getVictorias()/NUM_VUELTAS;
        	double d = jugadores[3].getVictorias()/NUM_VUELTAS;
        	double f = jugadores[4].getVictorias()/NUM_VUELTAS;
        	double g = jugadores[5].getVictorias()/NUM_VUELTAS;

        	double tot = h+o+s+d+f+g;;
        }

        private double[] calcularPorcentajes(){
            double por[] = new double[6];
                for(int i=0; i<6; i++) por[i] = redondear(100*jugadores[i].getVictorias()/NUM_VUELTAS,3);
            
                return por;
        }
                
	private void mirarGanadorPreFlop(){
		
		ArrayList<Carta> baraja = (ArrayList<Carta>) this.baraja.clone();
		ArrayList<Carta> board = new ArrayList<Carta>();
		Carta[] cartas,mejoresCartas;

		for(int i = 0;i<5;i++)
			board.add(getCartaRandom(baraja));
		
		for(int i=0;i<jugadores.length;i++){
			cartas = juntar(board, jugadores[i]);
			mejoresCartas = comprobar(cartas, i);
			
			ArrayList<Carta> listaCarta = new ArrayList<Carta>();

			for (int j = 0; j < mejoresCartas.length; j++) 
				listaCarta.add(mejoresCartas[j]); 
			
			jugadores[i].setCartas(listaCarta);
		}
		
		ArrayList<Jugador> ord = ordenarManos(); 
		
		if(!sumaEmpates(ord)){ 

			for(int j=0; j<jugadores.length;j++)
				if(ord.get(0)==jugadores[j])
					sumaVictorias(j);
		}
	}

	
	public void sumaVictorias(int j){
		jugadores[j].setVictorias(jugadores[j].getVictorias()+1);
	}
	
	public boolean sumaEmpates(ArrayList<Jugador> ord){
		int i=0;
		double empatados=0;
		boolean seguir=false,empate=false;
		
        while (!seguir && i < ord.size()-1){

        	if(!desempateFinal(ord,ord.get(i),ord.get(i+1))){
        		empatados++;
        		empate=true;
        	}else
        		seguir = true;

        	i++;
        }  
        
        if(empatados>0)
        	for(int j=0; j<=i;j++) //Recorremos los jugadores hasta donde ya no hay empatados
        		for(int h = 0;h<jugadores.length;h++)
        			if(ord.get(j)==jugadores[h]){
        				jugadores[h].setVictorias(jugadores[h].getVictorias() + (1/(empatados+1))); 
        			}

        return empate;
	}

	private boolean iguales(Jugador combo, Jugador combo2) {
		boolean iguales = true;
		ArrayList<Carta> a = combo.getCartas(),b=combo2.getCartas();
		
		if(combo.getPeso() == combo2.getPeso()){
			if(combo.getPeso() == 5);
			else
				for(int i = 0;i<a.size();i++){
					if(a.get(i).getValor() != b.get(i).getValor())
						iguales = false;
				}
		}else
			iguales = false;
		
		return iguales;
	}
	
	private void mirarGanadorTurn() {

		ArrayList<Carta> baraja = (ArrayList<Carta>) this.baraja.clone();
		ArrayList<Carta> b = (ArrayList<Carta>) board.clone();
		Carta[] cartas,mejoresCartas;

		b.add(4, getCartaRandom(baraja));

		for(int i=0;i<jugadores.length;i++){
			cartas = juntar(b, jugadores[i]);
			mejoresCartas = comprobar(cartas, i);

			ArrayList<Carta> listaCarta = new ArrayList<Carta>();

			for (int j = 0; j < mejoresCartas.length; j++) 
				listaCarta.add(mejoresCartas[j]); 

			jugadores[i].setCartas(listaCarta);
		}

		ArrayList<Jugador> ord = ordenarManos(); 

		if(!sumaEmpates(ord)){ 

			for(int j=0; j<jugadores.length;j++)
				if(ord.get(0)==jugadores[j])
					sumaVictorias(j);
		}


	}


	private void mirarGanadorRiver() {

		ArrayList<Carta> baraja = (ArrayList<Carta>) this.baraja.clone();
		ArrayList<Carta> board = (ArrayList<Carta>) this.board.clone();
		Carta[] cartas,mejoresCartas;


		for(int i=0;i<jugadores.length;i++){
			cartas = juntar(board, jugadores[i]);
			mejoresCartas = comprobar(cartas, i);

			ArrayList<Carta> listaCarta = new ArrayList<Carta>();

			for (int j = 0; j < mejoresCartas.length; j++) 
				listaCarta.add(mejoresCartas[j]); 

			jugadores[i].setCartas(listaCarta);
		}

		ArrayList<Jugador> ord = ordenarManos(); 

		if(!sumaEmpates(ord)){ 

			for(int j=0; j<jugadores.length;j++)
				if(ord.get(0)==jugadores[j])
					sumaVictorias(j);
		}
	}


	private void mirarGanadorFlop() {

		ArrayList<Carta> baraja = (ArrayList<Carta>) this.baraja.clone();
		ArrayList<Carta> b = (ArrayList<Carta>) board.clone();
		Carta[] cartas,mejoresCartas;

		for(int i = 3;i<5;i++) b.add(i, getCartaRandom(baraja));

		for(int i=0;i<jugadores.length;i++){
			cartas = juntar(b, jugadores[i]);
			mejoresCartas = comprobar(cartas, i);

			ArrayList<Carta> listaCarta = new ArrayList<Carta>();

			for (int j = 0; j < mejoresCartas.length; j++) 
				listaCarta.add(mejoresCartas[j]); 

			jugadores[i].setCartas(listaCarta);
		}

		ArrayList<Jugador> ord = ordenarManos(); 

		if(!sumaEmpates(ord)){ 

			for(int j=0; j<jugadores.length;j++)
				if(ord.get(0)==jugadores[j])
					sumaVictorias(j);
		}

	}

	private static Carta[] juntar(ArrayList<Carta> board, Jugador c) { //Metodo para juntar el arrayList mano y arrayList mesa
		Carta[] cart;
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas = (ArrayList<Carta>) board.clone();
		cartas.add(c.getCarta(1));
		cartas.add(c.getCarta(2));

		cart = new Carta[cartas.size()];
		for (int i = 0; i < cartas.size(); i++) {
			cart[i] = cartas.get(i);
		}

		return cart;
	}
	
	private int devolverKikerColor(Carta carta1, Carta carta2, Carta cartaMaxColor){

		Carta cartaAlta=null;
		int i = -1;

		if(carta1.getColor() == carta2.getColor()){
			if(carta1.getColor() == cartaMaxColor.getColor())
				if(carta1.getValor()>carta2.getValor())
					cartaAlta=carta1;
				else
					cartaAlta=carta2;
		}

		else if(carta1.getColor() == cartaMaxColor.getColor())
			cartaAlta=carta1;

		else if(carta2.getColor() == cartaMaxColor.getColor())
			cartaAlta=carta2;
		
		if(cartaAlta != null)
			i = cartaAlta.getValor();

		return i;
	}
	
	private boolean desempateFinal(ArrayList<Jugador> ord,Jugador a,Jugador b){

		boolean desempateFinal=true;


		if(iguales(a, b)){
			if(a.getPeso()==2 || a.getPeso()==1 
					|| a.getPeso()==7 || a.getPeso()==3 || a.getPeso() == 0 || a.getPeso()==5){ 

				int kikeri = devolverKiker(a.getCarta(1), a.getCarta(2));
				int kikerj = devolverKiker(b.getCarta(1), b.getCarta(2));

				if(kikeri==kikerj)
					desempateFinal=false;

				else if(kikeri>kikerj)
					ord.set(0,a);

				else if(kikerj>kikeri)
					ord.set(0,b);
			}
		}else
			if(a.getPeso()==5){

				int kiker1 = devolverKikerColor(a.getCarta(1), a.getCarta(2),a.getCartas().get(0));
				int kiker2 = devolverKikerColor(b.getCarta(1), b.getCarta(2),a.getCartas().get(0));

				if(kiker1==kiker2)
					desempateFinal=false;

				else if(kiker1>kiker2)
					ord.set(0,a);

				else if(kiker1>kiker2)
					ord.set(0,b);
			}

		return desempateFinal;
	}

	private int devolverKiker(Carta carta1, Carta carta2){

		Carta cartaAlta;

		if(carta1.getValor()>carta2.getValor())
			cartaAlta=carta1;
		else
			cartaAlta=carta2;

		return cartaAlta.getValor();
	}

	private static Carta[] escaleraDeColor(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		ordenador(cartas);
		int cont = 0, cart = 0;
		boolean esc = false, escA = false;

		while (cont < cartas.length - 1 && !escA) {

			if (cartas[cont].getColor() == cartas[cont + 1].getColor()
					&& cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()) {
				if (!esc) {
					mejoresCartas[cart] = cartas[cont];
					if (cart < 5) {
						cart++;
					}
				} else {
					for (int i = 0; i < mejoresCartas.length - 1; i++) {
						mejoresCartas[i] = mejoresCartas[i + 1];
					}

					mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				}
			} else {
				if (cart == 5) {
					for (int i = 0; i < mejoresCartas.length - 1; i++) {
						mejoresCartas[i] = mejoresCartas[i + 1];
					}
					mejoresCartas[cart - 1] = cartas[cont];
				}
				cart = 0;
			}
			cont++;

			//Unico caso de escalera 1,2,3,4,5
			if (cart == 3 && cont < cartas.length - 1) {
				if (cartas[cont + 1].getValor() != 6 && cartas[cont].getValor() == 5 && cartas[cartas.length - 1].getValor() == 14
						&& mejoresCartas[2].getColor() == cartas[cont].getColor() && mejoresCartas[2].getColor() == cartas[cartas.length - 1].getColor()) {
					mejoresCartas[cart] = cartas[cont];
					mejoresCartas[cart + 1] = cartas[cartas.length - 1];
					esc = true;
					escA = true;
				}
			} else if (cart == 5) {
				esc = true;
			}
		}

		if (!escA && cartas[cont].getColor() == cartas[cont - 1].getColor()
				&& cartas[cont].getValor() == cartas[cont - 1].getValor() + 1) {
			if (esc == true) {
				for (int i = 0; i < mejoresCartas.length - 1; i++) {
					mejoresCartas[i] = mejoresCartas[i + 1];
				}
				mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
			} else if (cart == 4) {
				mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				esc = true;
			}
		}

		if (!esc) {
			mejoresCartas = null;
		}

		return mejoresCartas;

	}

	private static Carta[] poker(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[4];
		int cont = 0;
		for (int i = 0; i < cartas.length - 1; i++) {
			cont = 0;
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					mejoresCartas[cont] = cartas[j];
					cont++;
					if (cont == 3) { // a�adimos la ultima carta
						mejoresCartas[cont] = cartas[i];
						return mejoresCartas;
					}
				}
			}
		}
		return null;
	}

	private static Carta[] full(Carta[] cartas) {

		Carta[] mejoresCartas = new Carta[5];
		Carta[] mejoresCartasTrio = new Carta[3];
		Carta[] mejoresCartasPareja = new Carta[2];

		mejoresCartasTrio = trio(cartas);
		if (mejoresCartasTrio != null) {

			int valor = mejoresCartasTrio[0].getValor();

			for (int i = 0; i < cartas.length; i++) {
				if (valor == cartas[i].getValor()) {
					cartas[i].setValor(-1);
				}
			}

			mejoresCartasPareja = pareja(cartas);
			if (mejoresCartasPareja != null) {

				for (int i = 0; i < cartas.length; i++) {
					if (i < mejoresCartasTrio.length && mejoresCartasTrio[i].getValor() == -1) {
						mejoresCartasTrio[i].setValor(valor);
					}

					if (cartas[i].getValor() == -1) {
						cartas[i].setValor(valor);
					}

				}

				mejoresCartas[0] = mejoresCartasTrio[0];
				mejoresCartas[1] = mejoresCartasTrio[1];
				mejoresCartas[2] = mejoresCartasTrio[2];
				mejoresCartas[3] = mejoresCartasPareja[0];
				mejoresCartas[4] = mejoresCartasPareja[1];
				return mejoresCartas;

			} else {
				for (int i = 0; i < cartas.length; i++) {
					if (cartas[i].getValor() == -1) {
						cartas[i].setValor(valor);
					}
				}
			}
		}
		return null;
	}

	private static Carta[] color(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		int cont = cartas.length - 1, color, j;
		boolean col = false;

		while (cont > 0 && !col) {
			color = 0;
			j = cont - 1;
			mejoresCartas[color] = cartas[cont];
			color++;
			while (j >= 0) {
				if (mejoresCartas[0].getColor() == cartas[j].getColor()) {
					mejoresCartas[color] = cartas[j];
					color++;
				}
				if (color == 5) {
					return mejoresCartas;
				}

				j--;
			}
			color = 0;
			cont--;
		}
		return null;
	}

	private static Carta[] escalera(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		ordenador(cartas);
		int cont = 0, cart = 0;
		boolean esc = false, escA = false;

		while (cont < cartas.length - 1 && !escA) {

			if (cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()) {
				if (!esc) {
					mejoresCartas[cart] = cartas[cont];
					if (cart < 5) {
						cart++;
					}
				} else {//Si ha habido escalera pero puede ser mayor
					for (int i = 0; i < mejoresCartas.length - 1; i++) {
						mejoresCartas[i] = mejoresCartas[i + 1];
					}

					mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				}
			} else {//penultima pos no coincide con ult pero hacia escalera
				if (cart == 5) {

					for (int i = 0; i < mejoresCartas.length - 1; i++) {
						mejoresCartas[i] = mejoresCartas[i + 1];
					}
					mejoresCartas[cart - 1] = cartas[cont];
				}
				cart = 0;
			}
			cont++;

			//Unico caso de escalera 1,2,3,4,5
			if (cart == 3 && cont < cartas.length - 1) {
				if (cartas[cont + 1].getValor() != 6 && cartas[cont].getValor() == 5 && cartas[cartas.length - 1].getValor() == 14) {
					mejoresCartas[cart] = cartas[cont];
					mejoresCartas[cart + 1] = cartas[cartas.length - 1];
					esc = true;
					escA = true;
				}
			} else if (cart == 5) {
				esc = true;
			}
		}
		//ult pos que no se entra en el bucle
		if (!escA && cartas[cont].getValor() == cartas[cont - 1].getValor() + 1) {
			if (esc == true) {
				for (int i = 0; i < mejoresCartas.length - 1; i++) {
					mejoresCartas[i] = mejoresCartas[i + 1];
				}
				mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
			} else if (cart == 4) {
				mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				esc = true;
			}
		}

		if (!esc) {
			mejoresCartas = null;
		}

		return mejoresCartas;

	}

	private static Carta[] trio(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[3];
		int cont;
		for (int i = cartas.length - 1; i > 0; i--) {
			cont = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					mejoresCartas[cont] = cartas[j];
					cont++;
					if (cont == 2) {
						mejoresCartas[cont] = cartas[i];
						return mejoresCartas;
					}
				}
			}
		}
		return null;
	}

	private static Carta[] doblePareja(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[4];
		mejoresCartas[0] = new Carta(0, 'h');
		boolean salir = true;
		int cont = 0, i = cartas.length - 1, j;
		while (i > 0) {
			j = i - 1;
			salir = true;
			while (j >= 0 && salir) {
				if (cartas[i].getValor() == cartas[j].getValor() && cartas[i].getValor() != mejoresCartas[0].getValor()) {
					mejoresCartas[cont] = cartas[i];
					mejoresCartas[cont + 1] = cartas[j];
					cont += 2;
					salir = false;
					if (cont > 2) {
						return mejoresCartas;
					}

				}
				j--;
			}
			i--;
		}
		return null;
	}

	private static Carta[] pareja(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[2];
		for (int i = 0; i < cartas.length - 1; i++) {
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor() && cartas[i].getValor() != -1) {
					mejoresCartas[0] = cartas[i];
					mejoresCartas[1] = cartas[j];

					return mejoresCartas;
				}
			}
		}
		return null;
	}

	private static Carta[] cartaAlta(Carta[] cartas) {

		Carta[] cartas1 = new Carta[1];

		cartas1[0]= cartas[cartas.length-1];

		return cartas1;
	}
	
	
	private static void ordenador(Carta[] cartas) { //Metodo para ordenar las cartas. Util para escaleras

		for (int i = 0; i < cartas.length - 1; i++) {
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() > cartas[j].getValor()) {
					Carta aux = cartas[i];
					cartas[i] = cartas[j];
					cartas[j] = aux;

				}
			}
		}
	}

	public Carta[] comprobar(Carta[] cartas,int h) {

			Carta[] mejoresCartas = null;
			ordenador(cartas);
			mejoresCartas = escaleraDeColor(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(8);
				return mejoresCartas;
			}
			mejoresCartas = poker(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(7);
				/*for (int i = cartas.length - 1; i >= 0; i--) {
					if (cartas[i].getValor() != mejoresCartas[0].getValor()) {
						mejoresCartas[4] = cartas[i];
						return mejoresCartas;
					}
				}*/
				return mejoresCartas;
			}
			mejoresCartas = full(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(6);
				return mejoresCartas;
			}
			mejoresCartas = color(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(5);
				return mejoresCartas;
			}
			mejoresCartas = escalera(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(4);
				return mejoresCartas;
			}
			mejoresCartas = trio(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(3);
				boolean primero = true;
				/*for (int i = cartas.length - 1; i >= 0; i--) {
					if (cartas[i].getValor() != mejoresCartas[0].getValor()) {
						if (primero) {
							mejoresCartas[3] = cartas[i];
							primero = false;
						} else {
							mejoresCartas[4] = cartas[i];
							return mejoresCartas;
						}
					}
				}*/
				return mejoresCartas;
			}
			mejoresCartas = doblePareja(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(2);
				return mejoresCartas;
			}

			mejoresCartas = pareja(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(1);
				/*int cont = 2, pos = cartas.length - 1;
				while (cont < 5) {
					if (cartas[pos].getValor() != mejoresCartas[0].getValor()) {
						mejoresCartas[cont] = cartas[pos];
						cont++;
					}
					pos--;
				}*/
				return mejoresCartas;
			}

			mejoresCartas = cartaAlta(cartas);
			if (mejoresCartas != null) {
				jugadores[h].setPeso(0);
				return mejoresCartas;
			}
			return mejoresCartas;	
	}

	private ArrayList<Jugador> ordenarManos() {
		
		int contJug = 0, peso = 8, nPesos, posMejor, pos;
		boolean seguir = false;

		ArrayList<Jugador> empatados, ordenados = new ArrayList<Jugador>();
		while (peso >= 0) {
			posMejor = -1;
			empatados = new ArrayList<Jugador>();
			nPesos = 0;
			pos = 0;
			if (contJug < jugadores.length) {
				seguir = true;
			}

			while (seguir && contJug < jugadores.length) {
				if (jugadores[pos].getPeso() == peso) {
					empatados.add(jugadores[pos]);
					nPesos++;
					contJug++;
				}

				if (pos == jugadores.length - 1) {
					seguir = false;
				}

				pos++;
			}

			while (nPesos >= 2) {
				posMejor = desempateManos(empatados);
				ordenados.add(empatados.get(posMejor));
				empatados.remove(posMejor);
				nPesos--;
			}

			if (nPesos == 1) {
				ordenados.add(empatados.get(0));
			}

			peso--;
		}
		return ordenados;
	}

    private int desempateManos(ArrayList<Jugador> jugadores) {

        int posMano = -1, valorAct = 0, valorAnt = 0, valorMax = 0, posMax = 0;

        for (int i = 0; i < jugadores.size(); i++) {
            for (int h = i + 1; h < jugadores.size(); h++) {

                if (jugadores.get(i).getPeso() == 8 || jugadores.get(i).getPeso() == 4) { //Escalera normal y de color
                    valorAct = valorMaxMano(jugadores.get(i).getCartas(), true);
                    valorAnt = valorMaxMano(jugadores.get(h).getCartas(), true);

                    if (valorAct > valorAnt) {
                        //posMano = i;
                        if (valorAct > valorMax) {
                            valorMax = valorAct;
                            posMax = i;
                        }
                    } else //posMano=h;
                    if (valorAnt > valorMax) {
                        valorMax = valorAnt;
                        posMax = h;
                    }

                } else if (jugadores.get(i).getPeso() == 7) { //poker
                    valorAct = desempateCartaRep(jugadores.get(i).getCartas(), -1);
                    valorAnt = desempateCartaRep(jugadores.get(h).getCartas(), -1);

                    if (valorAct > valorAnt) {
                        //posMano = i;
                        if (valorAct > valorMax) {
                            valorMax = valorAct;
                            posMax = i;
                        }
                    } else //posMano=h;
                    if (valorAnt > valorMax) {
                        valorMax = valorAnt;
                        posMax = h;
                    }
                } else if (jugadores.get(i).getPeso() == 6) { //full
                    valorAct = desEmpateTrioFull(jugadores.get(i).getCartas());
                    valorAnt = desEmpateTrioFull(jugadores.get(h).getCartas());

                    if (valorAct > valorAnt) {
                        //posMano = i;
                        if (valorAct > valorMax) {
                            valorMax = valorAct;
                            posMax = i;
                        }
                    } else //posMano=h;
                    if (valorAnt > valorMax) {
                        valorMax = valorAnt;
                        posMax = h;
                    }
                } else if (jugadores.get(i).getPeso() == 5) { //color

                    valorAct = valorMaxMano(jugadores.get(i).getCartas(), true);
                    valorAnt = valorMaxMano(jugadores.get(h).getCartas(), true);

                    if (valorAct > valorAnt) {
                        //posMano = i;
                        if (valorAct > valorMax) {
                            valorMax = valorAct;
                            posMax = i;
                        }
                    } else //posMano=h;
                    if (valorAnt > valorMax) {
                        valorMax = valorAnt;
                        posMax = h;
                    }

                } else if (jugadores.get(i).getPeso() == 3) { //trio
                    valorAct = desempateCartaRep(jugadores.get(i).getCartas(), -1);
                    valorAnt = desempateCartaRep(jugadores.get(h).getCartas(), -1);

                    if (valorAct > valorAnt) {
                        //posMano = i;
                        if (valorAct > valorMax) {
                            valorMax = valorAct;
                            posMax = i;
                        }
                    } else //posMano=h;
                    if (valorAnt > valorMax) {
                        valorMax = valorAnt;
                        posMax = h;
                    }
                } else if (jugadores.get(i).getPeso() == 2) {//doble pareja

                    valorAct = parejaAltaDP(jugadores.get(i).getCartas());
                    valorAnt = parejaAltaDP(jugadores.get(h).getCartas());

                    if (valorAct == valorAnt) { //Si la priemra pareja es igual miramos la segunda
                        valorAct = parejaBajaDP(jugadores.get(i).getCartas());
                        valorAnt = parejaBajaDP(jugadores.get(h).getCartas());
                        if (valorAct > valorAnt) {
                            if (valorAct > valorMax) {
                                valorMax = valorAct;
                                posMax = i;
                            }
                        } else if (valorAnt > valorMax) {
                            valorMax = valorAnt;
                            posMax = h;
                        }
                    } else //Si la primera pareja ya no es igual no hay que mirar mas
                    if (valorAct > valorAnt) {
                        if (valorAct > valorMax) {
                            valorMax = valorAct;
                            posMax = i;
                        } else {
                            if (valorAnt > valorMax) {
                                valorMax = valorAnt;
                                posMax = h;
                            }
                        }
                    }
                } else if (jugadores.get(i).getPeso() == 1) {//pareja
                    valorAct = desempateCartaRep(jugadores.get(i).getCartas(), -1);
                    valorAnt = desempateCartaRep(jugadores.get(h).getCartas(), -1);

                    if (valorAct > valorAnt) {
                        //posMano = i;
                        if (valorAct > valorMax) {
                            valorMax = valorAct;
                            posMax = i;
                        }
                    } else //posMano=h;
                    if (valorAnt > valorMax) {
                        valorMax = valorAnt;
                        posMax = h;
                    }
                } else if (jugadores.get(i).getPeso() == 0) {//Carta-Alta

                    if (valorMaxMano(jugadores.get(i).getCartas(), false) > valorMaxMano(jugadores.get(h).getCartas(), false)) {
                        posMano = i;
                    } else {
                        posMano = h;
                    }
                }
            }
        }
        return posMax;//pos del ganador
    }
    
    private int parejaAltaDP(ArrayList<Carta> cartas) {
        return cartas.get(0).getValor();
    }

    private int parejaBajaDP(ArrayList<Carta> cartas) {
        return cartas.get(2).getValor();
    }

    private int desEmpateTrioFull(ArrayList<Carta> cartas) {
        return cartas.get(0).getValor();
    }

    private int valorMaxMano(ArrayList<Carta> cartas, boolean escalera) { //Te devuelve el valor de la carta mas alta de una mano

        int max = cartas.get(cartas.size() - 1).getValor();

        if (escalera && max == 14 && cartas.get(cartas.size() - 2).getValor() == 5)//Caso de escalera acabada en 5 
        {
            max = 5;
        }

        return max;
    }

    private int desempateCartaRep(ArrayList<Carta> cartas, int anterior) {
        int valor = 0, i = cartas.size() - 1, j;
        boolean repetido = false;

        while (i > 0 && !repetido) {
            valor = cartas.get(i).getValor();
            if (valor != anterior) {
                j = i - 1;
                while (j >= 0 && !repetido) {
                    if (valor == cartas.get(j).getValor()) {
                        repetido = true;
                    }

                    j--;

                }
            }
            i--;
        }

        return valor;
    }
    
    public String getEstado(){
        String s="";
        switch(estado){
            case 0: s="Pre-Flop";break;
            case 1: s="Flop";break;
            case 2: s="Turn";break;
            case 3: s="River";break;
            default: s="Fin";break;
        }
        return s;
    }

    public ArrayList<Carta> getBoard() {
        return board;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
    
    private String intToChar(int valor) {
        String carta = null;
        switch (valor) {
            case 10:
                carta = "T";
                break;
            case 11:
                carta = "J";
                break;
            case 12:
                carta = "Q";
                break;
            case 13:
                carta = "K";
                break;
            case 14:
                carta = "A";
                break;
            default:
                carta = Integer.toString(valor);
                break;
        }
        return carta;
    }
    
     private double redondear(double numero, int digitos) {
        int cifras = (int) Math.pow(10, digitos);
        return Math.rint(numero * cifras) / cifras;
    }
     
    public int CharToInt(char valor) {
        int carta;
        switch (valor) {
            case 'T':
                carta = 10;
                break;
            case 'J':
                carta = 11;
                break;
            case 'Q':
                carta = 12;
                break;
            case 'K':
                carta = 13;
                break;
            case 'A':
                carta = 14;
                break;
            case 't':
                carta = 10;
                break;
            case 'j':
                carta = 11;
                break;
            case 'q':
                carta = 12;
                break;
            case 'k':
                carta = 13;
                break;
            case 'a':
                carta = 14;
                break;
            default:
                carta = Character.getNumericValue(valor);
                break;
        }
        return carta;
    }

    public void setJugador(int i, Jugador jugador) {
        jugadores[i]=jugador;
    }
}
