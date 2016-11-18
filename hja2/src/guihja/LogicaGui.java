/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guihja;

/**
 *
 * @author YVCX
 */
public class LogicaGui {
    
    private static double porcentaje;
    static final Posicion[] ranking = {new Posicion(14,14),new Posicion(13,13),new Posicion(14,13)};
       
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
        return porcentaje;
    }

    public static void setPorcentaje(double porcentaje) {
        LogicaGui.porcentaje = porcentaje;
    }
    
    public static void sumarPorcentaje(int i, int j){
    	if(i == j)
    		LogicaGui.porcentaje += 0.45;
    	else if (i<j)
    		LogicaGui.porcentaje += 0.9;
    	else
    		LogicaGui.porcentaje += 0.3;
    }
    
    public static void restarPorcentaje(int i, int j){
    	if(i == j)
    		LogicaGui.porcentaje -= 0.45;
    	else if (i<j)
    		LogicaGui.porcentaje -= 0.9;
    	else
    		LogicaGui.porcentaje -= 0.3;
    }
    
    public static String porcentajeString(){
    	return String.valueOf(redondear(LogicaGui.porcentaje,2));
    }
    
    public static double redondear(double numero,int digitos){ 
    	int cifras=(int) Math.pow(10,digitos);         
    	return Math.rint(numero*cifras)/cifras;    
    }

    
}
