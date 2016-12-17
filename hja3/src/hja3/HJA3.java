/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hja3;

import gui.Tablero;
import Logica.Logica;
import gui.Inicio;
import javax.swing.JFrame;

/**
 *
 * @author Grupo 01
 */
public class HJA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("HJA: PRACTICA 3 - GRUPO 1");
        Logica l = new Logica();
        //f.add(new Inicio());
        f.add(new Tablero());
        f.setVisible(true);
        f.setSize(815, 700);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        l.comprobarTotal();
    }
    
}
