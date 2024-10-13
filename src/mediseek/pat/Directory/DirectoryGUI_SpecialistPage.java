/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Directory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mediseek.pat.CriticalClasses.Methods;
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
 Methods obj = new Methods();   
    
 /**
     * Constructor method that displays the array in the list
     */
    public DirectoryGUI_SpecialistPage() {
        initComponents();
        getSpecialist();
    }

  ////////////////////////////////////////////////////////////////////////////////  
    /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     */
    public void getSpecialist() {
        specialistDirectory = objDirect.fromtblDirectory("Select * from tblDirectory order by specialty");
        for (int i = 0; i < objDirect.getSize(); i++) {
            dlstDirectory.addElement(specialistDirectory[i].toString());
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
        tfSurname = new javax.swing.JTextField();
        tfSpec = new javax.swing.JTextField();
        tfResidence = new javax.swing.JTextField();
        tfQual = new javax.swing.JTextField();
        tfContact = new javax.swing.JTextField();
        tfGender = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnSeeInStaffPanel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 810, 550));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Directory/EmergencyDoctorLogo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 180, 200));

        lblname.setText("Name:");
        jPanel1.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 50, 30));

        lblsname.setText("Surname:");
        jPanel1.add(lblsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 90, 30));

        lblgender.setText("Sex:");
        jPanel1.add(lblgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 40, 30));

        lblSpecialty.setText("Specialty: ");
        jPanel1.add(lblSpecialty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 90, 30));

        lblResidence.setText("Residence:");
        jPanel1.add(lblResidence, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 90, 30));

        lblQualifications.setText("Contact No:");
        jPanel1.add(lblQualifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 90, 30));

        lblQualifications1.setText("Qualifications:");
        jPanel1.add(lblQualifications1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 90, 30));

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        jPanel1.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 220, 30));

        tfSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSurnameActionPerformed(evt);
            }
        });
        jPanel1.add(tfSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 220, 30));

        tfSpec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSpecActionPerformed(evt);
            }
        });
        jPanel1.add(tfSpec, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 220, 30));

        tfResidence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResidenceActionPerformed(evt);
            }
        });
        jPanel1.add(tfResidence, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 220, 40));

        tfQual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQualActionPerformed(evt);
            }
        });
        jPanel1.add(tfQual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 350, 60));

        tfContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactActionPerformed(evt);
            }
        });
        jPanel1.add(tfContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 170, 30));

        tfGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGenderActionPerformed(evt);
            }
        });
        jPanel1.add(tfGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 410, 610));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 0, 51));
        lblTitle.setText("Find a MediSeek Specialist ");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 720, 80));

        jLabel24.setText("Once a Record has been selected Click below:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, -1, 30));

        btnSeeInStaffPanel.setText("See Specialist's Info");
        btnSeeInStaffPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInStaffPanelActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeeInStaffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, 220, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:                      Surname:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, -1));

        jLabel3.setText("Sex:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jLabel5.setText("Location of Practice: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 190, -1));

        jLabel6.setText("Specialty:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 70, -1));

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

    private void tfSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSurnameActionPerformed

    private void tfSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecActionPerformed

    private void tfResidenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResidenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResidenceActionPerformed

    private void tfQualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQualActionPerformed

    private void tfContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactActionPerformed

    private void tfGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGenderActionPerformed

    private void btnSeeInStaffPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInStaffPanelActionPerformed
// DefaultListModel dlstDirectory = new DefaultListModel();
// directory[] specialistDirectory = new directory[500]; 
// useDirectory objDirect = new useDirectory();
        if (lstDirectory.getSelectedIndex()>-1)//edits a new record in the table and refreshes the display of the list
        {

            tfName.setText(""+specialistDirectory[lstDirectory.getSelectedIndex()].getsName());
            tfSurname.setText(""+specialistDirectory[lstDirectory.getSelectedIndex()].getsSurname());
            tfGender.setText(""+specialistDirectory[lstDirectory.getSelectedIndex()].getGender());
            tfQual.setText(""+specialistDirectory[lstDirectory.getSelectedIndex()].getQualifications());
            tfSpec.setText(""+specialistDirectory[lstDirectory.getSelectedIndex()].getSpecialty());
            tfResidence.setText(""+specialistDirectory[lstDirectory.getSelectedIndex()].getResidence());
            tfContact.setText(""+specialistDirectory[lstDirectory.getSelectedIndex()].getContact());


        }else {JOptionPane.showMessageDialog(null, " SELECT A SPECIALIST TO VIEW");}
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
    private javax.swing.JButton btnSeeInStaffPanel;
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
    private javax.swing.JLabel lblResidence;
    private javax.swing.JLabel lblSpecialty;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblgender;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblsname;
    private javax.swing.JList<String> lstDirectory;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfGender;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfQual;
    private javax.swing.JTextField tfResidence;
    private javax.swing.JTextField tfSpec;
    private javax.swing.JTextField tfSurname;
    // End of variables declaration//GEN-END:variables
}
