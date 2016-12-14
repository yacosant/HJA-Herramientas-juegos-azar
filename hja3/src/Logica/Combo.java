package Logica;

import java.util.ArrayList;

/**
 *
 * @author Grupo 1
 *
 */
public class Combo {

    private Carta carta1;
    private Carta carta2;
    private int peso;
    private int victorias;
    private ArrayList<Carta> mejorMano;

    public Carta getCarta(int i) {
        Carta carta;

        if (i == 1) {
            carta = carta1;
        } else {
            carta = carta2;
        }

        return carta;
    }

    public Combo(Carta carta1, Carta carta2) {
        this.carta1 = carta1;
        this.carta2 = carta2;

    }

	public void setPeso(int peso) {
		this.peso= peso;
		
	}

	public void setCartas(ArrayList<Carta> listaCarta) {
		this.mejorMano = listaCarta;
		
	}

	public int getPeso() {
		return this.peso;
	}

	public ArrayList<Carta> getCartas() {
		return this.mejorMano;
	}
	
	public int getVictorias(){
		return this.victorias;
	}
	
	public void setVictorias(int victorias){
		this.victorias=victorias;
	}

}
