/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Administator;
import javax.swing.JOptionPane;
import mediseek.pat.CriticalClasses.DataValidation;
import mediseek.pat.CriticalClasses.Methods;
import mediseek.pat.START.LoginGUIoption;
import mediseek.pat.Tables.Staff;
import mediseek.pat.Tables.useStaff;
import mediseek.pat.Administator.AdministratorPages;
/**
 *
 * @author tendi
 */
public class AdministratorGUIlogin extends javax.swing.JFrame {
//  OJECTS FOR RECORD SELECTION
useStaff objStaff = new useStaff();
Staff[] staffDirectory = new Staff[500]; 
 
//OTHER OBJECTS
DataValidation objValidation = new DataValidation();
Methods obj = new Methods();
    /**
     * Creates new form AdministratorGUIlogin
     */
    public AdministratorGUIlogin() {
        initComponents();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_ID = new javax.swing.JTextField();
        lbl_ID = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        Backgournd = new javax.swing.JLabel();
        lblAccent2 = new javax.swing.JLabel();
        pswPassword = new javax.swing.JPasswordField();
        lblErrorMessage = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_ID.setToolTipText("Enter the identification code issued upon your arrival.\nIf forgotton please visit the admin office.\n(gender symbol)(first letter of first name)(first letter of last name)-(staff number)\n\ni.e   mxx-123");
        tf_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IDActionPerformed(evt);
            }
        });
        getContentPane().add(tf_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 220, -1));

        lbl_ID.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbl_ID.setForeground(new java.awt.Color(0, 102, 102));
        lbl_ID.setText("STAFF ID:");
        getContentPane().add(lbl_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        lblPassword.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 102, 102));
        lblPassword.setText("PASSWORD:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        btnLogin.setBackground(new java.awt.Color(204, 255, 255));
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 80, 40));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 60)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Admin login:");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 420, 80));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, -1, -1));
        getContentPane().add(Backgournd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 790));
        getContentPane().add(lblAccent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 40, 790));
        getContentPane().add(pswPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 220, -1));

        lblErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lblErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 330, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/MS LOGIN.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 790));

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

    private void tf_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_IDActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        LoginGUIoption newGUI = new LoginGUIoption();
        newGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
  
  String userID = tf_ID.getText();
  staffDirectory = objStaff.fromtblStaff("SELECT * FROM tblStaff WHERE [Job Description]= 'administrator'; ");
  String ID = tf_ID.getText(), 
         password = pswPassword.getText(),
         correctPassword = "";
        boolean found = false;
  lblErrorMessage.setText("");                  
   
if(objValidation.isNotEmpty(ID)==true && objValidation.isNotEmpty(password)==true){
       
            
             for (int i = 0; i < objStaff.getSize(); i++) {
                   if(ID.equalsIgnoreCase(staffDirectory[i].getStaff_ID())){
                       found = true;
                       correctPassword = staffDirectory[i].getPassword();
                   }else{
                           tf_ID.setText("");
                           pswPassword.setText("");
                           lblErrorMessage.setText("STAFF ID DOES NOT EXIST! Try Again");}
             }
    
            
            if(found){
                if(password.equalsIgnoreCase(correctPassword)){
                        AdministratorPages log = new AdministratorPages(userID);
                        tf_ID.setText("");
                        pswPassword.setText("");
                        log.setVisible(true);
                        this.dispose();
                }else {    tf_ID.setText(ID);
                           pswPassword.setText("");
                           lblErrorMessage.setText("INCORRECT PASSWORD! Try Again");}
            }
                        
   
 }else {JOptionPane.showMessageDialog(null, "LOGIN FAILED \nPlease ensure that both the STAFF ID and PASSWORD have been entered before trying to proceed.");
 }
        
        
  
        
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(AdministratorGUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorGUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorGUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorGUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorGUIlogin().setVisible(true);
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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblAccent2;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField tf_ID;
    // End of variables declaration//GEN-END:variables
}
