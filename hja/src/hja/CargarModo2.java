package hja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CargarModo2 extends Cargar<CartasModo2>{
	
	public CargarModo2(){
		super();
	}
	
	@Override
	public CartasModo2 cargar(String archivo) {
        CartasModo2 cartas = new CartasModo2(cartasMano, cartasMesa);
        File fichero = new File(archivo);
        int num = 0;
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

                while (cont < 2) { //Primero cargamos las cartas de la mano
                    valor = conversion(bf.charAt(i));
                    mano[cont] = new Carta(valor, bf.charAt(i + 1));
                    i += 2;
                    cont++;
                }

                i++;
                num = conversion(bf.charAt(i));
                i += 2;

                mesa = new Carta[num];
                cont = 0;

                while (cont < num) { //Cargamos las cartas de la mesa
                    valor = conversion(bf.charAt(i));
                    mesa[cont] = new Carta(valor, bf.charAt(i + 1));
                    i += 2;
                    cont++;
                }

                cartasMano.add(mano);
                cartasMesa.add(mesa);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        }
        cartas.setSize(cartasMano.size());
        return cartas;

	}

}