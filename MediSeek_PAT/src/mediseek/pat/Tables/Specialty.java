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
    private String specialty;
    private String specialtyCode;

    public Specialty(String specialty, String specialtyCode) {
        this.specialty = specialty;
        this.specialtyCode = specialtyCode;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }
    
    
    
    
    
    
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }

    @Override
    public String toString() {
         String tmp = addSpace(33, specialty)+addSpace(35,specialtyCode);
         return tmp;
    }
    
    
    
    
    
}
