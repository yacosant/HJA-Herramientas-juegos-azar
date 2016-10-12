package logica;

import logica.Carta;

public class Logica {

	// private Carta[] cartas;
	// private int cont = 0;
	// private String[] manos = new String[9];

	// public void setCartas(Carta[] cartas) {
	// this.cartas = cartas;
	// }

	void comprobar() {

		// aqui s ehacen todas las llamadas a cada uno de los metodos que
		// comprueban una mano.
		// En el array de string se guardan las manos que si se han producido, y
		// en funcion de si se han producido,
		// el comprobar s eocmprobaran los menores o no, ejemplo: si se han
		// ecncontrado trio no se comprobará pareja

		// ----
		// Lamadas a:

		// straight flush(escalerade color)

		// four-of-a-kind (or quads) (poker)

		// full house (or boat) (full)

		// flush(color)

		// straight(escalera)

		// three-of-a-kind(trío)

		// two-pair(doblepareja)

		// pair (parejao par)

		// high card (carta alta)

	}

	boolean escaleraColor(Carta[] cartas) {
		boolean esEscalera = false;

		return esEscalera;
	}

	boolean poker(Carta[] cartas) {
		boolean esPoker = false;
		int cont = 0;
		for (int i = 0; i < cartas.length; i++) {
			cont = 0;
			for (int j = i + 1; j <= cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					cont++;
					if (cont == 3)
						esPoker = true;
				}
			}
		}
		return esPoker;
	}

	boolean full(Carta[] cartas) {
		boolean esFull = false;
		if (trio(cartas))
			if (pareja(cartas))
				esFull = true;
		return esFull;
	}

	boolean color(Carta[] cartas) {
		boolean esColor = false;
		int cont = 0;
		for (int i = 0; i < cartas.length; i++) {
			cont = 0;
			for (int j = i + 1; j <= cartas.length; j++) {
				if (cartas[i].getColor() == cartas[j].getColor()) {
					cont++;
					if (cont == 3)
						esColor = true;
				}
			}
		}
		return esColor;
	}

	boolean escalera(Carta[] cartas) {
		boolean esEscalera = false;

		return esEscalera;
	}

	boolean trio(Carta[] cartas) {
		boolean esTrio = false;
		int cont = 0;
		for (int i = 0; i < cartas.length; i++) {
			cont = 0;
			for (int j = i + 1; j <= cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					cont++;
					if (cont == 2)
						esTrio = true;
				}
			}
		}
		return esTrio;
	}

	boolean doblePareja(Carta[] cartas) {
		boolean esDoble = false, salir = true;
		int cont = 0, i = 0, j;
		while (i < cartas.length) {
			j = i + 1;
			while (j < cartas.length && salir) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					cont++;
					salir = false;
				}
				j++;
			}
			i++;
		}
		if (cont >= 2)
			esDoble = true;
		return esDoble;
	}

	boolean pareja(Carta[] cartas) {
		boolean esPareja = false;

		for (int i = 0; i < cartas.length; i++) {
			for (int j = i + 1; j <= cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor())
					esPareja = true;
			}
		}
		return esPareja;
	}

	int cartaAlta(Carta[] cartas) {
		int cartaAlta = cartas[0].getValor();
		for (int i = 1; i < cartas.length; i++) {
			if (cartaAlta < cartas[i].getValor())
				cartaAlta = cartas[i].getValor();
		}
		return cartaAlta;
	}
	// String escaleraColor(){
	// String mano= "";
	//
	// return mano;
	// }
	//
	// String poker(){
	// String mano= "";
	//
	// return mano;
	// }
	//
	// String full(){
	// String mano= "";
	//
	// return mano;
	// }
	//
	// String color(){
	// String mano= "";
	//
	// return mano;
	// }
	//
	// String escalera(){
	// String mano= "";
	//
	// return mano;
	// }
	//
	// String trio(){
	// String mano= "";
	//
	// return mano;
	// }
	//
	// String doblePareja(){
	// String mano= "";
	//
	// return mano;
	// }
	//
	// void pareja(int a){
	// boolean cierto= false;
	// int i=0, j;
	// char anterior =cartas[a].getValor();
	//
	// while( i<5 && !cierto){
	// j=0;
	// char carta= cartas[i].getValor();
	// if(carta!=anterior){
	// while( j<5 && !cierto){
	// if(i!=j){
	// char c= cartas[j].getValor();
	// if(carta==c){
	// cierto=true;
	// manos[cont]="Pareja";
	// cont++;
	// }
	// }
	// j++;
	// }
	// }
	// }
	// i++;
	// }
	//
	// void pareja1(){
	// boolean cierto= false;
	// int i=0, j;
	//
	// while( i<5 && !cierto){
	// j=0;
	// char carta= cartas[i].getValor();
	//
	// while( j<5 && !cierto){
	// if(i!=j){
	// char c= cartas[j].getValor();
	// if(carta==c){
	// cierto=true;
	// manos[cont]="Pareja";
	// cont++;
	// }
	// }
	// j++;
	// }
	// }
	// i++;
	// }
	//
	// void cartaAlta(){
	// boolean cierto =false;
	// int i=0;
	//
	// while( i<5 && !cierto){
	// char c= cartas[i].getValor();
	// if(c=='A' || c=='K' || c=='Q' || c=='J'){
	// cierto=true;
	// manos[cont]="Carta Alta";
	// cont++;
	// }
	// i++;
	// }
	// }
}
