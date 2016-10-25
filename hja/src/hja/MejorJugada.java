package hja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Grupo 1
 *
 */
public class MejorJugada {

    private ArrayList<String> lineas;
    private ArrayList<Carta[]> cartasMano;
    private ArrayList<Carta[]> cartasMesa;

    public MejorJugada() {
        this.lineas = new ArrayList<String>();
        this.cartasMano = new ArrayList<Carta[]>();
        this.cartasMesa = new ArrayList<Carta[]>();
    }

    public ArrayList<Carta[]> cargar(String archivo) { //Cargamos el archivo que nos pasan por parametro

        File fichero = new File(archivo);
        Scanner s = null;
        String linea = "";
        Carta[] mano = new Carta[5]; //Creamos un array Carta de 5 posiciones (una por carta)
        try {
            s = new Scanner(fichero);

            while (s.hasNext()) {
                linea = s.nextLine(); // Guardamos la linea en un String
                lineas.add(linea);
                StringBuffer bf = new StringBuffer(linea);

                int i = 0, cont = 0, valor;

                while (i < bf.length()) {
                    if (bf.charAt(i) == 'A') {
                        valor = 14;
                    } else if (bf.charAt(i) == 'K') {
                        valor = 13;
                    } else if (bf.charAt(i) == 'Q') {
                        valor = 12;
                    } else if (bf.charAt(i) == 'J') {
                        valor = 11;
                    } else if (bf.charAt(i) == 'T') {
                        valor = 10;
                    } else {
                        valor = bf.charAt(i) - 48;
                    }

                    mano[cont] = new Carta(valor, bf.charAt(i + 1)); //Guardamos el valor de la carta y el color

                    i += 2;
                    cont++;
                }
                cartasMano.add(mano);
                mano = new Carta[5];

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        }
        return cartasMano;

    }

    public CartasModo2 cargarModo2(String archivo) { //Metodo cargar para el apartado 2
        CartasModo2 cartas = new CartasModo2(cartasMano, cartasMesa);
        File fichero = new File(archivo);
        int num = 0;
        Scanner s = null;
        String linea = "";
        Carta[] mano;
        Carta[] mesa;
        try {
            s = new Scanner(fichero);

            while (s.hasNext()) {
                linea = s.nextLine(); // Guardamos la linea en un String
                lineas.add(linea);
                StringBuffer bf = new StringBuffer(linea);

                int i = 0, cont = 0, valor;
                mano = new Carta[2];

                while (cont < 2) { //Primero cargamos las cartas de la mano
                    valor = conversion(bf.charAt(i));
                    mano[cont] = new Carta(valor, bf.charAt(i + 1));
                    i += 2;
                    cont++;
                }

                i++;
                num = conversion(bf.charAt(i));
                i += 2;

                mesa = new Carta[num];
                cont = 0;

                while (cont < num) { //Cargamos las cartas de la mesa
                    valor = conversion(bf.charAt(i));
                    mesa[cont] = new Carta(valor, bf.charAt(i + 1));
                    i += 2;
                    cont++;
                }

                cartasMano.add(mano);
                cartasMesa.add(mesa);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        }
        cartas.setSize(cartasMano.size());
        return cartas;

    }

    public CartasModo2 cargarModo3(String archivo) {

        CartasModo2 cartas = new CartasModo2(cartasMano, cartasMesa);
        File fichero = new File(archivo);
        int num = 0;
        Scanner s = null;
        String linea = "";
        Carta[] mano;
        Carta[] mesa;

        try {
            s = new Scanner(fichero);

            while (s.hasNext()) {
                linea = s.nextLine(); // Guardamos la linea en un String
                lineas.add(linea);
                StringBuffer bf = new StringBuffer(linea);

                int i = 0, cont = 0, valor, jug, tamanyo;
                jug = conversion(bf.charAt(i));

                tamanyo = jug * 7;

                i++;
                while (i < tamanyo) {
                    mano = new Carta[2];
                    i += 3; //Leemos el Jx

                    while (cont < 2) { //Leemos las cartas que tiene cada jugador en su mano
                        valor = conversion(bf.charAt(i));
                        mano[cont] = new Carta(valor, bf.charAt(i + 1));
                        i += 2;
                        cont++;
                    }
                    cont = 0;
                    cartasMano.add(mano);
                }
                i++;
                mesa = new Carta[5];

                tamanyo += 12;

                while (i < tamanyo) { //Leemos las cartas de la mesa
                    valor = conversion(bf.charAt(i));
                    mesa[cont] = new Carta(valor, bf.charAt(i + 1));
                    i += 2;
                    cont++;
                }

                for (int j = 0; j < cartasMano.size(); j++) //A�adimos todas las cartas de la mesa
                {
                    cartasMesa.add(mesa);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        }
        cartas.setSize(cartasMano.size());
        return cartas;

    }

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

    private int conversion(char c) {
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
