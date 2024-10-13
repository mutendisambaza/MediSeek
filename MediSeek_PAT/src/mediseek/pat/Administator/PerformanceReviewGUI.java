/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Administator;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tendi
 */
public class PerformanceReviewGUI extends javax.swing.JFrame {

    /**
     * Creates new form PerformanceReviewGUI
     */
    public PerformanceReviewGUI() {
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

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        cbReviewPeriod = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 255, 204));
        lblTitle.setText("Select the Time Period");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 440, 100));

        lblTitle1.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(102, 255, 204));
        lblTitle1.setText("you wish to view:");
        jPanel1.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 330, 80));

        cbReviewPeriod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "To Date", "January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Whole Year" }));
        cbReviewPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReviewPeriodActionPerformed(evt);
            }
        });
        jPanel1.add(cbReviewPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 140, -1));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setText("See Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         //https://www.youtube.com/watch?v=RUDrjqywD1g
        
        DefaultCategoryDataset dod = new DefaultCategoryDataset();
     //data entries
     dod.setValue(10, "Patients", "tendi");
     dod.setValue(10, "Patients", "chris");
     dod.setValue(10, "Patients", "muffy");
     dod.setValue(10, "Patients", "yamu");
     dod.setValue(10, "Patients", "cheryl");
    //labeling the axis and creating graphing specifications
        JFreeChart jchart = null;
    switch(cbReviewPeriod.getSelectedIndex()){
         case 0:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(0), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);
            break;
        case 1:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(1), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);
            break;
        case 2:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(2), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);         
            break;
        case 3:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(3), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;
        case 4:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(4), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;
        case 5:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(5), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;    
        case 6:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(6), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;    
        case 7:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(7), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;    
        case 8:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(8), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;    
        case 9:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(9), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;    
        case 10:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(10), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;
        case 11:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(11), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;
        case 12:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(12), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;
        case 13:jchart = ChartFactory.createBarChart3D("Staff Performance Review: "+cbReviewPeriod.getItemAt(13), "Staff Name", "Number of Patients in Care", dod, PlotOrientation.VERTICAL, true, true, false);    
            break;   
            
    }
    
    
     CategoryPlot plot = jchart.getCategoryPlot();
     plot.setRangeGridlinePaint(Color.GRAY);
        
     ChartFrame chartFrm = new ChartFrame("Staff Performance Review",jchart,true);
     chartFrm.setVisible(true);
     chartFrm.setSize(1300, 850);       
     ChartPanel chartPanel = new ChartPanel(jchart);
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbReviewPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReviewPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbReviewPeriodActionPerformed

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
            java.util.logging.Logger.getLogger(PerformanceReviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerformanceReviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerformanceReviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerformanceReviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerformanceReviewGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbReviewPeriod;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    // End of variables declaration//GEN-END:variables
}
