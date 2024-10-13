/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Administator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mediseek.pat.CriticalClasses.DataValidation;
import mediseek.pat.CriticalClasses.Methods;
import mediseek.pat.START.LoginGUI;
import mediseek.pat.Tables.Staff;
import mediseek.pat.Tables.Appointments;
import mediseek.pat.Tables.Patients;
import mediseek.pat.Tables.Specialty;
import mediseek.pat.Tables.useAppointments;
import mediseek.pat.Tables.usePatients;
import mediseek.pat.Tables.useSpecialty;
import mediseek.pat.Tables.useStaff;



/**
 *
 * @author tendi
 */
public class AdministratorPages extends javax.swing.JFrame {
//  OJECTS FOR RECORD SELECTION

DefaultListModel dlstStaff = new DefaultListModel();
Staff[] staffDirectory = new Staff[500]; 
Staff[] user = new Staff[1];
useStaff objStaff = new useStaff();
Staff[] staffDirectorySearch = new Staff[10]; 
Staff[] staffDirectoryRefined = new Staff[500]; 

DefaultListModel dlstPatients = new DefaultListModel();
Patients[] patientDirectory = new Patients[100]; 
usePatients objPatients = new usePatients();
Patients[] patientDirectorySearch = new Patients[10]; 

DefaultListModel dlstSpecialties = new DefaultListModel();
Specialty[] specialtyDirectory = new Specialty[100]; 
useSpecialty objSpec = new useSpecialty();
   
DefaultListModel dlstAppoint = new DefaultListModel();
Appointments[] appDirectory = new Appointments[100]; 
useAppointments objApp = new useAppointments();

//OTHER OBJECTS
DataValidation objValidation = new DataValidation();
AdministratorGUIlogin loginObj = new AdministratorGUIlogin();
Methods obj = new Methods();
private String usertemp;
/**
     * Constructor method that displays the arrays in their respective lists
     * Takes the userID entered in the login and and saves it in a global variable
     * Also places all the information of the  user in their necessary fields on the personal information
     */
 public AdministratorPages(String userID){
     initComponents();
     getSpecialties();
     getPatients();
     getStaff();
     getAppointments();
     usertemp = userID;
        tfnamePERSONAL.setText(""+getUserInfo().getsName());
        tfSnamePERSONAL.setText(""+getUserInfo().getsSurname());
        tfSexPERSONAL.setText(""+getUserInfo().getGender());
        tfJobDescPERSONAL.setText(""+getUserInfo().getJobDescription());
        tfSpecPERSONAL.setText(""+getUserInfo().getSpecialty());
        tfResidencePERSONAL.setText(""+getUserInfo().getResidence());     
        tfQualPERSONAL.setText(""+getUserInfo().getQualifications());
        tfContactPERSONAL.setText(""+getUserInfo().getContact());   
        tfPasswordPERSONAL.setText(""+getUserInfo().getPassword());   
        
 }
 /**
     * Constructor method that displays the arrays in their respective lists
     * Takes the userID entered in the login and and saves it in a global variable
     */
 public AdministratorPages() { 
     initComponents();
     getSpecialties();
     getPatients();
     getStaff();
     getAppointments();
 
        
    }

    /////////////////////////////////////////////////////////////////////////////
  /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     * This will get all the records of the appointments scheduled
     */   
    
  public void getAppointments() {
        appDirectory = objApp.fromtblAppointments("Select * from tblAppointments;");
        for (int i = 0; i < objApp.getSize(); i++) {
            dlstAppoint.addElement(appDirectory[i].toString());
        }
    }  
    /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     */
  public void getSpecialties() {
        specialtyDirectory = objSpec.fromtblSpecialty("SELECT * FROM tblSpecialties;");
        for (int i = 0; i < objSpec.getSize(); i++) {
            dlstSpecialties.addElement(specialtyDirectory[i].toString());
        }
    }  
/**
 * Method fills an array with the elements based on the SQL Statement
 * Displays the elements in an list
 * This will be the records of the patients in the hospital
 */
      public void getPatients() {
        patientDirectory = objPatients.fromtblPatients("select * from tblPatients");
        for (int i = 0; i < objPatients.getSize(); i++) {
            dlstPatients.addElement(patientDirectory[i].toString());
        }
    } 
  /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which specifically looks for the Patient ID
     * Displays the elements in an list
     */    
      public void searchPatient(String patient_ID) {
        dlstPatients.clear();
        patientDirectorySearch = objPatients.fromtblPatients("SELECT * FROM tblPatients where Patient_ID = \""+patient_ID+"\";");
        for (int i = 0; i < objPatients.getSize(); i++) {
            dlstPatients.addElement(patientDirectorySearch[i].toString());
        }
    } 
      /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     * 
     */
    public void getStaff() {
        staffDirectory = objStaff.fromtblStaff("SELECT * FROM tblStaff;");
        for (int i = 0; i < objStaff.getSize(); i++) {
            dlstStaff.addElement(staffDirectory[i].toStringView());
        }
    }
    /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which specifically looks for the Staff ID
     * Displays the elements in an list
     */    
     public void searchStaff(String staff_ID) {
        dlstStaff.clear();
        staffDirectorySearch = objStaff.fromtblStaff("SELECT * FROM tblstaff WHERE Staff_ID = \"" + staff_ID + "\";");
        for (int i = 0; i < objStaff.getSize(); i++) {
            dlstStaff.addElement(staffDirectorySearch[i].toStringView());
        }
    }
////////////////////////////////////////////////////////////////////////////////
   /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which specifically looks for the Staff ID
     * Only making use of the first record [top of the search]
     * This will be the record of the user that logs in
     */ 
     public Staff getUserInfo(){  
         String test = usertemp;
        user = objStaff.fromtblStaff("SELECT * FROM tblStaff WHERE Staff_ID = '"  + usertemp + "';");
        String testing = user[0].toString();
                return user[0];
    }
////////////////////////////////////////////////////////////////////////////////
  /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which will contain an ORDER BY statement in order
     * to retrieve an array in an order
     * It then fills the list with each individual element until they are none left
     * This is to get th order of Staff
     */ 
     
     public void getStaffSorted(String x) {
         dlstStaff.clear();
         staffDirectoryRefined = objStaff.fromtblStaff(x);
        for (int i = 0; i < objStaff.getSize(); i++) {
            System.out.println(staffDirectoryRefined[i].toStringView());      
            dlstStaff.addElement(staffDirectoryRefined[i].toStringView());
        }
    }
    /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which will contain an ORDER BY statement in order
     * to retrieve an array in an order
     * It then fills the list with each individual element until they are none left
     * This is to get th order of Patients
     */ 
     
    public void getPatientsSorted(String x) {
         dlstPatients.clear();
         patientDirectory = objPatients.fromtblPatients(x);
        for (int i = 0; i < objPatients.getSize(); i++) {
            dlstPatients.addElement(patientDirectory[i].toString());
        }
    }
    /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which will contain an ORDER BY statement in order
     * to retrieve an array in an order
     * It then fills the list with each individual element until they are none left
     * This is to get th order of Appointments
     */ 
     public void getAppsSorted(String x) {
         dlstAppoint.clear();
         appDirectory = objApp.fromtblAppointments(x);
        for (int i = 0; i < objApp.getSize(); i++) {
            dlstAppoint.addElement(appDirectory[i].toString());
        }
    }
 /////////////////////////////////////////////////////////////////////////////////   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbPane = new javax.swing.JTabbedPane();
        ViewPatientsTab = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        PatientInfoPanel = new javax.swing.JPanel();
        tfname = new javax.swing.JTextField();
        lblname11 = new javax.swing.JLabel();
        lblsname5 = new javax.swing.JLabel();
        tfDiagnosis2 = new javax.swing.JTextField();
        lblgender3 = new javax.swing.JLabel();
        tfSname = new javax.swing.JTextField();
        lbldIAGNOSIS5 = new javax.swing.JLabel();
        tfPrescription = new javax.swing.JTextField();
        lblSymptoms5 = new javax.swing.JLabel();
        bxMedAid = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblgender2 = new javax.swing.JLabel();
        tfSpecCode = new javax.swing.JTextField();
        tfSex = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        btnDischarge = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPatients = new javax.swing.JList<>();
        cbPatientOrder = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfPatientID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddPatientPage = new javax.swing.JButton();
        btnShowPatient1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnSeeInPatientPanel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ViewStaffTab = new javax.swing.JPanel();
        StaffInfoPanel = new javax.swing.JPanel();
        tfPassword = new javax.swing.JTextField();
        lblname2 = new javax.swing.JLabel();
        lblsname2 = new javax.swing.JLabel();
        tfQual = new javax.swing.JTextField();
        lblJD = new javax.swing.JLabel();
        tfSname2 = new javax.swing.JTextField();
        lbldIAGNOSIS2 = new javax.swing.JLabel();
        tfResidence = new javax.swing.JTextField();
        lblSymptoms2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        UpdateStaff = new javax.swing.JButton();
        btnLOGOUT = new javax.swing.JButton();
        lblgender4 = new javax.swing.JLabel();
        lblJD1 = new javax.swing.JLabel();
        tfSex2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblname3 = new javax.swing.JLabel();
        lblname4 = new javax.swing.JLabel();
        tfContact = new javax.swing.JTextField();
        tfJobDesc = new javax.swing.JTextField();
        tfSpec = new javax.swing.JTextField();
        tfname6 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnDischarge1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstStaff = new javax.swing.JList<>();
        cbStaffSort = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfStaffID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAddStaffPage = new javax.swing.JButton();
        btnSearchPatient = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnSeeInStaffPanel = new javax.swing.JButton();
        btnRefresh1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTitle7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSpecialties = new javax.swing.JList<>();
        ViewAppointmentsTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAppoint = new javax.swing.JList<>();
        lblTitle2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cbSpecialtyApp = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cbMonthApp = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        AddPatientTab = new javax.swing.JPanel();
        tfnameADDp = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        lblsname = new javax.swing.JLabel();
        tfPrescriptionADDp = new javax.swing.JTextField();
        lblgender1 = new javax.swing.JLabel();
        tfSnameADDp = new javax.swing.JTextField();
        lbldIAGNOSIS = new javax.swing.JLabel();
        tfSymptomsADDp = new javax.swing.JTextField();
        lblSymptoms = new javax.swing.JLabel();
        cbMedAidADDp = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        btnAddPatient = new javax.swing.JButton();
        lblTitle6 = new javax.swing.JLabel();
        tfGenderADDp = new javax.swing.JTextField();
        tfSpecCodeADDp = new javax.swing.JTextField();
        lblgender7 = new javax.swing.JLabel();
        tfPatientIDADDp = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        AddStaffTab = new javax.swing.JPanel();
        tfPasswordADD = new javax.swing.JTextField();
        lblname5 = new javax.swing.JLabel();
        lblsname3 = new javax.swing.JLabel();
        tfQualADD = new javax.swing.JTextField();
        lblJD2 = new javax.swing.JLabel();
        tfSnameADD = new javax.swing.JTextField();
        lbldIAGNOSIS3 = new javax.swing.JLabel();
        tfSpecialtyADD = new javax.swing.JTextField();
        lblSymptoms3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAddStaff = new javax.swing.JButton();
        btnLOGOUT1 = new javax.swing.JButton();
        lblgender5 = new javax.swing.JLabel();
        lblJD3 = new javax.swing.JLabel();
        tfnameADD = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblname6 = new javax.swing.JLabel();
        lblname7 = new javax.swing.JLabel();
        tfContactADD = new javax.swing.JTextField();
        lblTitle5 = new javax.swing.JLabel();
        tfGenderADD = new javax.swing.JTextField();
        tfResidenceADD = new javax.swing.JTextField();
        tfJobDesADD = new javax.swing.JTextField();
        tfStaffIDADD = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        AddStaffTab1 = new javax.swing.JPanel();
        tfPasswordPERSONAL = new javax.swing.JTextField();
        lblname8 = new javax.swing.JLabel();
        lblsname4 = new javax.swing.JLabel();
        tfQualPERSONAL = new javax.swing.JTextField();
        lblJD4 = new javax.swing.JLabel();
        tfSnamePERSONAL = new javax.swing.JTextField();
        lbldIAGNOSIS4 = new javax.swing.JLabel();
        tfResidencePERSONAL = new javax.swing.JTextField();
        lblSymptoms4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAddStaff1 = new javax.swing.JButton();
        btnLOGOUT2 = new javax.swing.JButton();
        lblgender6 = new javax.swing.JLabel();
        lblJD5 = new javax.swing.JLabel();
        tfnamePERSONAL = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblname9 = new javax.swing.JLabel();
        lblname10 = new javax.swing.JLabel();
        tfContactPERSONAL = new javax.swing.JTextField();
        lblTitle4 = new javax.swing.JLabel();
        tfSexPERSONAL = new javax.swing.JTextField();
        tfSpecPERSONAL = new javax.swing.JTextField();
        tfJobDescPERSONAL = new javax.swing.JTextField();
        btnLogout = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPerformanceReview = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

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

        lblname11.setText("Name:");
        PatientInfoPanel.add(lblname11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));

        lblsname5.setText("Surname:");
        PatientInfoPanel.add(lblsname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 90, -1));

        tfDiagnosis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDiagnosis2ActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfDiagnosis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 430, 60));

        lblgender3.setText("Specialty Code:");
        PatientInfoPanel.add(lblgender3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, 30));

        tfSname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnameActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 230, 50));

        lbldIAGNOSIS5.setText("Symptoms:");
        PatientInfoPanel.add(lbldIAGNOSIS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 90, 30));

        tfPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrescriptionActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 430, 70));

        lblSymptoms5.setText("Prescription:");
        PatientInfoPanel.add(lblSymptoms5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, 30));

        bxMedAid.setText("Patient Possesses Medical Aid");
        bxMedAid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxMedAidActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(bxMedAid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 210, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/INJUREDpatient.png"))); // NOI18N
        PatientInfoPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 280));

        jButton2.setText("Update Patient Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 160, -1));

        lblgender2.setText("Sex:");
        PatientInfoPanel.add(lblgender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 90, 30));

        tfSpecCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSpecCodeActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSpecCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 130, 50));

        tfSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSexActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 100, 50));

        jLabel29.setText("If you wish to DISCHRGE this Patient:");
        PatientInfoPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, -1, -1));

        jLabel30.setText("1) Click  Below");
        PatientInfoPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, -1, -1));

        jLabel46.setText("If you wish to change the information of this Patient:");
        PatientInfoPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, -1, -1));

        jLabel47.setText("1) Change information   2) Click Update and Save Below");
        PatientInfoPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, -1));

        btnDischarge.setBackground(new java.awt.Color(255, 0, 51));
        btnDischarge.setForeground(new java.awt.Color(255, 255, 255));
        btnDischarge.setText("Discharge Patient");
        btnDischarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDischargeActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(btnDischarge, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 150, -1));

        jPanel4.add(PatientInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 1070, 580));

        lstPatients.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lstPatients.setModel(dlstPatients);
        jScrollPane1.setViewportView(lstPatients);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 900, 120));

        cbPatientOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Order", "Alphabetical Order (First Name)", "Alphabetical Order (Surname Name)", "Gender" }));
        cbPatientOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPatientOrderActionPerformed(evt);
            }
        });
        jPanel4.add(cbPatientOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, 220, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Place patients in order of:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 220, 30));

        tfPatientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPatientIDActionPerformed(evt);
            }
        });
        jPanel4.add(tfPatientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Patient Information:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 140, 30));

        lblTitle1.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("View Patients");
        jPanel4.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Patient ID:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        btnAddPatientPage.setText("Add a Patient");
        btnAddPatientPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientPageActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddPatientPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 150, -1));

        btnShowPatient1.setText("Search Patient");
        btnShowPatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPatient1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnShowPatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, -1));

        jLabel16.setText("Name");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel17.setText("Surname");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        btnSeeInPatientPanel.setText("See Patient Info");
        btnSeeInPatientPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInPatientPanelActionPerformed(evt);
            }
        });
        jPanel4.add(btnSeeInPatientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jLabel6.setText("Once a Record has been selected Click below:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        btnRefresh.setText("Resfresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 80, -1));

        jLabel34.setText("Gender");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        jLabel35.setText("Patient-ID");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        jLabel36.setText("Medical Aid?");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 80, 20));

        jLabel37.setText("Spec Code");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, 20));

        jLabel38.setText("Symptoms");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, -1));

        jLabel39.setText("Prescription");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 90, -1, -1));

        ViewPatientsTab.setViewportView(jPanel4);

        tbPane.addTab("View Patients", ViewPatientsTab);

        ViewStaffTab.setBackground(new java.awt.Color(126, 145, 158));
        ViewStaffTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StaffInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });
        StaffInfoPanel.add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, 170, 30));

        lblname2.setText("Staff ID Password: ");
        StaffInfoPanel.add(lblname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 120, 30));

        lblsname2.setText("Surname:");
        StaffInfoPanel.add(lblsname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, -1));
        StaffInfoPanel.add(tfQual, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 430, 70));

        lblJD.setText("Specialty: ");
        StaffInfoPanel.add(lblJD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 90, 30));
        StaffInfoPanel.add(tfSname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 230, 50));

        lbldIAGNOSIS2.setText("Qualifications:");
        StaffInfoPanel.add(lbldIAGNOSIS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 90, 30));
        StaffInfoPanel.add(tfResidence, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 430, 60));

        lblSymptoms2.setText("Residence:");
        StaffInfoPanel.add(lblSymptoms2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 90, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/medicalstafficon.jpg"))); // NOI18N
        StaffInfoPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 260, 270));

        UpdateStaff.setText("Update and Save Staffer's  Details");
        UpdateStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStaffActionPerformed(evt);
            }
        });
        StaffInfoPanel.add(UpdateStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 220, -1));

        btnLOGOUT.setText("LOGOUT");
        StaffInfoPanel.add(btnLOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, -440, -1, -1));

        lblgender4.setText("Sex:");
        StaffInfoPanel.add(lblgender4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 90, 30));

        lblJD1.setText("Job Description:");
        StaffInfoPanel.add(lblJD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 30));
        StaffInfoPanel.add(tfSex2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 160, 40));

        jLabel11.setText("Personal Information");
        StaffInfoPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 130, 30));

        lblname3.setText("Name:");
        StaffInfoPanel.add(lblname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 90, 30));

        lblname4.setText("Contact No:");
        StaffInfoPanel.add(lblname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 90, 30));
        StaffInfoPanel.add(tfContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, 170, 30));
        StaffInfoPanel.add(tfJobDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 160, 50));
        StaffInfoPanel.add(tfSpec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 160, 40));
        StaffInfoPanel.add(tfname6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 50));

        jLabel25.setText("If you wish to change the information of this staff member:");
        StaffInfoPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, -1, -1));

        jLabel26.setText("1) Change information   2) Click Update and Save Below");
        StaffInfoPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, -1, -1));

        btnDischarge1.setBackground(new java.awt.Color(255, 51, 51));
        btnDischarge1.setForeground(new java.awt.Color(255, 255, 255));
        btnDischarge1.setText("Remove Staffer from Duty");
        btnDischarge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDischarge1ActionPerformed(evt);
            }
        });
        StaffInfoPanel.add(btnDischarge1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, 220, -1));

        ViewStaffTab.add(StaffInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 1070, 600));

        lstStaff.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lstStaff.setModel(dlstStaff);
        jScrollPane3.setViewportView(lstStaff);

        ViewStaffTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 900, 130));

        cbStaffSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Order", "Alphabetical Order (First Name)", "Alphabetical Order (Surname Name)", "Gender", "Job Description", "Specialty" }));
        cbStaffSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStaffSortActionPerformed(evt);
            }
        });
        ViewStaffTab.add(cbStaffSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 270, 220, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Place Staff in order of:");
        ViewStaffTab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 220, 30));

        tfStaffID.setToolTipText("Enter the Staff ID of the meber you wish to search and proceed to click the Search Patient Button below");
        ViewStaffTab.add(tfStaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Staff Information:");
        ViewStaffTab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 140, 30));

        lblTitle3.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setText("View Staff");
        ViewStaffTab.add(lblTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, 80));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setText("Staff ID:");
        ViewStaffTab.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        btnAddStaffPage.setText("Add a Staff Member");
        btnAddStaffPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffPageActionPerformed(evt);
            }
        });
        ViewStaffTab.add(btnAddStaffPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 70, 150, -1));

        btnSearchPatient.setText("Search Staff");
        btnSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPatientActionPerformed(evt);
            }
        });
        ViewStaffTab.add(btnSearchPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, -1));

        jLabel18.setText("Name");
        ViewStaffTab.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel19.setText("Surname");
        ViewStaffTab.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        jLabel20.setText("Staff ID");
        ViewStaffTab.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jLabel21.setText("Specialty");
        ViewStaffTab.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        jLabel22.setText("Sex");
        ViewStaffTab.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, -1, -1));

        jLabel24.setText("Once a Record has been selected Click below:");
        ViewStaffTab.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        btnSeeInStaffPanel.setText("See Staff Info");
        btnSeeInStaffPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInStaffPanelActionPerformed(evt);
            }
        });
        ViewStaffTab.add(btnSeeInStaffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        btnRefresh1.setText("Resfresh");
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });
        ViewStaffTab.add(btnRefresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 80, -1));

        jScrollPane5.setViewportView(ViewStaffTab);

        tbPane.addTab("View Staff", jScrollPane5);

        jPanel1.setBackground(new java.awt.Color(82, 155, 155));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle7.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle7.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle7.setText("Specialty Codes:");
        jPanel1.add(lblTitle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 230, 80));

        lstSpecialties.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        lstSpecialties.setForeground(new java.awt.Color(0, 0, 0));
        lstSpecialties.setModel(dlstSpecialties);
        jScrollPane4.setViewportView(lstSpecialties);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 880, 460));

        tbPane.addTab("View Specialty Codes", jPanel1);

        ViewAppointmentsTab.setBackground(new java.awt.Color(126, 145, 158));
        ViewAppointmentsTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstAppoint.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lstAppoint.setModel(dlstAppoint);
        jScrollPane2.setViewportView(lstAppoint);

        ViewAppointmentsTab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 1180, 390));

        lblTitle2.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("View Appointments:");
        ViewAppointmentsTab.add(lblTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, 80));

        jLabel31.setText("Get all the appointments by Specialty:");
        ViewAppointmentsTab.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 220, -1));

        cbSpecialtyApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "Biokinetics", "Cardiologist", "Gynaecologist", "General Practitioner", "Infectious Diseases Specialist", "Neurologist", "Oncologist", "Pharmacist", "Prosthetist", "Psychologist", "Radiologist" }));
        cbSpecialtyApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSpecialtyAppActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(cbSpecialtyApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 180, -1));

        jLabel32.setText("OR");
        ViewAppointmentsTab.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jLabel33.setText("Get all the Appointments by Month:");
        ViewAppointmentsTab.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 200, -1));

        cbMonthApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbMonthApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthAppActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(cbMonthApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 180, -1));

        jToggleButton1.setText("REFRESH");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 70, 90, -1));

        jLabel41.setText("Patient-ID");
        ViewAppointmentsTab.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel42.setText("Staff-ID");
        ViewAppointmentsTab.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabel43.setText("Date");
        ViewAppointmentsTab.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jLabel44.setText("Time");
        ViewAppointmentsTab.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        jLabel45.setText("Patient Admitted?");
        ViewAppointmentsTab.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, -1, -1));

        jLabel40.setText("Symptoms");
        ViewAppointmentsTab.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, 20));

        tbPane.addTab("View Appointments", ViewAppointmentsTab);

        AddPatientTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfnameADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnameADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfnameADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 50));

        lblname.setText("Name:");
        AddPatientTab.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));

        lblsname.setText("Surname:");
        AddPatientTab.add(lblsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, -1));

        tfPrescriptionADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrescriptionADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfPrescriptionADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 430, 60));

        lblgender1.setText("Sex:");
        AddPatientTab.add(lblgender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 30));

        tfSnameADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnameADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfSnameADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 230, 50));

        lbldIAGNOSIS.setText("Prescription:");
        AddPatientTab.add(lbldIAGNOSIS, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 90, 30));

        tfSymptomsADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSymptomsADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfSymptomsADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 430, 130));

        lblSymptoms.setText("Symptoms:");
        AddPatientTab.add(lblSymptoms, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 90, 30));

        cbMedAidADDp.setText("Patient Possesses Medical Aid");
        cbMedAidADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedAidADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(cbMedAidADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 210, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/INJUREDpatient.png"))); // NOI18N
        AddPatientTab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 280));

        btnAddPatient.setText("Add new Patient");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });
        AddPatientTab.add(btnAddPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 160, -1));

        lblTitle6.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle6.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle6.setText("Add a Patient:");
        AddPatientTab.add(lblTitle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));

        tfGenderADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGenderADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfGenderADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 100, 50));

        tfSpecCodeADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSpecCodeADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfSpecCodeADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 130, 50));

        lblgender7.setText("Specialty Code:");
        AddPatientTab.add(lblgender7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, 30));

        tfPatientIDADDp.setToolTipText("P(PatientNum)\neg P321");
        tfPatientIDADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPatientIDADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfPatientIDADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, 180, -1));

        jLabel27.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel27.setText("Patient ID:");
        AddPatientTab.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 90, 30));

        tbPane.addTab("Add a Patient", AddPatientTab);

        AddStaffTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPasswordADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfPasswordADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, 170, 30));

        lblname5.setText("Staff ID Password: ");
        AddStaffTab.add(lblname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 120, 30));

        lblsname3.setText("Surname:");
        AddStaffTab.add(lblsname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, -1));

        tfQualADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQualADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfQualADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 430, 70));

        lblJD2.setText("Specialty: ");
        AddStaffTab.add(lblJD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 90, 30));

        tfSnameADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnameADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfSnameADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 230, 50));

        lbldIAGNOSIS3.setText("Qualifications:");
        AddStaffTab.add(lbldIAGNOSIS3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, 30));

        tfSpecialtyADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSpecialtyADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfSpecialtyADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 270, 30));

        lblSymptoms3.setText("Residence:");
        AddStaffTab.add(lblSymptoms3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 90, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/medicalstafficon.jpg"))); // NOI18N
        AddStaffTab.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 260, 270));

        btnAddStaff.setText("Add a new Staff Member");
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });
        AddStaffTab.add(btnAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 540, 220, -1));

        btnLOGOUT1.setText("LOGOUT");
        btnLOGOUT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUT1ActionPerformed(evt);
            }
        });
        AddStaffTab.add(btnLOGOUT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, -440, -1, -1));

        lblgender5.setText("Sex:");
        AddStaffTab.add(lblgender5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 90, 30));

        lblJD3.setText("Job Description:");
        AddStaffTab.add(lblJD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 30));

        tfnameADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnameADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfnameADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 50));

        jLabel13.setText("Personal Information");
        AddStaffTab.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 130, 30));

        lblname6.setText("Name:");
        AddStaffTab.add(lblname6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 90, 30));

        lblname7.setText("Contact No:");
        AddStaffTab.add(lblname7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 90, 30));

        tfContactADD.setToolTipText("10 DIGIT NUMBER");
        tfContactADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfContactADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, 170, 30));

        lblTitle5.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle5.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle5.setText("Add Staff Member:");
        AddStaffTab.add(lblTitle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));

        tfGenderADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGenderADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfGenderADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 100, 50));

        tfResidenceADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResidenceADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfResidenceADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 430, 60));

        tfJobDesADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJobDesADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfJobDesADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 270, 30));

        tfStaffIDADD.setToolTipText("(gender symbol)(first letter of first name)(first letter of last name)-(reference number that starts at 101 so there are no duplicates)\neg fab-101");
        tfStaffIDADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStaffIDADDActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfStaffIDADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 180, -1));

        jLabel28.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel28.setText("Staff ID:  ");
        AddStaffTab.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 90, 30));

        jLabel48.setForeground(new java.awt.Color(255, 51, 51));
        jLabel48.setText("eg.0123456789 - Ten Digits");
        AddStaffTab.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 190, 20));

        jLabel49.setForeground(new java.awt.Color(255, 51, 51));
        jLabel49.setText("F / M");
        AddStaffTab.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 270, 20));

        jLabel50.setForeground(new java.awt.Color(255, 51, 51));
        jLabel50.setText("\"MediSeek Johannesburg City Hospital\"");
        AddStaffTab.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 230, 20));

        jLabel51.setForeground(new java.awt.Color(255, 51, 51));
        jLabel51.setText("eg XXX-123     Hover over field to see format");
        AddStaffTab.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 270, 30));

        jLabel52.setForeground(new java.awt.Color(255, 51, 51));
        jLabel52.setText("Doctor/Pharmacist/Receptionist/ Administrator");
        AddStaffTab.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 270, 20));

        jLabel53.setForeground(new java.awt.Color(255, 51, 51));
        jLabel53.setText("What have they specialized in?");
        AddStaffTab.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 270, 20));

        jLabel54.setForeground(new java.awt.Color(255, 51, 51));
        jLabel54.setText("^^Doc - Specialty;  Admin - Administration; Pharm - pharmacist; Recep - reception^^");
        AddStaffTab.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 470, 20));

        tbPane.addTab("Add new Staff", AddStaffTab);

        AddStaffTab1.setBackground(new java.awt.Color(99, 158, 158));
        AddStaffTab1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPasswordPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfPasswordPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 170, 30));

        lblname8.setText("Staff ID Password: ");
        AddStaffTab1.add(lblname8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 120, 30));

        lblsname4.setText("Surname:");
        AddStaffTab1.add(lblsname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 90, -1));

        tfQualPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQualPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfQualPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 430, 70));

        lblJD4.setText("Specialty: ");
        AddStaffTab1.add(lblJD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 90, 30));

        tfSnamePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnamePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfSnamePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 230, 50));

        lbldIAGNOSIS4.setText("Qualifications:");
        AddStaffTab1.add(lbldIAGNOSIS4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 90, 30));

        tfResidencePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResidencePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfResidencePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 430, 60));

        lblSymptoms4.setText("Residence:");
        AddStaffTab1.add(lblSymptoms4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 90, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/medicalstafficon.jpg"))); // NOI18N
        AddStaffTab1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 260, 270));

        btnAddStaff1.setText("Update Your Information");
        btnAddStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaff1ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(btnAddStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 220, -1));

        btnLOGOUT2.setText("LOGOUT");
        btnLOGOUT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUT2ActionPerformed(evt);
            }
        });
        AddStaffTab1.add(btnLOGOUT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, -440, -1, -1));

        lblgender6.setText("Sex:");
        AddStaffTab1.add(lblgender6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 90, 30));

        lblJD5.setText("Job Description:");
        AddStaffTab1.add(lblJD5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, 90, 30));

        tfnamePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnamePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfnamePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 230, 50));

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel15.setText("Personal Information");
        AddStaffTab1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 160, 30));

        lblname9.setText("Name:");
        AddStaffTab1.add(lblname9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 90, 30));

        lblname10.setText("Contact No:");
        AddStaffTab1.add(lblname10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, 90, 30));

        tfContactPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfContactPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 170, 30));

        lblTitle4.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle4.setText("Your Personal Info:");
        AddStaffTab1.add(lblTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));
        AddStaffTab1.add(tfSexPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 70, 40));
        AddStaffTab1.add(tfSpecPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 160, 40));
        AddStaffTab1.add(tfJobDescPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 270, 40));

        tbPane.addTab("Personal Information", AddStaffTab1);

        getContentPane().add(tbPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1260, 640));

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Administrator");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 320, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/MS Main1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 770));

        btnPerformanceReview.setBackground(new java.awt.Color(74, 74, 76));
        btnPerformanceReview.setText("Staff Performance Review");
        btnPerformanceReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerformanceReviewActionPerformed(evt);
            }
        });
        getContentPane().add(btnPerformanceReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 170, 20));

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

    private void tfnameADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameADDpActionPerformed

    private void tfPrescriptionADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrescriptionADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrescriptionADDpActionPerformed

    private void tfSnameADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnameADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnameADDpActionPerformed

    private void tfSymptomsADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSymptomsADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSymptomsADDpActionPerformed

    private void cbMedAidADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedAidADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMedAidADDpActionPerformed

    private void btnAddPatientPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientPageActionPerformed
        tbPane.setSelectedIndex(4);
    }//GEN-LAST:event_btnAddPatientPageActionPerformed

    private void tfPasswordADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordADDActionPerformed

    private void tfQualADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQualADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQualADDActionPerformed

    private void tfSnameADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnameADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnameADDActionPerformed

    private void tfSpecialtyADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecialtyADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecialtyADDActionPerformed

    private void btnLOGOUT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLOGOUT1ActionPerformed

    private void tfnameADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameADDActionPerformed

    private void tfContactADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactADDActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginGUI LoginGUI = new LoginGUI();
        LoginGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnShowPatientActionPerformed(java.awt.event.ActionEvent evt) {                                               
// 
//if (tfStaffID.getText().equalsIgnoreCase("")) {
//JOptionPane.showMessageDialog(null,"Please ensure that you enter the ID you wish to search");
//} else if(tfStaffID.getText().length()!=7)   {
//JOptionPane.showMessageDialog(null,"Please ensure that the that you wish to search is the correct length and follows the right format\n ie \txxx-123");
//} else if(tfStaffID.getText().length()==7){
//    searchStaff(tfStaffID.getText().toLowerCase());

 
//private void btnSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNameActionPerformed
//          System.out.println(obj.isNotEmpty(txtSearchName.getText()));
//         System.out.println(obj.allCharacters(txtSearchName.getText()));
//         if (obj.isNotEmpty(txtSearchName.getText())==true & obj.allCharacters(txtSearchName.getText())==true)
//         { 
//        lstRunner.clear();
//            getRunners("select * from tblRunner where name like '*"+txtSearchName.getText()+"*'");
//         }else lblError.setText("INVALID ENTRY");
//    }//GEN-LAST:event_btnSearchNameActionPerformed


}
        
        
        
                                                  

    private void btnShowPatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPatient1ActionPerformed
if(objValidation.isNotEmpty(tfPatientID.getText())==true){searchPatient(tfPatientID.getText());}
else{JOptionPane.showMessageDialog(null, " PLEASE INPUT A PATIENT ID");}      
        
        
        
    }//GEN-LAST:event_btnShowPatient1ActionPerformed

    private void tfPasswordPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordPERSONALActionPerformed

    private void tfQualPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQualPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQualPERSONALActionPerformed

    private void tfSnamePERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnamePERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnamePERSONALActionPerformed

    private void tfResidencePERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResidencePERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResidencePERSONALActionPerformed

    private void btnLOGOUT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLOGOUT2ActionPerformed

    private void tfnamePERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnamePERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnamePERSONALActionPerformed

    private void tfContactPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactPERSONALActionPerformed

    private void tfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameActionPerformed

    private void tfDiagnosis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDiagnosis2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDiagnosis2ActionPerformed

    private void tfSnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnameActionPerformed

    private void tfPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrescriptionActionPerformed

    private void bxMedAidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxMedAidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bxMedAidActionPerformed

    private void btnSeeInPatientPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInPatientPanelActionPerformed
//edits a new record in the table and refreshes the display of the list
        if (lstPatients.getSelectedIndex()>-1) //checks to see if a record from the list element has been selected
        {   tbPane.setSelectedIndex(0); //selects the tab that all the tetfields are in
    //input the data that has been taken from the database into each corresponding textfield
            tfPatientID.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getPatientID());
            tfname.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getName());
            tfSname.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getSurname());
            tfSex.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getGender()); 
            tfSpecCode.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getSpecialtyCode());
            bxMedAid.setSelected(patientDirectory[lstPatients.getSelectedIndex()].isMedicalAid());
            tfDiagnosis2.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getDiagnosis());
            tfPrescription.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getPrescription());
           
        }else {JOptionPane.showMessageDialog(null, " SELECT A PATIENT TO VIEW");  }   
        
        
    }//GEN-LAST:event_btnSeeInPatientPanelActionPerformed

    private void tfSpecCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecCodeActionPerformed

    private void tfSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSexActionPerformed

    private void btnSeeInStaffPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInStaffPanelActionPerformed

        if (lstStaff.getSelectedIndex()>-1)//edits a new record in the table and refreshes the display of the list
        {   tbPane.setSelectedIndex(1);
    
            tfStaffID.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getStaff_ID());
            tfname6.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getsName());
            tfSname2.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getsSurname());
            tfSex2.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getGender());
            tfJobDesc.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getJobDescription());
            tfSpec.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getSpecialty());
            tfResidence.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getResidence());
            tfQual.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getQualifications());
            tfContact.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getContact());
            tfPassword.setText(""+staffDirectory[lstStaff.getSelectedIndex()].getPassword());
           
        }else JOptionPane.showMessageDialog(null, " SELECT A STAFF MEMEBR TO VIEW"); 
        
        
        
        
    }//GEN-LAST:event_btnSeeInStaffPanelActionPerformed

    private void btnAddStaffPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffPageActionPerformed
        tbPane.setSelectedIndex(5);
    }//GEN-LAST:event_btnAddStaffPageActionPerformed

    private void btnPerformanceReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerformanceReviewActionPerformed
//    PerformanceReviewGUI LoginGUI = new PerformanceReviewGUI();
//        LoginGUI.setVisible(true);
    }//GEN-LAST:event_btnPerformanceReviewActionPerformed

    private void tfPatientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPatientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPatientIDActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
    
        if (objValidation.isNotEmpty(tfnameADDp.getText()) == true && objValidation.isNotEmpty(tfSnameADDp.getText()) == true && objValidation.isNotEmpty(tfGenderADDp.getText()) == true
            && objValidation.isNotEmpty(tfSpecCodeADDp.getText()) == true && objValidation.isNotEmpty(tfSymptomsADDp.getText()) == true && objValidation.isNotEmpty(tfPrescriptionADDp.getText()) == true
            && objValidation.isNotEmpty(tfPatientIDADDp.getText()) == true){
                String MedAidConverstion = "";

                    if (lstPatients.getSelectedIndex() == -1) {
                                if(objValidation.allCharacters(tfnameADDp.getText()) && objValidation.allCharacters(tfSnameADDp.getText()) && objValidation.allCharacters(tfGenderADDp.getText())
                                && objValidation.allCharacters(tfSpec.getText()) && objValidation.allCharacters(tfJobDesc.getText()) ){
                                            if (cbMedAidADDp.isSelected() == true) {
                                                    MedAidConverstion = "yes";
                                                } else {
                                                    MedAidConverstion = "no";
                                                }
                                            //addes a new record to the table and refreshes the display of the list
                                            objPatients.updateTable("insert into tblPatients (pName, pSurname, Gender, Patient_ID, MedicalAid, SpecialtyCode, Symptoms, Prescription) values('" + tfnameADDp.getText() + "','" + tfSnameADDp.getText() + "','" + tfGenderADDp.getText()
                                                    + "','" + tfPatientIDADDp.getText() + "'," + MedAidConverstion + ",'" + tfSpecCodeADDp.getText() + "','" + tfSymptomsADDp.getText() + "','" + tfPrescriptionADDp.getText() + "') ;");

                                            System.out.println("insert into tblPatients (pName, pSurname, Gender, Patient_ID, MedicalAid, SpecialtyCode, Symptoms, Prescription) values('" + tfnameADDp.getText() + "','" + tfSnameADDp.getText() + "','" + tfGenderADDp.getText()
                                                    + "','" + tfPatientIDADDp.getText() + "'," + MedAidConverstion + ",'" + tfSpecCodeADDp.getText() + "','" + tfSymptomsADDp.getText() + "','" + tfPrescriptionADDp.getText() + "') ;");          
                                }else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE Fields \n Try Again!");}            

        }else{
        JOptionPane.showMessageDialog(null, "ALL FIELDS ARE TO BE FILLED. Review your entry and Try Again!");
        } 
     

        tbPane.setSelectedIndex(0);
        dlstPatients.clear();
        getPatients();
        
        }else{JOptionPane.showMessageDialog(null, "UNABLE TO ADD PATIENT \nPlease ensure that every field has been filled in then retry your entry.");}
 
        
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void tfGenderADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGenderADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGenderADDpActionPerformed

    private void tfSpecCodeADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecCodeADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecCodeADDpActionPerformed

    private void tfPatientIDADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPatientIDADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPatientIDADDpActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if (objValidation.isNotEmpty(tfname.getText()) && objValidation.isNotEmpty(tfSname.getText()) && objValidation.isNotEmpty(tfSex.getText()) && objValidation.isNotEmpty(tfSpecCode.getText())
       &&  objValidation.isNotEmpty(tfDiagnosis2.getText()) &&  objValidation.isNotEmpty(tfPrescription.getText()) &&  objValidation.isNotEmpty(tfPatientID.getText())) {
     
            String MedAidConverstion = "";
            if (lstPatients.getSelectedIndex() == -1) {JOptionPane.showMessageDialog(null, "Please select a Record");}
            else{
                      
                MedAidConverstion = "";
                    if (cbMedAidADDp.isSelected() == true) {
                    MedAidConverstion = "yes";
                    } else {
                        MedAidConverstion = "no";
                    }
                        
                        
                if(objValidation.allCharacters(tfname.getText()) && objValidation.allCharacters(tfSname.getText()) && objValidation.allCharacters(tfSex.getText()) && objValidation.allCharacters(tfSpecCode.getText())){
                            System.out.println("UPDATE tblPatients SET  tblPatients.pName = '" + tfname.getText()
                                            + "', tblPatients.pSurname = '" + tfSname.getText()
                                            + "', tblPatients.Gender = '" + tfSex.getText()
                                            + "', tblPatients.Patient_ID = '" + tfPatientID.getText()
                                            + "', tblPatients.SpecialtyCode = '" + tfSpecCode.getText()                        
                                            + "', tblPatients.MedicalAid = " + MedAidConverstion
                                            + ", tblPatients.Symptoms = '" + tfDiagnosis2.getText()
                                            + "', tblPatients.Prescription = '" + tfPrescription.getText()
                                            + "' WHERE Patient_ID = '" + tfPatientID.getText() + "';");

                                    objPatients.updateTable("UPDATE tblPatients SET  tblPatients.pName = '" + tfname.getText()
                                            + "', tblPatients.pSurname = '" + tfSname.getText()
                                            + "', tblPatients.Gender = '" + tfSex.getText()
                                            + "', tblPatients.Patient_ID = '" + tfPatientID.getText()
                                            + "', tblPatients.SpecialtyCode = '" + tfSpecCode.getText()                        
                                            + "', tblPatients.MedicalAid = " + MedAidConverstion
                                            + ", tblPatients.Symptoms = '" + tfDiagnosis2.getText()
                                            + "', tblPatients.Prescription = '" + tfPrescription.getText()
                                            + "' WHERE Patient_ID = '" + tfPatientID.getText() + "';");
                }else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE Fields \n Try Again!");}            
              
            } 
            
            tbPane.setSelectedIndex(0);
            dlstPatients.clear();
            getPatients();
        } else{
        JOptionPane.showMessageDialog(null, "ALL FIELDS ARE TO BE FILLED. Review your entry and Try Again!");
        }

        
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbPatientOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPatientOrderActionPerformed
//getPatientsSorted(String x)   
// No Order
//Alphabetical Order (First Name)
//Alphabetical Order (Surname Name)
//Gender       
        switch(cbPatientOrder.getSelectedIndex()){
            case 0:getPatients();
                break;
            case 1: getPatientsSorted("SELECT * FROM tblPatients ORDER BY tblPatients.pName;");
                break;
            case 2: getPatientsSorted("SELECT * FROM tblPatients ORDER BY tblPatients.pSurname;");
                break;
            case 3: getPatientsSorted("SELECT * FROM tblPatients ORDER BY tblPatients.Gender;");
                break;
            default: System.out.println("Unkown index selected"); 
                break;    
        }
        
        
        
    }//GEN-LAST:event_cbPatientOrderActionPerformed

    private void tfGenderADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGenderADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGenderADDActionPerformed

    private void tfResidenceADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResidenceADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResidenceADDActionPerformed

    private void tfJobDesADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJobDesADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJobDesADDActionPerformed

    private void UpdateStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateStaffActionPerformed

     if (lstStaff.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(null, "Please select a record first"); 
        } else {
         if (objValidation.isNotEmpty(tfname6.getText()) && objValidation.isNotEmpty(tfSname2.getText()) && objValidation.isNotEmpty(tfSex2.getText()) && objValidation.isNotEmpty(tfJobDesc.getText()) && 
              objValidation.isNotEmpty(tfSpec.getText()) &&  objValidation.isNotEmpty(tfResidence.getText()) && objValidation.isNotEmpty(tfQual.getText()) &&  objValidation.isNotEmpty(tfQual.getText()) 
                && objValidation.isNotEmpty(tfContact.getText()) && objValidation.isNotEmpty(tfStaffID.getText()) && objValidation.isNotEmpty(tfPassword.getText())) {

           
                if(objValidation.allCharacters(tfname6.getText()) && objValidation.allCharacters(tfSname2.getText()) && objValidation.allCharacters(tfSex2.getText())
                       && objValidation.allCharacters(tfSpec.getText()) && objValidation.allCharacters(tfJobDesc.getText()) ){
                            if(objValidation.isValidNumber(tfContact.getText()) && tfContact.getText().length()==10){
                                          System.out.println("UPDATE tblStaff SET  tblStaff.sName = '" + tfname6.getText()
                                                            + "', tblStaff.sSurname = '" + tfSname2.getText()
                                                            + "', tblStaff.Gender = '" + tfSex2.getText()
                                                            + "', tblStaff.[Job Description] = '" + tfJobDesc.getText()
                                                            + "', tblStaff.Specialty = '" + tfSpec.getText()                        
                                                            + "', tblStaff.Residence = '" + tfResidence.getText()
                                                            + "', tblStaff.Qualifications = '" + tfQual.getText()
                                                            + "', tblStaff.Contact = '" + tfContact.getText()
                                                            + "', tblStaff.Password = '" + tfPassword.getText()
                                                            + "' WHERE Staff_ID = '" + tfStaffID.getText() + "';");

                                        objStaff.updateTable("UPDATE tblStaff SET  tblStaff.sName = '" + tfname6.getText()
                                                            + "', tblStaff.sSurname = '" + tfSname2.getText()
                                                            + "', tblStaff.Gender = '" + tfSex2.getText()
                                                            + "', tblStaff.[Job Description] = '" + tfJobDesc.getText()
                                                            + "', tblStaff.Specialty = '" + tfSpec.getText()                        
                                                            + "', tblStaff.Residence = '" + tfResidence.getText()
                                                            + "', tblStaff.Qualifications = '" + tfQual.getText()
                                                            + "', tblStaff.Contact = '" + tfContact.getText()
                                                            + "', tblStaff.Password = '" + tfPassword.getText() 

                                                            + "' WHERE Staff_ID = '" + tfStaffID.getText() + "';");
                            }else{
                                JOptionPane.showMessageDialog(null, "Please ensure that you have put in a valid phone number\nIE: TEN DIGITS\n     ALL NUMBERS");
                            }              
                 }else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE/JOB DESCRIPTION Fields \n Try Again!");}            

            
            
        }else{
        JOptionPane.showMessageDialog(null, "ALL FIELDS ARE TO BE FILLED. Review your entry and Try Again!");
        }
     
     }
        tbPane.setSelectedIndex(1);
        dlstStaff.clear();
        getStaff();
        
        
    }//GEN-LAST:event_UpdateStaffActionPerformed

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
            
if (objValidation.isNotEmpty(tfnameADD.getText()) == true && objValidation.isNotEmpty(tfSnameADD.getText()) == true && objValidation.isNotEmpty(tfGenderADD.getText()) == true
&& objValidation.isNotEmpty(tfJobDesADD.getText()) == true && objValidation.isNotEmpty(tfSpecialtyADD.getText()) == true && objValidation.isNotEmpty(tfResidenceADD.getText()) == true
&& objValidation.isNotEmpty(tfQualADD.getText()) == true && objValidation.isNotEmpty(tfContactADD.getText())== true && objValidation.isNotEmpty(tfStaffIDADD.getText()) == true && objValidation.isNotEmpty(tfPasswordADD.getText())==true) {

            if (lstStaff.getSelectedIndex() == -1) {
                if(objValidation.allCharacters(tfname6.getText()) && objValidation.allCharacters(tfSname2.getText()) && objValidation.allCharacters(tfSex2.getText())
                   && objValidation.allCharacters(tfSpec.getText()) && objValidation.allCharacters(tfJobDesc.getText()) ){
                    System.out.println(objValidation.isValidNumber(tfContact.getText()+"") +" "+ (tfContact.getText()+"").length());
                      
                            //adds a new record to the table and refreshes the display of the list
                            objStaff.updateTable("insert into tblStaff (sName, sSurname, Gender, [Job Description], Specialty, Residence, Qualifications, Contact, Staff_ID, Password) values('" + tfnameADD.getText() + "','" + tfSnameADD.getText() + "','" + tfGenderADD.getText()
                                    + "','" + tfJobDesADD.getText() + "','" + tfSpecialtyADD.getText() + "','" + tfResidenceADD.getText() + "','" + tfQualADD.getText() + "','" + tfContactADD.getText() +  "','" + tfStaffIDADD.getText() +  "','" + tfPasswordADD.getText()+ "') ;");

                            System.out.println("insert into tblStaff (sName, sSurname, Gender, [Job Description], Specialty, Residence, Qualifications, Contact, Staff_ID, Password) values('" + tfnameADD.getText() + "','" + tfSnameADD.getText() + "','" + tfGenderADD.getText()
                                    + "','" + tfJobDesADD.getText() + "','" + tfSpecialtyADD.getText() + "','" + tfResidenceADD.getText() + "','" + tfQualADD.getText() + "','" + tfContactADD.getText() +  "','" + tfStaffIDADD.getText() +  "','" + tfPasswordADD.getText()+ "') ;");          
                
                            tbPane.setSelectedIndex(1);
                              dlstStaff.clear();
                              getStaff();
                            
                        
               }else{JOptionPane.showMessageDialog(null, "You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE/JOB DESCRIPTION Fields \n Try Again!");}            

            } 
            
            
        
        
} else{JOptionPane.showMessageDialog(null, "UNABLE TO ADD STAFF MEMBER \nPlease ensure that every field has been filled in then retry your entry.");}
 
        
        
        
    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void tfStaffIDADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStaffIDADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStaffIDADDActionPerformed

    private void btnAddStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaff1ActionPerformed
  if (objValidation.isNotEmpty(tfnamePERSONAL.getText()) == true && objValidation.isNotEmpty(tfSnamePERSONAL.getText()) == true && objValidation.isNotEmpty(tfSexPERSONAL.getText()) == true
      && objValidation.isNotEmpty(tfJobDescPERSONAL.getText()) == true && objValidation.isNotEmpty(tfSpecPERSONAL.getText()) == true && objValidation.isNotEmpty(tfResidencePERSONAL.getText()) == true
      && objValidation.isNotEmpty(tfQualPERSONAL.getText()) == true && objValidation.isNotEmpty(tfContactPERSONAL.getText())== true && objValidation.isNotEmpty(tfPasswordPERSONAL.getText()) == true && objValidation.isNotEmpty(tfPasswordPERSONAL.getText())==true) {
            if(objValidation.allCharacters(tfnamePERSONAL.getText()) && objValidation.allCharacters(tfSnamePERSONAL.getText()) && objValidation.allCharacters(tfSexPERSONAL.getText())
              && objValidation.allCharacters(tfSpecPERSONAL.getText()) && objValidation.allCharacters(tfJobDescPERSONAL.getText()) ){
                    //adds a new record to the table and refreshes the display of the list
                    System.out.println("UPDATE tblStaff SET  tblStaff.sName = '" + tfnamePERSONAL.getText()
                                        + "', tblStaff.sSurname = '" + tfSnamePERSONAL.getText()
                                        + "', tblStaff.Gender = '" + tfSexPERSONAL.getText()
                                        + "', tblStaff.[Job Description] = '" + tfJobDescPERSONAL.getText()
                                        + "', tblStaff.Specialty = '" + tfSpecPERSONAL.getText()                        
                                        + "', tblStaff.Residence = '" + tfResidencePERSONAL.getText()
                                        + "', tblStaff.Qualifications = '" + tfQualPERSONAL.getText()
                                        + "', tblStaff.Contact = '" + tfContactPERSONAL.getText()
                                        + "', tblStaff.Password = '" + tfPasswordPERSONAL.getText()
                                        + "' WHERE Staff_ID = '" + getUserInfo().getStaff_ID() + "';");

                                objStaff.updateTable("UPDATE tblStaff SET  tblStaff.sName = '" + tfnamePERSONAL.getText()
                                        + "', tblStaff.sSurname = '" + tfSnamePERSONAL.getText()
                                        + "', tblStaff.Gender = '" + tfSexPERSONAL.getText()
                                        + "', tblStaff.[Job Description] = '" + tfJobDescPERSONAL.getText()
                                        + "', tblStaff.Specialty = '" + tfSpecPERSONAL.getText()                        
                                        + "', tblStaff.Residence = '" + tfResidencePERSONAL.getText()
                                        + "', tblStaff.Qualifications = '" + tfQualPERSONAL.getText()
                                        + "', tblStaff.Contact = '" + tfContactPERSONAL.getText()
                                        + "', tblStaff.Password = '" + tfPasswordPERSONAL.getText()
                                        + "' WHERE Staff_ID = '" + getUserInfo().getStaff_ID() + "';");

            } else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE/JOB DESCRIPTION Fields \n Try Again!");}            

            
  }  else{JOptionPane.showMessageDialog(null, "UNABLE TO EDIT YOUR DETAILS\nPlease ensure that every field has been filled in then retry your entry.");}

    }//GEN-LAST:event_btnAddStaff1ActionPerformed

    private void btnSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPatientActionPerformed
if(objValidation.isNotEmpty(tfStaffID.getText())==true){searchStaff(tfStaffID.getText());}
else{JOptionPane.showMessageDialog(null, " PLEASE INPUT A STAFF ID");}               
        
    }//GEN-LAST:event_btnSearchPatientActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        dlstPatients.clear();
        getPatients();

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        dlstStaff.clear();
        getStaff();

    }//GEN-LAST:event_btnRefresh1ActionPerformed

    private void cbStaffSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStaffSortActionPerformed
//No Order
//Alphabetical Order (First Name)
//Alphabetical Order (First Name)
//Gender
//Job Description
//Specialty
System.out.println(cbStaffSort.getSelectedIndex());
        
      
        switch(cbStaffSort.getSelectedIndex()){
            case 0: dlstStaff.clear();getStaff();
                break;
            case 1: getStaffSorted("SELECT * FROM tblStaff ORDER BY tblStaff.sName;");
                break;
            case 2: getStaffSorted("SELECT * FROM tblStaff ORDER BY tblStaff.sSurname;");
                break;
            case 3: getStaffSorted("SELECT * FROM tblStaff ORDER BY tblStaff.Gender;");
                break;
            case 4: getStaffSorted("SELECT * FROM tblStaff ORDER BY tblStaff.[Job Description];");
                break;
            case 5: getStaffSorted("SELECT * FROM tblStaff ORDER BY tblStaff.Specialty;");
                break;
            
            default: System.out.println("Unkown index selected");
                    
                break;    
        }
        
    }//GEN-LAST:event_cbStaffSortActionPerformed

    private void cbSpecialtyAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSpecialtyAppActionPerformed
        //NONE
        //Biokinetics
        //Cardiologist
        //Gynaecologist
        //General Practitioner
        //Infectious Diseases Specialist
        //Neurologist
        //Oncologist
        //Pharmacist
        //Prosthetist
        //Psychologist
        //Radiologist
        switch(cbSpecialtyApp.getSelectedIndex()){
            case 0: getAppointments();
            break;
            case 1: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Biokinetics';");
            break;
            case 2: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Cardiologist';");
            break;
            case 3: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Gynaecologist';");
            break;
            case 4: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'General Practitioner';");
            break;
            case 5: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Infectious Diseases Specialist';");
            break;
            case 6: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Neurologist';");
            break;
            case 7: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Oncologist';");
            break;
            case 8: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Pharmacist';");
            break;
            case 9: getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Prosthetist';");
            break;
            case 10:getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Psychologist';");
            break;
            case 11:getAppsSorted("SELECT tblAppointments.* FROM tblAppointments INNER JOIN tblStaff ON tblAppointments.Staff_ID = tblStaff.Staff_ID WHERE tblStaff.Specialty = 'Radiologist';");
            break;
            default: System.out.println("Unkown index selected");

            break;
        }
    }//GEN-LAST:event_cbSpecialtyAppActionPerformed

    private void cbMonthAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonthAppActionPerformed

        switch(cbMonthApp.getSelectedIndex()){
            case 0: getAppointments();
            break;
            case 1: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 1;");
            break;
            case 2: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 2;");
            break;
            case 3: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 3;");
            break;
            case 4: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 4;");
            break;
            case 5: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 5;");
            break;
            case 6: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 6;");
            break;
            case 7: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 7;");
            break;
            case 8: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 8;");
            break;
            case 9: getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 9;");
            break;
            case 10:getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 10;");
            break;
            case 11:getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 11;");
            break;
            case 12:getAppsSorted("SELECT * FROM tblAppointments WHERE MONTH(APPDATE) = 12;");
            break;
            default: System.out.println("Unkown index selected");
            break;
        }
    }//GEN-LAST:event_cbMonthAppActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
dlstAppoint.clear();        getAppointments();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnDischargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDischargeActionPerformed
        if (lstPatients.getSelectedIndex() > -1) {  // make sure that the item is selected in the list
            objPatients.updateTable("delete * FROM tblPatients where Patient_ID = '" +patientDirectory[lstPatients.getSelectedIndex()].getPatientID()+"';");//delete item selected using the update method in the
            dlstPatients.clear();//clear list for the updated data
            getPatients();// add updated data to the list
        } else {
            JOptionPane.showMessageDialog(null, " SELECT A PATIENT RECORD FROM THE LIST");
        }
    tfPatientID.setText("");
    tfname.setText("");
    tfSname.setText("");
    tfSex.setText(""); 
    tfSpecCode.setText("");
    bxMedAid.setSelected(false);
    tfDiagnosis2.setText("");
    tfPrescription.setText("");   
        
        
    }//GEN-LAST:event_btnDischargeActionPerformed

    private void btnDischarge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDischarge1ActionPerformed
if (lstStaff.getSelectedIndex() > -1) {  // make sure that the item is selected in the list
            objStaff.updateTable("delete * FROM tblstaff WHERE Staff_ID = '" +staffDirectory[lstStaff.getSelectedIndex()].getStaff_ID()+"';");//delete item selected using the update method in the
            dlstStaff.clear();//clear list for the updated data
            getStaff();// add updated data to the list
        } else {
            JOptionPane.showMessageDialog(null, " SELECT A STAFF RECORD FROM THE LIST");
        }        
        
            tfStaffID.setText("");
            tfname6.setText("");
            tfSname2.setText("");
            tfSex2.setText("");
            tfJobDesc.setText("");
            tfSpec.setText("");
            tfResidence.setText("");
            tfQual.setText("");
            tfContact.setText("");
            tfPassword.setText("");

        
        
    }//GEN-LAST:event_btnDischarge1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        obj.openWord("MediSeek Who are we.docx");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        obj.openWord("MediSeek Help.docx");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(AdministratorPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorPages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPatientTab;
    private javax.swing.JPanel AddStaffTab;
    private javax.swing.JPanel AddStaffTab1;
    private javax.swing.JPanel PatientInfoPanel;
    private javax.swing.JPanel StaffInfoPanel;
    private javax.swing.JButton UpdateStaff;
    private javax.swing.JPanel ViewAppointmentsTab;
    private javax.swing.JScrollPane ViewPatientsTab;
    private javax.swing.JPanel ViewStaffTab;
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnAddPatientPage;
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnAddStaff1;
    private javax.swing.JButton btnAddStaffPage;
    private javax.swing.JButton btnDischarge;
    private javax.swing.JButton btnDischarge1;
    private javax.swing.JButton btnLOGOUT;
    private javax.swing.JButton btnLOGOUT1;
    private javax.swing.JButton btnLOGOUT2;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPerformanceReview;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnSearchPatient;
    private javax.swing.JButton btnSeeInPatientPanel;
    private javax.swing.JButton btnSeeInStaffPanel;
    private javax.swing.JButton btnShowPatient1;
    private javax.swing.JCheckBox bxMedAid;
    private javax.swing.JCheckBox cbMedAidADDp;
    private javax.swing.JComboBox<String> cbMonthApp;
    private javax.swing.JComboBox<String> cbPatientOrder;
    private javax.swing.JComboBox<String> cbSpecialtyApp;
    private javax.swing.JComboBox<String> cbStaffSort;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblJD;
    private javax.swing.JLabel lblJD1;
    private javax.swing.JLabel lblJD2;
    private javax.swing.JLabel lblJD3;
    private javax.swing.JLabel lblJD4;
    private javax.swing.JLabel lblJD5;
    private javax.swing.JLabel lblSymptoms;
    private javax.swing.JLabel lblSymptoms2;
    private javax.swing.JLabel lblSymptoms3;
    private javax.swing.JLabel lblSymptoms4;
    private javax.swing.JLabel lblSymptoms5;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JLabel lblTitle7;
    private javax.swing.JLabel lbldIAGNOSIS;
    private javax.swing.JLabel lbldIAGNOSIS2;
    private javax.swing.JLabel lbldIAGNOSIS3;
    private javax.swing.JLabel lbldIAGNOSIS4;
    private javax.swing.JLabel lbldIAGNOSIS5;
    private javax.swing.JLabel lblgender1;
    private javax.swing.JLabel lblgender2;
    private javax.swing.JLabel lblgender3;
    private javax.swing.JLabel lblgender4;
    private javax.swing.JLabel lblgender5;
    private javax.swing.JLabel lblgender6;
    private javax.swing.JLabel lblgender7;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname10;
    private javax.swing.JLabel lblname11;
    private javax.swing.JLabel lblname2;
    private javax.swing.JLabel lblname3;
    private javax.swing.JLabel lblname4;
    private javax.swing.JLabel lblname5;
    private javax.swing.JLabel lblname6;
    private javax.swing.JLabel lblname7;
    private javax.swing.JLabel lblname8;
    private javax.swing.JLabel lblname9;
    private javax.swing.JLabel lblsname;
    private javax.swing.JLabel lblsname2;
    private javax.swing.JLabel lblsname3;
    private javax.swing.JLabel lblsname4;
    private javax.swing.JLabel lblsname5;
    private javax.swing.JList<String> lstAppoint;
    private javax.swing.JList<String> lstPatients;
    private javax.swing.JList<String> lstSpecialties;
    private javax.swing.JList<String> lstStaff;
    private javax.swing.JTabbedPane tbPane;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfContactADD;
    private javax.swing.JTextField tfContactPERSONAL;
    private javax.swing.JTextField tfDiagnosis2;
    private javax.swing.JTextField tfGenderADD;
    private javax.swing.JTextField tfGenderADDp;
    private javax.swing.JTextField tfJobDesADD;
    private javax.swing.JTextField tfJobDesc;
    private javax.swing.JTextField tfJobDescPERSONAL;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfPasswordADD;
    private javax.swing.JTextField tfPasswordPERSONAL;
    private javax.swing.JTextField tfPatientID;
    private javax.swing.JTextField tfPatientIDADDp;
    private javax.swing.JTextField tfPrescription;
    private javax.swing.JTextField tfPrescriptionADDp;
    private javax.swing.JTextField tfQual;
    private javax.swing.JTextField tfQualADD;
    private javax.swing.JTextField tfQualPERSONAL;
    private javax.swing.JTextField tfResidence;
    private javax.swing.JTextField tfResidenceADD;
    private javax.swing.JTextField tfResidencePERSONAL;
    private javax.swing.JTextField tfSex;
    private javax.swing.JTextField tfSex2;
    private javax.swing.JTextField tfSexPERSONAL;
    private javax.swing.JTextField tfSname;
    private javax.swing.JTextField tfSname2;
    private javax.swing.JTextField tfSnameADD;
    private javax.swing.JTextField tfSnameADDp;
    private javax.swing.JTextField tfSnamePERSONAL;
    private javax.swing.JTextField tfSpec;
    private javax.swing.JTextField tfSpecCode;
    private javax.swing.JTextField tfSpecCodeADDp;
    private javax.swing.JTextField tfSpecPERSONAL;
    private javax.swing.JTextField tfSpecialtyADD;
    private javax.swing.JTextField tfStaffID;
    private javax.swing.JTextField tfStaffIDADD;
    private javax.swing.JTextField tfSymptomsADDp;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfname6;
    private javax.swing.JTextField tfnameADD;
    private javax.swing.JTextField tfnameADDp;
    private javax.swing.JTextField tfnamePERSONAL;
    // End of variables declaration//GEN-END:variables
}
