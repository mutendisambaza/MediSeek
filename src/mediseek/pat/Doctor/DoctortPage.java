/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Doctor;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mediseek.pat.START.LoginGUIoption;
import mediseek.pat.Tables.Appointments;
import mediseek.pat.Tables.Patients;
import mediseek.pat.Tables.useAppointments;
import mediseek.pat.Tables.usePatients;
import mediseek.pat.CriticalClasses.DataValidation;
import mediseek.pat.CriticalClasses.Methods;
import mediseek.pat.Tables.Staff;
import mediseek.pat.Tables.useStaff;
/**
 *
 * @author tendi
 */
public class DoctortPage extends javax.swing.JFrame {
 Staff[] staffDirectory = new Staff[500]; 
 useStaff objStaff = new useStaff();
 Staff[] user = new Staff[1];
    
DefaultListModel dlstPatients = new DefaultListModel();
Patients[] patientDirectory = new Patients[100]; 
usePatients objPatients = new usePatients();
Patients[] patientDirectorySearch = new Patients[100];    

DefaultListModel dlstAppoint = new DefaultListModel();
DefaultListModel dlstPHistory = new DefaultListModel();
Appointments[] appDirectory = new Appointments[100]; 
useAppointments objApp = new useAppointments();
Appointments[] appDirectoryHistory = new Appointments[100]; 



//OTHER OBJECTS
DataValidation objValidation = new DataValidation();
DoctorGUIlogin loginObj = new DoctorGUIlogin();
Methods obj = new Methods();
private String usertemp;
/**
     * Constructor method that displays the arrays in their respective lists
     * Takes the userID entered in the login and and saves it in a global variable
     * Also places all the information of the  user in their necessary fields on the personal information
     */
    public DoctortPage(String userID) {
            initComponents();
            getPatients();
            getAppointments();
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
    public DoctortPage() {
        initComponents();
        getAppointments();
        getPatients();
        getAppointments();
    }
 
    
 ////////////////////////////////////////////////////////////////////////////////
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
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     * This will get all the records of the appointments scheduled
     */ 
    public void getAppointments() {
        appDirectory = objApp.fromtblAppointments("Select * from tblAppointments");
        for (int i = 0; i < objApp.getSize(); i++) {
            dlstAppoint.addElement(appDirectory[i].toString());
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
     * Method clears a display
     * fills an array with the elements based on the SQL Statement which specifically looks for the Patients ID
     * Displays the elements in an list
     */  
       public void searchPatient(String ID) {
        dlstPatients.clear();
        patientDirectorySearch = objPatients.fromtblPatients("SELECT * FROM tblPatients where Patient_ID = \""+ID+"\";");
        for (int i = 0; i < objPatients.getSize(); i++) {
            dlstPatients.addElement(patientDirectorySearch[i].toString());
        }
    } 
 ///////////////////////////////////////////////////////////////////////////////
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        tbPaneDoc = new javax.swing.JTabbedPane();
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
        tfPrescription = new javax.swing.JTextField();
        lblSymptoms = new javax.swing.JLabel();
        cbMedAid = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblgender2 = new javax.swing.JLabel();
        tfSex = new javax.swing.JTextField();
        tfSpecCode = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        SearchDetails = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPatients = new javax.swing.JList<>();
        cbPatientOrder = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfPateintsID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSeeInPatientPanel = new javax.swing.JButton();
        btnShowPatient1 = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ViewAppointmentsTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAppoint = new javax.swing.JList<>();
        lblTitle2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbSpecialtyApp = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbMonthApp = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        ViewPatientsHistoryTab = new javax.swing.JPanel();
        lblTitle3 = new javax.swing.JLabel();
        tfPID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPHistory = new javax.swing.JList<>();
        btnSeeHistory = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        AddStaffTab2 = new javax.swing.JPanel();
        tfPasswordPERSONAL = new javax.swing.JTextField();
        lblname11 = new javax.swing.JLabel();
        lblsname5 = new javax.swing.JLabel();
        tfQualPERSONAL = new javax.swing.JTextField();
        lblJD6 = new javax.swing.JLabel();
        tfSnamePERSONAL = new javax.swing.JTextField();
        lbldIAGNOSIS5 = new javax.swing.JLabel();
        tfResidencePERSONAL = new javax.swing.JTextField();
        lblSymptoms5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnAddStaff2 = new javax.swing.JButton();
        btnLOGOUT3 = new javax.swing.JButton();
        lblgender7 = new javax.swing.JLabel();
        lblJD7 = new javax.swing.JLabel();
        tfnamePERSONAL = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblname12 = new javax.swing.JLabel();
        lblname13 = new javax.swing.JLabel();
        tfContactPERSONAL = new javax.swing.JTextField();
        lblTitle4 = new javax.swing.JLabel();
        tfSexPERSONAL = new javax.swing.JTextField();
        tfSpecPERSONAL = new javax.swing.JTextField();
        tfJobDescPERSONAL = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        lblname.setText("Name:");
        PatientInfoPanel.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));

        lblsname.setText("Surname:");
        PatientInfoPanel.add(lblsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, -1));

        tfDiagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDiagnosisActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfDiagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 430, 90));

        lblgender1.setText("Specialty Code:");
        PatientInfoPanel.add(lblgender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, 30));

        tfSname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnameActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 230, 50));

        lbldIAGNOSIS.setText("Symptoms:");
        PatientInfoPanel.add(lbldIAGNOSIS, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, 30));

        tfPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrescriptionActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 430, 70));

        lblSymptoms.setText("Prescription:");
        PatientInfoPanel.add(lblSymptoms, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, 30));

        cbMedAid.setText("Patient Possesses Medical Aid");
        cbMedAid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedAidActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(cbMedAid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 210, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/INJUREDpatient.png"))); // NOI18N
        PatientInfoPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 280, 280));

        jButton2.setText("Update Patient Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 540, 160, -1));

        lblgender2.setText("Sex:");
        PatientInfoPanel.add(lblgender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 90, 30));

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

        jLabel29.setText("If you wish to change the information of this Patient:");
        PatientInfoPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, -1, -1));

        jLabel30.setText("1) Change information   2) Click Update and Save Below");
        PatientInfoPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, -1, -1));

        SearchDetails.setBackground(new java.awt.Color(255, 255, 255));
        SearchDetails.setForeground(new java.awt.Color(0, 102, 102));
        SearchDetails.setText("Research Patient Symptoms");
        SearchDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchDetailsActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(SearchDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 190, -1));

        jPanel4.add(PatientInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 1070, 580));

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

        tfPateintsID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPateintsIDActionPerformed(evt);
            }
        });
        jPanel4.add(tfPateintsID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));

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

        jLabel6.setText("Once a Record has been selected Click below:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        btnSeeInPatientPanel.setText("See Patient Info");
        btnSeeInPatientPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInPatientPanelActionPerformed(evt);
            }
        });
        jPanel4.add(btnSeeInPatientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        btnShowPatient1.setText("Search Patient");
        btnShowPatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPatient1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnShowPatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 120, -1));

        btnRefresh.setText("Resfresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 80, -1));

        jLabel19.setText("Name");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel20.setText("Symptoms");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, -1));

        jLabel21.setText("Surname");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        jLabel22.setText("Gender");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        jLabel23.setText("Patient-ID");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        jLabel24.setText("Prescription");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 90, -1, -1));

        jLabel25.setText("Medical Aid?");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 80, 20));

        jLabel26.setText("Spec Code");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, 20));

        ViewPatientsTab.setViewportView(jPanel4);

        tbPaneDoc.addTab("View Patients", ViewPatientsTab);

        ViewAppointmentsTab.setBackground(new java.awt.Color(126, 145, 158));
        ViewAppointmentsTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstAppoint.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lstAppoint.setModel(dlstAppoint);
        jScrollPane2.setViewportView(lstAppoint);

        ViewAppointmentsTab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 1190, 400));

        lblTitle2.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("View Your Appointments:");
        ViewAppointmentsTab.add(lblTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 390, 80));

        jLabel11.setText("Get all the appointments by Specialty:");
        ViewAppointmentsTab.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 220, -1));

        cbSpecialtyApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "Biokinetics", "Cardiologist", "Gynaecologist", "General Practitioner", "Infectious Diseases Specialist", "Neurologist", "Oncologist", "Pharmacist", "Prosthetist", "Psychologist", "Radiologist" }));
        cbSpecialtyApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSpecialtyAppActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(cbSpecialtyApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 180, -1));

        jLabel18.setText("OR");
        ViewAppointmentsTab.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        jLabel13.setText("Get all the Appointments by Month:");
        ViewAppointmentsTab.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 200, -1));

        cbMonthApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbMonthApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthAppActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(cbMonthApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 180, -1));

        jToggleButton1.setText("REFRESH");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        ViewAppointmentsTab.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 80, 90, -1));

        jLabel41.setText("Patient-ID");
        ViewAppointmentsTab.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel42.setText("Staff-ID");
        ViewAppointmentsTab.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabel43.setText("Date");
        ViewAppointmentsTab.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jLabel44.setText("Time");
        ViewAppointmentsTab.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        jLabel45.setText("Patient Admitted?");
        ViewAppointmentsTab.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, -1, -1));

        jLabel40.setText("Symptoms");
        ViewAppointmentsTab.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, 20));

        tbPaneDoc.addTab("View Appointments", ViewAppointmentsTab);

        ViewPatientsHistoryTab.setBackground(new java.awt.Color(102, 116, 141));
        ViewPatientsHistoryTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle3.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setText("View Patients History:");
        ViewPatientsHistoryTab.add(lblTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));
        ViewPatientsHistoryTab.add(tfPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 180, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Patient ID:");
        ViewPatientsHistoryTab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 90, 30));

        lstPHistory.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        lstPHistory.setModel(dlstPHistory);
        jScrollPane3.setViewportView(lstPHistory);

        ViewPatientsHistoryTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1160, 360));

        btnSeeHistory.setText("See History of Patient");
        btnSeeHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeHistoryActionPerformed(evt);
            }
        });
        ViewPatientsHistoryTab.add(btnSeeHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 160, 40));

        jLabel27.setText("Symptoms");
        ViewPatientsHistoryTab.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 70, -1));

        jLabel28.setText("Patient-ID");
        ViewPatientsHistoryTab.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel31.setText("Staff-ID");
        ViewPatientsHistoryTab.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel32.setText("Date");
        ViewPatientsHistoryTab.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel33.setText("Time");
        ViewPatientsHistoryTab.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        jLabel34.setText("Patient Admitted?");
        ViewPatientsHistoryTab.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        tbPaneDoc.addTab("View Patient History", ViewPatientsHistoryTab);

        AddStaffTab2.setBackground(new java.awt.Color(99, 158, 158));
        AddStaffTab2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPasswordPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab2.add(tfPasswordPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 170, 30));

        lblname11.setText("Staff ID Password: ");
        AddStaffTab2.add(lblname11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 120, 30));

        lblsname5.setText("Surname:");
        AddStaffTab2.add(lblsname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 90, -1));

        tfQualPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQualPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab2.add(tfQualPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 430, 70));

        lblJD6.setText("Specialty: ");
        AddStaffTab2.add(lblJD6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 90, 30));

        tfSnamePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSnamePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab2.add(tfSnamePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 230, 50));

        lbldIAGNOSIS5.setText("Qualifications:");
        AddStaffTab2.add(lbldIAGNOSIS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 90, 30));

        tfResidencePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResidencePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab2.add(tfResidencePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 430, 60));

        lblSymptoms5.setText("Residence:");
        AddStaffTab2.add(lblSymptoms5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 90, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/Doctor/medicalstafficon.jpg"))); // NOI18N
        AddStaffTab2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 260, 270));

        btnAddStaff2.setText("Update Your Information");
        btnAddStaff2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaff2ActionPerformed(evt);
            }
        });
        AddStaffTab2.add(btnAddStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 220, -1));

        btnLOGOUT3.setText("LOGOUT");
        btnLOGOUT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUT3ActionPerformed(evt);
            }
        });
        AddStaffTab2.add(btnLOGOUT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, -440, -1, -1));

        lblgender7.setText("Sex:");
        AddStaffTab2.add(lblgender7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 90, 30));

        lblJD7.setText("Job Description:");
        AddStaffTab2.add(lblJD7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, 90, 30));

        tfnamePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnamePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab2.add(tfnamePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 230, 50));

        jLabel17.setText("Personal Information");
        AddStaffTab2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 130, 30));

        lblname12.setText("Name:");
        AddStaffTab2.add(lblname12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 90, 30));

        lblname13.setText("Contact No:");
        AddStaffTab2.add(lblname13, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 90, 30));

        tfContactPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactPERSONALActionPerformed(evt);
            }
        });
        AddStaffTab2.add(tfContactPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 170, 30));

        lblTitle4.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle4.setText("Your Personal Info:");
        AddStaffTab2.add(lblTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 310, 80));
        AddStaffTab2.add(tfSexPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 70, 40));
        AddStaffTab2.add(tfSpecPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 160, 40));
        AddStaffTab2.add(tfJobDescPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 270, 40));

        tbPaneDoc.addTab("Personal Information", AddStaffTab2);

        getContentPane().add(tbPaneDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1260, 640));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediseek/pat/MS Main1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 770));

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

    private void tfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameActionPerformed

    private void tfDiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDiagnosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDiagnosisActionPerformed

    private void tfSnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnameActionPerformed

    private void tfPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrescriptionActionPerformed

    private void cbMedAidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedAidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMedAidActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
      LoginGUIoption LoginGUI = new LoginGUIoption();
        LoginGUI.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSeeHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeHistoryActionPerformed

if(objValidation.isNotEmpty(tfPID.getText())==true){getPatientHistory(tfPID.getText());}
else{JOptionPane.showMessageDialog(null, " PLEASE INPUT A PATIENT ID");}



 
    }//GEN-LAST:event_btnSeeHistoryActionPerformed

    private void btnSeeInPatientPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeInPatientPanelActionPerformed
        //edits a new record in the table and refreshes the display of the list
        if (lstPatients.getSelectedIndex()>-1) //checks to see if a record from the list element has been selected
        {   tbPaneDoc.setSelectedIndex(0); //selects the tab that all the tetfields are in
            //input the data that has been taken from the database into each corresponding textfield
            tfPateintsID.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getPatientID());
            tfname.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getName());
            tfSname.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getSurname());
            tfSex.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getGender());
            tfSpecCode.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getSpecialtyCode());
            cbMedAid.setSelected(patientDirectory[lstPatients.getSelectedIndex()].isMedicalAid());
            tfDiagnosis.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getDiagnosis());
            tfPrescription.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getPrescription());

        }else JOptionPane.showMessageDialog(null, " SELECT A PATIENT TO VIEW");

    }//GEN-LAST:event_btnSeeInPatientPanelActionPerformed

    private void tfPateintsIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPateintsIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPateintsIDActionPerformed

    private void tfSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSexActionPerformed

    private void tfSpecCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecCodeActionPerformed

    private void btnShowPatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPatient1ActionPerformed
if(objValidation.isNotEmpty(tfPateintsID.getText())==true){searchPatient(tfPateintsID.getText());}
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

    private void btnLOGOUT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUT3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLOGOUT3ActionPerformed

    private void tfnamePERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnamePERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnamePERSONALActionPerformed

    private void tfContactPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactPERSONALActionPerformed

    private void btnAddStaff2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaff2ActionPerformed
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
                        
        
        } else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE/CONTACT/JOB DESCRIPTION Fields \n Try Again!");}            

            
  }  else{JOptionPane.showMessageDialog(null, "UNABLE TO EDIT YOUR DETAILS\nPlease ensure that every field has been filled in then retry your entry.");}

        
    }//GEN-LAST:event_btnAddStaff2ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        dlstPatients.clear();
        getPatients();
        
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbPatientOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPatientOrderActionPerformed
 //getPatientsSorted(String x)   
// No Order
//Alphabetical Order (First Name)
//Alphabetical Order (Surname Name)
//Gender       
        switch(cbPatientOrder.getSelectedIndex()){
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
   if (objValidation.isNotEmpty(tfname.getText()) && objValidation.isNotEmpty(tfSname.getText()) && objValidation.isNotEmpty(tfSex.getText()) && objValidation.isNotEmpty(tfSpecCode.getText())
       &&  objValidation.isNotEmpty(tfDiagnosis.getText()) &&  objValidation.isNotEmpty(tfPrescription.getText()) &&  objValidation.isNotEmpty(tfPateintsID.getText())) {
       
     
        String MedAidConverstion = "";
            if (lstPatients.getSelectedIndex() == -1) {
                    if(objValidation.allCharacters(tfname.getText()) && objValidation.allCharacters(tfSname.getText()) && objValidation.allCharacters(tfSex.getText()) && objValidation.allCharacters(tfSpecCode.getText())){

                                     MedAidConverstion = "";
                                            if (cbMedAid.isSelected() == true) {
                                            MedAidConverstion = "yes";
                                        } else {
                                            MedAidConverstion = "no";
                                        }
                                    System.out.println("UPDATE tblPatients SET  tblPatients.pName = '" + tfname.getText()
                                            + "', tblPatients.pSurname = '" + tfSname.getText()
                                            + "', tblPatients.Gender = '" + tfSex.getText()
                                            + "', tblPatients.SpecialtyCode = '" + tfSpecCode.getText()                        
                                            + "', tblPatients.MedicalAid = " + MedAidConverstion
                                            + ", tblPatients.Symptoms = '" + tfDiagnosis.getText()
                                            + "', tblPatients.Prescription = '" + tfPrescription.getText()
                                            + "' WHERE Patient_ID = '" + tfPateintsID.getText() + "';");

                                    objPatients.updateTable("UPDATE tblPatients SET  tblPatients.pName = '" + tfname.getText()
                                            + "', tblPatients.pSurname = '" + tfSname.getText()
                                            + "', tblPatients.Gender = '" + tfSex.getText()                       
                                            + "', tblPatients.SpecialtyCode = '" + tfSpecCode.getText()                        
                                            + "', tblPatients.MedicalAid = " + MedAidConverstion
                                            + ", tblPatients.Symptoms = '" + tfDiagnosis.getText()
                                            + "', tblPatients.Prescription = '" + tfPrescription.getText()
                                            + "' WHERE Patient_ID = '" + tfPateintsID.getText() + "';");
                   }else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE Fields \n Try Again!");}                                      
            } 
            
            
   } else{JOptionPane.showMessageDialog(null, "ALL FIELDS ARE TO BE FILLED. Review your entry and Try Again!");}

        tbPaneDoc.setSelectedIndex(0);
        dlstPatients.clear();
        getPatients();
    
    }//GEN-LAST:event_jButton2ActionPerformed

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
dlstAppoint.clear();
        getAppointments();

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        obj.openWord("MediSeek Who are we.docx");

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        obj.openWord("MediSeek Help.docx");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void SearchDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchDetailsActionPerformed
      if(objValidation.isNotEmpty(tfDiagnosis.getText())){
      obj.OpenSite(tfDiagnosis.getText());
      }else {JOptionPane.showMessageDialog(null, "Please ensure you have selected a patient record to view. \nOnce this field is filled then you can attempt a search");}
        
        
    }//GEN-LAST:event_SearchDetailsActionPerformed

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
    private javax.swing.JPanel AddStaffTab2;
    private javax.swing.JPanel PatientInfoPanel;
    private javax.swing.JButton SearchDetails;
    private javax.swing.JPanel ViewAppointmentsTab;
    private javax.swing.JPanel ViewPatientsHistoryTab;
    private javax.swing.JScrollPane ViewPatientsTab;
    private javax.swing.JButton btnAddStaff2;
    private javax.swing.JButton btnLOGOUT3;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSeeHistory;
    private javax.swing.JButton btnSeeInPatientPanel;
    private javax.swing.JButton btnShowPatient1;
    private javax.swing.JCheckBox cbMedAid;
    private javax.swing.JComboBox<String> cbMonthApp;
    private javax.swing.JComboBox<String> cbPatientOrder;
    private javax.swing.JComboBox<String> cbSpecialtyApp;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblJD6;
    private javax.swing.JLabel lblJD7;
    private javax.swing.JLabel lblSymptoms;
    private javax.swing.JLabel lblSymptoms5;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lbldIAGNOSIS;
    private javax.swing.JLabel lbldIAGNOSIS5;
    private javax.swing.JLabel lblgender1;
    private javax.swing.JLabel lblgender2;
    private javax.swing.JLabel lblgender7;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname11;
    private javax.swing.JLabel lblname12;
    private javax.swing.JLabel lblname13;
    private javax.swing.JLabel lblsname;
    private javax.swing.JLabel lblsname5;
    private javax.swing.JList<String> lstAppoint;
    private javax.swing.JList<String> lstPHistory;
    private javax.swing.JList<String> lstPatients;
    private javax.swing.JTabbedPane tbPaneDoc;
    private javax.swing.JTextField tfContactPERSONAL;
    private javax.swing.JTextField tfDiagnosis;
    private javax.swing.JTextField tfJobDescPERSONAL;
    private javax.swing.JTextField tfPID;
    private javax.swing.JTextField tfPasswordPERSONAL;
    private javax.swing.JTextField tfPateintsID;
    private javax.swing.JTextField tfPrescription;
    private javax.swing.JTextField tfQualPERSONAL;
    private javax.swing.JTextField tfResidencePERSONAL;
    private javax.swing.JTextField tfSex;
    private javax.swing.JTextField tfSexPERSONAL;
    private javax.swing.JTextField tfSname;
    private javax.swing.JTextField tfSnamePERSONAL;
    private javax.swing.JTextField tfSpecCode;
    private javax.swing.JTextField tfSpecPERSONAL;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfnamePERSONAL;
    // End of variables declaration//GEN-END:variables
}
