/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guihja;
//
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




/**
 *
 * @author Grupo 01
 * 
 */
public class LogicaGui {

	private static double porcentaje;
	private static Tablero t;
	private static ArrayList<Posicion> rango = new ArrayList<Posicion>();
	private static ArrayList<Carta> board = new ArrayList<Carta>();
	private static boolean[][] pulsado = new boolean[13][13];
	private static ArrayList<String> posiciones = new ArrayList<String>();
        
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
			new Posicion(10, 11), new Posicion(4, 13), new Posicion(12, 7), new Posicion(10, 9),
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
                        addCartas(new Posicion(a,b));
		} else {
			restar(valor);
			t.pintar(a, b, color);
                        delCartas(new Posicion(a,b));
		}
		LogicaGui.procesar();
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
	
    private static Carta[] juntar(ArrayList<Carta> board,Combo c) { //Metodo para juntar el arrayList mano y arrayList mesa
        Carta[] cart;
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas=(ArrayList<Carta>)board.clone();
        cartas.add(c.getCarta(1));
        cartas.add(c.getCarta(2));
        
        cart = new Carta[cartas.size()];
        for(int i=0; i<cartas.size(); i++) cart[i]=cartas.get(i);
        
        return cart;
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
				combo = new Combo(new Carta(x,'h'),new Carta(y,'c'));
		}else if(o >= 3 && o < 6){
			if(o == 3)
				combo = new Combo(new Carta(x,'s'),new Carta(y,'h'));
			else if(o == 4)
				combo = new Combo(new Carta(x,'s'),new Carta(y,'d'));
			else
				combo = new Combo(new Carta(x,'s'),new Carta(y,'c'));
		}else if(o >= 6 && o < 9){
			if(o == 6)
				combo = new Combo(new Carta(x,'d'),new Carta(y,'h'));
			else if(o == 7)
				combo = new Combo(new Carta(x,'d'),new Carta(y,'c'));
			else
				combo = new Combo(new Carta(x,'d'),new Carta(y,'s'));
		}else{
			if(o == 9)
				combo = new Combo(new Carta(x,'c'),new Carta(y,'h'));
			else if(o == 10)
				combo = new Combo(new Carta(x,'c'),new Carta(y,'s'));
			else
				combo = new Combo(new Carta(x,'c'),new Carta(y,'d'));
		}
			
		
		return combo;
	}

	private static Combo crearParejaCombo(int p,int x){
		Combo combo;
		if(p < 3){
			if(p == 0)
				combo = new Combo(new Carta(x,'h'),new Carta(x,'s'));
			else if(p == 1)
				combo = new Combo(new Carta(x,'h'),new Carta(x,'c'));
			else
				combo = new Combo(new Carta(x,'h'),new Carta(x,'d'));
		}else if(p >= 3 && p < 5){
			if(p == 3)
				combo = new Combo(new Carta(x,'s'),new Carta(x,'c'));
			else 
				combo = new Combo(new Carta(x,'s'),new Carta(x,'d'));
		}else
			combo = new Combo(new Carta(x,'c'),new Carta(x,'d'));	
		
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
			combo = new Combo(new Carta(x,'c'),new Carta(y,'c'));
		
		return combo;
	}

	public static ArrayList<Combo> reducirCombos(ArrayList<Combo> c,ArrayList<Carta> board){
		
		ArrayList<Combo> combos = c;
		
		for(int i = 0;i < board.size();i++)
			for(int j = 0;j<combos.size();j++)
				if((board.get(i).getColor() == combos.get(j).getCarta(1).getColor() && board.get(i).getValor() == combos.get(j).getCarta(1).getValor())
						|| (board.get(i).getColor() == combos.get(j).getCarta(2).getColor() && board.get(i).getValor() == combos.get(j).getCarta(2).getValor())){
					combos.remove(j);
					j--;
				}
		
		return combos;
	}
	
	private static void procesarCombos(ArrayList<Combo> c,ArrayList<Carta> board){
                
		Carta[] cartas;
                double[] combos = new double[16];
                for(int i=0; i<combos.length; i++) combos[i]=0;
              
		for(int i = 0;i<c.size();i++){
			
			cartas = juntar(board, c.get(i));
			
			if(hayCombo(escaleraDeColor(cartas),c.get(i)))//No sabiamos si tienen que estar ambas cartas del combo o con una vale
				combos[0]++;
			else if (hayCombo(poker(cartas),c.get(i))) 
				combos[1]++;
			else if (hayCombo(full(cartas),c.get(i))) 
				combos[2]++;
			else if (hayCombo(color(cartas),c.get(i))) 
				combos[3]++;
			else if (hayCombo(escalera(cartas),c.get(i)))
				combos[4]++;
			else if (hayCombo(trio(cartas),c.get(i))) 
				combos[5]++;
			else if (hayCombo(doblePareja(cartas),c.get(i)))
				combos[6]++; 
			else if (hayCombo(pareja(cartas),c.get(i)))
				if(overPair(board,c.get(i)))
					combos[7]++;
				else if(topPair(board, pareja(cartas), c.get(i)))
					combos[8]++;
				else if(pocketPair(board, c.get(i)))
					combos[9]++;
				else if(middlePair(board, pareja(cartas), c.get(i)))
					combos[10]++;
				else 
					combos[11]++; //pareja debil
			
			else
				combos[12]++;
			
			
			if(hayCombo(buscarProyectoC(cartas),c.get(i)))//proyecto color
				combos[13]++;
			
			if(hayCombo(proyectoEscAbierta(cartas),c.get(i)))//proyecto esc abierta
				combos[14]++;
			
			if(hayCombo(proyectoGut(cartas),c.get(i)))
				combos[15]++;
			
			
		}
		CombosGui.setValues(combos, c.size());//pasar los contadores de combos de arriba visualmente 
		
	}
	
	 private static boolean hayCombo(Carta[] cartas,Combo c){
		
		 boolean combo = false;
		 
		 if(cartas != null)
			 for(int i = 0;i<cartas.length;i++)
				 if((cartas[i].getValor() == c.getCarta(1).getValor() && cartas[i].getColor() == c.getCarta(1).getColor()) ||
						 (cartas[i].getValor() == c.getCarta(2).getValor() && cartas[i].getColor() == c.getCarta(2).getColor()))
					 combo = true;
					 
		 return combo;
	 }
	 
	 private static Carta[] escaleraDeColor(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 ordenador(cartas);
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
			 if (cart == 3 && cont < cartas.length-1) {
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

	 private static Carta[] poker(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[4];
		 int cont = 0;
		 for (int i = 0; i < cartas.length - 1; i++) {
			 cont = 0;
			 for (int j = i + 1; j < cartas.length; j++) {
				 if (cartas[i].getValor() == cartas[j].getValor()) {
					 mejoresCartas[cont] = cartas[j];
					 cont++;
					 if (cont == 3) { // a�adimos la ultima carta
						 mejoresCartas[cont] = cartas[i];
						 return mejoresCartas;
					 }
				 }
			 }
		 }
		 return null;
	 }
	
	 private static Carta[] full(Carta[] cartas) {

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

				 for (int i = 0; i < cartas.length; i++) {
					 if (i < mejoresCartasTrio.length && mejoresCartasTrio[i].getValor() == -1) 
						 mejoresCartasTrio[i].setValor(valor);
					 
					 if(cartas[i].getValor() == -1)
						 cartas[i].setValor(valor);
						 
					 
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
	 
	 private static Carta[] color(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 int cont = cartas.length-1, color, j;
		 boolean col = false;


		 while (cont > 0 && !col) {
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
	 
	 private static Carta[] escalera(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[5];
		 ordenador(cartas);
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
			 if (cart == 3 && cont < cartas.length-1) {
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
	 
	 private static Carta[] trio(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[3];
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
	 
	 private static Carta[] doblePareja(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[4];
		 mejoresCartas[0] = new Carta(0,'h');
		 boolean salir = true;
		 int cont = 0, i = cartas.length - 1, j;
		 while (i > 0) {
			 j = i - 1;
			 salir = true;
			 while (j >= 0 && salir) {
				 if (cartas[i].getValor() == cartas[j].getValor() && cartas[i].getValor() != mejoresCartas[0].getValor()) {
					 mejoresCartas[cont] = cartas[i];
					 mejoresCartas[cont + 1] = cartas[j];
					 cont += 2;
					 salir = false;
					 if (cont > 2)
						 return mejoresCartas;
					 
				 }
				 j--;
			 }
			 i--;
		 }
		 return null;
	 }
	 
	 private static Carta[] pareja(Carta[] cartas) {
		 Carta[] mejoresCartas = new Carta[2];
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
	 
	 private static int cartaAlta(ArrayList<Carta> board){
		 
		 int max = 0;
		 
		 for(int i = 0;i<board.size();i++)
			 if(board.get(i).getValor() > max)
				 max = board.get(i).getValor();
		 
		 return max;
	 }
	 
	 private static int segundaCartaAlta(ArrayList<Carta> board){
		 int max = cartaAlta(board);
		 int segunda = 0;
		 
		 for(int i = 0; i < board.size();i++)
			 if(board.get(i).getValor() > segunda && board.get(i).getValor() != max)
				 segunda = board.get(i).getValor();
		 
		 return segunda;
	 }
	 
	 private static boolean overPair(ArrayList<Carta> board,Combo c){
		 boolean op = false;
		 int max = cartaAlta(board);
		 
		 if(c.getCarta(1).getValor() == c.getCarta(2).getValor())
			 if(max < c.getCarta(1).getValor())
				 op = true;
		 
		 return op;
	 }
	 
	 private static boolean topPair(ArrayList<Carta> board,Carta[] pareja,Combo c){
		 boolean tp = false;
		 int max = cartaAlta(board);
		 
		 if(c.getCarta(1).getValor() != c.getCarta(2).getValor())
			 if(max == pareja[0].getValor())
				 tp = true;
		 

		 return tp;
	 }
	 
	 private static boolean pocketPair(ArrayList<Carta> board,Combo c){
		 boolean pp = false;
		 
		 int max = cartaAlta(board),segunda = segundaCartaAlta(board);
		 
		 if(c.getCarta(1).getValor() == c.getCarta(2).getValor())
			 if(max > c.getCarta(1).getValor() && segunda < c.getCarta(1).getValor())
				 pp = true;
		 
		 return pp;
	 }

	 private static boolean middlePair(ArrayList<Carta> board,Carta[] pareja,Combo c){
		 boolean mp = false;
		 int segunda = segundaCartaAlta(board);
		 
		 if(c.getCarta(1).getValor() != c.getCarta(2).getValor())
			 if(segunda == pareja[0].getValor())
				 mp = true;
		
		 return mp;
	 }
         
    public static void procesar(/*ArrayList<Posicion> cartas,ArrayList<Carta> board*/){
    	if(board.size() >= 3 && !rango.isEmpty()){
    		ArrayList<Combo> combos= crearCombos(rango);
    		combos = reducirCombos(combos, board);
    		procesarCombos(combos,board);
    	}
        else CombosGui.resetCombos();
    }
         
    private static void addCartas(Posicion p){
        rango.add(p);
    }
    
    public static void addBoard(Carta c){
        board.add(c);
    }
    
    private static void delCartas(Posicion p){
        boolean encontrado=false;
        int i=0;
        while(!encontrado && i < rango.size()){
            if(rango.get(i).getX()==p.getX() && rango.get(i).getY()==p.getY())encontrado=true;
        i++;
        }
        if(encontrado) rango.remove(i-1);
        
    }
    
    public static void delBoard(Carta c){
        boolean encontrado=false;
        int i=0;
        while(!encontrado && i < board.size()){
            if(board.get(i).getColor()==c.getColor() && board.get(i).getValor()==c.getValor())encontrado=true;
        i++;
        }
        if(encontrado) board.remove(i-1);
    }
    
    public static void clearBoard(){
        board.clear();
    }
    
    public static void clearTab(){
        rango.clear();
    }
    
    public static void clearPos(){
    	posiciones.clear();
    }
    
    public static int pulsadasBoard(){
        return board.size();
    }
    
    private static void ordenador(Carta[] cartas) { //Metodo para ordenar las cartas. Util para escaleras

        for (int i = 0; i < cartas.length - 1; i++) {
            for (int j = i + 1; j < cartas.length; j++) {
                if (cartas[i].getValor() > cartas[j].getValor()) {
                    Carta aux = cartas[i];
                    cartas[i] = cartas[j];
                    cartas[j] = aux;

                }
            }
        }
    }
    
    private static Carta[] proyectoGut(Carta[] cartas){
    	
    	boolean draw = false,esc = false,seguir = true,gutI=false;
    	Carta[] mejores = new Carta[4];
    	int cont,gut=0;
    	
    	for(int i = 0;i<cartas.length-1 && !esc;i++){
    		cont = 0;
    		seguir = true;
    		if(!draw && cartas[i].getValor()+1 == cartas[i+1].getValor())
    			mejores[cont] = cartas[i];
    		else if(cartas[i].getValor() != cartas[i+1].getValor()){
    			if(!draw && i < cartas.length-2 && cartas[i].getValor()+2 == cartas[i+1].getValor()){    			
    				gutI = true;
    				mejores[cont] = cartas[i];
    			}else
    				seguir = false;
    		}
    		
    		cont++;
    		for(int j = i+1;j<cartas.length-1 && seguir;j++){
    			if(gutI){
    				gut++;
    				gutI = false;
    				if(cartas[j+1].getValor()+1 == cartas[j+2].getValor()){
    					if(cont == 2){
    						mejores[cont] = cartas[j];
    						mejores[cont+1] = cartas[j+1];
    					}else
    						mejores[cont] = cartas[j];
    				}else
    					seguir = false;
    				cont++;
    			}else if(gut <= 1 && !draw && cartas[j].getValor()+1 == cartas[j+1].getValor()){
    				
    				if(cont == 2){
						mejores[cont] = cartas[j];
						mejores[cont+1] = cartas[j+1];
					}else
						mejores[cont] = cartas[j];
				
    				cont++;
    			}else if(cartas[j].getValor()+2 == cartas[j+1].getValor()){
    				if(cont == 2){
    					mejores[cont] = cartas[j];
    					mejores[cont+1] = cartas[j+1];
    				}else
    					mejores[cont] = cartas[j];
    				gut++;
    				j++;
    				cont++;
    				
    			}else if(cont == 3 && cartas[j].getValor() == 5 && cartas[cartas.length-1].getValor() == 14)
    				cont++;
    			else
    				seguir = false;
    			
    		}
    		if(cont == 3)
    			draw = true;
    		else if (cont >= 4){
    			esc = true;
    			draw = false;
    		}
    		
    		gutI = false;
    	}
    	
    	return mejores;
    }

    private static Carta[] proyectoEscAbierta(Carta[] cartas) {

    	boolean draw = false,esc = false,seguir;
    	Carta[] mejores = new Carta[4];
    	int cont;

    	for(int i = 0;i<cartas.length-1 && !esc;i++){
    		cont = 0;
    		seguir = true;
    		if(cartas[i].getValor()+1 != cartas[i+1].getValor())
    			seguir = false;
    		else if(!draw){
    			mejores[cont] = cartas[i];
    			cont++;
    		}else
    			cont++;
    		for(int j = i+1;j<cartas.length-1 && seguir;j++)
    			if(cartas[j].getValor()+1 == cartas[j+1].getValor()){
    				if(!draw){
    					if(cont == 2){
    						mejores[cont] = cartas[j];
    						mejores[cont+1] = cartas[j+1];   						
    					}else
    						mejores[cont] = cartas[j];

    				}
    				cont++;
    			}

    			else if(cont == 3 && cartas[j].getValor() == 5 && cartas[cartas.length-1].getValor() == 14)
    				cont++;
    			else
    				seguir = false;

    		if(cont == 3)
    			draw = true;
    		else if (cont >= 4){
    			esc = true;
    			draw = false;
    		}

    	}
    	
		if(!draw)
			mejores = null;
		
    	return mejores;

    }
    
    private static Carta[] buscarProyectoC(Carta[] cartas) {

        boolean draw = false,color = false;
        Carta[] mejores = new Carta[4];
        int cont;
        
        for(int i = 0;i < cartas.length-1 && !color;i++){
        	cont = 0;
        	for(int j = i + 1;j < cartas.length;j++)
        		if(cartas[i].getColor() == cartas[j].getColor()){
        			if(!draw){
        				if(cont == 2){
        					mejores[cont] = cartas[j];
        					mejores[cont+1] = cartas[i];
        				}else
        					mejores[cont] = cartas[j];
        			}
        			
        			cont++;
        		}
        	
        	if(cont == 3)
        		draw = true;
        	else if(cont >= 4){
        		color = true;
        		draw = false;
        	}
        }
        
        if(!draw)
        	mejores = null;
        

        return mejores;
    }
    
    public static String rango(){
		
    	String rango = "";
    	ArrayList<Posicion> pair = rangoPair(),off = rangoOff(),suited = rangoSuited();
        posiciones.clear();
    	rangoPair(pair);
    	rangoOffSuited(off);
    	rangoSuited(suited);

    	rango = String.join(",",posiciones);
    	return rango;
    	
    }
    
    private static ArrayList<Posicion> rangoPair(){
    	ArrayList<Posicion> pair = new ArrayList<Posicion>();
    	
    	for(int i = 0; i<rango.size();i++)
    		if(rango.get(i).getX() == rango.get(i).getY())
    			pair.add(rango.get(i));
    	
    	return pair;
    }
    
    private static ArrayList<Posicion> rangoOff(){
    	ArrayList<Posicion> off = new ArrayList<Posicion>();
    	
    	for(int i = 0; i<rango.size();i++)
    		if(rango.get(i).getX() < rango.get(i).getY())
    			off.add(rango.get(i));
    	
    	return off;
    }
    
    private static ArrayList<Posicion> rangoSuited(){

    	ArrayList<Posicion> suited = new ArrayList<Posicion>();
    	
    	for(int i = 0; i<rango.size();i++)
    		if(rango.get(i).getX() > rango.get(i).getY())
    			suited.add(rango.get(i));
    	
    	return suited;
    }

	private static void ordenarPos(ArrayList<Posicion> pair){
		
    	Collections.sort(pair, new Comparator<Posicion>(){
    		public int compare(Posicion p1, Posicion p2) {
    			return new Integer(p1.getX()).compareTo(new Integer(p2.getX()));
    		}
    	});
    }
	
	private static void ordenarPosOff(ArrayList<Posicion> pos){
		
    	Collections.sort(pos, new Comparator<Posicion>(){
    		public int compare(Posicion p1, Posicion p2) {
    			Integer a = p1.getY();
    			Integer b = p2.getY();
    	
    			if(a == b)	return new Integer(p1.getX()).compareTo(new Integer(p2.getX()));
    			else 	return new Integer(p2.getY()).compareTo(new Integer(p1.getY()));
    		}
    	});
    }
	
	private static void ordenarPosSuited(ArrayList<Posicion> pair){
		
    	Collections.sort(pair, new Comparator<Posicion>(){
    		public int compare(Posicion p1, Posicion p2) {
    			Integer a = p1.getX();
    			Integer b = p2.getX();
    			if(a == b)	return new Integer(p1.getY()).compareTo(new Integer(p2.getY()));
    			else	return new Integer(p2.getX()).compareTo(new Integer(p1.getX()));
    		}
    	});
    }
	
	private static void rangoPair(ArrayList<Posicion> pair){
    	ordenarPos(pair);
    	int cont;
    	
    	while(!pair.isEmpty()){
    		cont = 0;
    		int min = pair.get(cont).getX();

    		boolean seguir = true;
    		while(seguir && cont < pair.size()-1){
    			if(pair.get(cont).getX()+1 == pair.get(cont+1).getX())
    				cont++;
    			else
    				seguir = false;
    		}
    		
    		if(pair.get(cont).getX() == 14 && cont != 0)
    			addPosicion(intToChar(min) + intToChar(min) + "+");
    		else if(cont > 0)
    			addPosicion(intToChar(pair.get(cont).getX())+ intToChar(pair.get(cont).getX()) + "-" + intToChar(min)+ intToChar(min));
    		else
    			addPosicion(intToChar(min)+intToChar(min));
    		
    		for(int i = 0;i<=cont;i++)
    			pair.remove(0);

    	}
	}
	
	private static void rangoSuited(ArrayList<Posicion> suited){
		
    	ordenarPosSuited(suited);
    	int cont;
    	
    	while(!suited.isEmpty()){
    		cont = 0;
    		int min = suited.get(cont).getX(),min2 = suited.get(cont).getY();

    		boolean seguir = true;
    		while(seguir && cont < suited.size()-1){
    			if(suited.get(cont).getX() == suited.get(cont+1).getX() && suited.get(cont).getY()+1 == suited.get(cont+1).getY())
    				cont++;
    			else
    				seguir = false;
    		}
    		
    		if(suited.get(cont).getX()-1 == suited.get(cont).getY() && cont != 0)
    			addPosicion(intToChar(min) + intToChar(min2)+"s" + "+");
    		else if(cont > 0)
    			addPosicion(intToChar(suited.get(cont).getX())+ intToChar(suited.get(cont).getY())+"s" + "-" + intToChar(min)+ intToChar(min2)+"s");
    		else
    			addPosicion(intToChar(min)+intToChar(min2)+"s");
    		
    		for(int i = 0;i<=cont;i++)
    			suited.remove(0);

    	}
	}
	
	private static void rangoOffSuited(ArrayList<Posicion> off){
		
    	ordenarPosOff(off);
    	int cont;
    	
    	while(!off.isEmpty()){
    		cont = 0;
    		int min = off.get(cont).getY(),min2 = off.get(cont).getX();

    		boolean seguir = true;
    		while(seguir && cont < off.size()-1){
    			if(off.get(cont).getY() == off.get(cont+1).getY() && off.get(cont).getX()+1 == off.get(cont+1).getX())
    				cont++;
    			else
    				seguir = false;
    		}
    		
    		if(off.get(cont).getY()-1 == off.get(cont).getX() && cont != 0)
    			addPosicion(intToChar(min) + intToChar(min2)+"o" + "+");
    		else if(cont > 0)
    			addPosicion(intToChar(off.get(cont).getY())+ intToChar(off.get(cont).getX())+ "o" + "-" + intToChar(min)+ intToChar(min2)+"o");
    		else
    			addPosicion(intToChar(min)+intToChar(min2)+"o");
    		
    		for(int i = 0;i<=cont;i++)
    			off.remove(0);

    	}
	}
	
    public static void addPosicion(String valor){
        posiciones.add(valor);
    }
    
	
}


