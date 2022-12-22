package com.pau.cse.model.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.pau.cse.model.bean.Temperatura;
import com.pau.cse.model.dao.TemperaturaDAO;
import com.pau.cse.model.util.ArduinoSerial;

/**
 *
 * @author Samuelson
 */
public class ViewTemperatura extends javax.swing.JFrame {

    /**
     * Creates new form ViewTemperatura
     */
    

    
    public ViewTemperatura() {
        initComponents();
        
        
       final  ArduinoSerial arduino = new ArduinoSerial("COM4");
        
        Thread t = new Thread(){
            @Override
            public void run() {
                
               arduino.initialize();
               
                while (true) {                    
                    
                    lbTemperatura.setText(arduino.read());
                    
                    if(arduino.read() != null ){
                        
                        TemperaturaDAO dao = new TemperaturaDAO();
                        Temperatura temp = new Temperatura();
                        
                        temp.setValor(Double.parseDouble(arduino.read()));
                        
                        System.out.println(Double.parseDouble(arduino.read()));
                        
                        
//                        if(dao.save(temp)){
//                            System.out.println("Data Saved!");
//                        }else{
//                            System.err.println("Error!");
//                        }
                        
                        arduino.sleep(500);
                        
                        
                    }
                    
                    
                }
            }
        };
        
        t.start();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTemperatura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Temperatura");

        lbTemperatura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTemperatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTemperatura.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(lbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(lbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTemperatura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTemperatura;
    // End of variables declaration//GEN-END:variables
}