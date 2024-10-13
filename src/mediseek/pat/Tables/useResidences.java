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
public class useResidences {
    /**
    *Instantiation
    **/
  private  Residences[] res = new Residences[500];
  private  int size;
  ForConnecting obj = new ForConnecting();
    
    
    /////////////////////////////////////////////////////////////////////////////// 
  /**
     * Takes the String input of SQL
     * It collects the result set of record elements based on the list SQL Entry
     * Assigns values to the variables looped as long as there is another record in the result set From Residence
     * instantiation of of array
     * returns an error message if there is a failure
     * 
     * Basically collects the data from a specific table and formats it into an array 
     */
    public Residences[] fromtblResidences(String SQL) {
       
        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery(SQL);
     String residences;
     int capacity;
     String province;
     String contact;
     boolean covidTestStation;
     String address;
    
while (rs.next()) {
                residences = rs.getString("Residence");
                capacity = rs.getInt("Capacity");
                province = rs.getString("Province");
                contact = rs.getString("Contact");
                covidTestStation = rs.getBoolean("COVID-19 Testing Station");
                address = rs.getString("Address");
                
       
                
                res[size] = new Residences(residences, capacity, province, contact,covidTestStation, address);
                System.out.println(res[size].toString());
                System.out.println(size);
                    size++;
            }
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(mediseek.pat.Tables.useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }return res;
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
            Logger.getLogger(Residences.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
