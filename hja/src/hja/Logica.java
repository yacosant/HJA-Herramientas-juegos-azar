/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hja;

/**
 *
 * @author YVCX
 */
public class Logica {
    
    private Carta[] cartas;
    private int cont=0;
    private String[] manos = new String[9];
    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }
        
    void comprobar(){
        
        //aqui s ehacen todas las llamadas a cada uno de los metodos que comprueban una mano.
        //En el array de string se guardan las manos que si se han producido, y en funcion de si se han producido, 
        //el comprobar s eocmprobaran los menores o no, ejemplo: si se han ecncontrado trio no se comprobará pareja
        
       //----
       //Lamadas a:
       
       
       // straight flush(escalerade color)
       
       // four-of-a-kind (or quads) (poker)
       
       // full house (or boat) (full)
       
       // flush(color)
       
       // straight(escalera)
       
       // three-of-a-kind(trío)
       
       // two-pair(doblepareja)
       
       // pair (parejao par)
       
        //high card (carta alta)
        
    }
           
    String escaleraColor(){
        String mano= "";
        
        return mano;
    }
   
    String poker(){
        String mano= "";
        
        return mano;
    }
    
    String full(){
        String mano= "";
        
        return mano;
    }
    
    String color(){
        String mano= "";
        
        return mano;
    }
       
     String escalera(){
        String mano= "";
        
        return mano;
    }
     
    String trio(){
        String mano= "";
        
        return mano;
    }
    
    String doblePareja(){
        String mano= "";
        
        return mano;
    }
    
        void pareja(int a){
        boolean cierto= false;
        int i=0, j;
        char anterior =cartas[a].getValor();
        
        while( i<5 && !cierto){
           j=0;
           char carta= cartas[i].getValor();
           if(carta!=anterior){
                while( j<5 && !cierto){
                    if(i!=j){
                        char c= cartas[j].getValor();
                        if(carta==c){
                            cierto=true;
                            manos[cont]="Pareja";
                            cont++;
                        }
                    }
                    j++;
                }
           }
           }
           i++;
    }
    
    void pareja1(){
        boolean cierto= false;
        int i=0, j;
        
        while( i<5 && !cierto){
           j=0;
            char carta= cartas[i].getValor();
           
           while( j<5 && !cierto){
               if(i!=j){
                   char c= cartas[j].getValor();
                   if(carta==c){
                       cierto=true;
                       manos[cont]="Pareja";
                       cont++;
                   }
               }
               j++;
           }
           }
           i++;
    }
         
    void cartaAlta(){
        boolean cierto =false;
        int i=0;
        
        while( i<5 && !cierto){
           char c= cartas[i].getValor();
           if(c=='A' || c=='K' || c=='Q' || c=='J'){
               cierto=true;
               manos[cont]="Carta Alta";
               cont++;
           }
           i++;
        }
    }
}
