/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Logica.Carta;
import Logica.Jugador;
import Logica.Logica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 01
 */
public class Tablero extends javax.swing.JDialog {

	private JButton cartas[];
	private Logica logica;
	private String dir = "/imgs/baraja/";
	private JLabel board[];
        private static int turno;
        private boolean hayGanador=false;
	/**
	 * Creates new form Tablero
	 */
	public Tablero(java.awt.Frame parent, boolean modal, Logica l) throws InterruptedException {
		super(parent, modal);
		initComponents();
		cartas = new JButton[] { j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26,
				j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47,
				j48, j49 };
                board = new JLabel[] { t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26,
				t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40, t41, t42, t43, t44, t45, t46, t47,
				t48, t49 };
        ocultarTab();
        this.setSize(1030, 778);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("HJA: CINQUILLO - TABLERO - GRUPO 01");
        this.setVisible(true);
        logica=l;
        logica.repartir();
        logica.partida();
        inicializarBotones();
       
	}

        private void partida(){
            Jugador j;
            
            
        }
        
	private void ocultarTab() {
		t10.setVisible(false);
		t11.setVisible(false);
		t12.setVisible(false);
		t13.setVisible(false);
		t14.setVisible(false);
		t15.setVisible(false);
		t16.setVisible(false);
		t17.setVisible(false);
		t18.setVisible(false);
		t19.setVisible(false);

		t20.setVisible(false);
		t21.setVisible(false);
		t22.setVisible(false);
		t23.setVisible(false);
		t24.setVisible(false);
		t25.setVisible(false);
		t26.setVisible(false);
		t27.setVisible(false);
		t28.setVisible(false);
		t29.setVisible(false);

		t30.setVisible(false);
		t31.setVisible(false);
		t32.setVisible(false);
		t33.setVisible(false);
		t34.setVisible(false);
		t35.setVisible(false);
		t36.setVisible(false);
		t37.setVisible(false);
		t38.setVisible(false);
		t39.setVisible(false);

		t40.setVisible(false);
		t41.setVisible(false);
		t42.setVisible(false);
		t43.setVisible(false);
		t44.setVisible(false);
		t45.setVisible(false);
		t46.setVisible(false);
		t47.setVisible(false);
		t48.setVisible(false);
		t49.setVisible(false);
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j15 = new javax.swing.JButton();
        j16 = new javax.swing.JButton();
        j17 = new javax.swing.JButton();
        j18 = new javax.swing.JButton();
        j19 = new javax.swing.JButton();
        j11 = new javax.swing.JButton();
        j10 = new javax.swing.JButton();
        j12 = new javax.swing.JButton();
        j13 = new javax.swing.JButton();
        j14 = new javax.swing.JButton();
        j20 = new javax.swing.JButton();
        j21 = new javax.swing.JButton();
        j22 = new javax.swing.JButton();
        j23 = new javax.swing.JButton();
        j24 = new javax.swing.JButton();
        j25 = new javax.swing.JButton();
        j26 = new javax.swing.JButton();
        j27 = new javax.swing.JButton();
        j28 = new javax.swing.JButton();
        j29 = new javax.swing.JButton();
        separador = new javax.swing.JLabel();
        t10 = new javax.swing.JLabel();
        t11 = new javax.swing.JLabel();
        t12 = new javax.swing.JLabel();
        t13 = new javax.swing.JLabel();
        t14 = new javax.swing.JLabel();
        t15 = new javax.swing.JLabel();
        t16 = new javax.swing.JLabel();
        t17 = new javax.swing.JLabel();
        t18 = new javax.swing.JLabel();
        t19 = new javax.swing.JLabel();
        t20 = new javax.swing.JLabel();
        t21 = new javax.swing.JLabel();
        t22 = new javax.swing.JLabel();
        t23 = new javax.swing.JLabel();
        t24 = new javax.swing.JLabel();
        t25 = new javax.swing.JLabel();
        t26 = new javax.swing.JLabel();
        t27 = new javax.swing.JLabel();
        t28 = new javax.swing.JLabel();
        t29 = new javax.swing.JLabel();
        t30 = new javax.swing.JLabel();
        t31 = new javax.swing.JLabel();
        t32 = new javax.swing.JLabel();
        t33 = new javax.swing.JLabel();
        t34 = new javax.swing.JLabel();
        t35 = new javax.swing.JLabel();
        t36 = new javax.swing.JLabel();
        t37 = new javax.swing.JLabel();
        t38 = new javax.swing.JLabel();
        t39 = new javax.swing.JLabel();
        t40 = new javax.swing.JLabel();
        t41 = new javax.swing.JLabel();
        t42 = new javax.swing.JLabel();
        t43 = new javax.swing.JLabel();
        t44 = new javax.swing.JLabel();
        t45 = new javax.swing.JLabel();
        t46 = new javax.swing.JLabel();
        t47 = new javax.swing.JLabel();
        t48 = new javax.swing.JLabel();
        t49 = new javax.swing.JLabel();
        j30 = new javax.swing.JButton();
        j31 = new javax.swing.JButton();
        j32 = new javax.swing.JButton();
        j33 = new javax.swing.JButton();
        j34 = new javax.swing.JButton();
        j35 = new javax.swing.JButton();
        j36 = new javax.swing.JButton();
        j37 = new javax.swing.JButton();
        j38 = new javax.swing.JButton();
        j39 = new javax.swing.JButton();
        j40 = new javax.swing.JButton();
        j41 = new javax.swing.JButton();
        j42 = new javax.swing.JButton();
        j43 = new javax.swing.JButton();
        j44 = new javax.swing.JButton();
        j45 = new javax.swing.JButton();
        j46 = new javax.swing.JButton();
        j47 = new javax.swing.JButton();
        j48 = new javax.swing.JButton();
        j49 = new javax.swing.JButton();
        lTurno = new javax.swing.JLabel();
        numTurno = new javax.swing.JLabel();
        botonPasar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        j15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j15.setBorderPainted(false);
        getContentPane().add(j15);
        j15.setBounds(60, 30, 60, 100);

        j16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j16.setBorderPainted(false);
        getContentPane().add(j16);
        j16.setBounds(130, 30, 60, 100);

        j17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j17.setBorderPainted(false);
        getContentPane().add(j17);
        j17.setBounds(200, 30, 60, 100);

        j18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j18.setBorderPainted(false);
        getContentPane().add(j18);
        j18.setBounds(270, 30, 60, 100);

        j19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j19.setBorderPainted(false);
        getContentPane().add(j19);
        j19.setBounds(340, 30, 60, 100);

        j11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j11.setBorderPainted(false);
        getContentPane().add(j11);
        j11.setBounds(150, 10, 60, 100);

        j10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j10.setBorderPainted(false);
        getContentPane().add(j10);
        j10.setBounds(80, 10, 60, 100);

        j12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j12.setBorderPainted(false);
        getContentPane().add(j12);
        j12.setBounds(220, 10, 60, 100);

        j13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j13.setBorderPainted(false);
        getContentPane().add(j13);
        j13.setBounds(290, 10, 60, 100);

        j14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j14.setBorderPainted(false);
        getContentPane().add(j14);
        j14.setBounds(360, 10, 60, 100);

        j20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j20.setBorderPainted(false);
        getContentPane().add(j20);
        j20.setBounds(640, 30, 60, 100);

        j21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j21.setBorderPainted(false);
        getContentPane().add(j21);
        j21.setBounds(710, 30, 60, 100);

        j22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j22.setBorderPainted(false);
        getContentPane().add(j22);
        j22.setBounds(780, 30, 60, 100);

        j23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j23.setBorderPainted(false);
        getContentPane().add(j23);
        j23.setBounds(850, 30, 60, 100);

        j24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j24.setBorderPainted(false);
        getContentPane().add(j24);
        j24.setBounds(920, 30, 60, 100);

        j25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j25.setBorderPainted(false);
        getContentPane().add(j25);
        j25.setBounds(660, 10, 60, 100);

        j26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j26.setBorderPainted(false);
        getContentPane().add(j26);
        j26.setBounds(730, 10, 60, 100);

        j27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j27.setBorderPainted(false);
        getContentPane().add(j27);
        j27.setBounds(800, 10, 60, 100);

        j28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j28.setBorderPainted(false);
        getContentPane().add(j28);
        j28.setBounds(870, 10, 60, 100);

        j29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j29.setBorderPainted(false);
        getContentPane().add(j29);
        j29.setBounds(940, 10, 60, 100);
        getContentPane().add(separador);
        separador.setBounds(10, 10, 0, 0);

        t10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/1c.png"))); // NOI18N
        getContentPane().add(t10);
        t10.setBounds(270, 160, 70, 100);

        t11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/2c.png"))); // NOI18N
        getContentPane().add(t11);
        t11.setBounds(320, 160, 70, 100);

        t12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/3c.png"))); // NOI18N
        getContentPane().add(t12);
        t12.setBounds(370, 160, 70, 100);

        t13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/4c.png"))); // NOI18N
        getContentPane().add(t13);
        t13.setBounds(420, 160, 70, 100);

        t14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/5c.png"))); // NOI18N
        getContentPane().add(t14);
        t14.setBounds(470, 160, 70, 100);

        t15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/6c.png"))); // NOI18N
        getContentPane().add(t15);
        t15.setBounds(520, 160, 70, 100);

        t16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/7c.png"))); // NOI18N
        getContentPane().add(t16);
        t16.setBounds(570, 160, 70, 100);

        t17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/10c.png"))); // NOI18N
        getContentPane().add(t17);
        t17.setBounds(620, 160, 70, 100);

        t18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/11c.png"))); // NOI18N
        getContentPane().add(t18);
        t18.setBounds(670, 160, 70, 100);

        t19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/12c.png"))); // NOI18N
        getContentPane().add(t19);
        t19.setBounds(720, 160, 70, 100);

        t20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/1b.png"))); // NOI18N
        getContentPane().add(t20);
        t20.setBounds(270, 270, 70, 100);

        t21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/2b.png"))); // NOI18N
        getContentPane().add(t21);
        t21.setBounds(320, 270, 70, 100);

        t22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/3b.png"))); // NOI18N
        getContentPane().add(t22);
        t22.setBounds(370, 270, 70, 100);

        t23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/4b.png"))); // NOI18N
        getContentPane().add(t23);
        t23.setBounds(420, 270, 70, 100);

        t24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/5b.png"))); // NOI18N
        getContentPane().add(t24);
        t24.setBounds(470, 270, 70, 100);

        t25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/6b.png"))); // NOI18N
        getContentPane().add(t25);
        t25.setBounds(520, 270, 70, 100);

        t26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/7b.png"))); // NOI18N
        getContentPane().add(t26);
        t26.setBounds(570, 270, 70, 100);

        t27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/10b.png"))); // NOI18N
        getContentPane().add(t27);
        t27.setBounds(620, 270, 70, 100);

        t28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/11b.png"))); // NOI18N
        getContentPane().add(t28);
        t28.setBounds(670, 270, 70, 100);

        t29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/12b.png"))); // NOI18N
        getContentPane().add(t29);
        t29.setBounds(720, 270, 70, 100);

        t30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/1o.png"))); // NOI18N
        getContentPane().add(t30);
        t30.setBounds(270, 380, 70, 100);

        t31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/2o.png"))); // NOI18N
        getContentPane().add(t31);
        t31.setBounds(320, 380, 70, 100);

        t32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/3o.png"))); // NOI18N
        getContentPane().add(t32);
        t32.setBounds(370, 380, 70, 100);

        t33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/4o.png"))); // NOI18N
        getContentPane().add(t33);
        t33.setBounds(420, 380, 70, 100);

        t34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/5o.png"))); // NOI18N
        getContentPane().add(t34);
        t34.setBounds(470, 380, 70, 100);

        t35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/6o.png"))); // NOI18N
        getContentPane().add(t35);
        t35.setBounds(520, 380, 70, 100);

        t36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/7o.png"))); // NOI18N
        getContentPane().add(t36);
        t36.setBounds(570, 380, 70, 100);

        t37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/10o.png"))); // NOI18N
        getContentPane().add(t37);
        t37.setBounds(620, 380, 70, 100);

        t38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/11o.png"))); // NOI18N
        getContentPane().add(t38);
        t38.setBounds(670, 380, 70, 100);

        t39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/12o.png"))); // NOI18N
        getContentPane().add(t39);
        t39.setBounds(720, 380, 70, 100);

        t40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/1e.png"))); // NOI18N
        getContentPane().add(t40);
        t40.setBounds(270, 490, 70, 100);

        t41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/2e.png"))); // NOI18N
        getContentPane().add(t41);
        t41.setBounds(320, 490, 70, 100);

        t42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/3e.png"))); // NOI18N
        getContentPane().add(t42);
        t42.setBounds(370, 490, 70, 100);

        t43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/4e.png"))); // NOI18N
        getContentPane().add(t43);
        t43.setBounds(420, 490, 70, 100);

        t44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/5e.png"))); // NOI18N
        getContentPane().add(t44);
        t44.setBounds(470, 490, 70, 100);

        t45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/6e.png"))); // NOI18N
        getContentPane().add(t45);
        t45.setBounds(520, 490, 70, 100);

        t46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/7e.png"))); // NOI18N
        getContentPane().add(t46);
        t46.setBounds(570, 490, 70, 100);

        t47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/10e.png"))); // NOI18N
        getContentPane().add(t47);
        t47.setBounds(620, 490, 70, 100);

        t48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/11e.png"))); // NOI18N
        getContentPane().add(t48);
        t48.setBounds(670, 490, 70, 100);

        t49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/12e.png"))); // NOI18N
        getContentPane().add(t49);
        t49.setBounds(720, 490, 70, 100);

        j30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j30.setBorderPainted(false);
        getContentPane().add(j30);
        j30.setBounds(640, 630, 60, 100);

        j31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j31.setBorderPainted(false);
        getContentPane().add(j31);
        j31.setBounds(710, 630, 60, 100);

        j32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j32.setBorderPainted(false);
        getContentPane().add(j32);
        j32.setBounds(780, 630, 60, 100);

        j33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j33.setBorderPainted(false);
        getContentPane().add(j33);
        j33.setBounds(850, 630, 60, 100);

        j34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j34.setBorderPainted(false);
        getContentPane().add(j34);
        j34.setBounds(920, 630, 60, 100);

        j35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j35.setBorderPainted(false);
        getContentPane().add(j35);
        j35.setBounds(660, 610, 60, 100);

        j36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j36.setBorderPainted(false);
        getContentPane().add(j36);
        j36.setBounds(730, 610, 60, 100);

        j37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j37.setBorderPainted(false);
        getContentPane().add(j37);
        j37.setBounds(800, 610, 60, 100);

        j38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j38.setBorderPainted(false);
        getContentPane().add(j38);
        j38.setBounds(870, 610, 60, 100);

        j39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j39.setBorderPainted(false);
        getContentPane().add(j39);
        j39.setBounds(940, 610, 60, 100);

        j40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j40.setBorderPainted(false);
        getContentPane().add(j40);
        j40.setBounds(20, 630, 60, 100);

        j41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j41.setBorderPainted(false);
        getContentPane().add(j41);
        j41.setBounds(90, 630, 60, 100);

        j42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j42.setBorderPainted(false);
        getContentPane().add(j42);
        j42.setBounds(160, 630, 60, 100);

        j43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j43.setBorderPainted(false);
        getContentPane().add(j43);
        j43.setBounds(230, 630, 60, 100);

        j44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j44.setBorderPainted(false);
        getContentPane().add(j44);
        j44.setBounds(300, 630, 60, 100);

        j45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j45.setBorderPainted(false);
        getContentPane().add(j45);
        j45.setBounds(40, 610, 60, 100);

        j46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j46.setBorderPainted(false);
        getContentPane().add(j46);
        j46.setBounds(110, 610, 60, 100);

        j47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j47.setBorderPainted(false);
        getContentPane().add(j47);
        j47.setBounds(180, 610, 60, 100);

        j48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j48.setBorderPainted(false);
        getContentPane().add(j48);
        j48.setBounds(250, 610, 60, 100);

        j49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/baraja/atras.png"))); // NOI18N
        j49.setBorderPainted(false);
        getContentPane().add(j49);
        j49.setBounds(320, 610, 60, 100);

        lTurno.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lTurno.setForeground(new java.awt.Color(255, 255, 255));
        lTurno.setText("Turno de Jugador:");
        getContentPane().add(lTurno);
        lTurno.setBounds(10, 180, 190, 50);

        numTurno.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        numTurno.setForeground(new java.awt.Color(255, 255, 0));
        numTurno.setText("X");
        getContentPane().add(numTurno);
        numTurno.setBounds(200, 194, 50, 20);

        botonPasar.setText("Pasar Turno");
        botonPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPasarActionPerformed(evt);
            }
        });
        getContentPane().add(botonPasar);
        botonPasar.setBounds(40, 230, 160, 23);

        fondo.setBackground(new java.awt.Color(0, 0, 0));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fondo1.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, -100, 1030, 850);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPasarActionPerformed
        logica.pasarTurno();
        logica.partida();
    }//GEN-LAST:event_botonPasarActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		/*java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Tablero dialog = new Tablero(new javax.swing.JFrame(), true);
                               	dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});*/
	}
    
    private void inicializarBotones(){
        ActionListener ac;
        String valor="";
        ArrayList<Carta> c;
        c = logica.getJugador(1).getCartas();
        valor = ""+c.get(5).getValor();
                valor += c.get(5).getColor();
        
        for (int i = 0; i <4; i++) {
            if(!logica.esBot(i)){
            c = logica.getJugador(i).getCartas();
            for (int j = 0; j < 10; j++) {
                valor = ""+c.get(j).getValor();
                valor += c.get(j).getColor();
                
                
                cartas[j + (10 * i)].setIcon(new javax.swing.ImageIcon(getClass().getResource(dir + valor+ ".png")));
                
                cartas[i*10 + j].setName(valor);
          
                ac = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                       
                        javax.swing.JButton label = (javax.swing.JButton) e.getSource();
                        String tecla = label.getName();
                        int pos;
                        String msg=pulsado(tecla);
                        if(msg==null){
                           if(logica.getGanador()) terminar();
                           label.setVisible(false);
                           pos = getPosBoard(tecla);
                           board[pos-1].setVisible(true);
                           logica.partida();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, msg);
                        }
                    }

                };
               
                cartas[i*10 + j].addActionListener(ac);
            }
        }
        }
    }
    
    private void terminar(){
         JOptionPane.showMessageDialog(null, "Partida acabada. El ganador es el jugador "+ turno);
    }
    
    private String pulsado(String boton){
        char c;
        int val;
        c= boton.substring(boton.length()-1).charAt(0);
        String v= boton.substring(boton.length()-2,boton.length()-1);
        val=  Integer.parseInt (v);
        return logica.esPosible(new Carta(val,c));
        //CAMBIAR A STRING CON MENSAJE DE ERROR O OK
    }
    
    private int getPosBoard(String text){
        int aux=0;
        char c;
        int val;
        c= text.substring(text.length()-1).charAt(0);
        String v= text.substring(text.length()-2,text.length()-1);
        val=  Integer.parseInt (v);
        switch(c){
            case 'c': aux=0; break;
            case 'b': aux=1; break;
            case 'o': aux=2; break;
            case 'e': aux=3; break;
        }
        return (val+10*aux);
    }
    
    public static void actualizaTurno(int j){
        turno=j;
        numTurno.setText(Integer.toString(j+1));
    }
    public static void bloquearPasar(boolean t){
        botonPasar.enable(t);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton botonPasar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton j10;
    private javax.swing.JButton j11;
    private javax.swing.JButton j12;
    private javax.swing.JButton j13;
    private javax.swing.JButton j14;
    private javax.swing.JButton j15;
    private javax.swing.JButton j16;
    private javax.swing.JButton j17;
    private javax.swing.JButton j18;
    private javax.swing.JButton j19;
    private javax.swing.JButton j20;
    private javax.swing.JButton j21;
    private javax.swing.JButton j22;
    private javax.swing.JButton j23;
    private javax.swing.JButton j24;
    private javax.swing.JButton j25;
    private javax.swing.JButton j26;
    private javax.swing.JButton j27;
    private javax.swing.JButton j28;
    private javax.swing.JButton j29;
    private javax.swing.JButton j30;
    private javax.swing.JButton j31;
    private javax.swing.JButton j32;
    private javax.swing.JButton j33;
    private javax.swing.JButton j34;
    private javax.swing.JButton j35;
    private javax.swing.JButton j36;
    private javax.swing.JButton j37;
    private javax.swing.JButton j38;
    private javax.swing.JButton j39;
    private javax.swing.JButton j40;
    private javax.swing.JButton j41;
    private javax.swing.JButton j42;
    private javax.swing.JButton j43;
    private javax.swing.JButton j44;
    private javax.swing.JButton j45;
    private javax.swing.JButton j46;
    private javax.swing.JButton j47;
    private javax.swing.JButton j48;
    private javax.swing.JButton j49;
    private javax.swing.JLabel lTurno;
    private static javax.swing.JLabel numTurno;
    private javax.swing.JLabel separador;
    private javax.swing.JLabel t10;
    private javax.swing.JLabel t11;
    private javax.swing.JLabel t12;
    private javax.swing.JLabel t13;
    private javax.swing.JLabel t14;
    private javax.swing.JLabel t15;
    private javax.swing.JLabel t16;
    private javax.swing.JLabel t17;
    private javax.swing.JLabel t18;
    private javax.swing.JLabel t19;
    private javax.swing.JLabel t20;
    private javax.swing.JLabel t21;
    private javax.swing.JLabel t22;
    private javax.swing.JLabel t23;
    private javax.swing.JLabel t24;
    private javax.swing.JLabel t25;
    private javax.swing.JLabel t26;
    private javax.swing.JLabel t27;
    private javax.swing.JLabel t28;
    private javax.swing.JLabel t29;
    private javax.swing.JLabel t30;
    private javax.swing.JLabel t31;
    private javax.swing.JLabel t32;
    private javax.swing.JLabel t33;
    private javax.swing.JLabel t34;
    private javax.swing.JLabel t35;
    private javax.swing.JLabel t36;
    private javax.swing.JLabel t37;
    private javax.swing.JLabel t38;
    private javax.swing.JLabel t39;
    private javax.swing.JLabel t40;
    private javax.swing.JLabel t41;
    private javax.swing.JLabel t42;
    private javax.swing.JLabel t43;
    private javax.swing.JLabel t44;
    private javax.swing.JLabel t45;
    private javax.swing.JLabel t46;
    private javax.swing.JLabel t47;
    private javax.swing.JLabel t48;
    private javax.swing.JLabel t49;
    // End of variables declaration//GEN-END:variables
}
