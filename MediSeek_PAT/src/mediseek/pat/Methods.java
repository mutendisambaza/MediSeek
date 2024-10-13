/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tendi
 */
public class Methods {
    public void OpenSite(String site)  {
        try {
            Desktop desktop = Desktop.getDesktop();
            String x = (site.trim());
            try {
                desktop.browse(new URI("http://" + x.replace(" ", "+")));
            } catch (IOException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    



public void openWord(String docName) {

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(docName));
        } catch (IOException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }




















}
