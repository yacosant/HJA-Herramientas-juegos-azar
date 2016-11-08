package hja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CargarModo1 extends Cargar<ArrayList<Carta[]>>{
	
	public CargarModo1(){
		super();
	}
	
	@Override
	public ArrayList<Carta[]> cargar(String archivo) {
		File fichero = new File(archivo);
        Scanner s = null;
        String linea = "";
        Carta[] mano = new Carta[5]; //Creamos un array Carta de 5 posiciones (una por carta)
        try {
            s = new Scanner(fichero);

            while (s.hasNext()) {
                linea = s.nextLine(); // Guardamos la linea en un String
                lineas.add(linea);
                StringBuffer bf = new StringBuffer(linea);

                int i = 0, cont = 0, valor;

                while (i < bf.length()) {
                    if (bf.charAt(i) == 'A') {
                        valor = 14;
                    } else if (bf.charAt(i) == 'K') {
                        valor = 13;
                    } else if (bf.charAt(i) == 'Q') {
                        valor = 12;
                    } else if (bf.charAt(i) == 'J') {
                        valor = 11;
                    } else if (bf.charAt(i) == 'T') {
                        valor = 10;
                    } else {
                        valor = bf.charAt(i) - 48;
                    }

                    mano[cont] = new Carta(valor, bf.charAt(i + 1)); //Guardamos el valor de la carta y el color

                    i += 2;
                    cont++;
                }
                cartasMano.add(mano);
                mano = new Carta[5];

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        }
        return cartasMano;

	}

}