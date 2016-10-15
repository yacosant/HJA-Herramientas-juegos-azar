package hja;

import java.util.ArrayList;


/**
 * 
 * @author Grupo 1

 *
 */
public class Hja {

	

	//Parseamos el juego que queremos jugar
	private static void parseGame(int n) throws ParseException {
		
		//Switch de los juegos que hay 
		if(n==1)
			//LLAMAR A JUEGO 1
		else if(n==2)
			//LLAMAR A JUEGO 2
		else if(n==3)
			//LLAMAR A JUEGO 3
		else if(n==4)
			//LLAMAR A JUEGO 4
		else
			throw new ParseException("Ese juego no existe, cambia el numero del txt(1-4)");

	}

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
                        ar.guardar(respuesta, cont);
			System.out.println(respuesta);
			cont++;
		}
		
		//int n = LLAMADA DEL METODO QUE CARGARA EL INT DEL TXT
		//parseGame(n);
		
	}
}
