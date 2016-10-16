package hja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MejorJugada2 {
	
	private ArrayList<Carta[]> cartasMano;
	private ArrayList<Carta[]> cartasMesa;
        private ArrayList<String> lineas;
	public MejorJugada2() {
		
	}
	
        public CartasModo2 cargar(String archivo) {
            CartasModo2 cartas = new CartasModo2(cartasMano, cartasMesa);
		File fichero = new File(archivo);
		Scanner s = null;
		String linea = "";
                Carta[] mano;
                Carta[] mesa;
		try {
			s = new Scanner(fichero);
		
			while (s.hasNext()) {
				linea = s.nextLine(); // Guardamos la linea en un String
                                lineas.add(linea);
				StringBuffer bf = new StringBuffer(linea);
				int i = 0, cont = 0, valor;
                                mano = new Carta[2];
				while(i<2){
                                    valor= conversion(bf.charAt(i));
                                    mano[cont]= new Carta(valor, bf.charAt(i + 1));
                                    i += 2;
                                    cont++;
                                }
                                i+=3; //saltar las dos ; y el numero.
                                
                                mesa = new Carta[5];
                                cont=0;
                                while (i < bf.length()) {
					valor= conversion(bf.charAt(i));
					mesa[cont]= new Carta(valor, bf.charAt(i + 1));
					i += 2;
					cont++;
				}
                                cartasMano.add(mano);
                                cartasMesa.add(mesa);
                                
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error en la lectura del fichero");
		}
                
		return cartas;

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
        
        int conversion (char c){
            int valor;
            if (c == 'A')
                    valor = 14;
            else if (c == 'K')
                    valor = 13;
            else if (c == 'Q')
                    valor = 12;
            else if (c == 'J')
                    valor = 11;
            else if (c == 'T')
                    valor = 10;
            else
                    valor = c - 48;
            
            return valor;
        }
	
}
