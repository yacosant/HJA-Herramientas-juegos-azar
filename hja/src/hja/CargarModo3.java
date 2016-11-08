package hja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CargarModo3 extends Cargar<ArrayList<CartasModo2>>{

	public CargarModo3(){
		super();
	}
	
	@Override
	public ArrayList<CartasModo2> cargar(String archivo) {
		CartasModo2 cartas = new CartasModo2(cartasMano, cartasMesa);
        ArrayList<CartasModo2> listaCartas = new ArrayList<CartasModo2>();
        File fichero = new File(archivo);
        Scanner s = null;
        String linea = "";
        Carta[] mano;
        Carta[] mesa;

        try {
            s = new Scanner(fichero);

            while (s.hasNext()) {
            	cartasMano = new ArrayList<Carta[]>();
                cartasMesa = new ArrayList<Carta[]>();
            	cartas = new CartasModo2(cartasMano, cartasMesa);
                linea = s.nextLine(); // Guardamos la linea en un String
                lineas.add(linea);
                StringBuffer bf = new StringBuffer(linea);

                int i = 0, cont = 0, valor, jug, tamanyo;
                jug = conversion(bf.charAt(i));

                tamanyo = jug * 7;

                i++;
                while (i < tamanyo) {
                    mano = new Carta[2];
                    i += 3; //Leemos el Jx

                    while (cont < 2) { //Leemos las cartas que tiene cada jugador en su mano
                        valor = conversion(bf.charAt(i));
                        mano[cont] = new Carta(valor, bf.charAt(i + 1));
                        i += 2;
                        cont++;
                    }
                    cont = 0;
                    cartasMano.add(mano);
                }
                i++;
                mesa = new Carta[5];

                tamanyo += 12;

                while (i < tamanyo) { //Leemos las cartas de la mesa
                    valor = conversion(bf.charAt(i));
                    mesa[cont] = new Carta(valor, bf.charAt(i + 1));
                    i += 2;
                    cont++;
                }

                for (int j = 0; j < cartasMano.size(); j++) //A�adimos todas las cartas de la mesa
                {
                    cartasMesa.add(mesa);
                }
             cartas.setSize(cartasMano.size());
             listaCartas.add(cartas);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        }
        
        return listaCartas;
	}
 

}