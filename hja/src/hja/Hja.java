package hja;

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
		Carta[][] manos  = new Carta[3][5];
		manos = ar.cargar("prueba.txt");
		int cont = 0;
		while (cont < manos.length) {
			String respuesta = log.comprobar(manos[cont]);
			System.out.println(respuesta);
			cont++;
		}
	}

}
