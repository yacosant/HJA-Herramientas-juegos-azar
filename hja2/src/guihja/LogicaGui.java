/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guihja;

import java.util.ArrayList;



/**
 *
 * @author Grupo 01
 * 
 */
public class LogicaGui {

	private static double porcentaje;
	private static Tablero t;
	private static ArrayList<Posicion> rango;
	private static boolean[][] pulsado = new boolean[13][13];
	private final static Posicion[] ranking = { new Posicion(14, 14), new Posicion(13, 13), new Posicion(14, 13),
			new Posicion(12, 12), new Posicion(13, 14), new Posicion(11, 11),
			new Posicion(14, 12), new Posicion(10, 10), new Posicion(12, 14), new Posicion(9, 9), new Posicion(14, 11),
			new Posicion(8, 8), new Posicion(14, 10), new Posicion(11, 14), new Posicion(7, 7), new Posicion(6, 6),
			new Posicion(10, 14), new Posicion(14, 9), new Posicion(5, 5), new Posicion(14, 8), new Posicion(13, 12),
			new Posicion(4, 4), new Posicion(9, 14), new Posicion(14, 7), new Posicion(13, 11), new Posicion(14, 5),
			new Posicion(8, 14), new Posicion(14, 6), new Posicion(14, 4), new Posicion(3, 3),
			new Posicion(13, 10), new Posicion(7, 14), new Posicion(14, 3), new Posicion(12, 13), new Posicion(14, 2),
			new Posicion(5, 14), new Posicion(6, 14), new Posicion(4, 14), new Posicion(11, 13), new Posicion(12, 11),
			new Posicion(3, 14), new Posicion(2, 2), new Posicion(13, 9), new Posicion(2, 14), new Posicion(10, 13),
			new Posicion(12, 10), new Posicion(13, 8), new Posicion(13, 7), new Posicion(11, 10), new Posicion(9, 13),
			new Posicion(13, 6), new Posicion(11, 12), new Posicion(12, 9), new Posicion(13, 5), new Posicion(8, 13),
			new Posicion(13, 4), new Posicion(10, 12), new Posicion(7, 13), new Posicion(13, 3), new Posicion(12, 8),
			new Posicion(6, 13), new Posicion(13, 2), new Posicion(11, 9), new Posicion(5, 13), new Posicion(9, 12),
			new Posicion(14, 14), new Posicion(10, 11), new Posicion(4, 13), new Posicion(12, 7), new Posicion(10, 9),
			new Posicion(12, 6), new Posicion(3, 13), new Posicion(11, 8), new Posicion(12, 5), new Posicion(2, 13),
			new Posicion(8, 12), new Posicion(12, 4), new Posicion(9, 11), new Posicion(12, 3), new Posicion(10, 8),
			new Posicion(7, 12), new Posicion(11, 7), new Posicion(12, 2), new Posicion(6, 12), new Posicion(9, 8),
			new Posicion(5, 12), new Posicion(8, 11), new Posicion(9, 10), new Posicion(11, 6), new Posicion(11, 5),
			new Posicion(10, 7), new Posicion(4, 12), new Posicion(11, 4), new Posicion(7, 11), new Posicion(3, 12),
			new Posicion(9, 7), new Posicion(8, 10), new Posicion(11, 3), new Posicion(10, 6), new Posicion(2, 12),
			new Posicion(11, 2), new Posicion(8, 7), new Posicion(6, 11), new Posicion(8, 9), new Posicion(7, 10),
			new Posicion(5, 11), new Posicion(9, 6), new Posicion(10, 5), new Posicion(10, 4), new Posicion(8, 6),
			new Posicion(4, 11), new Posicion(10, 3), new Posicion(7, 9), new Posicion(6, 10), new Posicion(9, 5),
			new Posicion(7, 6), new Posicion(3, 11), new Posicion(10, 2), new Posicion(7, 8), new Posicion(8, 5),
			new Posicion(6, 9), new Posicion(2, 11), new Posicion(5, 10), new Posicion(9, 4), new Posicion(7, 5),
			new Posicion(4, 10), new Posicion(6, 5), new Posicion(9, 3), new Posicion(6, 8), new Posicion(8, 4),
			new Posicion(5, 9), new Posicion(3, 10), new Posicion(6, 7), new Posicion(9, 2), new Posicion(7, 4),
			new Posicion(5, 8), new Posicion(2, 10), new Posicion(5, 4), new Posicion(6, 4), new Posicion(8, 3),
			new Posicion(5, 7), new Posicion(4, 9), new Posicion(8, 2), new Posicion(7, 3), new Posicion(3, 9),
			new Posicion(5, 3), new Posicion(5, 6), new Posicion(2, 9), new Posicion(4, 8), new Posicion(6, 3),
			new Posicion(4, 3), new Posicion(4, 7), new Posicion(4, 5), new Posicion(7, 2), new Posicion(3, 8),
			new Posicion(6, 2), new Posicion(4, 6), new Posicion(5, 2), new Posicion(2, 8), new Posicion(4, 2),
			new Posicion(3, 7), new Posicion(3, 6), new Posicion(3, 5), new Posicion(3, 2), new Posicion(3, 4),
			new Posicion(2, 7), new Posicion(2, 6), new Posicion(2, 5), new Posicion(2, 4), new Posicion(2, 3) };

	public static String intToChar(int valor) {
		String carta = null;
		switch (valor) {
		case 10:
			carta = "T";
			break;
		case 11:
			carta = "J";
			break;
		case 12:
			carta = "Q";
			break;
		case 13:
			carta = "K";
			break;
		case 14:
			carta = "A";
			break;
		default:
			carta = Integer.toString(valor);
			break;
		}
		return carta;
	}

	public static int CharToInt(char valor) {
		int carta;
		switch (valor) {
		case 'T':
			carta = 10;
			break;
		case 'J':
			carta = 11;
			break;
		case 'Q':
			carta = 12;
			break;
		case 'K':
			carta = 13;
			break;
		case 'A':
			carta = 14;
			break;
		case 't':
			carta = 10;
			break;
		case 'j':
			carta = 11;
			break;
		case 'q':
			carta = 12;
			break;
		case 'k':
			carta = 13;
			break;
		case 'a':
			carta = 14;
			break;
		default:
			carta = Character.getNumericValue(valor);
			break;
		}
		return carta;
	}

	public static double getPorcentaje() {
		double p = Math.round(porcentaje * 100);
		return (p / 100);
	}

	public static void setPorcentaje(double porcentaje) {
		LogicaGui.porcentaje = porcentaje;
	}

	public static void pulsacion(String s) {
		int a, b, i = 0, color = 3;
		double valor = 0;
		char c;

		a = LogicaGui.CharToInt(s.charAt(i));
		b = LogicaGui.CharToInt(s.charAt(i + 1));
		if (s.length() == 3) {
			c = s.charAt(2);

			if (c == 's') {
				valor += 0.3;
				color = 4;
			} else if (c == 'o') {
				int temp = a;
				a = b;
				b = temp;
				valor += 0.9;
				color = 2;
			}

		} else
			valor += 0.45;

		if (!marcado(a, b)) {
			sumar(valor);
			t.pintar(a, b, 0);
                        Principal.addPosicion(s);
		} else {
			restar(valor);
			t.pintar(a, b, color);
                        Principal.deletePosiciones(s);
		}
		pulsar(a, b, !marcado(a, b));
                
	}

	public static void sumarPorcentaje(int i, int j) {
		if (i == j)
			porcentaje += 0.45;
		else if (i < j)
			porcentaje += 0.9;
		else
			porcentaje += 0.3;

		pulsar(i, j, true);
	}

	public static double restarPorcentaje(double valor, int i, int j) {
		if (i == j)
			valor -= 0.45;
		else if (i < j)
			valor -= 0.9;
		else
			valor -= 0.3;

		return valor;

	}

	private static boolean marcado(int a, int b) {
		return pulsado[a - 2][b - 2];
	}

	private static void sumar(double i) {
		porcentaje += i;
	}

	public static void restar(double i) {
		porcentaje -= i;
	}

	public static String porcentajeString() {
		return String.valueOf(redondear(LogicaGui.porcentaje, 2));
	}

	public static double redondear(double numero, int digitos) {
		int cifras = (int) Math.pow(10, digitos);
		return Math.rint(numero * cifras) / cifras;
	}

	public static void setT(Tablero tab) {
		t = tab;
	}

	public static void pulsar(int a, int b, boolean val) {
		pulsado[a - 2][b - 2] = val;
	}

	public static void pintarPor(double valor, Tablero t2) {
		int i = 0, x, y;
		rango = new ArrayList<Posicion>();
		t2.reset();
		while (valor > 0) {
			x = ranking[i].getX();
			y = ranking[i].getY();
			t2.pintar(x, y, 1);
			rango.add(ranking[i]);// El rango que mostramos por pantalla
			valor = LogicaGui.restarPorcentaje(valor, x, y);

			i++;
		}
	}
	

    public ArrayList<Carta> juntar(ArrayList<Carta> board,Combo c) { //Metodo para juntar el arrayList mano y arrayList mesa
        ArrayList<Carta> cartas = board;

        cartas.add(c.getCarta(1));
        cartas.add(c.getCarta(2));
        
        return cartas;
    }
    
	public static ArrayList<Combo> crearCombos(ArrayList<Posicion> rango){
		ArrayList<Combo> combos = new ArrayList<Combo>();
		for(int i = 0;i<rango.size();i++){
			int x,y;
			x = rango.get(i).getX();
			y = rango.get(i).getY();
			if(x == y)
				for(int p = 0; p<6;p++)
					combos.add(crearParejaCombo(p,x));
			else if(x > y)
				for(int s = 0;s<4;s++)
					combos.add(crearSuitedCombo(s,x,y));
			else
				for(int o = 0; o<12;o++)
					combos.add(crearOffCombo(o,x,y));
		}
		return combos;
	}
		
	private static Combo crearOffCombo(int o, int x, int y) {
		Combo combo;
		
		if(o < 3){
			if(o == 0)
				combo = new Combo(new Carta(x,'h'),new Carta(y,'s'));
			else if(o == 1)
				combo = new Combo(new Carta(x,'h'),new Carta(y,'d'));
			else
				combo = new Combo(new Carta(x,'h'),new Carta(y,'t'));
		}else if(o >= 3 && o < 6){
			if(o == 3)
				combo = new Combo(new Carta(x,'s'),new Carta(y,'h'));
			else if(o == 4)
				combo = new Combo(new Carta(x,'s'),new Carta(y,'d'));
			else
				combo = new Combo(new Carta(x,'s'),new Carta(y,'t'));
		}else if(o >= 6 && o < 9){
			if(o == 6)
				combo = new Combo(new Carta(x,'d'),new Carta(y,'h'));
			else if(o == 7)
				combo = new Combo(new Carta(x,'d'),new Carta(y,'t'));
			else
				combo = new Combo(new Carta(x,'d'),new Carta(y,'s'));
		}else{
			if(o == 9)
				combo = new Combo(new Carta(x,'t'),new Carta(y,'h'));
			else if(o == 10)
				combo = new Combo(new Carta(x,'t'),new Carta(y,'s'));
			else
				combo = new Combo(new Carta(x,'t'),new Carta(y,'d'));
		}
			
		
		return combo;
	}

	private static Combo crearParejaCombo(int p,int x){
		Combo combo;
		if(p < 3){
			if(p == 0)
				combo = new Combo(new Carta(x,'h'),new Carta(x,'s'));
			else if(p == 1)
				combo = new Combo(new Carta(x,'h'),new Carta(x,'t'));
			else
				combo = new Combo(new Carta(x,'h'),new Carta(x,'d'));
		}else if(p >= 3 && p < 5){
			if(p == 3)
				combo = new Combo(new Carta(x,'s'),new Carta(x,'t'));
			else 
				combo = new Combo(new Carta(x,'s'),new Carta(x,'d'));
		}else
			combo = new Combo(new Carta(x,'t'),new Carta(x,'d'));	
		
		return combo;
	}
	
	private static Combo crearSuitedCombo(int s,int x,int y){
		Combo combo;
		
		if(s == 0)
			combo = new Combo(new Carta(x,'h'),new Carta(y,'h'));
		else if(s == 1)
			combo = new Combo(new Carta(x,'s'),new Carta(y,'s'));
		else if(s == 2)
			combo = new Combo(new Carta(x,'d'),new Carta(y,'d'));
		else 
			combo = new Combo(new Carta(x,'t'),new Carta(y,'t'));
		
		return combo;
	}
	

	public static ArrayList<Combo> reducirCombos(ArrayList<Combo> c,ArrayList<Carta> board){
		
		ArrayList<Combo> combos = c;
		
		for(int i = 0;i < board.size();i++)
			for(Combo com : combos)
				if((board.get(i).getColor() == com.getCarta(1).getColor() && board.get(i).getValor() == com.getCarta(1).getValor())
						|| (board.get(i).getColor() == com.getCarta(2).getColor() && board.get(i).getValor() == com.getCarta(2).getValor()))
					combos.remove(com);
		
		return combos;
	}
	
	public void procesarCombos(ArrayList<Combo> c,ArrayList<Carta> board){

		Carta[] cartas;
		int sf=0,quads=0,full=0,flush=0,straight=0,trio=0,dp=0,nhm=0,totalCombos=c.size();
		
		for(int i = 0;i<c.size();i++){
			
			cartas = (guihja.Carta[]) juntar(board, c.get(i)).toArray();
			
			if(hayCombo(escaleraDeColor(cartas),c.get(i)))
				sf++;
			else if (hayCombo(poker(cartas),c.get(i))) 
				quads++;
			else if (hayCombo(full(cartas),c.get(i))) 
				full++;
			else if (hayCombo(color(cartas),c.get(i))) 
				flush++;
			else if (hayCombo(escalera(cartas),c.get(i)))
				straight++;
			else if (hayCombo(trio(cartas),c.get(i))) 
				trio++;
			else if (hayCombo(doblePareja(cartas),c.get(i)))
				dp++; 
			else if (hayCombo(pareja(cartas),c.get(i)))
				;//segun el valor de la pareja sera uno u otro
			else
				nhm++;
			
			
		}
		
		//pasar los contadores de combos de arriba visualmente con algun metodo
	}
	
	 private boolean hayCombo(Carta[] cartas,Combo c){
		
		 boolean combo = false;
		 
		 if(cartas != null)
			 for(int i = 0;i<cartas.length;i++)
				 if((cartas[i].getValor() == c.getCarta(1).getValor() && cartas[i].getColor() == c.getCarta(1).getColor()) ||
						 (cartas[i].getValor() == c.getCarta(2).getValor() && cartas[i].getColor() == c.getCarta(2).getColor()))
					 combo = true;
					 
		 return combo;
	}
	 
	 private Carta[] escaleraDeColor(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];

		 int cont = 0, cart = 0;
		 boolean esc = false, escA = false;

		 while (cont < cartas.length - 1 && !escA) {

			 if (cartas[cont].getColor() == cartas[cont + 1].getColor()
					 && cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()) {
				 if (!esc) {
					 mejoresCartas[cart] = cartas[cont];
					 if (cart < 5) {
						 cart++;
					 }
				 } else {
					 for (int i = 0; i < mejoresCartas.length - 1; i++) {
						 mejoresCartas[i] = mejoresCartas[i + 1];
					 }

					 mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				 }
			 } else {
				 if (cart == 5) {
					 for (int i = 0; i < mejoresCartas.length - 1; i++) {
						 mejoresCartas[i] = mejoresCartas[i + 1];
					 }
					 mejoresCartas[cart - 1] = cartas[cont];
				 }
				 cart = 0;
			 }
			 cont++;

			 //Unico caso de escalera 1,2,3,4,5
			 if (cart == 3) {
				 if (cartas[cont + 1].getValor() != 6 && cartas[cont].getValor() == 5 && cartas[cartas.length - 1].getValor() == 14
						 && mejoresCartas[2].getColor() == cartas[cont].getColor() && mejoresCartas[2].getColor() == cartas[cartas.length - 1].getColor()) {
					 mejoresCartas[cart] = cartas[cont];
					 mejoresCartas[cart + 1] = cartas[cartas.length - 1];
					 esc = true;
					 escA = true;
				 }
			 } else if (cart == 5) {
				 esc = true;
			 }
		 }

		 if (!escA && cartas[cont].getColor() == cartas[cont - 1].getColor()
				 && cartas[cont].getValor() == cartas[cont - 1].getValor() + 1) {
			 if (esc == true) {
				 for (int i = 0; i < mejoresCartas.length - 1; i++) {
					 mejoresCartas[i] = mejoresCartas[i + 1];
				 }
				 mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
			 } else if (cart == 4) {
				 mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				 esc = true;
			 }
		 }

		 if (!esc) 
			 mejoresCartas = null;


		 return mejoresCartas;

	 }

	 private Carta[] poker(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 int cont = 0;
		 for (int i = 0; i < cartas.length - 1; i++) {
			 cont = 0;
			 for (int j = i + 1; j < cartas.length; j++) {
				 if (cartas[i].getValor() == cartas[j].getValor()) {
					 mejoresCartas[cont] = cartas[i];
					 cont++;
					 if (cont == 3) { // a�adimos la ultima carta
						 mejoresCartas[cont] = cartas[j];
						 return mejoresCartas;
					 }
				 }
			 }
		 }
		 return null;
	 }
	
	 private Carta[] full(Carta[] cartas) {

		 Carta[] mejoresCartas = new Carta[5];
		 Carta[] mejoresCartasTrio = new Carta[3];
		 Carta[] mejoresCartasPareja = new Carta[2];

		 mejoresCartasTrio = trio(cartas);
		 if (mejoresCartasTrio != null) {

			 int valor = mejoresCartasTrio[0].getValor();

			 for (int i = 0; i < cartas.length; i++) {
				 if (valor == cartas[i].getValor()) {
					 cartas[i].setValor(-1);
				 }
			 }

			 mejoresCartasPareja = pareja(cartas);
			 if (mejoresCartasPareja != null) {

				 for (int i = 0; i < mejoresCartasTrio.length - 2; i++) {
					 if (mejoresCartasTrio[i].getValor() == -1) {
						 mejoresCartasTrio[i].setValor(valor);
					 }
				 }

				 mejoresCartas[0] = mejoresCartasTrio[0];
				 mejoresCartas[1] = mejoresCartasTrio[1];
				 mejoresCartas[2] = mejoresCartasTrio[2];
				 mejoresCartas[3] = mejoresCartasPareja[0];
				 mejoresCartas[4] = mejoresCartasPareja[1];
				 return mejoresCartas;

			 } else {
				 for (int i = 0; i < cartas.length; i++) {
					 if (cartas[i].getValor() == -1) {
						 cartas[i].setValor(valor);
					 }
				 }
			 }
		 }
		 return null;
	 }
	 
	 private Carta[] color(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 int cont = cartas.length-1, color, j;
		 boolean col = false;


		 while (cont >= 0 && !col) {
			 color = 0;
			 j = cont - 1;
			 mejoresCartas[color] = cartas[cont];
			 color++;
			 while (j >= 0) {
				 if (mejoresCartas[0].getColor() == cartas[j].getColor()) {
					 mejoresCartas[color] = cartas[j];
					 color++;
				 }
				 if (color == 5) {
					 return mejoresCartas;
				 }

				 j--;
			 }
			 color = 0;
			 cont--;
		 }
		 return null;
	 }
	 
	 private Carta[] escalera(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];

		 int cont = 0, cart = 0;
		 boolean esc = false, escA = false;

		 while (cont < cartas.length - 1 && !escA) {

			 if (cartas[cont].getValor() + 1 == cartas[cont + 1].getValor()) {
				 if (!esc) {
					 mejoresCartas[cart] = cartas[cont];
					 if (cart < 5) {
						 cart++;
					 }
				 } else {//Si ha habido escalera pero puede ser mayor
					 for (int i = 0; i < mejoresCartas.length - 1; i++) {
						 mejoresCartas[i] = mejoresCartas[i + 1];
					 }

					 mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				 }
			 } else {//penultima pos no coincide con ult pero hacia escalera
				 if (cart == 5) {

					 for (int i = 0; i < mejoresCartas.length - 1; i++) {
						 mejoresCartas[i] = mejoresCartas[i + 1];
					 }
					 mejoresCartas[cart - 1] = cartas[cont];
				 }
				 cart = 0;
			 }
			 cont++;

			 //Unico caso de escalera 1,2,3,4,5
			 if (cart == 3) {
				 if (cartas[cont + 1].getValor() != 6 && cartas[cont].getValor() == 5 && cartas[cartas.length - 1].getValor() == 14) {
					 mejoresCartas[cart] = cartas[cont];
					 mejoresCartas[cart + 1] = cartas[cartas.length - 1];
					 esc = true;
					 escA = true;
				 }
			 } else if (cart == 5) {
				 esc = true;
			 }
		 }
		 //ult pos que no se entra en el bucle
		 if (!escA && cartas[cont].getValor() == cartas[cont - 1].getValor() + 1) {
			 if (esc == true) {
				 for (int i = 0; i < mejoresCartas.length - 1; i++) {
					 mejoresCartas[i] = mejoresCartas[i + 1];
				 }
				 mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
			 } else if (cart == 4) {
				 mejoresCartas[mejoresCartas.length - 1] = cartas[cont];
				 esc = true;
			 }
		 }

		 if (!esc) {
			 mejoresCartas = null;
		 }

		 return mejoresCartas;

	 }
	 
	 private Carta[] trio(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 int cont;
		 for (int i = cartas.length - 1; i > 0; i--) {
			 cont = 0;
			 for (int j = i - 1; j >= 0; j--) {
				 if (cartas[i].getValor() == cartas[j].getValor()) {
					 mejoresCartas[cont] = cartas[j];
					 cont++;
					 if (cont == 2) {
						 mejoresCartas[cont] = cartas[i];
						 return mejoresCartas;
					 }
				 }
			 }
		 }
		 return null;
	 }
	 
	 private Carta[] doblePareja(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 boolean salir = true;
		 int cont = 0, i = cartas.length - 1, j;
		 while (i > 0) {
			 j = i - 1;
			 salir = true;
			 while (j >= 0 && salir) {
				 if (cartas[i].getValor() == cartas[j].getValor()) {
					 mejoresCartas[cont] = cartas[i];
					 mejoresCartas[cont + 1] = cartas[j];
					 cont += 2;
					 salir = false;
					 if (cont > 2) {
						 int k = cartas.length - 1;
						 boolean end = false;
						 while (k > 0 && !end) {
							 if (cartas[k].getValor() != mejoresCartas[0].getValor() && cartas[k].getValor() != mejoresCartas[2].getValor()) {
								 mejoresCartas[4] = cartas[k];
								 end = true;
							 }
							 k--;
						 }
						 return mejoresCartas;
					 }
				 }
				 j--;
			 }
			 i--;
		 }
		 return null;
	 }
	 
	 private Carta[] pareja(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 for (int i = 0; i < cartas.length - 1; i++) {
			 for (int j = i + 1; j < cartas.length; j++) {
				 if (cartas[i].getValor() == cartas[j].getValor() && cartas[i].getValor() != -1) {
					 mejoresCartas[0] = cartas[i];
					 mejoresCartas[1] = cartas[j];

					 return mejoresCartas;
				 }
			 }
		 }
		 return null;
	 }
}


