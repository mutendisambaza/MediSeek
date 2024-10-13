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
public class useMedicine {
    
  private  Medicine[] med = new Medicine[100];
  private  int size;
  ForConnecting obj = new ForConnecting();
    
    
/////////////////////////////////////////////////////////////////////////////// 
  
    public Medicine[] fromtblMedicine(String SQL) {
       
        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery("Select * from tblMedicine");
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
            Logger.getLogger(mediseek.pat.useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }return med;
    }
    
    //////////////////////////////////////////////////////////////////////////////

    public int getSize() {
        return size;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
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
