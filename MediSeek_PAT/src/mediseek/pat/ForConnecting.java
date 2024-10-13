package mediseek.pat;



import mediseek.pat.Tables.directory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSambaza
 */

public class ForConnecting {
  static public Connection conn;
  
  public ForConnecting() 
   {  try {
       // to find the path
       
       String workingDir = System.getProperty("user.dir");
       
       String accessFileName=workingDir+"\\\\Mutendi_Sambaza_MediSeek_PAT";
       System.out.println("Current working directory : " + accessFileName);
       
       
       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       
       conn = DriverManager.getConnection("jdbc:ucanaccess://"+accessFileName+".accdb");
       System.out.println("connected");
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(ForConnecting.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(ForConnecting.class.getName()).log(Level.SEVERE, null, ex);
      }
      
}

    directory[] fromtblStaff(String select__from_tblDirectory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}