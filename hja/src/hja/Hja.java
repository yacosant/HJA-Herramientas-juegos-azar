package hja;

import java.util.ArrayList;

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
		MejorJugada ar = new MejorJugada();
		Logica log = new Logica();
		//Carta[][] manos  = new Carta[3][5];
                ArrayList<Carta[]> manos  = new ArrayList<Carta[]>();
		manos = ar.cargar("prueba.txt");
		int cont = 0;
		while (cont < manos.size()) {
			String respuesta = log.comprobar(manos.get(cont));
			System.out.println(respuesta);
			cont++;
		}
	}

}
