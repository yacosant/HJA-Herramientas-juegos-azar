/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guihja;

import java.util.ArrayList;

/**
 *
 * @author YVCX
 */
public class LogicaGui {
    
    private static double porcentaje;
    private static Tablero t;
       
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
    
    public void pintarPorcentaje(Tablero t, ArrayList<Posicion> posiciones){
        int x,y;
        for(int i=0;i<posiciones.size();i++){
            x=posiciones.get(i).getX();
            y=posiciones.get(i).getY();
            t.pintar(x+2, y+2, 1);
        }
        
    }
    
    public static void pulsacion(String s){
        int a,b,i=0;
        double valor=0;
        char c;
      
            a=LogicaGui.CharToInt(s.charAt(i));
            b=LogicaGui.CharToInt(s.charAt(i+1));
            if(s.length()==3){
                c=s.charAt(2);
                
                if(c=='s') valor+=0.3;
                else if(c=='o'){
                    int temp=a;
                    a=b;
                    b=temp;
                    valor+=0.9;
                }
                
            }
            else  valor+=0.5;
            t.pintar(a,b,0);
       sumar(valor);
   
    }
    
    private static void sumar(double a){
        porcentaje+=a;
    }

    public static void setT(Tablero t) {
        LogicaGui.t = t;
    }
    
}
