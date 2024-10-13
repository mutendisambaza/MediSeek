/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Directory;
import javax.swing.DefaultListModel;
import mediseek.pat.Tables.directory;
import mediseek.pat.Tables.useDirectory;

/**
 *
 * @author tendi
 */
public class DirectoryGUI_SpecialistPage extends javax.swing.JFrame {

 DefaultListModel dlstDirectory = new DefaultListModel();
 directory[] specialistDirectory = new directory[500]; 
 useDirectory objDirect = new useDirectory(); 
    
    
    public DirectoryGUI_SpecialistPage() {
        initComponents();
        getSpecialist();
    }

  ////////////////////////////////////////////////////////////////////////////////  
    public void getSpecialist() {
        specialistDirectory = objDirect.fromtblDirectory("Select * from tblDirectory");
        for (int i = 0; i < objDirect.getSize(); i++) {
            dlstDirectory.addElement(specialistDirectory[i].toString());
        }
    }

    
////////////////////////////////////////////////////////////////////////////////   
//       public void getStaffSorted(String x) {
//         dlstDirectory.clear();
//         staffDirectory = objDirect.fromtblDirectory(x);
//        for (int i = 0; i < objDirect.getSize(); i++) {
//            dlstDirectory.addElement(staffDirectory[i].toString());
//        }
//    }
    
 //////////////////////////////////////////////////////////////////////////////// 
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstDirectory = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblsname = new javax.swing.JLabel();
        lblgender = new javax.swing.JLabel();
        lblSpecialty = new javax.swing.JLabel();
        lblResidence = new javax.swing.JLabel();
        lblQualifications = new javax.swing.JLabel();
        lblQualifications1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfContact1 = new javax.swing.JTextField();
        tfContact2 = new javax.swing.JTextField();
        tfContact3 = new javax.swing.JTextField();
        tfContact4 = new javax.swing.JTextField();
        tfContact5 = new javax.swing.JTextField();
        tfContact6 = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 60, -1));

        lstDirectory.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lstDirectory.setModel(dlstDirectory);
        jScrollPane1.setViewportView(lstDirectory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 730, 550));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Directory/EmergencyDoctorLogo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 180, 200));

        lblname.setText("Name:");
        jPanel1.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 50, 30));

        lblsname.setText("Surname:");
        jPanel1.add(lblsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 90, 30));

        lblgender.setText("Sex:");
        jPanel1.add(lblgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 90, 30));

        lblSpecialty.setText("Specialty: ");
        jPanel1.add(lblSpecialty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 90, 30));

        lblResidence.setText("Residence:");
        jPanel1.add(lblResidence, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 90, 30));

        lblQualifications.setText("Contact No:");
        jPanel1.add(lblQualifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 90, 30));

        lblQualifications1.setText("Qualifications:");
        jPanel1.add(lblQualifications1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 90, 30));

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        jPanel1.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 220, 30));

        tfContact1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact1ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 220, 30));

        tfContact2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact2ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 220, 30));

        tfContact3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact3ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 220, 40));

        tfContact4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact4ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 220, 50));

        tfContact5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact5ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 170, 30));

        tfContact6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact6ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 410, 610));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 0, 51));
        lblTitle.setText("Find a MediSeek Specialist ");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 720, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Directory/MS Main2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1300, 780));

        jMenu1.setText("About");

        jMenu4.setText("jMenu4");

        jMenuItem7.setText("jMenuItem7");
        jMenu4.add(jMenuItem7);

        jMenuItem6.setText("jMenuItem6");
        jMenu4.add(jMenuItem6);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DirectoryGUI_ GUI = new DirectoryGUI_();
        GUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void tfContact1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact1ActionPerformed

    private void tfContact2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact2ActionPerformed

    private void tfContact3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact3ActionPerformed

    private void tfContact4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact4ActionPerformed

    private void tfContact5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact5ActionPerformed

    private void tfContact6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact6ActionPerformed

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
            java.util.logging.Logger.getLogger(DirectoryGUI_SpecialistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DirectoryGUI_SpecialistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DirectoryGUI_SpecialistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DirectoryGUI_SpecialistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DirectoryGUI_SpecialistPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQualifications;
    private javax.swing.JLabel lblQualifications1;
    private javax.swing.JLabel lblResidence;
    private javax.swing.JLabel lblSpecialty;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblgender;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblsname;
    private javax.swing.JList<String> lstDirectory;
    private javax.swing.JTextField tfContact1;
    private javax.swing.JTextField tfContact2;
    private javax.swing.JTextField tfContact3;
    private javax.swing.JTextField tfContact4;
    private javax.swing.JTextField tfContact5;
    private javax.swing.JTextField tfContact6;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
