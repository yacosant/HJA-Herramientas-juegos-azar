package hja;

import hja.Carta;

import java.util.ArrayList;

/**
 * 
 * @author Grupo 1
 *
 */
public class Logica {

	//Booleanos de tipos de proyectos
	private boolean proyectoColor = false;
	private boolean proyectoEscalera = false;
	private boolean proyectoEscaleraC = false;
	private boolean gutshot = false;
//

	/**
	 * Recorre el array de cartas para comprobar que jugada tiene
	 * 
	 * @param cartas
	 * @return
	 */
	public String comprobar(boolean proyect,Carta[] cartas) { //Metodo que te devuelve la mejor jugada
		String mejorJugada = "-Best hand: ";
		// aqui se hacen todas las llamadas a cada uno de los metodos que
		// comprueban una mano.
		// En el array de string se guardan las manos que si se han producido, y
		// en funcion de si se han producido,
		// el comprobar s eocmprobaran los menores o no, ejemplo: si se han
		// ecncontrado trio no se comprobará pareja

		// ----
		// Lamadas a:

		// straight flush(escalera de color)
		if (escaleraDeColor(cartas))
			mejorJugada += "Straight Flush: ";
		// four-of-a-kind (or quads) (poker)
		else if (poker(cartas) != null)
			mejorJugada += "Four-of-a-kind: " + poker(cartas);
		// full house (or boat) (full)
		else if (full(cartas) != null)
			mejorJugada += full(cartas);
		// flush(color)
		else if (color(cartas) != null)
			mejorJugada += "Flush: " + color(cartas);
		// straight(escalera)
		else if (escalera(cartas))
			mejorJugada += "Straight";
		// three-of-a-kind(trío)
		else if (trio(cartas) != null)
			mejorJugada += "Three-of-a-kind: " + trio(cartas);
		// two-pair(doblepareja)
		else if (doblePareja(cartas) != null)
			mejorJugada += "Two-pair: " + doblePareja(cartas);
		// pair (parejao par)
		else if (pareja(cartas) != null)
			mejorJugada += "Pair: " + pareja(cartas);
		// high card (carta alta)
		else
			mejorJugada += "High Card: " + cartaAlta(cartas);

		if(proyect){
			//Proyectos
			if(proyectoEscaleraC){
				mejorJugada += "\r\n" + "-Draw: Straight Flush";

				if(gutshot)
					mejorJugada += " GutShot";
				else
					mejorJugada += " Open-ended";
			}

			if(proyectoEscalera){
				mejorJugada += "\r\n" + "-Draw: Straight";

				if(gutshot)
					mejorJugada += " GutShot";
				else
					mejorJugada += " Open-ended";
			}

			if(proyectoColor)
				mejorJugada += "\r\n" + "-Draw: Flush";
		}

		return mejorJugada;

	}
	
public static Carta[] comprobarModo3(Carta[] cartas,Modo3 jugador) {
		
		Carta[] mejoresCartas = null;
		ordenador(cartas);
		mejoresCartas = escaleraDeColorModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(8);
			return mejoresCartas;
		}
		mejoresCartas = pokerModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(7);
			for (int i = cartas.length - 1; i >= 0; i--) {
				if (cartas[i].getValor() != mejoresCartas[0].getValor()) {
					mejoresCartas[4] = cartas[i];
					return mejoresCartas;
				}
			}
			return mejoresCartas;
		}
		mejoresCartas = fullModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(6);
			return mejoresCartas;
		}
		mejoresCartas = colorModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(5);
			return mejoresCartas;
		}
		mejoresCartas = escaleraModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(4);
			return mejoresCartas;
		}
		mejoresCartas = trioModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(3);
			boolean primero = true;
			for (int i = cartas.length - 1; i >= 0; i--) {
				if (cartas[i].getValor() != mejoresCartas[0].getValor()) {
					if (primero) {
						mejoresCartas[3] = cartas[i];
						primero = false;
					} else {
						mejoresCartas[4] = cartas[i];
						return mejoresCartas;
					}
				}
			}
			return mejoresCartas;
		}
		mejoresCartas = dobleParejaModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(2);
			return mejoresCartas;
		}
		
		mejoresCartas = parejaModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(1);
			int cont = 2,pos = cartas.length-1;
			while(cont < 5){
				if(cartas[pos].getValor() != mejoresCartas[0].getValor()){
					mejoresCartas[cont] = cartas[pos];
					cont++;
				}
				pos--;
			}
			return mejoresCartas;
		}
		
		mejoresCartas = cartaAltaModo3(cartas);
		if (mejoresCartas != null) {
			jugador.setPeso(0);
			return mejoresCartas;
		}
		
		return mejoresCartas;
	}


private static Carta[] cartaAltaModo3(Carta[] cartas){
	Carta[] mejoresCartas = new Carta[5];
	boolean salir=false;
	int j=0;
	mejoresCartas[0] = cartas[cartas.length-1];
	
		for (int i = cartas.length-1; i >0 && !salir; i--) {
				mejoresCartas[j] = cartas[i];
				j++;
				if(j==5)
				salir=true;
			
		}
	return mejoresCartas;
}
	
private static Carta[] fullModo3(Carta[] cartas) {

	Carta[] mejoresCartas = new Carta[5];
	Carta[] mejoresCartasTrio = new Carta[3];
	Carta[] mejoresCartasPareja = new Carta[2];

	
	mejoresCartasTrio = trioModo3(cartas);
	if (mejoresCartasTrio != null) {
		
		int valor = mejoresCartasTrio[0].getValor();
		
		for (int i = 0; i < cartas.length; i++){
			if ( valor == cartas[i].getValor()){
				cartas[i].setValor(-1);
			}
		}
		
		mejoresCartasPareja = parejaModo3(cartas);
		if (mejoresCartasPareja != null) {
				
			for(int i=0;i<mejoresCartasTrio.length-2;i++)
				if(mejoresCartasTrio[i].getValor()==-1)
					mejoresCartasTrio[i].setValor(valor);
				
				mejoresCartas[0] = mejoresCartasTrio[0];
				mejoresCartas[1] = mejoresCartasTrio[1];
				mejoresCartas[2] = mejoresCartasTrio[2];
				mejoresCartas[3] = mejoresCartasPareja[0];
				mejoresCartas[4] = mejoresCartasPareja[1];
				return mejoresCartas;

			}
		else
			for(int i=0;i<cartas.length;i++){
				if(cartas[i].getValor()==-1)
					cartas[i].setValor(valor);
			}
		}
	return null;
}
	
private static Carta[] trioModo3(Carta[] cartas) {
	Carta[] mejoresCartas = new Carta[5];
	int cont;
	for (int i = cartas.length-1; i > 0 ; i--) {
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

private static Carta[] escaleraModo3(Carta[] cartas){
	Carta[] mejoresCartas = new Carta[5];

	int cont = 0, cart = 0;
	boolean esc = false,escA = false;

	while (cont < cartas.length-1 && !escA) {

		if (cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()){
			if(!esc){
				mejoresCartas[cart] = cartas[cont];
				if(cart<5)
					cart++;
			}else{//Si ha habido escalera pero puede ser mayor
				for(int i = 0;i<mejoresCartas.length-1;i++)
					mejoresCartas[i] = mejoresCartas[i+1];

				mejoresCartas[mejoresCartas.length-1] = cartas[cont];
			}
		}else{//penultima pos no coincide con ult pero hacia escalera
			if(cart == 5){

				for(int i = 0;i<mejoresCartas.length-1;i++)
					mejoresCartas[i] = mejoresCartas[i+1];
				mejoresCartas[cart-1] = cartas[cont];
			}
			cart = 0;
		}
		cont++;

		//Unico caso de escalera 1,2,3,4,5
		if(cart == 3){
			if(cartas[cont+1].getValor() != 6 && cartas[cont].getValor() == 5 && cartas[cartas.length-1].getValor() == 14){
				mejoresCartas[cart] = cartas[cont];
				mejoresCartas[cart+1] = cartas[cartas.length-1];
				esc = true;
				escA = true;
			}
		}else if(cart == 5)
			esc = true;
	}
	//ult pos que no se entra en el bucle
	if(!escA && cartas[cont].getValor()  == cartas[cont -1].getValor()+1){
		if(esc == true){
			for(int i = 0;i<mejoresCartas.length-1;i++)
				mejoresCartas[i] = mejoresCartas[i+1];
			mejoresCartas[mejoresCartas.length-1] = cartas[cont];
		}else if(cart == 4){
			mejoresCartas[mejoresCartas.length-1] = cartas[cont];
			esc = true;
		}
	}

	if(!esc)
		mejoresCartas = null;

	return mejoresCartas;

}
public static Carta[] escaleraDeColorModo3(Carta[] cartas) {
	Carta[] mejoresCartas = new Carta[5];

	int cont = 0, cart = 0;
	boolean esc = false,escA = false;
	
	while (cont < cartas.length-1 && !escA) {
		
		if (cartas[cont].getColor() == cartas[cont + 1].getColor()
				&& cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()){
			if(!esc){
				mejoresCartas[cart] = cartas[cont];
				if(cart<5)
					cart++;
			}else{
				for(int i = 0;i<mejoresCartas.length-1;i++)
					mejoresCartas[i] = mejoresCartas[i+1];
				
				mejoresCartas[mejoresCartas.length-1] = cartas[cont];
			}
		}else{
			if(cart == 5){
				for(int i = 0;i<mejoresCartas.length-1;i++)
					mejoresCartas[i] = mejoresCartas[i+1];
				mejoresCartas[cart-1] = cartas[cont];
			}
			cart = 0;
		}
		cont++;
		
		//Unico caso de escalera 1,2,3,4,5
		if(cart == 3){
			if(cartas[cont+1].getValor() != 6 && cartas[cont].getValor() == 5 && cartas[cartas.length-1].getValor() == 14 &&
					mejoresCartas[2].getColor() == cartas[cont].getColor() && mejoresCartas[2].getColor() == cartas[cartas.length-1].getColor()){
				mejoresCartas[cart] = cartas[cont];
				mejoresCartas[cart+1] = cartas[cartas.length-1];
				esc = true;
				escA = true;
			}
		}else if(cart == 5)
			esc = true;
	}
		
	if(!escA && cartas[cont].getColor() == cartas[cont -1].getColor()
			&& cartas[cont].getValor()  == cartas[cont -1].getValor()+1){
		if(esc == true){
			for(int i = 0;i<mejoresCartas.length-1;i++)
				mejoresCartas[i] = mejoresCartas[i+1];
			mejoresCartas[mejoresCartas.length-1] = cartas[cont];
		}else if(cart == 4){
			mejoresCartas[mejoresCartas.length-1] = cartas[cont];
			esc = true;
		}
	}
	
	if(!esc)
		mejoresCartas = null;
	
	return mejoresCartas;

}

private static Carta[] pokerModo3(Carta[] cartas) {
	Carta[] mejoresCartas = new Carta[5];
	int cont = 0;
	for (int i = 0; i < cartas.length-1; i++) {
		cont = 0;
		for (int j = i + 1; j < cartas.length; j++) {
			if (cartas[i].getValor() == cartas[j].getValor()) {
				mejoresCartas[cont] = cartas[i];
				cont++;
				if (cont == 3) { // a�adimos la ultima carta
					mejoresCartas[cont] = cartas[j];
					return mejoresCartas;
				}
			}
		}
	}
	return null;
}

private static Carta[] dobleParejaModo3(Carta[] cartas) {
	Carta[] mejoresCartas = new Carta[5];
	boolean salir = true;
	int cont = 0, i = cartas.length-1, j;
	while (i > 0) {
		j = i - 1;
		salir = true;
		while (j >= 0 && salir) {
			if (cartas[i].getValor() == cartas[j].getValor()) {
				mejoresCartas[cont] = cartas[i];
				mejoresCartas[cont + 1] = cartas[j];
				cont += 2;
				salir = false;
				if (cont > 2){
					int k =cartas.length-1;
					boolean end = false;
					while(k> 0 && !end){
						if(cartas[k].getValor() != mejoresCartas[0].getValor() && cartas[k].getValor() != mejoresCartas[2].getValor()){
							mejoresCartas[4] = cartas[k];
							end = true;
						}
						k--;
					}
					return mejoresCartas;
				}
			}
			j--;
		}
		i--;
	}
	return null;
}

private static Carta[] colorModo3(Carta[] cartas) {
	Carta[] mejoresCartas = new Carta[5];
	int cont = 0,color = 0,j;
	boolean col = false;

	while (cont < cartas.length-1 && !col) {
		j = cont+1;
		mejoresCartas[color] = cartas[cont];
		color++;
		while(j < cartas.length-1){
			if (cartas[cont].getColor() == cartas[j].getColor()) {
				mejoresCartas[color] = cartas[j];
				color++;
			}
			if (color == 5) 
				return mejoresCartas;
			
			j++;
		}
		color = 0;
		cont++;
	}
	return null;	
}

	//Metodos para ver que jugada tienes 

	boolean escaleraDeColor(Carta[] cartas) {
		boolean esEscalera = false, posible = true;
		ordenador(cartas); //Ordenamos las cartas

		int cont = 0;

		while (cont < cartas.length-1  && posible) {

			//Si tienen mismo color y un el valor de la carta es uno mas, aumentamos el contador
			if (cartas[cont].getColor() == cartas[cont + 1].getColor()
					&& cartas[cont].getValor() + 1 == cartas[cont + 1].getValor())
				cont++;

			else //Si no cumple lo anterior no es posible tener escalera de color
				posible = false;	
		}
		
		if(cont == 3){ //El valor 13 = As.

			if(cartas[cont].getValor() == 5 && cartas[cont + 1].getValor() == 1)
				cont++;

			else
				this.proyectoEscaleraC = true; 


		}else if (cont == 4) //Si contador es igual a 4 ya tenemos escalera
			esEscalera = true;

		else
			this.proyectoEscaleraC = buscarProyectoEC(cartas,cont);


		return esEscalera;
	}

	/**
	 * Recorre el array de cartas para comprobar si hay escalera
	 * 
	 * @param cartas
	 * @return
	 */
	boolean escalera(Carta[] cartas) {

		boolean esEscalera = false, posible = true;
		ordenador(cartas);
		int cont = 0;

		while (cont < cartas.length-1  && posible) {

			if (cartas[cont].getValor() + 1 == cartas[cont + 1].getValor())
				cont++;

			else
				posible = false;
		}

		if(cont == 3){ //El valor 13 es el as
			if(cartas[cont].getValor() == 5 && cartas[cont + 1].getValor() == 13)
				cont++;

			else
				this.proyectoEscalera = true;

		}else if (cont == 4)
			esEscalera = true;

		else 
			this.proyectoEscalera = buscarProyectoE(cartas,cont);

		return esEscalera;
	}

	/**
	 * Recorre el array de cartas para comprobar si hay poker
	 * 
	 * @param cartas
	 * @return
	 */
	String poker(Carta[] cartas) {
		String carta = null;
		int cont = 0;
		for (int i = 0; i < cartas.length; i++) {
			cont = 0;
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) { //Miramos si tenemos cartas iguales
					cont++;
					
					if (cont == 3) //Si tenemos 4 cartas iguales las pasamos de entero a carta
						carta = intToCarta(cartas[i].getValor());
				}
			}
		}
		return carta;
	}


	private static Carta[] parejaModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		for (int i = 0; i < cartas.length-1; i++) {
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

	/**
	 * Recorre el array de cartas para comprobar si hay full
	 * 
	 * @param cartas
	 * @return
	 */
	String full(Carta[] cartas) {
		String carta = null;
		String trio = null;

		if (trio(cartas) != null) {
			trio = trio(cartas);

			if (pareja(cartas) != null && !trio.equals(pareja(cartas)))
				carta = "Full house: Three-of-a-kind " + trio + " and pair of " + pareja(cartas);
		}
		return carta;
	}

	/**
	 * Recorre el array de cartas para comprobar si hay color
	 * 
	 * @param cartas
	 * @return
	 */
	String color(Carta[] cartas) {
		String carta = null;
		boolean posible = true;
		int cont = 0;

		while(cont < cartas.length-1 && posible) {
			if (cartas[cont].getColor() == cartas[cont+1].getColor())
				cont++;
			else
				posible = false;
		}

		if(cont == 4)
			carta = charToColor(cartas[cont].getColor());

		else
			this.proyectoColor = buscarProyectoC(cartas,cont);


		return carta;
	}

	/**
	 * Recorre el array de cartas para comprobar si hay trio
	 * 
	 * @param cartas
	 * @return
	 */
	String trio(Carta[] cartas) {
		String carta = null;
		int cont = 0;
		for (int i = 0; i < cartas.length; i++) {
			cont = 0;
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					cont++;
					if (cont == 2)
						carta = intToCarta(cartas[i].getValor());
				}
			}
		}
		return carta;
	}

	/**
	 * Recorre el array de cartas para devolver si hay doble pareja
	 * 
	 * @param cartas
	 * @return
	 */
	String doblePareja(Carta[] cartas) {
		boolean salir = true;
		int cont = 0, i = 0, j;
		String pareja = "";

		while (i < cartas.length) {
			j = i + 1;
			salir = true;
			while (j < cartas.length && salir) {//Miramos una pareja y salimos. Volvemos a entrar en el bucle a buscar mas parejas

				if (cartas[i].getValor() == cartas[j].getValor()) { 
					cont++;

					salir = false;
					pareja += " " + intToCarta(cartas[i].getValor());
				}
				j++;
			}
			i++;
		}

		if (cont >= 2) //Si hemos encontrado dos o mas parejas devolvemos que hay doblePareja
			return pareja;

		return null;
	}

	/**
	 * Recorre el array de cartas y devuelve si hay pareja
	 * 
	 * @param cartas
	 * @return
	 */

	String pareja(Carta[] cartas) {
		String carta = null;

		for (int i = 0; i < cartas.length; i++) {
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor())
					carta = intToCarta(cartas[i].getValor());
			}
		}
		return carta;
	}

	/**
	 * Recorre el array de cartas para devolver la mayor
	 * 
	 * @param cartas
	 * @return valor de la carta alta
	 */
	String cartaAlta(Carta[] cartas) {
		int cartaAlta = cartas[0].getValor();
		for (int i = 1; i < cartas.length; i++) {
			if (cartaAlta < cartas[i].getValor())
				cartaAlta = cartas[i].getValor();
		}
		return intToCarta(cartaAlta);
	}

	/**
	 * Ordena el array de cartas de menor a mayor
	 * 
	 * @param cartas
	 */
	public static void ordenador(Carta[] cartas) { //Metodo para ordenar las cartas. Util para escaleras

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

	//Metodos para ver si hay proyectos de jugadas

	private boolean buscarProyectoE(Carta[] cartas,int cont){

		boolean draw = false,start=false;

		if(cont == 0){
			cont++;
			draw=true;
			start=true;
		}

		else if(cartas[cont-1].getValor()+2 == cartas[cont+1].getValor()){
			draw=true;
			cont++;
		}

		while (cont < cartas.length-1  && draw){
			if(cartas[cont].getValor()+1 == cartas[cont+1].getValor())
				cont++;
			else if(start && cartas[cont].getValor()+2 == cartas[cont+1].getValor()){
				cont++;
				start = false;
			}
			else
				draw = false;
		}

		this.gutshot = draw;

		return draw;

	}

	private boolean buscarProyectoEC(Carta[] cartas,int cont){

		boolean draw = false,start=false;

		if(cont == 0){
			cont++;
			draw=true;
			start=true;
		}
		else if(cartas[cont-1].getValor()+2 == cartas[cont+1].getValor() 
				&& cartas[cont-1].getColor() == cartas[cont+1].getColor()){
			draw=true;
			cont++;
		}

		while (cont < cartas.length-1  && draw){
			if(cartas[cont].getValor()+1 == cartas[cont+1].getValor()
					&& cartas[cont-1].getColor() == cartas[cont+1].getColor())
				cont++;
			else if(start && cartas[cont].getValor()+2 == cartas[cont+1].getValor()
					&& cartas[cont-1].getColor() == cartas[cont+1].getColor()){
				cont++;
				start = false;
			}
			else
				draw = false;
		}

		this.gutshot = draw;

		return draw;

	}

	private boolean buscarProyectoC(Carta[] cartas,int cont){

		boolean draw = false;

		if(cont == 0){
			cont++;
			draw=true;
		}
		else if(cartas[cont-1].getColor() == cartas[cont+1].getColor()){

			draw=true;
			cont++;
		}

		while (cont < cartas.length-1  && draw){
			if(cartas[cont].getColor() == cartas[cont+1].getColor())
				cont++;
			else
				draw = false;
		}

		return draw;
	}



	/**
	 * Parsea el color de la carta
	 * 
	 * @param valor
	 * @return
	 */

	//Metodo para pasar de char a color
	private String charToColor(char valor) {
		String color = null;
		switch (valor) {
		case 'h':
			color = "Hearts";
			break;
		case 'd':
			color = "Diamonds";
			break;
		case 'c':
			color = "Clubs";
			break;
		case 's':
			color = "Spades";
			break;
		default:
			break;
		}
		return color;
	}

	/**
	 * Parsea el valor de la carta y lo pasa a String
	 * 
	 * @param valor
	 *            entero con el valor de la carta
	 * @return
	 */

	//Metodo para pasar de entero a Carta
	private String intToCarta(int valor) {
		String carta = null;
		switch (valor) {
		case 2:
			carta = "two";
			break;
		case 3:
			carta = "three";
			break;
		case 4:
			carta = "four";
			break;
		case 5:
			carta = "five";
			break;
		case 6:
			carta = "six";
			break;
		case 7:
			carta = "seven";
			break;
		case 8:
			carta = "eight";
			break;
		case 9:
			carta = "nine";
			break;
		case 10:
			carta = "ten";
			break;
		case 11:
			carta = "Jack";
			break;
		case 12:
			carta = "Queen";
			break;
		case 13:
			carta = "King";
			break;
		case 14:
			carta = "Ace";
			break;
		default:
			break;
		}
		return carta;
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
                        carta=Integer.toString(valor);
			break;
		}
		return carta;
	}
	
	//public ArrayList<Modo3> comprobarModo3(ArrayList<Carta[]> cartas) {
        public String comprobarModo3(ArrayList<Carta[]> cartas) {
		ArrayList<Modo3> jugadores = new ArrayList<Modo3>();
		
		for(int i=0; i<cartas.size(); i++){
			Modo3 c = new Modo3();
			c.setJugador(i);

			Carta[] car =comprobarModo3(cartas.get(i),c);
			ArrayList<Carta> listaCarta = new ArrayList<Carta>();

			for(int j=0; j<car.length;j++)
				listaCarta.add(car[j]); //cambiamos de carta[] a arraylis<Carta>
			
			c.setCartas(listaCarta);
			jugadores.add(c);
		}
		
		
		
            //return ordenarManos(jugadores);
            return salida(ordenarManos(jugadores));

	}
	
        public String salida(ArrayList<Modo3> jugadores){
            String salida="";
            
            for(int i=0; i<jugadores.size();i++){
                salida+= "J" + Integer.toString(jugadores.get(i).getJugador()+1) + ": " + cartasString(jugadores.get(i).getCartas());
                salida+= " (" + manoString(jugadores.get(i)) + ")";
                salida+="\r\n";
            }
            return salida;
        }
        
        private String cartasString(ArrayList<Carta> cartas){
            String c="";
            for(int i=0; i<cartas.size(); i++){
                c+= intToChar(cartas.get(i).getValor()) + cartas.get(i).getColor();
            }
            return c;
        }
        
        private String manoString(Modo3 jug){
           String c="";
           int peso= jug.getPeso();
           
            if(peso==8) c="Straight Flush of " + charToColor(jug.getCartas().get(0).getColor()) + "s";
            else if(peso==7)c="Poker of "+ intToCarta(jug.getCartas().get(0).getValor()) + "s";
            else if(peso==6){
                c="Full of Three "+ intToCarta(jug.getCartas().get(0).getValor()) + "s";
                c+=" and Two " + intToCarta(jug.getCartas().get(3).getValor()) + "s";
            }
            else if(peso==5){
                c="Flush of " + charToColor(jug.getCartas().get(0).getColor()) + "s";
            }
            else if(peso==4)c="Straight";
            else if(peso==3){
                c="Three of " + intToCarta(jug.getCartas().get(0).getValor()) + "s";
            }
            else if(peso==2){
                c="Two Pair of " + intToCarta(jug.getCartas().get(0).getValor()) + "s";
                c+=" and " + intToCarta(jug.getCartas().get(2).getValor()) + "s";
            }
            else if(peso==1){
                c="Pair of " + intToCarta(jug.getCartas().get(0).getValor()) + "s";
            }
            else if(peso==0)c="High Card";
           
            return c;
        }

    public static ArrayList<Modo3> ordenarManos(ArrayList<Modo3> jugadores) {
    		int contJug=0,peso = 8,nPesos,posMejor,pos;
    		boolean seguir = false;
    		ArrayList<Modo3> empatados,ordenados = new ArrayList<Modo3>();
     		while(peso >= 0){
    			posMejor=-1;
    			empatados = new ArrayList<Modo3>();
    			nPesos = 0;
    			pos=0;
    			if(contJug < jugadores.size())
    				seguir = true;
    			
    			while(seguir && contJug < jugadores.size()){
    				if(jugadores.get(pos).getPeso() == peso){
    					empatados.add(jugadores.get(pos));
    					nPesos++;
    					contJug++;
    				}
    				
    				if(pos == jugadores.size()-1)
    				   seguir = false;
    				
    				pos++;		
    			}
    			
    			while(nPesos>=2){
    				posMejor = desempateManos(empatados);
    				ordenados.add(empatados.get(posMejor));
    				empatados.remove(posMejor);
    				nPesos--;
    			}
    			
    			if(nPesos == 1)
    				ordenados.add(empatados.get(0));
    			
    			peso--;
    		}	
    		return ordenados;
    	}
    	
    	public static int desempateManos(ArrayList<Modo3> jugadores){

        int posMano=-1, valorAct=0, valorAnt=0, valorMax=0,posMax=0;

        for(int i=0; i<jugadores.size();i++){
         for(int h=i+1;h<jugadores.size();h++){

          if(jugadores.get(i).getPeso() == 8 || jugadores.get(i).getPeso() == 4){ //Escalera normal y de color
           valorAct=valorMaxMano(jugadores.get(i).getCartas(),true);
           valorAnt=valorMaxMano(jugadores.get(h).getCartas(),true);

           if(valorAct>valorAnt){
            //posMano = i;
            if(valorAct > valorMax){
             valorMax=valorAct;
             posMax=i;
            }
           }

           else{
            //posMano=h;
            if(valorAnt > valorMax){
             valorMax=valorAnt;
             posMax=h;
            }
           }

          }

          else if(jugadores.get(i).getPeso()==7){ //poker
           valorAct=desempateCartaRep(jugadores.get(i).getCartas(),-1);
           valorAnt=desempateCartaRep(jugadores.get(h).getCartas(),-1);

           if(valorAct>valorAnt){
            //posMano = i;
            if(valorAct > valorMax){
             valorMax=valorAct;
             posMax=i;
            }
           }

           else{
            //posMano=h;
            if(valorAnt > valorMax){
             valorMax=valorAnt;
             posMax=h;
            }
           }
          }

          else if(jugadores.get(i).getPeso()==6){ //full
           valorAct=desEmpateTrioFull(jugadores.get(i).getCartas());
           valorAnt=desEmpateTrioFull(jugadores.get(h).getCartas());

           if(valorAct>valorAnt){
            //posMano = i;
            if(valorAct > valorMax){
             valorMax=valorAct;
             posMax=i;
            }
           }

           else{
            //posMano=h;
            if(valorAnt > valorMax){
             valorMax=valorAnt;
             posMax=h;
            }
           }
          }
          else if(jugadores.get(i).getPeso()==5){ //color

           valorAct=valorMaxMano(jugadores.get(i).getCartas(),true);
           valorAnt=valorMaxMano(jugadores.get(h).getCartas(),true);

           if(valorAct>valorAnt){
            //posMano = i;
            if(valorAct > valorMax){
             valorMax=valorAct;
             posMax=i;
            }
           }

           else{
            //posMano=h;
            if(valorAnt > valorMax){
             valorMax=valorAnt;
             posMax=h;
            }
           }

          }

          else if(jugadores.get(i).getPeso()==3){ //trio
           valorAct=desempateCartaRep(jugadores.get(i).getCartas(),-1);
           valorAnt=desempateCartaRep(jugadores.get(h).getCartas(),-1);

           if(valorAct>valorAnt){
            //posMano = i;
            if(valorAct > valorMax){
             valorMax=valorAct;
             posMax=i;
            }
           }

           else{
            //posMano=h;
            if(valorAnt > valorMax){
             valorMax=valorAnt;
             posMax=h;
            }
           }
          }

          else if(jugadores.get(i).getPeso()==2){//doble pareja
           
           valorAct = parejaAltaDP(jugadores.get(i).getCartas());
           valorAnt = parejaAltaDP(jugadores.get(h).getCartas());
           
           if(valorAct == valorAnt){ //Si la priemra pareja es igual miramos la segunda
            valorAct = parejaBajaDP(jugadores.get(i).getCartas());
            valorAnt = parejaBajaDP(jugadores.get(h).getCartas());
            if(valorAct>valorAnt){
             if(valorAct > valorMax){
              valorMax = valorAct;
              posMax = i;
             }
            }else{
             if(valorAnt > valorMax){
                 valorMax=valorAnt;
                 posMax=h;
                }
            }
           }
           else{ //Si la primera pareja ya no es igual no hay que mirar mas
            if(valorAct>valorAnt)
             if(valorAct > valorMax){
              valorMax = valorAct;
              posMax = i;
             }
            
            else
                if(valorAnt > valorMax){
                 valorMax=valorAnt;
                 posMax=h;
                }
           }
          } 

          else if(jugadores.get(i).getPeso()==1){//pareja
           valorAct=desempateCartaRep(jugadores.get(i).getCartas(),-1);
           valorAnt=desempateCartaRep(jugadores.get(h).getCartas(),-1);

           if(valorAct>valorAnt){
            //posMano = i;
            if(valorAct > valorMax){
             valorMax=valorAct;
             posMax=i;
            }
           }

           else{
            //posMano=h;
            if(valorAnt > valorMax){
             valorMax=valorAnt;
             posMax=h;
            }
           }
          }

          else if(jugadores.get(i).getPeso()==0){//Carta-Alta

           if(valorMaxMano(jugadores.get(i).getCartas(),false)>valorMaxMano(jugadores.get(h).getCartas(),false))
            posMano = i;
           else
            posMano=h;
          }
         }
        }
        return posMax;//pos del ganador
       }
    
    	private static int parejaAltaDP(ArrayList<Carta> cartas){
    		return cartas.get(0).getValor();
    	}
    	
    	private static int parejaBajaDP(ArrayList<Carta> cartas){
    		return cartas.get(2).getValor();
    	}
    
     
    	 private static int desEmpateTrioFull(ArrayList<Carta> cartas){
    		   return cartas.get(0).getValor(); 
    		     }
	
    	public static int valorMaxMano(ArrayList<Carta> cartas,boolean escalera){ //Te devuelve el valor de la carta mas alta de una mano

    		int max=cartas.get(cartas.size()-1).getValor();
    		
    		if(escalera && max ==14 && cartas.get(cartas.size()-2).getValor() == 5)//Caso de escalera acabada en 5 
    			max = 5;
    		
    		return max;
        }
        
        	
    	private static int desempateCartaRep(ArrayList<Carta> cartas,int anterior){
    		int valor=0,i=cartas.size()-1,j;
    		boolean repetido = false;

    		while(i > 0 && !repetido){
    			valor = cartas.get(i).getValor();
    			if(valor != anterior){
    				j=i-1;
    				while(j>=0 && !repetido){
    					if(valor == cartas.get(j).getValor())
    						repetido = true;

    					j--;

    				}
    			}
    			i--;
    		}

    		return valor;
    	}
    	
}