/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guihja;
//

import java.util.ArrayList;

/**
 *
 * @author YVCX
 */
public class Principal extends javax.swing.JPanel {
    /**
     * Creates new form principal
     */
    private static ArrayList<String> posiciones = new ArrayList<String>();
    
    public Principal() {
        initComponents();
        t.reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t = new guihja.Tablero();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combosGui2 = new guihja.CombosGui();
        boardGui1 = new guihja.BoardGui();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador ");

        jButton1.setText("Pintar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(1000);
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jTextField2.setText("0,0%");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("COMBOS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("BOARD");

        jButton3.setText("(Aplicar)");

        jButton4.setText("Limpiar Board");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(boardGui1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4))
                                .addGap(48, 48, 48)
                                .addComponent(combosGui2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combosGui2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boardGui1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String input = jTextField1.getText(), linea="";
        int a,b,temp,i=0,v=1, h=1, c,d,max=0;
        
        t.reset();
        while(i<input.length()){
            String[] aaa = input.split(",");
            for(int k=0; k<aaa.length;k++)posiciones.add(aaa[k]);
            
            a=LogicaGui.CharToInt(input.charAt(i));
            b=LogicaGui.CharToInt(input.charAt(i+1));
            
            //CAMBIO DE A<B 
            if((i+2)<input.length() && ((input.charAt(i+2)=='o' && b<a) || (input.charAt(i+2)=='s' && a<b))){
                temp=a;
                a=b;
                b=temp;
            }  
            
            if((i+2)<input.length() && ((input.charAt(i+2)=='o' ) || (input.charAt(i+2)=='s' ))) i+=3;
            else i+=2;
            
            //SI ES XX+
            if(i<input.length() && input.charAt(i)=='+'){
                max=t.tam()-a+2;
                
                if(a<b){
                    v=0;
                    h=1;
                    max=b-a;
                }
                else if(a>b){
                    h=0;
                    v=1;
                    max=a-b;
                }
                else{
                    v=1;
                    h=1;
                }
                   
                for(int x=0;x<max; x++){
                    t.pintar(a+x*h, b+x*v,0);
                    LogicaGui.sumarPorcentaje(a+x*h, b+x*v);
                }
               i++;
            }
            
            if((i)<input.length() && input.charAt(i)=='-'){
                i++;
                c=LogicaGui.CharToInt(input.charAt(i));
                d=LogicaGui.CharToInt(input.charAt(i+1));
                
               //CAMBIO DE A<B  parte2
                if((i+2)<input.length() && ((input.charAt(i+2)=='o' && d<c) || (input.charAt(i+2)=='s' && c<d))){
                    temp=c;
                    c=d;
                    d=temp;
                }  

                if((i+2)<input.length() && (input.charAt(i+2)=='o' || input.charAt(i+2)=='s')) i+=3;
                else i+=2;
                
                if(a==c){
                    max=b-d;
                    h=0;
                }
                else if(b==d){
                    max=a-c;
                    v=0;
                }
                else  max=a-c;
                
                for(int x=0;x<=max; x++){
                    t.pintar(c+x*h, d+x*v,0);
                    LogicaGui.sumarPorcentaje(c+x*h, d+x*v);
                }
              
            }
            else {
                t.pintar(a, b,0);
                LogicaGui.sumarPorcentaje(a,b);
            }
            
            i++; //saltar la coma
        }
        jTextField2.setText(LogicaGui.getPorcentaje()+"%");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

        String tx= jTextField2.getText();
        String valor = tx.substring(0,tx.length()-1);
        String newName = valor.substring(0,valor.length()-2)+'.'+valor.substring(valor.length()-1);
               
        double v=Double.valueOf(newName);//Double.parseDouble(valor);
        LogicaGui.pintarPor(v,t);
        int a= (int)v*10;
        jSlider1.setValue(a);
        
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        double valor= jSlider1.getValue();
        valor=valor/10;
        jTextField2.setText(valor+"%");
        LogicaGui.setPorcentaje(valor);

        LogicaGui.pintarPor(valor,t);

        	
       
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("0.0%");
        t.reset();
        jSlider1.setValue(0);
        posiciones.clear();
        LogicaGui.setPorcentaje(0.0);
        LogicaGui.clearTab();
        CombosGui.resetCombos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        BoardGui.resetBoard();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public static void updateContador(){
        jTextField2.setText(LogicaGui.getPorcentaje()+"%");
    }

    public static void addText(String text){
        String previo = jTextField1.getText();
        if(previo.length()!=0) jTextField1.setText(previo+','+text);
        else jTextField1.setText(text);
        
    }
    
    public static void repaintEst(){
        boardGui1.repaint();
    }
    
    public static void deletePosiciones(String valor){
        posiciones.remove(valor); 
        pintarText();
    }
    
    public static void addPosicion(String valor){
        posiciones.add(valor);
        pintarText();
    }
    
    private static void pintarText(){
       jTextField1.setText(String.join(",",posiciones));
    }
    
    public static void setValues(double [] v, int tot){
        String salida="";
        if(tot==0)tot=1;
        for(int i=0; i<v.length; i++)salida+=(v[i]/tot)*100+"%"+"\n";
        jTextArea1.setText(salida);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static guihja.BoardGui boardGui1;
    private guihja.CombosGui combosGui2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private static javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;
    private guihja.Tablero t;
    // End of variables declaration//GEN-END:variables
}
