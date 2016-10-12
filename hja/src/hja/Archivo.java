/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivo {
    

    
    static public void guardar(Carta[] cartas){
        String linea="";
        String nombre = "salida.txt";
        //File fichero = new File(nombre);
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(nombre));
          
            for (int i=0;i<5;i++){
             linea = linea + String.valueOf(cartas[i].getValor()) + String.valueOf(cartas[i].getColor());
            }
            buffer.write(linea);
            
            //pintar las conclusiones obtenidas!
            //
            //
            //
            
            buffer.close();
            
        } catch (IOException ex) {
            System.err.println("Error: Ha habido algun problema al crear el archivo.");
        }
        
    }
}
