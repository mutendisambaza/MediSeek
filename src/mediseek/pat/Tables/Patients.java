/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Tables;

import java.util.logging.Logger;

/**
 *
 * @author tendi
 */
public class Patients {
    /**
    *Instantiation
    **/  
    private String name;
    private String surname;
    private String gender;
    private String patientID;
    private boolean medicalAid;
    private String specialtyCode;
    private String diagnosis;
    private String prescription;
 /**
     * A method that instantiates the objects and assigns the values to the fields. Receives  values as parameters
     **/
    public Patients(String name, String surname, String gender, String patientID, boolean medicalAid, String specialtyCode, String diagnosis, String prescription) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.patientID = patientID;
        this.medicalAid = medicalAid;
        this.specialtyCode = specialtyCode;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

   /**
     * Get data from the field name from the table tblPatients
     */ 
    public String getName() {
        return name;
    }
 /**
     * Get data from the field surname from the table tblPatients
     */ 
    public String getSurname() {
        return surname;
    }
 /**
     * Get data from the field gender from the table tblPatients
     */ 
    public String getGender() {
        return gender;
    }
 /**
     * Get data from the field patientID from the table tblPatients
     */ 
    public String getPatientID() {
        return patientID;
    }
 /**
     * Get data from the field medicalAid from the table tblPatients
     */ 
    public boolean isMedicalAid() {
        return medicalAid;
    }
 /**
     * Get data from the field specialtyCode from the table tblPatients
     */ 
    public String getSpecialtyCode() {
        return specialtyCode;
    }

     /**
     * Get data from the field diagnosis from the table tblPatients
     */ 
    public String getDiagnosis() {
        return diagnosis;
    }
 /**
     * Get data from the field prescription from the table tblPatients
     */ 
    public String getPrescription() {
        return prescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setMedicalAid(boolean medicalAid) {
        this.medicalAid = medicalAid;
    }
  
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

 
    
  //////////////////////////////////////////////////////////////////////////////////
    /**
     * Method that assists the toString to evenly space out the records within the display
     */
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }
     
//////////////////////////////////////////////////////////////////////////////////
/**
     * Method builds the String that contains all of the fields for display purposes
     */
    @Override
    public String toString() {
        String tmp = "";
        tmp = addSpace(15, name)+addSpace(15,surname)+addSpace(5,gender)+addSpace(10,patientID)+addSpace(10,medicalAid+"")+addSpace(10,specialtyCode)+addSpace(30,diagnosis)+addSpace(20,prescription);
        return tmp;
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
