package logica;

import logica.Carta;

public class Logica {

	// private Carta[] cartas;
	// private int cont = 0;
	//private String[] manos = new String[9];

	// public void setCartas(Carta[] cartas) {
	// this.cartas = cartas;
	// }

	void comprobar() {
            String mejorJugada = "";
            Carta[] cartas =null;
		// aqui s ehacen todas las llamadas a cada uno de los metodos que
		// comprueban una mano.
		// En el array de string se guardan las manos que si se han producido, y
		// en funcion de si se han producido,
		// el comprobar s eocmprobaran los menores o no, ejemplo: si se han
		// ecncontrado trio no se comprobará pareja

		// ----
		// Lamadas a:

		// straight flush(escalerade color)
                if(escaleraDecolor(cartas)) mejorJugada="Escalera de color";
                // four-of-a-kind (or quads) (poker)
                else if (poker(cartas)) mejorJugada="Poker";
		// full house (or boat) (full)
                else if(full(cartas)) mejorJugada="Full";
		// flush(color)
                 else if(color(cartas)) mejorJugada="Color";
		// straight(escalera)
                else if(escalera(cartas)) mejorJugada="Escalera";
		// three-of-a-kind(trío)
                 else if(trio(cartas)) mejorJugada="Trio";
		// two-pair(doblepareja)
                 else if(doblePareja(cartas)) mejorJugada="Doble Pareja";
		// pair (parejao par)
                 else if(pareja(cartas)) mejorJugada="Pareja";
		// high card (carta alta)
                 else if(cartaAlta(cartas)) mejorJugada="Carta Alta";
                
                
	}
        
	boolean escaleraDeColor(Carta[] cartas) {
		boolean esEscalera = false,posible = true;
		ordenador(cartas);
		int cont;
		for (int i = 0; i < cartas.length && posible; i++) {
			cont = 0;
			for (int j = i + 1; j <= cartas.length && posible; j++) {
				if(cartas[i].getColor() == cartas[j].getColor() 
						&& cartas[i].getValor() == 13 && cartas[j].getValor() == 2)
					cont++;
				else if (cartas[i].getColor() == cartas[j].getColor() 
						&& cartas[i].getValor()+1 == cartas[j].getValor())
					cont++;
				else
					posible = false;
				
				if (cont == 4)
					esEscalera = true;
			}
		}
		return esEscalera;
	}

        boolean escaleraDeColorSinDosFor(Carta[] cartas) {
		boolean esEscalera = false,posible = true;
		ordenador(cartas);
		int cont;
		for (int i = 0; i < cartas.length && posible; i++) {
			cont = 0;
		
                    if(cartas[i].getColor() == cartas[i+1].getColor() 
                                    && cartas[i].getValor() == 13 && cartas[i+1].getValor() == 2)
                            cont++;
                    else if (cartas[i].getColor() == cartas[i+1].getColor() 
                                    && cartas[i].getValor()+1 == cartas[i+1].getValor())
                            cont++;
                    else
                            posible = false;

                    if (cont == 4)
                            esEscalera = true;

		}
		return esEscalera;
	}
        
	boolean escalera(Carta[] cartas) {
		
		boolean esEscalera = false,posible = true;
		ordenador(cartas);
		int cont = 0;
		
		if(cartas[cont].getValor() == 13 && cartas[cont+1].getValor() == 2)
			cont++;
		
		while(cont < cartas.length && posible) {
			
			if(cartas[cont].getValor()+1 == cartas[cont+1].getValor())
				cont++;
			else
				posible = false;
		}

		if (cont == 4)
			esEscalera = true;
		
		return esEscalera;
	}

        boolean escaleraSinDobleFor(Carta[] cartas) {
		boolean esEscalera = false,posible = true;
		ordenador(cartas);
		int cont;
		for (int i = 0; i < cartas.length && posible; i++) {
			cont = 0;
			
                        if(cartas[i].getValor() == 13 && cartas[i+1].getValor() == 2)//el unico caso distinto,considerando as como 13
                                cont++;
                        else if(cartas[i].getValor()+1 == cartas[i+1].getValor())
                                cont++;
                        else posible = false;

                        if (cont == 4) esEscalera = true;
		
		}
		return esEscalera;
	}
        
	boolean poker(Carta[] cartas) {
		boolean esPoker = false;
		int cont = 0;
		for (int i = 0; i < cartas.length ; i++) {
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
		boolean esColor = false,posible = true;
		int cont = 0;
		for (int i = 0; i < cartas.length && posible; i++) {
			cont = 0;
			for (int j = i + 1; j <= cartas.length && posible; j++) {
				if (cartas[i].getColor() == cartas[j].getColor()) {
					cont++;
					if (cont == 4)//antes ponia 3 eso es para el proyecto de color
						esColor = true;
				}else
					posible = false;
			}
		}
		return esColor;
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
	
	public static void ordenador(Carta[] cartas){

		for(int i=0;i<cartas.length-1;i++){
			for(int j=i+1;j<cartas.length;j++){
				if(cartas[i]>cartas[j]){

					Carta aux=cartas[i];
					cartas[i]=cartas[j];
					cartas[j]=aux;

				}
			}
		}
	}

}
