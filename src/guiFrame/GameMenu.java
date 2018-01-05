/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ghosh Kakan
 */
public class GameMenu extends javax.swing.JFrame {

    /**
     * Creates new form GameMenu
     */
    
    private String gameOption = null;
    
    public GameMenu() {
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        setTitle("Menu");
        setBounds(dim.width/4,dim.height/4,200,200);
        setResizable(false);
        initComponents();
        
                
        buttonAction();
        
        
    }
    
    // button action
    
    public void buttonAction(){
        
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                gameOption = "option1";
                
                 new MyFrame(gameOption).setVisible(true);
                 dispose();
            }
        });
        
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                gameOption = "option2";
                
                 new MyFrame(gameOption).setVisible(true);
                 dispose();
            }
        });
        
        
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                gameOption = "option3";
                
                 new MyFrame(gameOption).setVisible(true);
                 dispose();
            }
        });
    }
    
    public String setGameOption(){
        return gameOption;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        gameMenuLabel = new javax.swing.JLabel();
        option1 = new javax.swing.JButton();
        option2 = new javax.swing.JButton();
        option3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        menuPanel.setBackground(new java.awt.Color(0, 0, 0));
        menuPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuPanel.setForeground(new java.awt.Color(102, 102, 255));

        gameMenuLabel.setBackground(new java.awt.Color(0, 0, 255));
        gameMenuLabel.setFont(new java.awt.Font("DokChampa", 0, 24)); // NOI18N
        gameMenuLabel.setForeground(new java.awt.Color(255, 0, 0));
        gameMenuLabel.setText("Game Menu");
        gameMenuLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        option1.setBackground(new java.awt.Color(51, 51, 51));
        option1.setFont(new java.awt.Font("Eras Medium ITC", 1, 14)); // NOI18N
        option1.setForeground(new java.awt.Color(255, 204, 204));
        option1.setText("Number Counting");
        option1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        option2.setBackground(new java.awt.Color(51, 51, 51));
        option2.setFont(new java.awt.Font("Eras Medium ITC", 1, 14)); // NOI18N
        option2.setForeground(new java.awt.Color(255, 204, 204));
        option2.setText("Odd Number");

        option3.setBackground(new java.awt.Color(51, 51, 51));
        option3.setFont(new java.awt.Font("Eras Medium ITC", 1, 14)); // NOI18N
        option3.setForeground(new java.awt.Color(255, 204, 204));
        option3.setText("Even Number");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(option3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(option2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addComponent(gameMenuLabel)
                        .addGap(140, 140, 140))))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(gameMenuLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(option2)
                .addGap(28, 28, 28)
                .addComponent(option3)
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option1ActionPerformed

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
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gameMenuLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton option1;
    private javax.swing.JButton option2;
    private javax.swing.JButton option3;
    // End of variables declaration//GEN-END:variables
}