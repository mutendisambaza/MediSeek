/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Receptionist;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mediseek.pat.START.LoginGUIoption;
import mediseek.pat.Tables.Staff;
import mediseek.pat.Tables.Appointments;
import mediseek.pat.Tables.Patients;
import mediseek.pat.Tables.useAppointments;
import mediseek.pat.Tables.usePatients;
import mediseek.pat.Tables.useStaff;
import mediseek.pat.CriticalClasses.DataValidation;
import mediseek.pat.CriticalClasses.Methods;

/**
 *
 * @author tendi
 */
public class ReceptionistPage extends javax.swing.JFrame {

 DefaultListModel dlstStaff = new DefaultListModel();
 Staff[] staffDirectory = new Staff[500]; 
 useStaff objStaff = new useStaff();
 Staff[] user = new Staff[1];
 
DefaultListModel dlstPatients = new DefaultListModel();
Patients[] patientDirectory = new Patients[100]; 
usePatients objPatients = new usePatients();
Patients[] patientDirectorySearch = new Patients[10];

DefaultListModel dlstAppoint = new DefaultListModel();
DefaultListModel dlstPHistory = new DefaultListModel();
Appointments[] appDirectory = new Appointments[100]; 
useAppointments objApp = new useAppointments();
Appointments[] appDirectoryHistory = new Appointments[100]; 
 
//OTHER OBJECTS
DataValidation objValidation = new DataValidation();
ReceptionistGUIlogin loginObj = new ReceptionistGUIlogin();
Methods obj = new Methods();
private String usertemp;

/**
     * Constructor method that displays the arrays in their respective lists
     * Takes the userID entered in the login and and saves it in a global variable
     * Also places all the information of the  user in their necessary fields on the personal information
     */
 public ReceptionistPage(String userID) {
           initComponents();
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
    public ReceptionistPage() {
        initComponents();        
        getPatients();
        getStaff();
        getAppointments();
        
    }
    
 //////////////////////////////////////////////////////////////////////////////////   
 /**
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
 * This will be the records of the patients in the hospital
 */
      public void getPatients() {
        patientDirectory = objPatients.fromtblPatients("SELECT * FROM tblPatients;");
        for (int i = 0; i < objPatients.getSize(); i++) {
            dlstPatients.addElement(patientDirectory[i].toString());
        }
    } 
   /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which specifically looks for the Patients ID
     * Displays the elements in an list
     */  
      public void searchPatient(String name, String surname) {
        dlstPatients.clear();
        patientDirectorySearch = objPatients.fromtblPatients("SELECT * FROM tblPatients where pName = \""+name+"\" and pSurname = \""+surname+"\";");
        for (int i = 0; i < objPatients.getSize(); i++) {
            dlstPatients.addElement(patientDirectorySearch[i].toString());
        }
    } 
     /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     * This will get all the records of the appointments scheduled before the day of the check
     */  
      public void getPatientHistory(String patientID) {
        dlstPHistory.clear();
        appDirectoryHistory = objApp.fromtblAppointments("Select * from tblAppointments where PatientNo = \""+patientID+"\" AND appDate < Now();");            
        for (int i = 0; i < objApp.getSize(); i++) {
            dlstPHistory.addElement(appDirectoryHistory[i].toString());
        }
      }
      /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     */ 
    public void getStaff() {
        staffDirectory = objStaff.fromtblStaff("SELECT * FROM tblStaff;");
        for (int i = 0; i < objStaff.getSize(); i++) {
            dlstStaff.addElement(staffDirectory[i].toStringView());
        }
    }
 //////////////////////////////////////////////////////////////////////////////////
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
    ///////////////////////////////////////////////////////////////////////////////
   /**
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which will contain an ORDER BY statement in order
     * to retrieve an array in an order
     * It then fills the list with each individual element until they are none left
     * This is to get th order of Staff
     */ 
    public void getStaffSorted(String x) {
         dlstStaff.clear();
         staffDirectory = objStaff.fromtblStaff(x);
        for (int i = 0; i < objStaff.getSize(); i++) {
            dlstStaff.addElement(staffDirectory[i].toStringView());
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
 /////////////////////////////////////////////////////////////////////////////////   
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        tbPane = new javax.swing.JTabbedPane();
        ViewPatientsTab = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        PatientInfoPanel = new javax.swing.JPanel();
        tfname = new javax.swing.JTextField();
        lblname2 = new javax.swing.JLabel();
        lblsname2 = new javax.swing.JLabel();
        tfDiagnosis2 = new javax.swing.JTextField();
        lblgender3 = new javax.swing.JLabel();
        tfSname = new javax.swing.JTextField();
        lbldIAGNOSIS2 = new javax.swing.JLabel();
        tfPrescription = new javax.swing.JTextField();
        lblSymptoms2 = new javax.swing.JLabel();
        cbMedAidCheck = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblgender2 = new javax.swing.JLabel();
        tfPID = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tfSex = new javax.swing.JTextField();
        tfSpecCode = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        btnDischarge = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPatients = new javax.swing.JList<>();
        tf_Surname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddPatientPage = new javax.swing.JButton();
        btnShowPatient1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_Name = new javax.swing.JTextField();
        lblTitle7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddApp1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblTitle8 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSeeInPatientPanel = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ViewStaffTab1 = new javax.swing.JPanel();
        PatientInfoPanel3 = new javax.swing.JPanel();
        lblsname5 = new javax.swing.JLabel();
        tfQual1 = new javax.swing.JTextField();
        lblJD2 = new javax.swing.JLabel();
        tfSname3 = new javax.swing.JTextField();
        lbldIAGNOSIS5 = new javax.swing.JLabel();
        tfResidence1 = new javax.swing.JTextField();
        lblSymptoms5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnLOGOUT1 = new javax.swing.JButton();
        lblgender5 = new javax.swing.JLabel();
        lblJD3 = new javax.swing.JLabel();
        tfname4 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        lblname7 = new javax.swing.JLabel();
        lblname11 = new javax.swing.JLabel();
        tfContact1 = new javax.swing.JTextField();
        tfStaffID1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        tfSex2 = new javax.swing.JTextField();
        tfJobDesc = new javax.swing.JTextField();
        tfSpec = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstStaff1 = new javax.swing.JList<>();
        cbStaffSorted = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblTitle9 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbSpecialtyOrder = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        btnSeeInStaffPanel = new javax.swing.JButton();
        ViewAppointmentsTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAppoint = new javax.swing.JList<>();
        lblTitle2 = new javax.swing.JLabel();
        btnAddApp = new javax.swing.JButton();
        cbMonthApp = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbSpecialtyApp = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
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
        tfPatientIDADDp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfGenderADDp = new javax.swing.JTextField();
        lblgender7 = new javax.swing.JLabel();
        tfSpecCodeADDp = new javax.swing.JTextField();
        ViewPatientsHistoryTab = new javax.swing.JPanel();
        lblTitle3 = new javax.swing.JLabel();
        tfPatientsID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPatientHistory = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        AddStaffTab = new javax.swing.JPanel();
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
        tfJobDescPERSONAL = new javax.swing.JTextField();
        tfSpecPERSONAL = new javax.swing.JTextField();
        btnLogout = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

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

        lblname2.setText("Name:");
        PatientInfoPanel.add(lblname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));

        lblsname2.setText("Surname:");
        PatientInfoPanel.add(lblsname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, -1));

        tfDiagnosis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDiagnosis2ActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfDiagnosis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 430, 80));

        lblgender3.setText("Specialty Code:");
        PatientInfoPanel.add(lblgender3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, 30));

        tfSname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnameActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 230, 50));

        lbldIAGNOSIS2.setText("Symptoms:");
        PatientInfoPanel.add(lbldIAGNOSIS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, 30));

        tfPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrescriptionActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 430, 70));

        lblSymptoms2.setText("Prescription:");
        PatientInfoPanel.add(lblSymptoms2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, 30));

        cbMedAidCheck.setText("Patient Possesses Medical Aid");
        cbMedAidCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedAidCheckActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(cbMedAidCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 210, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/INJUREDpatient.png"))); // NOI18N
        PatientInfoPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 280));

        jButton2.setText("Update Patient Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 160, -1));

        lblgender2.setText("Sex:");
        PatientInfoPanel.add(lblgender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 30));

        tfPID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPIDActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 180, -1));

        jLabel25.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel25.setText("Patient ID:");
        PatientInfoPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 90, 30));

        tfSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSexActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 100, 50));

        tfSpecCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSpecCodeActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSpecCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 130, 50));

        jLabel38.setText("1) Change information   2) Click Update and Save Below");
        PatientInfoPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, -1, -1));

        jLabel39.setText("If you wish to change the information of this Patient:");
        PatientInfoPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, -1, -1));

        btnDischarge.setBackground(new java.awt.Color(255, 0, 51));
        btnDischarge.setForeground(new java.awt.Color(255, 255, 255));
        btnDischarge.setText("Discharge Patient");
        btnDischarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDischargeActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(btnDischarge, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 540, 150, -1));

        jPanel4.add(PatientInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 1070, 580));

        lstPatients.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lstPatients.setModel(dlstPatients);
        jScrollPane1.setViewportView(lstPatients);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 1030, 220));
        jPanel4.add(tf_Surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 150, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Patient Information:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 140, 30));

        lblTitle1.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("*If Patient cannot be found in the Database:");
        jPanel4.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 310, 80));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Patient Surname:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 130, 30));

        btnAddPatientPage.setText("Add a new Patient");
        btnAddPatientPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientPageActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddPatientPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 70, 150, -1));

        btnShowPatient1.setText("Search Patient by Names");
        btnShowPatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPatient1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnShowPatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 180, -1));

        jLabel16.setText("Name");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jLabel17.setText("Patient-ID");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel12.setText("Patient First Name:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 30));

        tf_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NameActionPerformed(evt);
            }
        });
        jPanel4.add(tf_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 150, -1));

        lblTitle7.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle7.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle7.setText("View Patients:");
        jPanel4.add(lblTitle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Step 2)");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, -1, 50));

        btnAddApp1.setText("Add new Appointment");
        btnAddApp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddApp1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddApp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 110, 150, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setText("Step 1)");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, -1, 30));

        lblTitle8.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle8.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle8.setText("OR:");
        jPanel4.add(lblTitle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 70, 80));

        btnRefresh.setText("Resfresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 80, 20));

        jLabel6.setText("Once a Record has been selected Click below:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        btnSeeInPatientPanel.setText("See Patient Info");
        btnSeeInPatientPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInPatientPanelActionPerformed(evt);
            }
        });
        jPanel4.add(btnSeeInPatientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 130, -1));

        jLabel19.setText("Medical Aid?");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel20.setText("Spec Code");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jLabel21.setText("Prescription");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, -1, -1));

        jLabel22.setText("Surname");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel23.setText("Symptoms");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, -1, -1));

        jLabel26.setText("Gender");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        ViewPatientsTab.setViewportView(jPanel4);

        tbPane.addTab("View Patients", ViewPatientsTab);

        ViewStaffTab1.setBackground(new java.awt.Color(126, 145, 158));
        ViewStaffTab1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PatientInfoPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblsname5.setText("Surname:");
        PatientInfoPanel3.add(lblsname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, -1));

        tfQual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQual1ActionPerformed(evt);
            }
        });
        PatientInfoPanel3.add(tfQual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 430, 70));

        lblJD2.setText("Specialty: ");
        PatientInfoPanel3.add(lblJD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 90, 30));

        tfSname3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSname3ActionPerformed(evt);
            }
        });
        PatientInfoPanel3.add(tfSname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 230, 50));

        lbldIAGNOSIS5.setText("Qualifications:");
        PatientInfoPanel3.add(lbldIAGNOSIS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 90, 30));

        tfResidence1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResidence1ActionPerformed(evt);
            }
        });
        PatientInfoPanel3.add(tfResidence1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 430, 60));

        lblSymptoms5.setText("Residence:");
        PatientInfoPanel3.add(lblSymptoms5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 90, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/medicalstafficon.jpg"))); // NOI18N
        PatientInfoPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 260, 270));

        btnLOGOUT1.setText("LOGOUT");
        btnLOGOUT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUT1ActionPerformed(evt);
            }
        });
        PatientInfoPanel3.add(btnLOGOUT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, -440, -1, -1));

        lblgender5.setText("Sex:");
        PatientInfoPanel3.add(lblgender5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 90, 30));

        lblJD3.setText("Job Description:");
        PatientInfoPanel3.add(lblJD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 90, 30));

        tfname4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfname4ActionPerformed(evt);
            }
        });
        PatientInfoPanel3.add(tfname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 50));

        jLabel28.setText("Personal Information");
        PatientInfoPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 130, 30));

        lblname7.setText("Name:");
        PatientInfoPanel3.add(lblname7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 90, 30));

        lblname11.setText("Contact No:");
        PatientInfoPanel3.add(lblname11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 90, 30));

        tfContact1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContact1ActionPerformed(evt);
            }
        });
        PatientInfoPanel3.add(tfContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, 170, 30));

        tfStaffID1.setToolTipText("Enter the Staff ID of the meber you wish to search and proceed to click the Search Patient Button below");
        tfStaffID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStaffID1ActionPerformed(evt);
            }
        });
        PatientInfoPanel3.add(tfStaffID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 180, -1));

        jLabel29.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel29.setText("Staff ID:");
        PatientInfoPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 90, 30));
        PatientInfoPanel3.add(tfSex2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 160, 40));
        PatientInfoPanel3.add(tfJobDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 160, 50));
        PatientInfoPanel3.add(tfSpec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 160, 40));

        ViewStaffTab1.add(PatientInfoPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 1070, 600));

        lstStaff1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lstStaff1.setModel(dlstStaff);
        jScrollPane6.setViewportView(lstStaff1);

        ViewStaffTab1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 1070, 160));

        cbStaffSorted.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Order", "Alphabetical Order (First Name)", "Alphabetical Order (Surname Name)", "Gender", "Job Description", "Specialty" }));
        cbStaffSorted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStaffSortedActionPerformed(evt);
            }
        });
        ViewStaffTab1.add(cbStaffSorted, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 220, -1));

        jLabel30.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel30.setText("Search Staff by Specialty:");
        ViewStaffTab1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 260, 30));

        jLabel31.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel31.setText("Staff Information:");
        ViewStaffTab1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 140, 30));

        lblTitle9.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle9.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle9.setText("View Staff");
        ViewStaffTab1.add(lblTitle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 80));

        jLabel32.setText("Name");
        ViewStaffTab1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel33.setText("Surname");
        ViewStaffTab1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        jLabel34.setText("Staff ID");
        ViewStaffTab1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        jLabel35.setText("Specialty");
        ViewStaffTab1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jLabel36.setText("Sex");
        ViewStaffTab1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        jLabel37.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel37.setText("Place Staff in order of:");
        ViewStaffTab1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 220, 30));

        cbSpecialtyOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "Biokinetics", "Cardiologist", "Gynaecologist", "General Practitioner", "Infectious Diseases Specialist", "Neurologist", "Oncologist", "Pharmacist", "Prosthetist", "Psychologist", "Radiologist" }));
        cbSpecialtyOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSpecialtyOrderActionPerformed(evt);
            }
        });
        ViewStaffTab1.add(cbSpecialtyOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 160, -1));

        jLabel24.setText("Once a Record has been selected Click:");
        ViewStaffTab1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        btnSeeInStaffPanel.setText("See Staffer's Info");
        btnSeeInStaffPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInStaffPanelActionPerformed(evt);
            }
        });
        ViewStaffTab1.add(btnSeeInStaffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, -1, 30));

        jScrollPane5.setViewportView(ViewStaffTab1);

        tbPane.addTab("View Staff", jScrollPane5);

        ViewAppointmentsTab.setBackground(new java.awt.Color(126, 145, 158));
        ViewAppointmentsTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstAppoint.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        lstAppoint.setModel(dlstAppoint);
        jScrollPane2.setViewportView(lstAppoint);

        ViewAppointmentsTab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1180, 430));

        lblTitle2.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("View Appointments:");
        ViewAppointmentsTab.add(lblTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 80));

        btnAddApp.setText("Add new Appointment");
        btnAddApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAppActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(btnAddApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 150, -1));

        cbMonthApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbMonthApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthAppActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(cbMonthApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 180, -1));

        jLabel11.setText("Get all the appointments by Specialty:");
        ViewAppointmentsTab.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 220, -1));

        jLabel13.setText("Get all the Appointments by Month:");
        ViewAppointmentsTab.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 200, -1));

        jLabel18.setText("OR");
        ViewAppointmentsTab.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, -1));

        cbSpecialtyApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "Biokinetics", "Cardiologist", "Gynaecologist", "General Practitioner", "Infectious Diseases Specialist", "Neurologist", "Oncologist", "Pharmacist", "Prosthetist", "Psychologist", "Radiologist" }));
        cbSpecialtyApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSpecialtyAppActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(cbSpecialtyApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 180, -1));

        jToggleButton1.setText("REFRESH");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1121, 60, 90, -1));

        jLabel40.setText("Symptoms");
        ViewAppointmentsTab.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, -1, -1));

        jLabel41.setText("Patient-ID");
        ViewAppointmentsTab.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel42.setText("Staff-ID");
        ViewAppointmentsTab.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel43.setText("Date");
        ViewAppointmentsTab.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel44.setText("Time");
        ViewAppointmentsTab.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jLabel45.setText("Patient Admitted?");
        ViewAppointmentsTab.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

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
        AddPatientTab.add(cbMedAidADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 210, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/INJUREDpatient.png"))); // NOI18N
        AddPatientTab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 280));

        btnAddPatient.setText("Add Patient");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });
        AddPatientTab.add(btnAddPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 160, -1));

        lblTitle6.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle6.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle6.setText("Add a Patient:");
        AddPatientTab.add(lblTitle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 310, 80));

        tfPatientIDADDp.setToolTipText("P(PatientNum)\neg P321");
        tfPatientIDADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPatientIDADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfPatientIDADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, 180, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Patient ID:");
        AddPatientTab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 90, 30));

        tfGenderADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGenderADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfGenderADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 100, 50));

        lblgender7.setText("Specialty Code:");
        AddPatientTab.add(lblgender7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, 30));

        tfSpecCodeADDp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSpecCodeADDpActionPerformed(evt);
            }
        });
        AddPatientTab.add(tfSpecCodeADDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 130, 50));

        tbPane.addTab("Add a Patient", AddPatientTab);

        ViewPatientsHistoryTab.setBackground(new java.awt.Color(102, 116, 141));
        ViewPatientsHistoryTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle3.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setText("View Patients History:");
        ViewPatientsHistoryTab.add(lblTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));

        tfPatientsID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPatientsIDActionPerformed(evt);
            }
        });
        ViewPatientsHistoryTab.add(tfPatientsID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 180, -1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setText("Patient ID:");
        ViewPatientsHistoryTab.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 90, 30));

        lstPatientHistory.setModel(dlstPHistory);
        jScrollPane3.setViewportView(lstPatientHistory);

        ViewPatientsHistoryTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1160, 360));

        jButton1.setText("See History of Patient");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ViewPatientsHistoryTab.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 160, 40));

        tbPane.addTab("View Patient History", ViewPatientsHistoryTab);

        AddStaffTab.setBackground(new java.awt.Color(99, 158, 158));
        AddStaffTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPasswordPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfPasswordPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 170, 30));

        lblname8.setText("Staff ID Password: ");
        AddStaffTab.add(lblname8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 120, 30));

        lblsname4.setText("Surname:");
        AddStaffTab.add(lblsname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 90, -1));

        tfQualPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQualPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfQualPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 430, 70));

        lblJD4.setText("Specialty: ");
        AddStaffTab.add(lblJD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 90, 30));

        tfSnamePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnamePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfSnamePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 230, 50));

        lbldIAGNOSIS4.setText("Qualifications:");
        AddStaffTab.add(lbldIAGNOSIS4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 90, 30));

        tfResidencePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResidencePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfResidencePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 430, 60));

        lblSymptoms4.setText("Residence:");
        AddStaffTab.add(lblSymptoms4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 90, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/medicalstafficon.jpg"))); // NOI18N
        AddStaffTab.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 260, 270));

        btnAddStaff1.setText("Update Your Information");
        btnAddStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaff1ActionPerformed(evt);
            }
        });
        AddStaffTab.add(btnAddStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 220, -1));

        btnLOGOUT2.setText("LOGOUT");
        btnLOGOUT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUT2ActionPerformed(evt);
            }
        });
        AddStaffTab.add(btnLOGOUT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, -440, -1, -1));

        lblgender6.setText("Sex:");
        AddStaffTab.add(lblgender6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 90, 30));

        lblJD5.setText("Job Description:");
        AddStaffTab.add(lblJD5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 90, 30));

        tfnamePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnamePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfnamePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 230, 50));

        jLabel15.setText("Personal Information");
        AddStaffTab.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 130, 30));

        lblname9.setText("Name:");
        AddStaffTab.add(lblname9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 90, 30));

        lblname10.setText("Contact No:");
        AddStaffTab.add(lblname10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 90, 30));

        tfContactPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab.add(tfContactPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 170, 30));

        lblTitle4.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle4.setText("Your Personal Info:");
        AddStaffTab.add(lblTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));
        AddStaffTab.add(tfSexPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 70, 40));
        AddStaffTab.add(tfJobDescPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 270, 40));
        AddStaffTab.add(tfSpecPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 160, 40));

        tbPane.addTab("Personal Information", AddStaffTab);

        getContentPane().add(tbPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1260, 640));

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Receptionist:");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 320, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/MS Main1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 770));

        jMenu5.setText("About");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Who are we?");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar3.add(jMenu5);

        jMenu6.setText("Help");

        jMenuItem2.setText("Using the Program");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuBar3.add(jMenu6);

        setJMenuBar(jMenuBar3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginGUIoption LoginGUI = new LoginGUIoption();
        LoginGUI.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAddPatientPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPatientPageActionPerformed

    private void btnShowPatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPatient1ActionPerformed
if(objValidation.isNotEmpty(tf_Name.getText())==true && objValidation.isNotEmpty(tf_Surname.getText())==true)
    { if(objValidation.allCharacters(tf_Name.getText()) && objValidation.allCharacters(tf_Surname.getText())){
        searchPatient(tf_Name.getText(), tf_Surname.getText());
        }else{JOptionPane.showMessageDialog(null, " YOU MAY NOT ENTER ANY NUMBERS INTO YOUR SEARCH\n Try Again!");}
}else{JOptionPane.showMessageDialog(null, " PLEASE INPUT BOTH A NAME AND A SURNAME FOR THE PATIENT YOU WISH TO SEARCH");}    
    }//GEN-LAST:event_btnShowPatient1ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(objValidation.isNotEmpty(tfPatientsID.getText())==true){getPatientHistory(tfPatientsID.getText());}
else{JOptionPane.showMessageDialog(null, " PLEASE INPUT A PATIENT ID");}
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAppActionPerformed
       
         addAppointmentGUI LoginGUI = new addAppointmentGUI();
        LoginGUI.setVisible(true);
        
        
    }//GEN-LAST:event_btnAddAppActionPerformed

    private void btnAddApp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddApp1ActionPerformed
      
          addAppointmentGUI LoginGUI = new addAppointmentGUI();
        LoginGUI.setVisible(true);
        
        
    }//GEN-LAST:event_btnAddApp1ActionPerformed

    private void tfQual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQual1ActionPerformed

    private void tfSname3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSname3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSname3ActionPerformed

    private void tfResidence1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResidence1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResidence1ActionPerformed

    private void btnLOGOUT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLOGOUT1ActionPerformed

    private void tfname4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfname4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfname4ActionPerformed

    private void tfContact1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContact1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContact1ActionPerformed

    private void tfStaffID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStaffID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStaffID1ActionPerformed

    private void cbSpecialtyOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSpecialtyOrderActionPerformed
//cbSpecialtyOrder
// NONE
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
         switch(cbSpecialtyOrder.getSelectedIndex()){
            case 1: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Biokinetics\";");
                break;
            case 2: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Cardiologist\";");
                break;
            case 3: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Gynaecologist\";");
                break;
            case 4: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"General Practitioner\";");
                break;
            case 5: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Infectious Diseases Specialist\";");
                break;
            case 6: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Neurologist\";");
                break;
            case 7: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Oncologist\";");
                break;    
            case 8: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Pharmacist\";");
                break;    
            case 9: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Prosthetist\";");
                break;    
            case 10: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Psychologist\";");
                break;    
            case 11: getStaffSorted("SELECT * FROM tblStaff WHERE tblStaff.Specialty=\"Radiologist\";");
                break;      
            default: System.out.println("Unkown index selected");
                    
                break;    
        }
        
    }//GEN-LAST:event_cbSpecialtyOrderActionPerformed

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

    private void cbMedAidCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedAidCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMedAidCheckActionPerformed

    private void tf_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NameActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        dlstPatients.clear();
        getPatients();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSeeInStaffPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInStaffPanelActionPerformed

        if (lstStaff1.getSelectedIndex()>-1)//edits a new record in the table and refreshes the display of the list
        {   tbPane.setSelectedIndex(1);

            tfStaffID1.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getStaff_ID());
            tfname4.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getsName());
            tfSname3.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getsSurname());
            tfSex2.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getGender());
            tfJobDesc.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getJobDescription());
            tfSpec.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getSpecialty());
            tfResidence1.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getResidence());
            tfQual1.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getQualifications());
            tfContact1.setText(""+staffDirectory[lstStaff1.getSelectedIndex()].getContact());


        }else JOptionPane.showMessageDialog(null, " SELECT A STAFF MEMEBR TO VIEW");

    }//GEN-LAST:event_btnSeeInStaffPanelActionPerformed

    private void btnSeeInPatientPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInPatientPanelActionPerformed
        //edits a new record in the table and refreshes the display of the list
        if (lstPatients.getSelectedIndex()>-1) //checks to see if a record from the list element has been selected
        {   tbPane.setSelectedIndex(0); //selects the tab that all the tetfields are in
            //input the data that has been taken from the database into each corresponding textfield
            tfPID.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getPatientID());
            tfname.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getName());
            tfSname.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getSurname());
            tfSex.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getGender());
            tfSpecCode.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getSpecialtyCode());
            cbMedAidCheck.setSelected(patientDirectory[lstPatients.getSelectedIndex()].isMedicalAid());
            tfDiagnosis2.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getDiagnosis());
            tfPrescription.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getPrescription());

        }else {JOptionPane.showMessageDialog(null, " SELECT A PATIENT TO VIEW");  }

    }//GEN-LAST:event_btnSeeInPatientPanelActionPerformed

    private void tfSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSexActionPerformed

    private void tfSpecCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecCodeActionPerformed

    private void tfPatientsIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPatientsIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPatientsIDActionPerformed

    private void cbStaffSortedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStaffSortedActionPerformed
//No Order
//Alphabetical Order (First Name)
//Alphabetical Order (First Name)
//Gender
//Job Description
//Specialty

        switch(cbStaffSorted.getSelectedIndex()){
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
    }//GEN-LAST:event_cbStaffSortedActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if (objValidation.isNotEmpty(tfnameADDp.getText()) && objValidation.isNotEmpty(tfSnameADDp.getText()) && objValidation.isNotEmpty(tfGenderADDp.getText()) && objValidation.isNotEmpty(tfSpecCodeADDp.getText())
    &&  objValidation.isNotEmpty(tfSymptomsADDp.getText()) &&  objValidation.isNotEmpty(tfPrescriptionADDp.getText()) &&  objValidation.isNotEmpty(tfPatientIDADDp.getText())) {            

    String MedAidConverstion = "";
            if (lstPatients.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Please select a record first"); 
                
            } else {
                
                                 MedAidConverstion = "";
                                        if (cbMedAidCheck.isSelected() == true) {
                                        MedAidConverstion = "yes";
                                    } else {
                                        MedAidConverstion = "no";
                                    }
                     if(objValidation.allCharacters(tfname.getText()) && objValidation.allCharacters(tfSname.getText()) && objValidation.allCharacters(tfSex.getText()) && objValidation.allCharacters(tfSpecCode.getText())){
                                System.out.println("UPDATE tblPatients SET  tblPatients.pName = '" + tfname.getText()
                                        + "', tblPatients.pSurname = '" + tfSname.getText()
                                        + "', tblPatients.Gender = '" + tfSex.getText()
                                        + "', tblPatients.SpecialtyCode = '" + tfSpecCode.getText()                        
                                        + "', tblPatients.MedicalAid = " + MedAidConverstion
                                        + ", tblPatients.Symptoms = '" + tfPrescriptionADDp.getText()
                                        + "', tblPatients.Prescription = '" + tfPrescription.getText()
                                        + "' WHERE Patient_ID = '" + tfPID.getText() + "';");

                                objPatients.updateTable("UPDATE tblPatients SET  tblPatients.pName = '" + tfname.getText()
                                        + "', tblPatients.pSurname = '" + tfSname.getText()
                                        + "', tblPatients.Gender = '" + tfSex.getText()                       
                                        + "', tblPatients.SpecialtyCode = '" + tfSpecCode.getText()                        
                                        + "', tblPatients.MedicalAid = " + MedAidConverstion
                                        + ", tblPatients.Symptoms = '" + tfPrescriptionADDp.getText()
                                        + "', tblPatients.Prescription = '" + tfPrescription.getText()
                                        + "' WHERE Patient_ID = '" + tfPID.getText() + "';");
                    }else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE Fields \n Try Again!");}            

            } 

       
            tbPane.setSelectedIndex(0);
            dlstPatients.clear();
            getPatients();
        
        } else{
        JOptionPane.showMessageDialog(null, "ALL FIELDS ARE TO BE FILLED. Review your entry and Try Again!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfPIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPIDActionPerformed
  
    }//GEN-LAST:event_tfPIDActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
  
       
     
if (objValidation.isNotEmpty(tfnameADDp.getText()) == true && objValidation.isNotEmpty(tfGenderADDp.getText()) == true && objValidation.isNotEmpty(tfSpecCodeADDp.getText()) == true &&
    objValidation.isNotEmpty(tfSymptomsADDp.getText()) == true && objValidation.isNotEmpty(tfPrescriptionADDp.getText()) == true && objValidation.isNotEmpty(tfPatientIDADDp.getText()) == true &&
    objValidation.isNotEmpty(tfSnameADDp.getText())){
    
                    String MedAidConverstion = "";
                    if (lstPatients.getSelectedIndex() == -1) {
                             if(objValidation.allCharacters(tfnameADDp.getText()) && objValidation.allCharacters(tfSnameADDp.getText()) && objValidation.allCharacters(tfGenderADDp.getText()) 
                                && objValidation.allCharacters(tfSpec.getText()) && objValidation.allCharacters(tfJobDesc.getText()) ){
                                            if (cbMedAidADDp.isSelected() == true)
                                            {MedAidConverstion = "yes";} 
                                            else {MedAidConverstion = "no";}

                                            //addes a new record to the table and refreshes the display of the list
                                            objPatients.updateTable("insert into tblPatients (pName, pSurname, Gender, Patient_ID, MedicalAid, SpecialtyCode, Symptoms, Prescription) values('" + tfnameADDp.getText() + "','" + tfSnameADDp.getText() + "','" + tfGenderADDp.getText()
                                                    + "','" + tfPatientIDADDp.getText() + "'," + MedAidConverstion + ",'" + tfSpecCodeADDp.getText() + "','" + tfSymptomsADDp.getText() + "','" + tfPrescriptionADDp.getText() + "') ;");

                                            System.out.println("insert into tblPatients (pName, pSurname, Gender, Patient_ID, MedicalAid, SpecialtyCode, Symptoms, Prescription) values('" + tfnameADDp.getText() + "','" + tfSnameADDp.getText() + "','" + tfGenderADDp.getText()
                                                    + "','" + tfPatientIDADDp.getText() + "'," + MedAidConverstion + ",'" + tfSpecCodeADDp.getText() + "','" + tfSymptomsADDp.getText() + "','" + tfPrescriptionADDp.getText() + "') ;");                                 
                             }else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE Fields \n Try Again!");}            

                               
                    }

       } else{JOptionPane.showMessageDialog(null, "UNABLE TO ADD PATIENT \nPlease ensure that every field has been filled in then retry.");}

        tbPane.setSelectedIndex(0);
        dlstPatients.clear();
        getPatients();
        
     
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void tfGenderADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGenderADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGenderADDpActionPerformed

    private void tfSpecCodeADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecCodeADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecCodeADDpActionPerformed

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
dlstAppoint.clear();getAppointments();      
    
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnDischargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDischargeActionPerformed
        if (lstPatients.getSelectedIndex() > -1) {  // make sure that the item is selected in the list
            objPatients.updateTable("delete * FROM tblPatients where Patient_ID = '" +patientDirectory[lstPatients.getSelectedIndex()].getPatientID()+"';");//delete item selected using the update method in the
            dlstPatients.clear();//clear list for the updated data
            getPatients();// add updated data to the list
        } else {
            JOptionPane.showMessageDialog(null, " SELECT A PATIENT RECORD FROM THE LIST");
        }
        tfPID.setText("");
        tfname.setText("");
        tfSname.setText("");
        tfSex.setText("");
        tfSpecCode.setText("");
        cbMedAidCheck.setSelected(false);
        tfDiagnosis2.setText("");
        tfPrescription.setText("");

    }//GEN-LAST:event_btnDischargeActionPerformed

    private void btnAddStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaff1ActionPerformed

   if (objValidation.isNotEmpty(tfnamePERSONAL.getText()) == true && objValidation.isNotEmpty(tfSnamePERSONAL.getText()) == true && objValidation.isNotEmpty(tfSexPERSONAL.getText()) == true
      && objValidation.isNotEmpty(tfJobDescPERSONAL.getText()) == true && objValidation.isNotEmpty(tfSpecPERSONAL.getText()) == true && objValidation.isNotEmpty(tfResidencePERSONAL.getText()) == true
      && objValidation.isNotEmpty(tfQualPERSONAL.getText()) == true && objValidation.isNotEmpty(tfContactPERSONAL.getText())== true && objValidation.isNotEmpty(tfPasswordPERSONAL.getText()) == true && objValidation.isNotEmpty(tfPasswordPERSONAL.getText())==true) {
            if(objValidation.allCharacters(tfnamePERSONAL.getText()) && objValidation.allCharacters(tfSnamePERSONAL.getText()) && objValidation.allCharacters(tfSexPERSONAL.getText())
            && objValidation.allCharacters(tfSpecPERSONAL.getText()) && objValidation.allCharacters(tfJobDescPERSONAL.getText()) ){     

        
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
                 }else{JOptionPane.showMessageDialog(null, "You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE/JOB DESCRIPTION Fields \n Try Again!");}            

            
  }else{JOptionPane.showMessageDialog(null, "UNABLE TO EDIT YOUR DETAILS\nPlease ensure that every field has been filled in then retry your entry.");}
    }//GEN-LAST:event_btnAddStaff1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        obj.openWord("MediSeek Who are we.docx");

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        obj.openWord("MediSeek Help.docx");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tfPatientIDADDpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPatientIDADDpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPatientIDADDpActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPatientTab;
    private javax.swing.JPanel AddStaffTab;
    private javax.swing.JPanel PatientInfoPanel;
    private javax.swing.JPanel PatientInfoPanel3;
    private javax.swing.JPanel ViewAppointmentsTab;
    private javax.swing.JPanel ViewPatientsHistoryTab;
    private javax.swing.JScrollPane ViewPatientsTab;
    private javax.swing.JPanel ViewStaffTab1;
    private javax.swing.JButton btnAddApp;
    private javax.swing.JButton btnAddApp1;
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnAddPatientPage;
    private javax.swing.JButton btnAddStaff1;
    private javax.swing.JButton btnDischarge;
    private javax.swing.JButton btnLOGOUT1;
    private javax.swing.JButton btnLOGOUT2;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSeeInPatientPanel;
    private javax.swing.JButton btnSeeInStaffPanel;
    private javax.swing.JButton btnShowPatient1;
    private javax.swing.JCheckBox cbMedAidADDp;
    private javax.swing.JCheckBox cbMedAidCheck;
    private javax.swing.JComboBox<String> cbMonthApp;
    private javax.swing.JComboBox<String> cbSpecialtyApp;
    private javax.swing.JComboBox<String> cbSpecialtyOrder;
    private javax.swing.JComboBox<String> cbStaffSorted;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblJD2;
    private javax.swing.JLabel lblJD3;
    private javax.swing.JLabel lblJD4;
    private javax.swing.JLabel lblJD5;
    private javax.swing.JLabel lblSymptoms;
    private javax.swing.JLabel lblSymptoms2;
    private javax.swing.JLabel lblSymptoms4;
    private javax.swing.JLabel lblSymptoms5;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JLabel lblTitle7;
    private javax.swing.JLabel lblTitle8;
    private javax.swing.JLabel lblTitle9;
    private javax.swing.JLabel lbldIAGNOSIS;
    private javax.swing.JLabel lbldIAGNOSIS2;
    private javax.swing.JLabel lbldIAGNOSIS4;
    private javax.swing.JLabel lbldIAGNOSIS5;
    private javax.swing.JLabel lblgender1;
    private javax.swing.JLabel lblgender2;
    private javax.swing.JLabel lblgender3;
    private javax.swing.JLabel lblgender5;
    private javax.swing.JLabel lblgender6;
    private javax.swing.JLabel lblgender7;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname10;
    private javax.swing.JLabel lblname11;
    private javax.swing.JLabel lblname2;
    private javax.swing.JLabel lblname7;
    private javax.swing.JLabel lblname8;
    private javax.swing.JLabel lblname9;
    private javax.swing.JLabel lblsname;
    private javax.swing.JLabel lblsname2;
    private javax.swing.JLabel lblsname4;
    private javax.swing.JLabel lblsname5;
    private javax.swing.JList<String> lstAppoint;
    private javax.swing.JList<String> lstPatientHistory;
    private javax.swing.JList<String> lstPatients;
    private javax.swing.JList<String> lstStaff1;
    private javax.swing.JTabbedPane tbPane;
    private javax.swing.JTextField tfContact1;
    private javax.swing.JTextField tfContactPERSONAL;
    private javax.swing.JTextField tfDiagnosis2;
    private javax.swing.JTextField tfGenderADDp;
    private javax.swing.JTextField tfJobDesc;
    private javax.swing.JTextField tfJobDescPERSONAL;
    private javax.swing.JTextField tfPID;
    private javax.swing.JTextField tfPasswordPERSONAL;
    private javax.swing.JTextField tfPatientIDADDp;
    private javax.swing.JTextField tfPatientsID;
    private javax.swing.JTextField tfPrescription;
    private javax.swing.JTextField tfPrescriptionADDp;
    private javax.swing.JTextField tfQual1;
    private javax.swing.JTextField tfQualPERSONAL;
    private javax.swing.JTextField tfResidence1;
    private javax.swing.JTextField tfResidencePERSONAL;
    private javax.swing.JTextField tfSex;
    private javax.swing.JTextField tfSex2;
    private javax.swing.JTextField tfSexPERSONAL;
    private javax.swing.JTextField tfSname;
    private javax.swing.JTextField tfSname3;
    private javax.swing.JTextField tfSnameADDp;
    private javax.swing.JTextField tfSnamePERSONAL;
    private javax.swing.JTextField tfSpec;
    private javax.swing.JTextField tfSpecCode;
    private javax.swing.JTextField tfSpecCodeADDp;
    private javax.swing.JTextField tfSpecPERSONAL;
    private javax.swing.JTextField tfStaffID1;
    private javax.swing.JTextField tfSymptomsADDp;
    private javax.swing.JTextField tf_Name;
    private javax.swing.JTextField tf_Surname;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfname4;
    private javax.swing.JTextField tfnameADDp;
    private javax.swing.JTextField tfnamePERSONAL;
    // End of variables declaration//GEN-END:variables
}
