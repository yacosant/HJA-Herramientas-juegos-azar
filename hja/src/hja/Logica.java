package logica;

import logica.Carta;

/**
 * 
 * @author Grupo 1
 *
 */
public class Logica {

	/**
	 * Recorre el array de cartas para comprobar que jugada tiene
	 * 
	 * @param cartas
	 * @return
	 */
	String comprobar(Carta[] cartas) {
		String mejorJugada = "";
		// aqui s ehacen todas las llamadas a cada uno de los metodos que
		// comprueban una mano.
		// En el array de string se guardan las manos que si se han producido, y
		// en funcion de si se han producido,
		// el comprobar s eocmprobaran los menores o no, ejemplo: si se han
		// ecncontrado trio no se comprobará pareja

		// ----
		// Lamadas a:

		// straight flush(escalerade color)
		if (escaleraDeColor(cartas))
			mejorJugada = "Escalera de color";
		// four-of-a-kind (or quads) (poker)
		else if (poker(cartas) != null)
			mejorJugada = "Poker: " + poker(cartas);
		// full house (or boat) (full)
		else if (full(cartas) != null)
			mejorJugada = full(cartas);
		// flush(color)
		else if (color(cartas) != null)
			mejorJugada = "Color: " + color(cartas);
		// straight(escalera)
		else if (escalera(cartas))
			mejorJugada = "Escalera";
		// three-of-a-kind(trío)
		else if (trio(cartas) != null)
			mejorJugada = "Trio: " + trio(cartas);
		// two-pair(doblepareja)
		else if (doblePareja(cartas) != null)
			mejorJugada = "Doble Pareja de" + doblePareja(cartas);
		// pair (parejao par)
		else if (pareja(cartas) != null)
			mejorJugada = "Pareja: " + pareja(cartas);
		// high card (carta alta)
		else
			mejorJugada = "Carta Alta: " + cartaAlta(cartas);
		return mejorJugada;

	}

	/**
	 * Recorre el array de cartas para comprobar si hay escalera de color
	 * 
	 * @param cartas
	 * @return
	 */
	boolean escaleraDeColor(Carta[] cartas) {
		boolean esEscalera = false, posible = true;
		ordenador(cartas);

		int cont = 0;

		while (cont < cartas.length - 1 && posible) {

			if (cartas[cont].getColor() == cartas[cont + 1].getColor()
					&& cartas[cont].getValor() + 1 == cartas[cont + 1].getValor())
				cont++;
			else
				posible = false;
		}

		if (cont == 3 && cartas[cont].getValor() == 5 && cartas[cont + 1].getValor() == 13)
			cont++;
		// mejor hacer este if fuera ya que solo entraremos una vez,poniendo
		// length-1 arriba

		if (cont == 4)
			esEscalera = true;

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

		while (cont < cartas.length - 1 && posible) {

			if (cartas[cont].getValor() + 1 == cartas[cont + 1].getValor())
				cont++;
			else
				posible = false;
		}

		if (cont == 3 && cartas[cont].getValor() == 5 && cartas[cont + 1].getValor() == 13)
			cont++;
		// mismo coment que en la de color mejor solo una vez
		if (cont == 4)
			esEscalera = true;

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
				if (cartas[i].getValor() == cartas[j].getValor()) {
					cont++;
					if (cont == 3)
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
				carta = "Full: Trio de " + trio + " y pareja de " + pareja(cartas);
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
		for (int i = 0; i < cartas.length && posible; i++) {
			cont = 0;
			for (int j = i + 1; j < cartas.length && posible; j++) {
				if (cartas[i].getColor() == cartas[j].getColor()) {
					cont++;
					if (cont == 4)
						carta = charToColor(cartas[i].getColor());
				} else
					posible = false;
			}
		}
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
			while (j < cartas.length && salir) {
				if (cartas[i].getValor() == cartas[j].getValor()) {
					cont++;
					salir = false;
					pareja += " " + intToCarta(cartas[i].getValor());
				}
				j++;
			}
			i++;
		}
		if (cont >= 2)
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
	public static void ordenador(Carta[] cartas) {

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

	/**
	 * Parsea el color de la carta
	 * 
	 * @param valor
	 * @return
	 */
	private String charToColor(char valor) {
		String color = null;
		switch (valor) {
		case 'h':
			color = "Corazones";
			break;
		case 'd':
			color = "Diamantes";
			break;
		case 'c':
			color = "Tr�boles";
			break;
		case 's':
			color = "Picas";
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
	private String intToCarta(int valor) {
		String carta = null;
		switch (valor) {
		case 2:
			carta = "dos";
			break;
		case 3:
			carta = "tres";
			break;
		case 4:
			carta = "cuatro";
			break;
		case 5:
			carta = "cinco";
			break;
		case 6:
			carta = "seis";
			break;
		case 7:
			carta = "siete";
			break;
		case 8:
			carta = "ocho";
			break;
		case 9:
			carta = "nueve";
			break;
		case 10:
			carta = "diez";
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
			carta = "Aces";
			break;
		default:
			break;
		}
		return carta;
	}

}