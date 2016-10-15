/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Grupo 1
 *
 */
public class MejorJugada {
       private ArrayList<Carta[]> manos;
        //private Carta[][] manos;

	public MejorJugada() {
		//this.manos = new Carta[2][5];
                this.manos = new ArrayList<Carta[]>();
	}

        /*
	public Carta[][] cargar(String archivo) {

		File fichero = new File(archivo);
		Scanner s = null;
		String linea = "";
		try {
			s = new Scanner(fichero);
			int man = 0;
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
					manos[man][cont] = new Carta(valor, bf.charAt(i + 1));
					i += 2;
					cont++;
				}
				man++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error en la lectura del fichero");
		}
		return manos;

	}
        */

        public ArrayList<Carta[]> cargar(String archivo) {

		File fichero = new File(archivo);
		Scanner s = null;
		String linea = "";
                Carta[] mano = new Carta[5];
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
					mano[cont]= new Carta(valor, bf.charAt(i + 1));
					i += 2;
					cont++;
				}
                                manos.add(mano);
                                mano = new Carta[5];
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error en la lectura del fichero");
		}
		return manos;

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
