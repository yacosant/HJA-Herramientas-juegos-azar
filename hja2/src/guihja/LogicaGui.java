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
    
    

}
