package hja;

import java.util.ArrayList;

/**
 *
 * @author Grupo 1
 */

//Clase para el apartado 2
public class CartasModo2 {
	private ArrayList<Carta[]> cartasMano;
	private ArrayList<Carta[]> cartasMesa;
	private int size;

	public CartasModo2(ArrayList<Carta[]> mano, ArrayList<Carta[]> mesa){
		cartasMano=mano;
		cartasMesa=mesa;
		size= cartasMesa.size();
	}

	public ArrayList<Carta[]> getCartasMano() {
		return cartasMano;
	}

	public ArrayList<Carta[]> getCartasMesa() {
		return cartasMesa;
	}


	public ArrayList<Carta[]> juntar(){ //Metodo para juntar el arrayList mano y arrayList mesa
		ArrayList<Carta[]> cartas = new ArrayList<Carta[]>();
		for(int pos=0; pos<size; pos++){

			Carta[] c = new Carta[size+2]; //Creamos un array de Carta con el tamaño de la mesa mas 2 (las cartas de la mano)

			for (int i=0; i<2; i++){ //Cogemos las cartas de la mano
				c[i]=(cartasMano.get(pos)[i]);
			}

			for (int i=0; i<cartasMesa.size(); i++){ //Cogemos las cartas de la mesa
				c[i+2]=(cartasMesa.get(pos)[i]);
			}

			cartas.add(c); 
		}
		return cartas;
	}


	public int getSize() {
		return size;
	}

}
