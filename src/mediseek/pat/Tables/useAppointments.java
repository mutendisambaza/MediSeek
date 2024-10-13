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
import mediseek.pat.CriticalClasses.ForConnecting;

/**
 *
 * @author tendi
 */
public class useAppointments {
     /**
    *Instantiation
    **/
  private  Appointments[] ap = new Appointments[200];
  private  int size;
  ForConnecting obj = new ForConnecting();
    
    
/////////////////////////////////////////////////////////////////////////////// 
  
  /**
     * Takes the String input of SQL
     * It collects the result set of record elements based on the list SQL Entry
     * Assigns values to the variables looped as long as there is another record in the result set From Directory
     * instantiation of of array
     * returns an error message if there is a failure
     * 
     * Basically collects the data from a specific table and formats it into an array 
    */
    public Appointments[] fromtblAppointments(String SQL) {

        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery(SQL);
           
            String patientNo;
            String staffID;
            String appDate;
            String appTime;
            boolean admission;
            String symptoms;
           

            while (rs.next()) {
            patientNo = rs.getString("PatientNo");
            staffID = rs.getString("Staff_ID");
            
 //               System.out.println(patientNo+" "+staffID);
            appDate = rs.getString("appDate");
 //               System.out.println(appDate);
            appTime = rs.getString("appTime");
//                System.out.println(appTime);
            admission = rs.getBoolean("Admission");
            symptoms = rs.getString("Symptoms");
             

            
                
                ap[size] = new Appointments(patientNo, staffID, appDate, appTime, admission, symptoms);
                System.out.println(ap[size].toString());
                System.out.println(size);
                size++;
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(mediseek.pat.Tables.useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ap;
    }

    //////////////////////////////////////////////////////////////////////////////
/**
    *Method to get the integer value of the size
    **/
    public int getSize() {
        return size;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    
    /**
    *Gets the String SQL input as a parameter and updates the usePatients table based on the entered SQL
    **/
    
    public void updateTable(String update){
       
        try {
            System.out.println(update);
            Statement stmt = ForConnecting.conn.createStatement();
            stmt.executeUpdate(update);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(useAppointments.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
