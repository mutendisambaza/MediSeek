/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat;

/**
 *
 * @author tendi
 */
public class LoginGUIoption extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public LoginGUIoption() {
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

        btnDoctor = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnReceptionist = new javax.swing.JButton();
        btnPharmacist = new javax.swing.JButton();
        Backgournd = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDoctor.setBackground(new java.awt.Color(204, 255, 255));
        btnDoctor.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnDoctor.setForeground(new java.awt.Color(0, 0, 0));
        btnDoctor.setText("DOCTOR");
        getContentPane().add(btnDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 170, 60));

        btnAdmin.setBackground(new java.awt.Color(204, 255, 255));
        btnAdmin.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnAdmin.setForeground(new java.awt.Color(0, 0, 0));
        btnAdmin.setText("ADMINISTRATOR");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 560, 180, 60));

        btnReceptionist.setBackground(new java.awt.Color(204, 255, 255));
        btnReceptionist.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnReceptionist.setForeground(new java.awt.Color(0, 0, 0));
        btnReceptionist.setText("RECEPTIONIST");
        getContentPane().add(btnReceptionist, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 170, 60));

        btnPharmacist.setBackground(new java.awt.Color(204, 255, 255));
        btnPharmacist.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnPharmacist.setForeground(new java.awt.Color(0, 0, 0));
        btnPharmacist.setText("PHARMACIST");
        getContentPane().add(btnPharmacist, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 170, 60));

        Backgournd.setIcon(new javax.swing.ImageIcon("C:\\Users\\tendi\\OneDrive\\Education\\IT\\PAT\\Grade 12 PAT\\MediSeek_PAT\\src\\mediseek\\pat\\MS LOGIN.jpg")); // NOI18N
        getContentPane().add(Backgournd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 790));

        jMenu1.setText("About");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminActionPerformed

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
            java.util.logging.Logger.getLogger(LoginGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgournd;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnDoctor;
    private javax.swing.JButton btnPharmacist;
    private javax.swing.JButton btnReceptionist;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
