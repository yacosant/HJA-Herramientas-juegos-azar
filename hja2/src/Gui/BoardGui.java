package Gui;

import Logic.Carta;
import Logic.Logica;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Grupo 01
 */
public class BoardGui extends javax.swing.JPanel {

    private static Button[][] board = new Button[13][4];
    private static boolean[][] pulsado = new boolean[13][4];

    /**
     * Creates new form BoardGui
     */
    public BoardGui() {
        String valor = "";
        char c = 'x';

        initComponents();
        this.setLayout(new GridLayout(13, 4));
        ActionListener ac;
        for (int i = 14; i >= 2; i--) {
            for (int j = 0; j < 4; j++) {
                valor = Logica.intToChar(i);
                valor += palo(j);

                ac = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String tecla = e.getActionCommand();
                        pulsado(tecla);
                    }

                };
                board[i - 2][j] = new Button();
                board[i - 2][j].setLabel(valor);
                board[i - 2][j].addActionListener(ac);
                this.add(board[i - 2][j]);
            }
        }
        this.setVisible(true);
    }

    private void pulsado(String c) {
        int a = Logica.CharToInt(c.charAt(0));
        char p = c.charAt(1);
        int b = palo(p);
        Carta car = new Carta(a, p);
        if (Logica.pulsadasBoard() < 5) {
            if (!marcado(a, b)) {
                board[a - 2][b].setBackground(Color.green);
                Logica.addBoard(car);
            } else {
                board[a - 2][b].setBackground(new Color(240, 240, 240));
                Logica.delBoard(car);
            }
        } else {
            pulsado[a - 2][b] = false;
            board[a - 2][b].setBackground(new Color(240, 240, 240));
            Logica.delBoard(car);
        }
        Logica.procesar();
    }

    private String palo(int j) {
        String v = "";
        switch (j) {
            case 0:
                v = "h";
                break;
            case 1:
                v = "c";
                break;
            case 2:
                v = "d";
                break;
            case 3:
                v = "s";
                break;
        }
        return v;
    }

    public static void resetBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                pulsado[j][i] = false;
                board[j][i].setBackground(new Color(240, 240, 240));
            }
        }
        Logica.clearBoard();
        CombosGui.resetCombos();
    }

    private int palo(char j) {
        int v = 0;
        switch (j) {
            case 'h':
                v = 0;
                break;
            case 'c':
                v = 1;
                break;
            case 'd':
                v = 2;
                break;
            case 's':
                v = 3;
                break;
        }
        return v;
    }

    private boolean marcado(int a, int b) {
        boolean bo = pulsado[a - 2][b];
        if (bo) {
            pulsado[a - 2][b] = false;
        } else {
            pulsado[a - 2][b] = true;
        }
        return bo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
