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
			new Posicion(12, 12), new Posicion(13, 14), new Posicion(11, 11), new Posicion(14, 14),
			new Posicion(14, 12), new Posicion(10, 10), new Posicion(12, 14), new Posicion(9, 9), new Posicion(14, 11),
			new Posicion(8, 8), new Posicion(14, 10), new Posicion(11, 14), new Posicion(7, 7), new Posicion(6, 6),
			new Posicion(10, 14), new Posicion(14, 9), new Posicion(5, 5), new Posicion(14, 8), new Posicion(13, 12),
			new Posicion(4, 4), new Posicion(9, 14), new Posicion(14, 7), new Posicion(13, 11), new Posicion(14, 5),
			new Posicion(8, 14), new Posicion(14, 6), new Posicion(14, 14), new Posicion(14, 4), new Posicion(3, 3),
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
		} else {
			restar(valor);
			t.pintar(a, b, color);
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

}
