package mediseek.pat.CriticalClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
       
       String accessFileName = workingDir+"\\\\Mutendi_Sambaza_MediSeek_PAT";
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


   public void updateTable(String update){
       
      
      try {
          System.out.println(update);
          Statement stmt = ForConnecting.conn.createStatement();
          stmt.executeUpdate(update);
          stmt.close();
      } catch (SQLException ex) {
          Logger.getLogger(ForConnecting.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        

    }   
  
  
}