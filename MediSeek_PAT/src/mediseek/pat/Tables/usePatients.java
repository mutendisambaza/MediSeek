/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mediseek.pat.ForConnecting;

/**
 *
 * @author tendi
 */
public class usePatients {
    
    
  private  Patients[] patients = new Patients[500];
  private  int size;
  ForConnecting obj = new ForConnecting();
    
    
    
    public Patients[] fromtblPatients(String SQL) {
       
        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery("Select * from tblPatients");
     String name;
     String surname;
     String gender;
     String patientID;  
     boolean medicalAid;
     String diagnosis;
     String specialtyCode;
     String prescription;

 //    public Patients(String name, String surname, String gender, String patientID, boolean medicalAid, String specialtyCode, String diagnosis, String prescription) {
   
while (rs.next()) {
                
                name = rs.getString("pName");
                surname = rs.getString("pSurname");
                gender = rs.getString("Gender");
                patientID = rs.getString("Patient_ID");
                medicalAid = rs.getBoolean("MedicalAid");
                specialtyCode = rs.getString("SpecialtyCode");
                diagnosis = rs.getString("Diagnosis");
                prescription = rs.getString("Prescription");
                                
              


                patients[size] = new Patients(name, surname, gender, patientID, medicalAid, specialtyCode, diagnosis, prescription);
                System.out.println(patients[size].toString());
                System.out.println(size);
                    size++;
            }
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }return patients;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////

    public int getSize() {
        return size;
    }
////////////////////////////////////////////////////////////////////////////////////////
    public void updateTable(String update){
       
        try {
            System.out.println(update);
            Statement stmt = ForConnecting.conn.createStatement();
            stmt.executeUpdate(update);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }   
    
    
    
    
    
    
    
}
