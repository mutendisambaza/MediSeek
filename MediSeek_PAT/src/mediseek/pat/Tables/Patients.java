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
    
    private String name;
    private String surname;
    private String gender;
    private String patientID;
    private boolean medicalAid;
    private String specialtyCode;
    private String diagnosis;
    private String prescription;

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

    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getPatientID() {
        return patientID;
    }

    public boolean isMedicalAid() {
        return medicalAid;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    
    public String getDiagnosis() {
        return diagnosis;
    }

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
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }
     
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        String tmp = "";
        tmp = addSpace(15, name)+addSpace(15,surname)+addSpace(5,gender)+addSpace(10,patientID)+addSpace(10,medicalAid+"")+addSpace(10,specialtyCode)+addSpace(30,diagnosis)+addSpace(20,prescription);
        return tmp;
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
