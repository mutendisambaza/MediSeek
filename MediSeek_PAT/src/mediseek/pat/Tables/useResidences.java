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
public class useResidences {
    
    
  private  Residences[] res = new Residences[500];
  private  int size;
  ForConnecting obj = new ForConnecting();
    
    
    /////////////////////////////////////////////////////////////////////////////// 
  
    public Residences[] fromtblResidences(String SQL) {
       
        try {
            Statement stmt = obj.conn.createStatement();
            size = 0;
            ResultSet rs = stmt.executeQuery("Select * from tblResidences");
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
            Logger.getLogger(mediseek.pat.useStaff.class.getName()).log(Level.SEVERE, null, ex);
        }return res;
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
