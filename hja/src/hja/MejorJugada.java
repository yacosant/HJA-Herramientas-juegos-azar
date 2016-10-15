
package hja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Grupo 1
 *
 */
public class MejorJugada {
       private ArrayList<Carta[]> manos;
       private ArrayList<String> lineas;

	public MejorJugada() {
		this.lineas = new ArrayList<String>();
                this.manos = new ArrayList<Carta[]>();
	}

        public ArrayList<Carta[]> cargar(String archivo) {

		File fichero = new File(archivo);
		Scanner s = null;
		String linea = "";
                Carta[] mano = new Carta[5];
		try {
			s = new Scanner(fichero);
		
			while (s.hasNext()) {
				linea = s.nextLine(); // Guardamos la linea en un String
                                lineas.add(linea);
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

        
	public void guardar(String texto, int cont) {
		String nombre = "salida.txt";
		File fichero = new File(nombre);
		try {
                    FileWriter salida = new FileWriter(fichero, true);
                    
                    if(cont==0){
                        BufferedWriter buffer = new BufferedWriter(new FileWriter(nombre));
                            buffer.write(lineas.get(cont));
                            buffer.write("\r\n");
                            buffer.write(texto);
                            buffer.write("\r\n");
                        buffer.close();
                    }
                    else{
                            salida.write(lineas.get(cont));
                            salida.write("\r\n");
                            salida.write(texto);
                            salida.write("\r\n");
                        salida.close();
                    }

		} catch (IOException ex) {
			System.err.println("Error: Ha habido algun problema al crear el archivo.");
		}

	}
}
