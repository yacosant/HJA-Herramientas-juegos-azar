package hja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Cargar <T>{
	 protected ArrayList<String> lineas;
	 protected ArrayList<Carta[]> cartasMano;
	 protected ArrayList<Carta[]> cartasMesa;
	 
	 
	 public Cargar() {
	      this.lineas = new ArrayList<String>();
	      this.cartasMano = new ArrayList<Carta[]>();
	      this.cartasMesa = new ArrayList<Carta[]>();
	    }
	 
	 public abstract T cargar(String archivo);
	 
	 public void guardar(String nombre, String texto, int cont) { //Metodo para guardar en un archivo la respuesta

	        File fichero = new File(nombre);
	        try {
	            FileWriter salida = new FileWriter(fichero, true);

	            if (cont == 0) {
	                BufferedWriter buffer = new BufferedWriter(new FileWriter(nombre));
	                buffer.write(lineas.get(cont));
	                buffer.write("\r\n");
	                buffer.write(texto);
	                buffer.write("\r\n");
	                buffer.close();
	            } else {
	                salida.write(lineas.get(cont));
	                salida.write("\r\n");
	                salida.write(texto);
	                salida.write("\r\n");
	                salida.close();
	            }

	        } catch (IOException ex) {
	            System.err.println("Error: Ha habido algun problema al crear el archivo.");
	        }

	    }
	 
	 protected int conversion(char c) {
	        int valor;
	        if (c == 'A') {
	            valor = 14;
	        } else if (c == 'K') {
	            valor = 13;
	        } else if (c == 'Q') {
	            valor = 12;
	        } else if (c == 'J') {
	            valor = 11;
	        } else if (c == 'T') {
	            valor = 10;
	        } else {
	            valor = c - 48;
	        }

	        return valor;
	    }
	 
}