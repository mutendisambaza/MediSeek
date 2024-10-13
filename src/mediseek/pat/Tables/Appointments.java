/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat.Tables;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tendi
 */
public class Appointments {
  /**
    *Instantiation
    **/  
    private String patientNo;
    private String staffID;
    private LocalDate appDate;
    private String appTime;
    private boolean admission;
    private String symptoms;
 /**
     * A method that instantiates the objects and assigns the values to the fields. Receives  values as parameters
     **/
    public Appointments(String patientNo, String staffID, String appDate, String appTime, boolean admission, String symptoms) {
        this.patientNo = patientNo;
        this.staffID = staffID;
        this.appDate  = LocalDateTime.parse(appDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s")).toLocalDate();
        this.appTime = appTime;
        this.admission = admission;
        this.symptoms = symptoms;
    }
/**
     * Get data from the field patientNo from the table tblAppointments
     */
    public String getPatientNo() {
        return patientNo;
    }
/**
     * Get data from the field staffID from the table tblAppointments
     */
    public String getStaffID() {
        return staffID;
    }
/**
     * Get data from the field appDate from the table tblAppointments
     */
    public LocalDate getAppDate() {
        return appDate;
    }
/**
     * Get data from the field appTime from the table tblAppointments
     */
    public String getAppTime() {
        return appTime;
    }
/**
     * Get data from the field admission from the table tblAppointments
     */
    public boolean isAdmission() {
        return admission;
    }
/**
     * Get data from the field symptoms from the table tblAppointments
     */
    public String getSymptoms() {
        return symptoms;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setAppDate(LocalDate appDate) {
        this.appDate = appDate;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public void setAdmission(boolean admission) {
        this.admission = admission;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

  ////////////////////////////////////////////////////////////////////////////////
   /**
     * Method that assists the toString to evenly space out the records within the display
     */ 
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i = y.length(); i < x; i++)
    tmp = tmp+" ";
    return tmp;
    }
    
////////////////////////////////////////////////////////////////////////////////
 /**
     * Method builds the String that contains all of the fields for display purposes
     */
    @Override
    public String toString() {
      String  tmp = addSpace(10,patientNo) + addSpace(10,staffID)+ addSpace(20,appDate+"")+ addSpace(20,appTime+"") + addSpace(10,admission+"")+ addSpace(10,symptoms+"");
        return tmp;
 
    }  
    
    
    
    
    
    
}
