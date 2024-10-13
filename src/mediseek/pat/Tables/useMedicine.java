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
public class useMedicine {
    /**
    *Instantiation
    **/
  private  Medicine[] med = new Medicine[100];
  private  int size;
  ForConnecting obj = new ForConnecting();
    
    
/////////////////////////////////////////////////////////////////////////////// 
   /**
     * Takes the String input of SQL
     * It collects the result set of record elements based on the list SQL Entry
     * Assigns values to the variables looped as long as there is another record in the result set From Medicine
     * instantiation of of array
     * returns an error message if there is a failure
     * 
     * Basically collects the data from a specific table and formats it into an array 
     */
    public Medicine[] fromtblMedicine(String SQL) {

        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery(SQL);
            String medicine;
            String usageDescription;
            int cost;

            while (rs.next()) {
                medicine = rs.getString("Medicine");
                usageDescription = rs.getString("UsageDescription");
                cost = rs.getInt("Cost");
                
                med[size] = new Medicine(medicine, usageDescription, cost);
                System.out.println(med[size].toString());
                System.out.println(size);
                size++;
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(mediseek.pat.Tables.useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return med;
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
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }  
    
    
    
    
    
    
    
}
