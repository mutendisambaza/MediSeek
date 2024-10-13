/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.CriticalClasses;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tendi
 */
public class Methods {
    
/*
    Takes the search entry name as parameters
    creates an object for the desktop
    takes the search entry and converts it into the necessary format to be read by a browser
    excecutes the search for viewing
    */    
     
    public void OpenSite(String site)  {
        try {
            Desktop desktop = Desktop.getDesktop();
            String x = (site.trim());
            try {
                            desktop.browse(new URI("http://google.com/search?q=" + x.replace(" ", "+")));

            } catch (IOException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

/*
    Takes the document name as parameters
    creates an object for the desktop
    opens any document that resides on the desktop with the document name
    
    returns an error if not found
    */
    
    
public void openWord(String docName) {

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(docName));
        } catch (IOException ex) {
  JOptionPane.showMessageDialog(null, "Document not  found within your computer files");

            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

/*
Takes all the necessary parameters entered in the GUI
Proof checks to see if any items are full so that their corresponding values are set to nothing
Writes to a file that composes of the format for a MediSeek reciept, inputing the values where
there are meant to be

also returns an error if file is not found
*/

public void writeToReciept(String name, String surname,
        String item1, String item2, String item3, String item4,
        int quan1, int quan2, int quan3, int quan4, 
        int cost1, int cost2, int cost3, int cost4,int  total, 
        String instr1, String instr2, String instr3, String instr4){
    
    
    if(item1==null){ quan1 = 0; cost1 = 0; instr1 = "";}
    if(item2==null){ quan2 = 0; cost2 = 0; instr2 = "";}
    if(item3==null){ quan3 = 0; cost3 = 0; instr3 = "";}
    if(item4==null){ quan4 = 0; cost4 = 0; instr4 = "";}
     
PrintWriter writer = null;
        try {
            
            writer = new PrintWriter(new FileOutputStream(new File("RECIEPT.txt"),true));
            writer.println("***********************************MEDISEEK***********************************");
            writer.println("***********************************Pharmacy***********************************");
writer.println("");
writer.println("");
            writer.println("DATE: "+LocalDate.now());
            writer.println("FIRST NAME: "+name);
            writer.println("LAST  NAME: "+surname);
            writer.println("");
            writer.println("");
            writer.println("______________________________________________________________________________");
            writer.println("ITEMS:                         QUANTITY                      COST:");
            writer.println("------------------------------------------------------------------------------");
            writer.println("    =  "+item1);
            writer.println("                                 x"+quan1+"                        R"+cost1);
            writer.println("    =  "+item2);
            writer.println("                                 x"+quan2+"                        R"+cost2);
            writer.println("    =  "+item3);
            writer.println("                                 x"+quan3+"                        R"+cost3);
            writer.println("    =  "+item4);
            writer.println("                                 x"+quan4+"                        R"+cost4);
            writer.println("==============================================================================");
            writer.println("                   TAX = 0.00% ");
            writer.println("                                                 TOTAL:  R"+total);
            writer.println("                                                CHARGE:  R"+total);
            writer.println("______________________________________________________________________________");
            writer.println("==============================================================================");
            writer.println("USAGE INSTRUCTIONS:");
            writer.println("Please ensure that you follow these instructions correctly. Do not hesitate to");
            writer.println("call you doctor if you experience any issues.");
            writer.println("==============================================================================");
            writer.println(item1+ "     --------- "+instr1);
            writer.println("");
            writer.println(item2+ "     --------- "+instr2);
            writer.println("");
            writer.println(item3+ "     --------- "+instr3);
            writer.println("");
            writer.println(item4+ "     --------- "+instr4);
            writer.println("");
            writer.println("______________________________________________________________________________");
            writer.println("0034772778696422121                                                      0414 ");
            writer.println("******************************************************************************");
            writer.println("************************THANK YOU FOR CHOOSING MEDISEEK***********************");
            writer.println("******************************************************************************");
            
            
            writer.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File for the receipt has not been found within your documents");
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    
    
    
    

}















}
