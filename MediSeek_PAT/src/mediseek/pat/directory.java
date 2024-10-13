/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediseek.pat;

/**
 *
 * @author tendi
 */
public class directory {
    
    private String sName;
    private String sSurname;
    private String gender;
    private String jobDescription;
    private String specialty;
    private String residence;
    private String qualifications;
    private String contact;
    private String staff_ID;

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

    public String getsName() {
        return sName;
    }

    public String getsSurname() {
        return sSurname;
    }

    public String getGender() {
        return gender;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getResidence() {
        return residence;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getContact() {
        return contact;
    }

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

    
    
    
    ////////////////////////////////////////////////////////////////////////////////
    
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }
///////////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        String tmp = addSpace(15, sName+"")+addSpace(17,sSurname)+addSpace(15,gender)+addSpace(25,residence)+addSpace(10,contact)+addSpace(10,staff_ID);
        return tmp;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////   
    
//  public String toStringView() {
//        String tmp = addSpace(15, sName+"")+addSpace(15,sSurname)+addSpace(15,gender)+addSpace(15,specialty)+addSpace(25,residence);
//        return tmp;
//    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
