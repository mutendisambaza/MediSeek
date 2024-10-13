/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Pharmacist;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mediseek.pat.START.LoginGUIoption;
import mediseek.pat.Tables.Medicine;
import mediseek.pat.Tables.Patients;
import mediseek.pat.Tables.useMedicine;
import mediseek.pat.Tables.usePatients;
import mediseek.pat.CriticalClasses.DataValidation;
import mediseek.pat.CriticalClasses.Methods;
import mediseek.pat.Tables.Staff;
import mediseek.pat.Tables.Appointments;
import mediseek.pat.Tables.useAppointments;
import mediseek.pat.Tables.useStaff;

/**
 *
 * @author tendi
 */
public class PharmacistPage extends javax.swing.JFrame {
 Staff[] staffDirectory = new Staff[500]; 
 useStaff objStaff = new useStaff();
 Staff[] user = new Staff[1];   
    
DefaultListModel dlstMeds = new DefaultListModel();
Medicine[] medDirectory = new Medicine[100]; 
useMedicine objMeds = new useMedicine();

DefaultListModel dlstPatients = new DefaultListModel();
   
Patients[] patientDirectory = new Patients[100]; 
usePatients objPatients = new usePatients();
Patients[] patientDirectorySearch = new Patients[10]; 

DefaultListModel dlstPHistory = new DefaultListModel();
Appointments[] appDirectoryHistory = new Appointments[100]; 
useAppointments objApp = new useAppointments();

//OTHER OBJECTS
DataValidation objValidation = new DataValidation();
PharmacistGUIlogin loginObj = new PharmacistGUIlogin();
Methods obj = new Methods();
private String usertemp;
    /**
     * Constructor method that displays the arrays in their respective lists
     * Takes the userID entered in the login and and saves it in a global variable
     * Also places all the information of the  user in their necessary fields on the personal information
     */
 public PharmacistPage(String userID) {
         initComponents();
         getPatients();
         getMeds();
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
    public PharmacistPage() {
        initComponents();
        getPatients();
        getMeds();
        
    }  
 
 ////////////////////////////////////////////////////////////////////////////// 
  /**
     * Method fills an array with the elements based on the SQL Statement
     * Displays the elements in an list
     * This will be the records of the medicines in available
     */    
    public void getMeds() {
        medDirectory = objMeds.fromtblMedicine("SELECT * FROM tblMedicine;");
        for (int i = 0; i < objMeds.getSize(); i++) {
            dlstMeds.addElement(medDirectory[i].toString());
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
    public void searchPatient(String ID) {
           dlstPatients.clear();
        patientDirectorySearch = objPatients.fromtblPatients("SELECT * FROM tblPatients where Patient_ID = \""+ID+"\";");
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
 ////////////////////////////////////////////////////////////////////////////// 
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
///////////////////////////////////////////////////////////////////////////// 
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogout = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        tbPane = new javax.swing.JTabbedPane();
        ViewPatientsTab = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        PatientInfoPanel = new javax.swing.JPanel();
        tfname = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        lblsname = new javax.swing.JLabel();
        tfSymptom = new javax.swing.JTextField();
        lblgender1 = new javax.swing.JLabel();
        tfSname = new javax.swing.JTextField();
        lbldIAGNOSIS = new javax.swing.JLabel();
        tfPrescription = new javax.swing.JTextField();
        lblSymptoms = new javax.swing.JLabel();
        cbMedAid = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        lblgender2 = new javax.swing.JLabel();
        btnAddPatientPage = new javax.swing.JButton();
        tfSex = new javax.swing.JTextField();
        tfSpecCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPatients = new javax.swing.JList<>();
        cbPatientOrder = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfPatientID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnShowPatient1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSeeInPatientPanel = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstMeds = new javax.swing.JList<>();
        ViewPatientsHistoryTab = new javax.swing.JPanel();
        lblTitle3 = new javax.swing.JLabel();
        tfPID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPatientHistory = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
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
        tfJobDescPERSONAL = new javax.swing.JTextField();
        tfSpecPERSONAL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        lblTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("Pharmacist");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 320, 80));

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

        tfSymptom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSymptomActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(tfSymptom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 430, 110));

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

        lblgender2.setText("Sex:");
        PatientInfoPanel.add(lblgender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 90, 30));

        btnAddPatientPage.setText("Issue Prescription");
        btnAddPatientPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientPageActionPerformed(evt);
            }
        });
        PatientInfoPanel.add(btnAddPatientPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 150, 50));

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

        jPanel4.add(PatientInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 1070, 580));

        lstPatients.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lstPatients.setModel(dlstPatients);
        jScrollPane1.setViewportView(lstPatients);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 900, -1));

        cbPatientOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Order", "Alphabetical Order (First Name)", "Alphabetical Order (First Name)", "Gender" }));
        cbPatientOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPatientOrderActionPerformed(evt);
            }
        });
        jPanel4.add(cbPatientOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 300, 220, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Place patients in order of:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 220, 30));
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

        btnShowPatient1.setText("Search Patient");
        btnShowPatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPatient1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnShowPatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, -1));

        jLabel16.setText("Name");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jLabel17.setText("Surname");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        btnRefresh.setText("Resfresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 80, 20));

        jLabel6.setText("Once a Record has been selected Click below:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        btnSeeInPatientPanel.setText("See Patient Info");
        btnSeeInPatientPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeInPatientPanelActionPerformed(evt);
            }
        });
        jPanel4.add(btnSeeInPatientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jLabel22.setText("Gender");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 56, -1, 50));

        jLabel23.setText("Patient-ID");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 56, -1, 50));

        jLabel25.setText("Medical Aid?");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 80, 60));

        jLabel26.setText("Spec Code");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, 60));

        jLabel20.setText("Symptoms");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 56, -1, 50));

        jLabel24.setText("Prescription");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 56, -1, 50));

        ViewPatientsTab.setViewportView(jPanel4);

        tbPane.addTab("View Patients", ViewPatientsTab);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle7.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        lblTitle7.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle7.setText("View Medicine Dispensary:");
        jPanel1.add(lblTitle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 410, 80));

        lstMeds.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        lstMeds.setModel(dlstMeds);
        jScrollPane4.setViewportView(lstMeds);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 880, 460));

        tbPane.addTab("View Medicine Dispensary", jPanel1);

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

        lstPatientHistory.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
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

        jLabel27.setText("Symptoms");
        ViewPatientsHistoryTab.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 70, -1));

        tbPane.addTab("View Patient History", ViewPatientsHistoryTab);

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
        AddStaffTab1.add(lblgender6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 90, 30));

        lblJD5.setText("Job Description:");
        AddStaffTab1.add(lblJD5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 90, 30));

        tfnamePERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnamePERSONALActionPerformed(evt);
            }
        });
        AddStaffTab1.add(tfnamePERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 230, 50));

        jLabel15.setText("Personal Information");
        AddStaffTab1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 130, 30));

        lblname9.setText("Name:");
        AddStaffTab1.add(lblname9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 90, 30));

        lblname10.setText("Contact No:");
        AddStaffTab1.add(lblname10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 90, 30));

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
        AddStaffTab1.add(tfJobDescPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, 270, 40));
        AddStaffTab1.add(tfSpecPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 160, 40));

        tbPane.addTab("Personal Information", AddStaffTab1);

        getContentPane().add(tbPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1260, 640));

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

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginGUIoption LoginGUI = new LoginGUIoption();
        LoginGUI.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tfContactPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactPERSONALActionPerformed

    private void tfnamePERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnamePERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnamePERSONALActionPerformed

    private void btnLOGOUT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLOGOUT2ActionPerformed

    private void tfResidencePERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResidencePERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResidencePERSONALActionPerformed

    private void tfSnamePERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnamePERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnamePERSONALActionPerformed

    private void tfQualPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQualPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQualPERSONALActionPerformed

    private void tfPasswordPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordPERSONALActionPerformed

    private void btnShowPatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPatient1ActionPerformed
if(objValidation.isNotEmpty(tfPatientID.getText())==true){searchPatient(tfPatientID.getText());}
else{JOptionPane.showMessageDialog(null, " PLEASE INPUT A PATIENT ID");}
  
    }//GEN-LAST:event_btnShowPatient1ActionPerformed

    private void btnAddPatientPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientPageActionPerformed
     if(objValidation.isNotEmpty(tfPatientID.getText())==true && lstPatients.getSelectedIndex()>-1){   
        PrescriptionGUI LoginGUI = new PrescriptionGUI(tfPatientID.getText());
        LoginGUI.setVisible(true);
     } else{JOptionPane.showMessageDialog(null, "Please ensure that you have a Record selected AND have the information of the patient\ndisplayed");} 
    }//GEN-LAST:event_btnAddPatientPageActionPerformed

    private void tfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnameActionPerformed

    private void tfSymptomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSymptomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSymptomActionPerformed

    private void tfSnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSnameActionPerformed

    private void tfPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrescriptionActionPerformed

    private void cbMedAidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedAidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMedAidActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(objValidation.isNotEmpty(tfPID.getText())==true){getPatientHistory(tfPID.getText());}
else{JOptionPane.showMessageDialog(null, " PLEASE INPUT A PATIENT ID");}
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
tfPatientID.setText("");
        dlstPatients.clear();
        getPatients();

    }//GEN-LAST:event_btnRefreshActionPerformed

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
            cbMedAid.setSelected(patientDirectory[lstPatients.getSelectedIndex()].isMedicalAid());
            tfSymptom.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getDiagnosis());
            tfPrescription.setText(""+patientDirectory[lstPatients.getSelectedIndex()].getPrescription());

        }else {JOptionPane.showMessageDialog(null, " SELECT A PATIENT TO VIEW");  }

    }//GEN-LAST:event_btnSeeInPatientPanelActionPerformed

    private void tfSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSexActionPerformed

    private void tfSpecCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSpecCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSpecCodeActionPerformed

    private void btnAddStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaff1ActionPerformed

if (objValidation.isNotEmpty(tfnamePERSONAL.getText()) == true && objValidation.isNotEmpty(tfSnamePERSONAL.getText()) == true && objValidation.isNotEmpty(tfSexPERSONAL.getText()) == true
      && objValidation.isNotEmpty(tfJobDescPERSONAL.getText()) == true && objValidation.isNotEmpty(tfSpecPERSONAL.getText()) == true && objValidation.isNotEmpty(tfResidencePERSONAL.getText()) == true
      && objValidation.isNotEmpty(tfQualPERSONAL.getText()) == true && objValidation.isNotEmpty(tfContactPERSONAL.getText())== true && objValidation.isNotEmpty(tfPasswordPERSONAL.getText()) == true && objValidation.isNotEmpty(tfContactPERSONAL.getText())==true) {
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
                
           
             }else{JOptionPane.showMessageDialog(null, " You cannot enter any numbers into the NAME/SURNAME/GENDER/SPECIALTY CODE/CONTACT/JOB DESCRIPTION Fields \n Try Again!");}            

            
  }else{JOptionPane.showMessageDialog(null, "UNABLE TO EDIT YOUR DETAILS\nPlease ensure that every field has been filled in then retry your entry.");}

        
    }//GEN-LAST:event_btnAddStaff1ActionPerformed

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
            java.util.logging.Logger.getLogger(PharmacistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmacistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmacistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmacistPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmacistPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddStaffTab1;
    private javax.swing.JPanel PatientInfoPanel;
    private javax.swing.JPanel ViewPatientsHistoryTab;
    private javax.swing.JScrollPane ViewPatientsTab;
    private javax.swing.JButton btnAddPatientPage;
    private javax.swing.JButton btnAddStaff1;
    private javax.swing.JButton btnLOGOUT2;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSeeInPatientPanel;
    private javax.swing.JButton btnShowPatient1;
    private javax.swing.JCheckBox cbMedAid;
    private javax.swing.JComboBox<String> cbPatientOrder;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblJD4;
    private javax.swing.JLabel lblJD5;
    private javax.swing.JLabel lblSymptoms;
    private javax.swing.JLabel lblSymptoms4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle7;
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
    private javax.swing.JList<String> lstMeds;
    private javax.swing.JList<String> lstPatientHistory;
    private javax.swing.JList<String> lstPatients;
    private javax.swing.JTabbedPane tbPane;
    private javax.swing.JTextField tfContactPERSONAL;
    private javax.swing.JTextField tfJobDescPERSONAL;
    private javax.swing.JTextField tfPID;
    private javax.swing.JTextField tfPasswordPERSONAL;
    private javax.swing.JTextField tfPatientID;
    private javax.swing.JTextField tfPrescription;
    private javax.swing.JTextField tfQualPERSONAL;
    private javax.swing.JTextField tfResidencePERSONAL;
    private javax.swing.JTextField tfSex;
    private javax.swing.JTextField tfSexPERSONAL;
    private javax.swing.JTextField tfSname;
    private javax.swing.JTextField tfSnamePERSONAL;
    private javax.swing.JTextField tfSpecCode;
    private javax.swing.JTextField tfSpecPERSONAL;
    private javax.swing.JTextField tfSymptom;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfnamePERSONAL;
    // End of variables declaration//GEN-END:variables
}
