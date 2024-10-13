/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Tables;

/**
 *
 * @author tendi
 */
public class Specialty {
   /**
    *Instantiation
    **/  
    private String specialty;
    private String specialtyCode;

     /**
     * A method that instantiates the objects and assigns the values to the fields. Receives  values as parameters
     **/
    public Specialty(String specialty, String specialtyCode) {
        this.specialty = specialty;
        this.specialtyCode = specialtyCode;
    }
/**
     * Get data from the field specialty from the table tblSpecialty
     */
    public String getSpecialty() {
        return specialty;
    }
/**
     * Get data from the field specialtyCode from the table tblSpecialty
     */
    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }
    
    
    
    
     /**
     * Method that assists the toString to evenly space out the records within the display
     */
    
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }
/**
     * Method builds the String that contains all of the fields for display purposes
     */
    @Override
    public String toString() {
         String tmp = addSpace(33, specialty)+addSpace(35,specialtyCode);
         return tmp;
    }
    
    
    
    
    
}
