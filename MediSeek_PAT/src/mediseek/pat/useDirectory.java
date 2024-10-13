/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tendi
 */
public class useDirectory {
    
      // private Statement stmt = null;

  private  directory[] staffDirectory = new directory[500];
  private  int size;
  ForConnecting obj = new ForConnecting();
  
  /////////////////////////////////////////////////////////////////////////////////
    public directory[] fromtblDirectory(String SQL) {
       
        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery("Select * from tblDirectory");
     String sName;
     String sSurname;
     String gender;
     String jobDescription;
     String specialty;
     String residence;
     String qualifications;
     String contact;
     String staff_ID;
     
    
while (rs.next()) {
                sName = rs.getString("sName");
                sSurname = rs.getString("sSurname");
                gender = rs.getString("Gender");
                jobDescription = rs.getString("Job Description");
                specialty = rs.getString("Specialty");
                residence = rs.getString("Residence");
                qualifications = rs.getString("Qualifications");
                contact = rs.getString("Contact");
                staff_ID = rs.getString("Staff_ID");
                
                        
       
               
//                System.out.println(id+" "+name);
                staffDirectory[size] = new directory(sName, sSurname, gender, jobDescription, specialty, residence, qualifications, contact, staff_ID);
                System.out.println(staffDirectory[size].toString());
                System.out.println(size);
                    size++;
            }
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }return staffDirectory;
    }
    
    
    
 /////////////////////////////////////////////////////////////////////////////////////
    
     public int getSize() {
        return size;
    }
     
    
 ////////////////////////////////////////////////////////////////////////////////////   
    
     public void updateTable(String update)  {
       
        try {
            System.out.println(update);
            Statement stmt = ForConnecting.conn.createStatement();
            stmt.executeUpdate(update);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
 
/////////////////////////////////////////////////////////////////////////////////////     
     
     
     
     
     
     
}




