/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Directory;

import javax.swing.DefaultListModel;
import mediseek.pat.START.LoginGUI;
import mediseek.pat.Tables.Residences;
import mediseek.pat.Tables.useResidences;

/**
 *
 * @author tendi
 */
public class DirectoryGUI_ResidencePage extends javax.swing.JFrame {

    
    DefaultListModel dlstResidences = new DefaultListModel();
 Residences[] resDirectory = new Residences[500]; 
 useResidences objRes = new useResidences(); 
    
    
    
    public DirectoryGUI_ResidencePage() {
        initComponents();
        getResidence();
    }

   ///////////////////////////////////////////////////////////////////////////////  
    public void getResidence() {
        resDirectory = objRes.fromtblResidences("Select * from tblResidences");
        for (int i = 0; i < objRes.getSize(); i++) {
            dlstResidences.addElement(resDirectory[i].toString());
        }
    }

    
////////////////////////////////////////////////////////////////////////////////   
    
//      public void getStaffSorted(String x) {
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
        lstResidences = new javax.swing.JList<>();
        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        lblsname = new javax.swing.JLabel();
        lblSpecialty = new javax.swing.JLabel();
        lblQualifications = new javax.swing.JLabel();
        lblQualifications1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfContact2 = new javax.swing.JTextField();
        tfContact4 = new javax.swing.JTextField();
        tfContact5 = new javax.swing.JTextField();
        tfContact6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        lstResidences.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lstResidences.setModel(dlstResidences);
        jScrollPane1.setViewportView(lstResidences);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 690, 550));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 0, 51));
        lblTitle.setText("Find a MediSeek Residency");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 720, 80));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblname.setText("Residency:");
        jPanel1.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 70, 30));

        lblsname.setText("Housing Capacity: ");
        jPanel1.add(lblsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 140, 30));

        lblSpecialty.setText("Province:");
        jPanel1.add(lblSpecialty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, 30));

        lblQualifications.setText("Contact No:");
        jPanel1.add(lblQualifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 90, 30));

        lblQualifications1.setText("Address:");
        jPanel1.add(lblQualifications1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 90, 30));

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        jPanel1.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 220, 30));

        tfContact2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact2ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 220, 30));

        tfContact4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact4ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 220, 50));

        tfContact5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact5ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 170, 30));

        tfContact6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact6ActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Directory/hospitalIcon.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jCheckBox1.setText("Has a Covid-19 Testing Station");
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 410, 630));

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

    private void tfContact2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact2ActionPerformed

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
            java.util.logging.Logger.getLogger(DirectoryGUI_ResidencePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DirectoryGUI_ResidencePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DirectoryGUI_ResidencePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DirectoryGUI_ResidencePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DirectoryGUI_ResidencePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel lblSpecialty;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblsname;
    private javax.swing.JList<String> lstResidences;
    private javax.swing.JTextField tfContact2;
    private javax.swing.JTextField tfContact4;
    private javax.swing.JTextField tfContact5;
    private javax.swing.JTextField tfContact6;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
