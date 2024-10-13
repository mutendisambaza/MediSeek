/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Doctor;

import javax.swing.DefaultListModel;
import mediseek.pat.Pharmacist.*;
import mediseek.pat.START.LoginGUIoption;
import mediseek.pat.Tables.Patients;
import mediseek.pat.Tables.usePatients;

/**
 *
 * @author tendi
 */
public class DoctortPage extends javax.swing.JFrame {

DefaultListModel dlstPatients = new DefaultListModel();
Patients[] patientDirectory = new Patients[100]; 
usePatients objPatients = new usePatients();
     
    
    
    public DoctortPage() {
        initComponents();
        getPatients();
    }
 
    
 ////////////////////////////////////////////////////////////////////////////////
    public void getPatients() {
        patientDirectory = objPatients.fromtblPatients("SELECT * FROM tblPatients;");
        for (int i = 0; i < objPatients.getSize(); i++) {
            dlstPatients.addElement(patientDirectory[i].toString());
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ViewPatientsTab = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        PatientInfoPanel = new javax.swing.JPanel();
        tfname = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        lblsname = new javax.swing.JLabel();
        tfDiagnosis = new javax.swing.JTextField();
        lblgender1 = new javax.swing.JLabel();
        tfSname = new javax.swing.JTextField();
        lbldIAGNOSIS = new javax.swing.JLabel();
        tfSymptoms = new javax.swing.JTextField();
        lblSymptoms = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        cbSpecCode = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblgender2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPatients = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ViewAppointmentsTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAppoint = new javax.swing.JList<>();
        lblTitle2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        ViewPatientsHistoryTab = new javax.swing.JPanel();
        lblTitle3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        AddStaffTab1 = new javax.swing.JPanel();
        tfPasswordADD1 = new javax.swing.JTextField();
        lblname8 = new javax.swing.JLabel();
        lblsname4 = new javax.swing.JLabel();
        tfQualADD1 = new javax.swing.JTextField();
        lblJD4 = new javax.swing.JLabel();
        tfSnameADD1 = new javax.swing.JTextField();
        lbldIAGNOSIS4 = new javax.swing.JLabel();
        tfResidenceADD1 = new javax.swing.JTextField();
        lblSymptoms4 = new javax.swing.JLabel();
        cbGenderADD1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnAddStaff1 = new javax.swing.JButton();
        btnLOGOUT2 = new javax.swing.JButton();
        cbSpecialtyADD1 = new javax.swing.JComboBox<>();
        lblgender6 = new javax.swing.JLabel();
        lblJD5 = new javax.swing.JLabel();
        cbJobADD1 = new javax.swing.JComboBox<>();
        tfnameADD1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblname9 = new javax.swing.JLabel();
        lblname10 = new javax.swing.JLabel();
        tfContactADD1 = new javax.swing.JTextField();
        lblTitle5 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(126, 145, 158));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PatientInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnameActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 50));

        lblname.setText("Name:");
        PatientInfoPanel.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));

        lblsname.setText("Surname:");
        PatientInfoPanel.add(lblsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, -1));

        tfDiagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDiagnosisActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfDiagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 430, 120));

        lblgender1.setText("Specialty Code:");
        PatientInfoPanel.add(lblgender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, 30));

        tfSname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnameActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 230, 50));

        lbldIAGNOSIS.setText("Diagnosis:");
        PatientInfoPanel.add(lbldIAGNOSIS, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, 30));

        tfSymptoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSymptomsActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSymptoms, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 430, 70));

        lblSymptoms.setText("Prescription:");
        PatientInfoPanel.add(lblSymptoms, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, 30));

        jCheckBox1.setText("Patient Possesses Medical Aid");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 210, -1));

        cbSpecCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cbSpecCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSpecCodeActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(cbSpecCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 120, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/INJUREDpatient.png"))); // NOI18N
        PatientInfoPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 280));

        jButton2.setText("Update Patient Details");
        PatientInfoPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 540, 160, -1));

        lblgender2.setText("Sex:");
        PatientInfoPanel.add(lblgender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 120, 30));

        jPanel4.add(PatientInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 1070, 580));

        lstPatients.setModel(dlstPatients);
        jScrollPane1.setViewportView(lstPatients);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 900, 120));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, 220, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Place patients in order of:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 220, 30));
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Patient Information:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 140, 30));

        lblTitle1.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("View Patients");
        jPanel4.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, 80));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Patient ID:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        ViewPatientsTab.setViewportView(jPanel4);

        jTabbedPane1.addTab("View Patients", ViewPatientsTab);

        ViewAppointmentsTab.setBackground(new java.awt.Color(126, 145, 158));
        ViewAppointmentsTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setViewportView(lstAppoint);

        ViewAppointmentsTab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1190, 450));

        lblTitle2.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("View Your Appointments:");
        ViewAppointmentsTab.add(lblTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 390, 80));
        ViewAppointmentsTab.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 280, -1));

        jTabbedPane1.addTab("View Appointments", ViewAppointmentsTab);

        ViewPatientsHistoryTab.setBackground(new java.awt.Color(102, 116, 141));
        ViewPatientsHistoryTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle3.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setText("View Patients History:");
        ViewPatientsHistoryTab.add(lblTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));
        ViewPatientsHistoryTab.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 180, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Patient ID:");
        ViewPatientsHistoryTab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 90, 30));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        ViewPatientsHistoryTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1160, 360));

        jButton1.setText("See History of Patient");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ViewPatientsHistoryTab.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 160, 40));

        jTabbedPane1.addTab("View Patient History", ViewPatientsHistoryTab);

        AddStaffTab1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPasswordADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfPasswordADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 170, 30));

        lblname8.setText("Staff ID Password: ");
        AddStaffTab1.add(lblname8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 120, 30));

        lblsname4.setText("Surname:");
        AddStaffTab1.add(lblsname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 90, -1));

        tfQualADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQualADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfQualADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 430, 70));

        lblJD4.setText("Specialty: ");
        AddStaffTab1.add(lblJD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 90, 30));

        tfSnameADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnameADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfSnameADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 230, 50));

        lbldIAGNOSIS4.setText("Qualifications:");
        AddStaffTab1.add(lbldIAGNOSIS4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 90, 30));

        tfResidenceADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResidenceADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfResidenceADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 430, 60));

        lblSymptoms4.setText("Residence:");
        AddStaffTab1.add(lblSymptoms4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 90, 30));

        cbGenderADD1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cbGenderADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenderADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(cbGenderADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 200, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/medicalstafficon.jpg"))); // NOI18N
        AddStaffTab1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 260, 270));

        btnAddStaff1.setText("Update Your Information");
        AddStaffTab1.add(btnAddStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 220, -1));

        btnLOGOUT2.setText("LOGOUT");
        btnLOGOUT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUT2ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(btnLOGOUT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, -440, -1, -1));

        cbSpecialtyADD1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a specialty:", "Administration", "General Practitioner", "Cardiologist", "Pharmacist", "Infectious Diseases Specialist", "Prosthetist", "Neurologist", "Gynaecologist", "Oncologist", " ", " " }));
        cbSpecialtyADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSpecialtyADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(cbSpecialtyADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 200, 30));

        lblgender6.setText("Sex:");
        AddStaffTab1.add(lblgender6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 90, 30));

        lblJD5.setText("Job Description:");
        AddStaffTab1.add(lblJD5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, 90, 30));

        cbJobADD1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a description", "Doctor", "Pharmacist", "Receptionist", "Administrator" }));
        AddStaffTab1.add(cbJobADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 290, 200, 30));

        tfnameADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnameADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfnameADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 230, 50));

        jLabel15.setText("Personal Information");
        AddStaffTab1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 130, 30));

        lblname9.setText("Name:");
        AddStaffTab1.add(lblname9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 90, 30));

        lblname10.setText("Contact No:");
        AddStaffTab1.add(lblname10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 90, 30));

        tfContactADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactADD1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfContactADD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 170, 30));

        lblTitle5.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle5.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle5.setText("Your Personal Info:");
        AddStaffTab1.add(lblTitle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));

        jTabbedPane1.addTab("Personal Information", AddStaffTab1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1260, 640));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Doctor");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 80));

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\tendi\\OneDrive\\Education\\IT\\PAT\\Grade 12 PAT\\MediSeek_PAT\\MS Main1.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 770));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameActionPerformed

    private void tfDiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDiagnosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDiagnosisActionPerformed

    private void tfSnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnameActionPerformed

    private void tfSymptomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSymptomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSymptomsActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cbSpecCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSpecCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSpecCodeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
      LoginGUIoption LoginGUI = new LoginGUIoption();
        LoginGUI.setVisible(true);
        this.dispose();
        
        
        
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tfPasswordADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordADD1ActionPerformed

    private void tfQualADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQualADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQualADD1ActionPerformed

    private void tfSnameADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnameADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnameADD1ActionPerformed

    private void tfResidenceADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResidenceADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResidenceADD1ActionPerformed

    private void cbGenderADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenderADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGenderADD1ActionPerformed

    private void btnLOGOUT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLOGOUT2ActionPerformed

    private void cbSpecialtyADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSpecialtyADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSpecialtyADD1ActionPerformed

    private void tfnameADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameADD1ActionPerformed

    private void tfContactADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactADD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactADD1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DoctortPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctortPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctortPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctortPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctortPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddStaffTab1;
    private javax.swing.JPanel PatientInfoPanel;
    private javax.swing.JPanel ViewAppointmentsTab;
    private javax.swing.JPanel ViewPatientsHistoryTab;
    private javax.swing.JScrollPane ViewPatientsTab;
    private javax.swing.JButton btnAddStaff1;
    private javax.swing.JButton btnLOGOUT2;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> cbGenderADD1;
    private javax.swing.JComboBox<String> cbJobADD1;
    private javax.swing.JComboBox<String> cbSpecCode;
    private javax.swing.JComboBox<String> cbSpecialtyADD1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblJD4;
    private javax.swing.JLabel lblJD5;
    private javax.swing.JLabel lblSymptoms;
    private javax.swing.JLabel lblSymptoms4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lbldIAGNOSIS;
    private javax.swing.JLabel lbldIAGNOSIS4;
    private javax.swing.JLabel lblgender1;
    private javax.swing.JLabel lblgender2;
    private javax.swing.JLabel lblgender6;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname10;
    private javax.swing.JLabel lblname8;
    private javax.swing.JLabel lblname9;
    private javax.swing.JLabel lblsname;
    private javax.swing.JLabel lblsname4;
    private javax.swing.JList<String> lstAppoint;
    private javax.swing.JList<String> lstPatients;
    private javax.swing.JTextField tfContactADD1;
    private javax.swing.JTextField tfDiagnosis;
    private javax.swing.JTextField tfPasswordADD1;
    private javax.swing.JTextField tfQualADD1;
    private javax.swing.JTextField tfResidenceADD1;
    private javax.swing.JTextField tfSname;
    private javax.swing.JTextField tfSnameADD1;
    private javax.swing.JTextField tfSymptoms;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfnameADD1;
    // End of variables declaration//GEN-END:variables
}
