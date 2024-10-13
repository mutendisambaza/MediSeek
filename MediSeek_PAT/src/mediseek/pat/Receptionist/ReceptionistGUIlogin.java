/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Receptionist;

import mediseek.pat.START.LoginGUIoption;

/**
 *
 * @author tendi
 */
public class ReceptionistGUIlogin extends javax.swing.JFrame {

    /**
     * Creates new form ReceptionistGUI
     */
    public ReceptionistGUIlogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        lbl_ID = new javax.swing.JLabel();
        tf_ID = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        Backgournd = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setBackground(new java.awt.Color(204, 255, 255));
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("LOGIN");
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 80, 40));

        lbl_ID.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbl_ID.setForeground(new java.awt.Color(0, 102, 102));
        lbl_ID.setText("STAFF ID:");
        getContentPane().add(lbl_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        tf_ID.setToolTipText("Enter the identification code issued upon your arrival.\nIf forgotton please visit the admin office.\n(gender symbol)(first letter of first name)(first letter of last name)-(staff number)\n\ni.e   mxx-123");
        tf_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IDActionPerformed(evt);
            }
        });
        getContentPane().add(tf_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 220, -1));

        lblPassword.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 102, 102));
        lblPassword.setText("PASSWORD:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        tfPassword.setToolTipText("If forgotton, please go to the admin office");
        getContentPane().add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 220, -1));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 44)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Receptionist login:");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 460, 80));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, -1, -1));
        getContentPane().add(Backgournd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 790));

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\tendi\\OneDrive\\Education\\IT\\PAT\\Grade 12 PAT\\MediSeek_PAT\\MS LOGIN_final.jpg")); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 770));

        jMenu1.setText("About");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_IDActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        LoginGUIoption newGUI = new LoginGUIoption();
        newGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistGUIlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgournd;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tf_ID;
    // End of variables declaration//GEN-END:variables
}
