/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinquillo;

import Gui.Inicio;
import javax.swing.JFrame;

/**
 *
 * @author YVCX
 */
public class Cinquillo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame f = new JFrame("HJA: PRACTICA 3");
        f.add(new Inicio());
        f.setVisible(true);
        f.setSize(300, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }
    
}
