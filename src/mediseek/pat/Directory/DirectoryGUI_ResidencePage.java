/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Directory;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mediseek.pat.CriticalClasses.Methods;
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
    
Methods obj = new Methods();    
   /**
     * Constructor method that displays the array in the list
     */ 
    public DirectoryGUI_ResidencePage() {
        initComponents();
        getResidence();
    }

   ///////////////////////////////////////////////////////////////////////////////  
   /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     */
    public void getResidence() {
        resDirectory = objRes.fromtblResidences("Select * from tblResidences order by province");
        for (int i = 0; i < objRes.getSize(); i++) {
            dlstResidences.addElement(resDirectory[i].toString());
        }
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        btnSeeInStaffPanel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstResidences = new javax.swing.JList<>();
        lblTitle = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        lblsname = new javax.swing.JLabel();
        lblSpecialty = new javax.swing.JLabel();
        lblQualifications = new javax.swing.JLabel();
        lblQualifications1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfProvince = new javax.swing.JTextField();
        tfaddress = new javax.swing.JTextField();
        tfContact = new javax.swing.JTextField();
        tfCapacity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbCovid = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSeeInStaffPanel.setText("See Residence Info");
        btnSeeInStaffPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInStaffPanelActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeeInStaffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 220, 30));

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
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 720, 80));

        jLabel24.setText("Once a Record has been selected Click below:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 76, -1, 20));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblname.setText("Residency:");
        jPanel1.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 70, 30));

        lblsname.setText("Housing Capacity: ");
        jPanel1.add(lblsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 110, 30));

        lblSpecialty.setText("Province:");
        jPanel1.add(lblSpecialty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, 30));

        lblQualifications.setText("Contact No:");
        jPanel1.add(lblQualifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 90, 30));

        lblQualifications1.setText("Address:");
        jPanel1.add(lblQualifications1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 60, 30));

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        jPanel1.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 220, 30));

        tfProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProvinceActionPerformed(evt);
            }
        });
        jPanel1.add(tfProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 220, 30));

        tfaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfaddressActionPerformed(evt);
            }
        });
        jPanel1.add(tfaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 370, 40));

        tfContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 170, 30));

        tfCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCapacityActionPerformed(evt);
            }
        });
        jPanel1.add(tfCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Directory/hospitalIcon.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        cbCovid.setText("Has a Covid-19 Testing Station");
        jPanel1.add(cbCovid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 410, 620));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Capacity:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Covid Test Centre?");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 120, 120, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Name of residence:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 120, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Province:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 120, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Directory/MS Main2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1300, 780));

        jMenu1.setText("About");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Who are we?");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem7.setText("Using the Program");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

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

    private void tfProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProvinceActionPerformed

    private void tfaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfaddressActionPerformed

    private void tfContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactActionPerformed

    private void tfCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCapacityActionPerformed

    private void btnSeeInStaffPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInStaffPanelActionPerformed

        if (lstResidences.getSelectedIndex()>-1)//edits a new record in the table and refreshes the display of the list
        {   

            tfName.setText(""+resDirectory[lstResidences.getSelectedIndex()].getResidences());
            tfCapacity.setText(""+resDirectory[lstResidences.getSelectedIndex()].getCapacity());
            tfProvince.setText(""+resDirectory[lstResidences.getSelectedIndex()].getProvince());
            tfaddress.setText(""+resDirectory[lstResidences.getSelectedIndex()].getAddress());
            cbCovid.setSelected(resDirectory[lstResidences.getSelectedIndex()].isCovidTestStation());
            tfContact.setText(""+resDirectory[lstResidences.getSelectedIndex()].getContact());
            
    

        }else {JOptionPane.showMessageDialog(null, " SELECT A RESIDENCY TO VIEW");}

    }//GEN-LAST:event_btnSeeInStaffPanelActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        obj.openWord("MediSeek Who are we.docx");

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        obj.openWord("MediSeek Help.docx");

    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
    private javax.swing.JButton btnSeeInStaffPanel;
    private javax.swing.JCheckBox cbCovid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
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
    private javax.swing.JTextField tfCapacity;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfProvince;
    private javax.swing.JTextField tfaddress;
    // End of variables declaration//GEN-END:variables
}
