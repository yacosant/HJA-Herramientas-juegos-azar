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
	private ArrayList<Modo3> jugadores = new ArrayList<Modo3>();

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
		// ecncontrado trio no se comprobar√° pareja

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
		// three-of-a-kind(tr√≠o)
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
	
	public Carta[] comprobarModo3(Carta[] cartas,Modo3 jugador) {
		
		Carta[] mejoresCartas = null;
		ordenador(cartas);
		mejoresCartas = escaleraDeColorModo3(cartas);
		if (!mejoresCartas.equals(null)) {
			jugador.setPeso(8);
			return mejoresCartas;
		}
		mejoresCartas = pokerModo3(cartas);
		if (!mejoresCartas.equals(null)) {
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
		if (!mejoresCartas.equals(null)) {
			jugador.setPeso(6);
			return mejoresCartas;
		}
		mejoresCartas = colorModo3(cartas);
		if (!mejoresCartas.equals(null)) {
			jugador.setPeso(5);
			return mejoresCartas;
		}
		mejoresCartas = escaleraModo3(cartas);
		if (!mejoresCartas.equals(null)) {
			jugador.setPeso(4);
			return mejoresCartas;
		}
		mejoresCartas = trioModo3(cartas);
		if (!mejoresCartas.equals(null)) {
			jugador.setPeso(3);
			boolean primero = true;
			for (int i = cartas.length - 1; i >= 0; i--) {
				if (cartas[i].getValor() != mejoresCartas[0].getValor()) {
					if (primero) {
						mejoresCartas[3] = cartas[i];
						primero = false;
					} else {
						mejoresCartas[3] = cartas[i];
						return mejoresCartas;
					}
				}
			}
			return mejoresCartas;
		}
		mejoresCartas = dobleParejaModo3(cartas);
		if (!mejoresCartas.equals(null)) {
			jugador.setPeso(2);
			for (int i = cartas.length - 1; i >= 0; i--) {
				if (cartas[i].getValor() != mejoresCartas[0].getValor()
						&& cartas[i].getValor() != mejoresCartas[2].getValor()) {
					mejoresCartas[4] = cartas[i];
					return mejoresCartas;
				}
			}
			return mejoresCartas;
		}
		mejoresCartas = parejaModo3(cartas);
		if (!mejoresCartas.equals(null)) {
			jugador.setPeso(1);
			int cont = 2;
			for (int i = cartas.length - 1; i >= 0; i--) {
				if (cartas[i].getValor() != mejoresCartas[0].getValor()) {
					mejoresCartas[cont] = cartas[i];
					cont++;
					if (cont == 5)
						return mejoresCartas;
				}
			}
			return mejoresCartas;
		}
		for (int i = cartas.length - 1; i >= 0; i--)
			mejoresCartas[i] = cartas[i];
		jugador.setPeso(0);
		return mejoresCartas;
	}

	private Carta[] fullModo3(Carta[] cartas) {
		ordenador(cartas);
		Carta[] mejoresCartas = new Carta[5];
		Carta[] mejoresCartasTrio = new Carta[3];
		Carta[] mejoresCartasPareja = new Carta[2];
		
		mejoresCartasTrio = trioModo3(cartas);
		if (!mejoresCartasTrio.equals(null)) {
			for (int i = 0; i < cartas.length; i++)
				if (mejoresCartasPareja[0].getValor() == cartas[i].getValor())
					cartas[i] = null;
			mejoresCartasPareja = parejaModo3(cartas);
			if (!mejoresCartasPareja.equals(null)) {
				mejoresCartas[0] = mejoresCartasTrio[0];
				mejoresCartas[1] = mejoresCartasTrio[1];
				mejoresCartas[2] = mejoresCartasTrio[2];
				mejoresCartas[3] = mejoresCartasPareja[0];
				mejoresCartas[4] = mejoresCartasPareja[1];
				return mejoresCartas;
				
			}
		}
		return null;
	}

	private Carta[] dobleParejaModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		boolean salir = true;
		int cont = 0, i = 0, j;
		while (i < cartas.length) {
			j = i + 1;
			salir = true;
			while (j < cartas.length && salir) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					mejoresCartas[cont] = new Carta(cartas[i].getValor(), cartas[i].getColor());
					mejoresCartas[cont + 1] = new Carta(cartas[j].getValor(), cartas[j].getColor());
					cont += 2;
					salir = false;
					if (cont > 2)
						return mejoresCartas;
				}
				j++;
			}
			i++;
		}
		return null;
	}

	private Carta[] colorModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		int cont = 0;

		while (cont < cartas.length - 1) {
			if (cartas[cont].getColor() == cartas[cont + 1].getColor()) {
				mejoresCartas[cont] = new Carta(cartas[cont].getValor(), cartas[cont].getColor());
				cont++;
			}
			if (cont == 4) {
				mejoresCartas[cont] = new Carta(cartas[cont + 1].getValor(), cartas[cont + 1].getColor());
				return mejoresCartas;
			}
		}
		return null;
	}

	/*private Carta[] escaleraModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		ordenador(cartas); // Ordenamos las cartas
		int cont = 0, cart = 0;

		while (cont < cartas.length - 1) {
			if (cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()) {
				mejoresCartas[cart] = new Carta(cartas[cont].getValor(), cartas[cont].getColor());
				cart++;
				if (mejoresCartas.length - 1 == cart) // si es el ultimo con el
														// que
					// coincidio se aÒade
					mejoresCartas[cart] = new Carta(cartas[cont + 1].getValor(), cartas[cont + 1].getColor());
			}
			if (mejoresCartas[4] == (null))
				return mejoresCartas;
			cont++;
		}
		return null;
	}*/
	
	private Carta[] escaleraModo3(Carta[] cartas){
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
				if(cart == 5)
					for(int i = 0;i<mejoresCartas.length-1;i++)
						mejoresCartas[i] = mejoresCartas[i+1];
				mejoresCartas[cart-1] = cartas[cont];
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
			}else{
				mejoresCartas[mejoresCartas.length-1] = cartas[cont];
				esc = true;
			}
		}

		if(!esc)
			mejoresCartas = null;

		return mejoresCartas;

	}
	
	private Carta[] trioModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		int cont = 0;
		for (int i = 0; i < cartas.length; i++) {
			cont = 0;
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					mejoresCartas[cont] = new Carta(cartas[i].getValor(), cartas[i].getColor());
					cont++;
					if (cont == 2) {
						mejoresCartas[cont] = new Carta(cartas[j].getValor(), cartas[j].getColor());
						return mejoresCartas;
					}
				}
			}
		}
		return null;
	}

	private Carta[] parejaModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		for (int i = 0; i < cartas.length; i++) {
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					mejoresCartas[0] = new Carta(cartas[i].getValor(), cartas[i].getColor());
					mejoresCartas[1] = new Carta(cartas[j].getValor(), cartas[j].getColor());
					return mejoresCartas;
				}
			}
		}
		return null;
	}

	private Carta[] pokerModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		int cont = 0;
		for (int i = 0; i < cartas.length; i++) {
			cont = 0;
			for (int j = i + 1; j < cartas.length; j++) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					mejoresCartas[cont] = new Carta(cartas[i].getValor(), cartas[i].getColor());
					cont++;
					if (cont == 3) { // aÒadimos la ultima carta
						mejoresCartas[cont] = new Carta(cartas[j].getValor(), cartas[j].getColor());
						return mejoresCartas;
					}
				}
			}
		}
		return null;
	}

	/*public Carta[] escaleraDeColorModo3(Carta[] cartas) {
		Carta[] mejoresCartas = new Carta[5];
		ordenador(cartas); // Ordenamos las cartas
		int cont = 0, cart = 0;

		while (cont < cartas.length - 1) {
			if (cartas[cont].getColor() == cartas[cont + 1].getColor()
					&& cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()) {
				mejoresCartas[cart] = new Carta(cartas[cont].getValor(), cartas[cont].getColor());
				cart++;
				if (mejoresCartas.length - 1 == cart) // si es el ultimo con el
														// que
					// coincidio se aÒade
					mejoresCartas[cart] = new Carta(cartas[cont + 1].getValor(), cartas[cont + 1].getColor());
			}
			if (mejoresCartas[4] == null)
				return mejoresCartas;
			cont++;
		}
		return null;
	}*/
	
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
				}else{//Si ha habido escalera pero puede ser mayor
					for(int i = 0;i<mejoresCartas.length-1;i++)
						mejoresCartas[i] = mejoresCartas[i+1];

					mejoresCartas[mejoresCartas.length-1] = cartas[cont];
				}
			}else{//penultima pos no coincide con ult pero hacia escalera
				if(cart == 5)
					for(int i = 0;i<mejoresCartas.length-1;i++)
						mejoresCartas[i] = mejoresCartas[i+1];
				mejoresCartas[cart-1] = cartas[cont];
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
		//ult pos que no se entra en el bucle
		if(!escA && cartas[cont].getColor() == cartas[cont -1].getColor()
				&& cartas[cont].getValor()  == cartas[cont -1].getValor()+1){
			if(esc == true){
				for(int i = 0;i<mejoresCartas.length-1;i++)
					mejoresCartas[i] = mejoresCartas[i+1];
				mejoresCartas[mejoresCartas.length-1] = cartas[cont];
			}else{
				mejoresCartas[mejoresCartas.length-1] = cartas[cont];
				esc = true;
			}
		}

		if(!esc)
			mejoresCartas = null;

		return mejoresCartas;

	}

	/**
	 * Recorre el array de cartas para comprobar si hay escalera de color
	 * 
	 * @param cartas
	 * @return
	 */

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

			if(cartas[cont].getValor() == 5 && cartas[cont + 1].getValor() == 13)
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

	public void comprobarModo3() {


	}
	
	public void comprobarModo3(ArrayList<Carta[]> cartas) {
		
		for(int i=0; i<cartas.size(); i++){
			Modo3 c = new Modo3();
			c.setJugador(i);
			c.setCartas(comprobarModo3(cartas.get(i), c));
			jugadores.add(c);
		}

	}
	
	private ArrayList<Modo3> ordenarManos() {
		
		int cont,peso = 8,nPesos,posMejor;
	
		ArrayList<Modo3> empatados,ordenados = new ArrayList<Modo3>();
		while(peso >= 0){
			empatados = new ArrayList<Modo3>();
			nPesos = 0;
			cont = 0;
			
			while(cont < jugadores.size())
				if(jugadores.get(cont).getPeso() == peso){
					empatados.add(jugadores.get(cont));
					nPesos++;
					cont++;
				}
			
			if(nPesos > 1);
				posMejor = desempateManos(empatados);//desEmpate de damaso

			
			if(posMejor == -1)//Ha habido empate,no importa el orden
				for(int i = 0;i<empatados.size();i++)
					ordenados.add(empatados.get(i));
			else{
				ordenados.add(empatados.get(posMejor));//aÒado primero el que gana el desempate 
				for(int i = 0;i<empatados.size();i++)//luego los demas sin importar el orden
					if(i != posMejor)
						ordenados.add(empatados.get(i));
			}
			
		}
		
		
		return ordenados;
	

	}
	
	private int desempateManos(ArrayList<Modo3> jugadores){
	
		int posMano=-1;

		for(int i=0; i<jugadores.size()-1;i++){
			for(int h=i+1;h<jugadores.size();h++){
				
				if(jugadores.get(i).getPeso() == 8 || jugadores.get(i).getPeso() == 4) //Escalera normal y de color
					if(valorMaxMano(jugadores.get(i).getCartas())>valorMaxMano(jugadores.get(h).getCartas()))
						posMano = i;

					else if(jugadores.get(i).getPeso()==7){ //poker
						if(desempateCartaRep(jugadores.get(i).getCartas(),-1)>desempateCartaRep(jugadores.get(h).getCartas(),-1))
							posMano = i;
						else
							posMano=h;
					}

//					else if(jugadores.get(i).getPeso()==6) //full
//
//					else if(jugadores.get(i).getPeso()==5) //color

					else if(jugadores.get(i).getPeso()==3){ //trio
						if(desempateCartaRep(jugadores.get(i).getCartas(),-1)>desempateCartaRep(jugadores.get(h).getCartas(),-1))
							posMano = i;
						else
							posMano=h;
					}

					else if(jugadores.get(i).getPeso()==2){//doble pareja

						int anteriorJi = desempateCartaRep(jugadores.get(i).getCartas(),-1);
						int anteriorJh = desempateCartaRep(jugadores.get(h).getCartas(),-1);


						if(desempateCartaRep(jugadores.get(i).getCartas(), anteriorJi)>desempateCartaRep(jugadores.get(h).getCartas(),anteriorJh))
							posMano = i;
						else
							posMano=h;
					} 

					else if(jugadores.get(i).getPeso()==1){//pareja
						
						if(desempateCartaRep(jugadores.get(i).getCartas(),-1)>desempateCartaRep(jugadores.get(h).getCartas(),-1))
							posMano = i;
						else
							posMano=h;
						
					} 
			}
		}
		return posMano;
	}

	/*private Modo3 darPesoJugadasModo3(Carta[] cartas) {
		Modo3 c = new Modo3();

		if (escaleraDeColor(cartas))
			c.setPeso(8);
		// four-of-a-kind (or quads) (poker)
		else if (poker(cartas) != null)
			c.setPeso(7);
		// full house (or boat) (full)
		else if (full(cartas) != null)
			c.setPeso(6);
		// flush(color)
		else if (color(cartas) != null)
			c.setPeso(5);
		// straight(escalera)
		else if (escalera(cartas))
			c.setPeso(4);
		// three-of-a-kind(tr√≠o)
		else if (trio(cartas) != null)
			c.setPeso(3);
		// two-pair(doblepareja)
		else if (doblePareja(cartas) != null)
			c.setPeso(2);
		// pair (parejao par)
		else if (pareja(cartas) != null)
			c.setPeso(1);
		// high card (carta alta)
		else
			c.setPeso(0);

		return c;
	}
	*/

	
	private int valorMaxMano(Carta[] cartas){ //Te devuelve el valor de la carta mas alta de una mano

		int max=0;

		for (int i = 0; i < cartas.length; i++) {
			max=0;
			if (cartas[i].getValor()> max) {
				max = cartas[i].getValor();
			}
		}
		return max;
	}

	private int desempateCartaRep(Carta[] cartas,int anterior){
		int valor=0,i=0,j;
		boolean repetido = false;

		while(i < cartas.length && !repetido){
			valor = cartas[i].getValor();
			if(valor != anterior){
				j=i+1;
				while(j<cartas.length && !repetido){
					if(valor == cartas[j].getValor())
						repetido = true;

					j++;

				}
			}
			i++;
		}

		return valor;
	}
	
}