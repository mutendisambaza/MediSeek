/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.START;
import mediseek.pat.Administator.AdministratorGUIlogin;
import mediseek.pat.Doctor.DoctorGUIlogin;
import mediseek.pat.CriticalClasses.Methods;
import mediseek.pat.START.LoginGUI;
import mediseek.pat.Pharmacist.PharmacistGUIlogin;
import mediseek.pat.Receptionist.ReceptionistGUIlogin;

/**
 *
 * @author tendi
 */
public class LoginGUIoption extends javax.swing.JFrame {
Methods obj = new Methods();
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

        lblTitle = new javax.swing.JLabel();
        doctorPicture = new javax.swing.JLabel();
        btnDoctor = new javax.swing.JButton();
        adminPicture1 = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();
        recepPicture = new javax.swing.JLabel();
        btnReceptionist = new javax.swing.JButton();
        pharmPicture = new javax.swing.JLabel();
        btnPharmacist = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        Backgournd = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Select Occupation:");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 510, 100));

        doctorPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/doctorLogo.png"))); // NOI18N
        doctorPicture.setText("jLabel1");
        getContentPane().add(doctorPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 210, 240));

        btnDoctor.setBackground(new java.awt.Color(204, 255, 255));
        btnDoctor.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnDoctor.setForeground(new java.awt.Color(0, 0, 0));
        btnDoctor.setText("DOCTOR");
        btnDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorActionPerformed(evt);
            }
        });
        getContentPane().add(btnDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 170, 60));

        adminPicture1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/adminLogo.jpg"))); // NOI18N
        getContentPane().add(adminPicture1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 200, 240));

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

        recepPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/PharmLogo.png"))); // NOI18N
        getContentPane().add(recepPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 200, 240));

        btnReceptionist.setBackground(new java.awt.Color(204, 255, 255));
        btnReceptionist.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnReceptionist.setForeground(new java.awt.Color(0, 0, 0));
        btnReceptionist.setText("RECEPTIONIST");
        btnReceptionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceptionistActionPerformed(evt);
            }
        });
        getContentPane().add(btnReceptionist, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 170, 60));

        pharmPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/recepLogo.png"))); // NOI18N
        getContentPane().add(pharmPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 210, 250));

        btnPharmacist.setBackground(new java.awt.Color(204, 255, 255));
        btnPharmacist.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnPharmacist.setForeground(new java.awt.Color(0, 0, 0));
        btnPharmacist.setText("PHARMACIST");
        btnPharmacist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPharmacistActionPerformed(evt);
            }
        });
        getContentPane().add(btnPharmacist, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 170, 60));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, -1, -1));
        getContentPane().add(Backgournd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 790));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/MS LOGIN.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 770));

        jMenu1.setText("About");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Who are we?");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem2.setText("Using the Program");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        AdministratorGUIlogin newGUI = new AdministratorGUIlogin();
        newGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorActionPerformed
        DoctorGUIlogin newGUI = new DoctorGUIlogin();
        newGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDoctorActionPerformed

    private void btnPharmacistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPharmacistActionPerformed
        PharmacistGUIlogin newGUI = new PharmacistGUIlogin();
        newGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPharmacistActionPerformed

    private void btnReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceptionistActionPerformed
        ReceptionistGUIlogin newGUI = new ReceptionistGUIlogin();
        newGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReceptionistActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        LoginGUI newGUI = new LoginGUI();
        newGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        obj.openWord("MediSeek Who are we.docx");

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        obj.openWord("MediSeek Help.docx");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel adminPicture1;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDoctor;
    private javax.swing.JButton btnPharmacist;
    private javax.swing.JButton btnReceptionist;
    private javax.swing.JLabel doctorPicture;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel pharmPicture;
    private javax.swing.JLabel recepPicture;
    // End of variables declaration//GEN-END:variables
}
