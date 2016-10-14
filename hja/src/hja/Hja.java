package hja;

import logica.Archivo;
import logica.Carta;
import logica.Logica;

/**
 * 
 * @author Grupo 1
 *
 */
public class Hja {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// leemos archivo
		Archivo ar = new Archivo();
		Logica log = new Logica();
		Carta[] cartas = new Carta[5];
		cartas = ar.cargar("prueba.txt");
		String respuesta = log.comprobar(cartas);
		System.out.println(respuesta);
	}

}