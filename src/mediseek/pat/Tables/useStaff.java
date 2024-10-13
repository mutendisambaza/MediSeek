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
public class useStaff {
   /**
    *Instantiation
    **/ 
  private  Staff[] staffMember = new Staff[500];
  private  int size;
  ForConnecting obj = new ForConnecting();
  
 /////////////////////////////////////////////////////////////////////////////// 
  /**
     * Takes the String input of SQL
     * It collects the result set of record elements based on the list SQL Entry
     * Assigns values to the variables looped as long as there is another record in the result set From Staff
     * instantiation of of array
     * returns an error message if there is a failure
     * 
     * Basically collects the data from a specific table and formats it into an array 
     */
    public Staff[] fromtblStaff(String SQL) {
       
        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery(SQL);
     String sName;
     String sSurname;
     String gender;
     String jobDescription;
     String specialty;
     String residence;
     String qualifications;
     String contact;
     String staff_ID;
     String password;
    
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
                password = rs.getString("Password");
                        

                staffMember[size] = new Staff(sName, sSurname, gender, jobDescription, specialty, residence, qualifications, contact, staff_ID, password);
                System.out.println(staffMember[size].toString());
                System.out.println(size);
                    size++;
            }
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }return staffMember;
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
            Logger.getLogger(useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
