
package hja;

import java.util.ArrayList;

/**
 *
 * @author Grupo 1
 */
public class Modo3 {
	private ArrayList<Carta> cartas;
	private int peso;
	private int jugador;
        private String mano;

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public int getPeso() {
		return peso;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

}
