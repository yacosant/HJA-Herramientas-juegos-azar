package hja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Grupo 1
 *
 */
public class Archivo {

	public Carta[] cargar(String archivo) {

		Carta[] cartas = new Carta[5];
		File fichero = new File(archivo);
		Scanner s = null;
		String linea = "";
		try {
			s = new Scanner(fichero);
			while (s.hasNext()) {
				linea = s.nextLine(); // Guardamos la linea en un String
				StringBuffer bf = new StringBuffer(linea);
				int i = 0, cont = 0, valor;
				while (i < bf.length()) {
					if (bf.charAt(i) == 'A')
						valor = 14;
					else if (bf.charAt(i) == 'K')
						valor = 13;
					else if (bf.charAt(i) == 'Q')
						valor = 12;
					else if (bf.charAt(i) == 'J')
						valor = 11;
					else if (bf.charAt(i) == 'T')
						valor = 10;
					else
						valor = bf.charAt(i) - 48;
					cartas[cont] = new Carta(valor, bf.charAt(i + 1));
					i += 2;
					cont++;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error en la lectura del fichero");
		}
		return cartas;

	}

	static public void guardar(Carta[] cartas) {
		String linea = "";
		String nombre = "salida.txt";
		// File fichero = new File(nombre);
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(nombre));

			for (int i = 0; i < 5; i++) {
				linea = linea + String.valueOf(cartas[i].getValor()) + String.valueOf(cartas[i].getColor());
			}
			buffer.write(linea);

			// pintar las conclusiones obtenidas!
			//
			//
			//

			buffer.close();

		} catch (IOException ex) {
			System.err.println("Error: Ha habido algun problema al crear el archivo.");
		}

	}
}