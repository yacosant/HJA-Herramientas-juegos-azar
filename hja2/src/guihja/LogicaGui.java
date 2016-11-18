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
    private static boolean[][] pulsado = new boolean[13][13];
    private final Posicion[] ranking={new Posicion(14,14),new Posicion(13,13),new Posicion(14,13), new Posicion(13,14)};
    
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
        double p=Math.round(porcentaje * 100);
        return (p/100);
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
        int a,b,i=0, color=3;
        double valor=0;
        char c;
      
            a=LogicaGui.CharToInt(s.charAt(i));
            b=LogicaGui.CharToInt(s.charAt(i+1));
            if(s.length()==3){
                c=s.charAt(2);
                
                if(c=='s'){
                    valor+=0.3;
                    color=4;
                }
                else if(c=='o'){
                    int temp=a;
                    a=b;
                    b=temp;
                    valor+=0.9;
                    color=2;
                }
                
            }
            else  valor+=0.5;
           
            if(!marcado(a,b)){
                sumar(valor);
                t.pintar(a, b, 0);
            }
            else{
                restar(valor);
                t.pintar(a,b,color);
            } 
            pulsar(a,b,!marcado(a,b));
     }
	
    public static void sumarPorcentaje(int i, int j){
    	if(i == j)
    		porcentaje += 0.45;
    	else if (i<j)
    		porcentaje += 0.9;
    	else
    		porcentaje += 0.3;
        
        pulsar(i,j,true);
    }
     
    private static boolean marcado(int a, int b){
        return pulsado[a-2][b-2];
    }
    
    private static void sumar(double i){
        porcentaje +=i;
    }
    
    public static void restar(double i){
    	porcentaje -=i;
    }
   
    public static String porcentajeString(){
    	return String.valueOf(redondear(LogicaGui.porcentaje,2));
    }

    public static double redondear(double numero,int digitos){ 
    	int cifras=(int) Math.pow(10,digitos);         
    	return Math.rint(numero*cifras)/cifras;    
    }

    public static void setT(Tablero tab) {
        t=tab;
    }

    public static void pulsar(int a,int b, boolean val){
       pulsado[a-2][b-2]=val;
    }
    
}

