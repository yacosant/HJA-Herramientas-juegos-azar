package Gui;

import javax.swing.JFrame;

/**
 *
 * @author Grupo 01
 */
public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("HJA: PRACTICA 2 - GRUPO 1");
        f.add(new Principal());
        f.setVisible(true);
        f.setSize(1050, 600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

    }

}
