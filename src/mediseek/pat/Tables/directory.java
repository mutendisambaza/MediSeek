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
public class directory {
  /**
    *Instantiation
    **/  
    private String sName;
    private String sSurname;
    private String gender;
    private String jobDescription;
    private String specialty;
    private String residence;
    private String qualifications;
    private String contact;
    private String staff_ID;

    /**
     * A method that instantiates the objects and assigns the values to the fields. Receives  values as parameters
     **/
    
    public directory(String sName, String sSurname, String gender, String jobDescription, String specialty, String residence, String qualifications, String contact, String staff_ID) {
        this.sName = sName;
        this.sSurname = sSurname;
        this.gender = gender;
        this.jobDescription = jobDescription;
        this.specialty = specialty;
        this.residence = residence;
        this.qualifications = qualifications;
        this.contact = contact;
        this.staff_ID = staff_ID;
    }
/**
     * Get data from the field sName from the table tblDirectory
     */
    public String getsName() {
        return sName;
    }
/**
     * Get data from the field sSurname from the table tblDirectory
     */
    public String getsSurname() {
        return sSurname;
    }
/**
     * Get data from the field gender from the table tblDirectory
     */
    public String getGender() {
        return gender;
    }
/**
     * Get data from the field jobDescription from the table tblDirectory
     */
    public String getJobDescription() {
        return jobDescription;
    }
/**
     * Get data from the field specialty from the table tblDirectory
     */
    public String getSpecialty() {
        return specialty;
    }
/**
     * Get data from the field residence from the table tblDirectory
     */
    public String getResidence() {
        return residence;
    }
/**
     * Get data from the field qualifications from the table tblDirectory
     */
    public String getQualifications() {
        return qualifications;
    }
/**
     * Get data from the field contact from the table tblDirectory
     */
    public String getContact() {
        return contact;
    }
/**
     * Get data from the field staff_ID from the table tblDirectory
     */
    public String getStaff_ID() {
        return staff_ID;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsSurname(String sSurname) {
        this.sSurname = sSurname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setStaff_ID(String staff_ID) {
        this.staff_ID = staff_ID;
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
        String tmp = addSpace(12, sName+"")+addSpace(12,sSurname)+addSpace(10,gender)+addSpace(15,specialty)+addSpace(40,residence);
        return tmp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
