package guihja;

public class Combo {

	private int peso;
	private Carta carta1;
	private Carta carta2;
	
	public int getPeso(int peso){
		return peso;
	}
	
	public void setPeso(int peso){
		this.peso=peso;
	}
	
	public Carta getCarta(int i){
		Carta carta;
		
		if(i==1)
			carta = carta1;
		else
			carta = carta2;
		
		return carta;
	}
	
	
	public Combo(int peso, Carta carta1, Carta carta2){
		this.peso=peso;
		this.carta1=carta1;
		this.carta2=carta2;
		
	}
	
}
