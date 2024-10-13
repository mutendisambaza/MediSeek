/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.START;

import javax.swing.JOptionPane;

/**
 *
 * @author tendi
 */
public class START extends javax.swing.JFrame {

    /**
     * Creates new form START
     */
    public START() {
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
        pbLoading = new javax.swing.JProgressBar();
        LoadingLabel = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 100)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("MediSeek");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 530, 140));

        pbLoading.setForeground(new java.awt.Color(153, 255, 204));
        getContentPane().add(pbLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 700, -1));

        LoadingLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        LoadingLabel.setForeground(new java.awt.Color(0, 102, 102));
        LoadingLabel.setText("Loading...");
        getContentPane().add(LoadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 220, -1));

        LoadingValue.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(0, 102, 102));
        LoadingValue.setText("0%");
        getContentPane().add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/lifeline gif.gif"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

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
            java.util.logging.Logger.getLogger(START.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(START.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(START.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(START.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        START start = new START();
        start.setVisible(true);
        
        try{
            
                for(int i =0; i<100;i++){
                    Thread.sleep(100);
                    start.LoadingValue.setText(i+"%");
                    
                    if(i==10){
                        start.LoadingLabel.setText("Loading...");
                    }
                    if(i==20){
                        start.LoadingLabel.setText("Configuring Program...");
                    }
                    if(i==40){
                        start.LoadingLabel.setText("Connecting to Databases...");
                    }
                    if(i==60){
                        start.LoadingLabel.setText("Collecting Files...");
                    }
                    if(i==80){
                        start.LoadingLabel.setText("Connection Successful...");
                    }
                    if(i==90){
                        start.LoadingLabel.setText("Launching Application...");
                    }
                    
                   start.pbLoading.setValue(i);
                    
                    
                }
        
         } catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
        
        LoginGUI log = new LoginGUI();
        log.setVisible(true);
        start.setVisible(false);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel background;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JProgressBar pbLoading;
    // End of variables declaration//GEN-END:variables
}
