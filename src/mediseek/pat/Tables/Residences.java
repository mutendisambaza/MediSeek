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
public class Residences {
    /**
    *Instantiation
    **/  
    private String residences;
    private int capacity;
    private String province;
    private String contact;
    private boolean covidTestStation;
    private String address;
 /**
     * A method that instantiates the objects and assigns the values to the fields. Receives  values as parameters
     **/
    public Residences(String residences, int capacity, String province, String contact, boolean covidTestStation, String address) {
        this.residences = residences;
        this.capacity = capacity;
        this.province = province;
        this.contact = contact;
        this.covidTestStation = covidTestStation;
        this.address = address;
    }
/**
     * Get data from the field residences from the table tblResidences
     */
    public String getResidences() {
        return residences;
    }
/**
     * Get data from the field capacity from the table tblResidences
     */
    public int getCapacity() {
        return capacity;
    }
/**
     * Get data from the field province from the table tblResidences
     */
    public String getProvince() {
        return province;
    }
/**
     * Get data from the field contact from the table tblResidences
     */
    public String getContact() {
        return contact;
    }
/**
     * Get data from the field covidTestStation from the table tblResidences
     */
    public boolean isCovidTestStation() {
        return covidTestStation;
    }
/**
     * Get data from the field address from the table tblResidences
     */
    public String getAddress() {
        return address;
    }

    public void setResidences(String residences) {
        this.residences = residences;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setCovidTestStation(boolean covidTestStation) {
        this.covidTestStation = covidTestStation;
    }

    public void setAddress(String address) {
        this.address = address;
    }
  
    

    ////////////////////////////////////////////////////////////////////////////////
  /**
     * Method that assists the toString to evenly space out the records within the display
     */
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }

 ///////////////////////////////////////////////////////////////////////////////  
    /**
     * Method builds the String that contains all of the fields for display purposes
     */
    @Override
    public String toString() {
        String tmp = addSpace(40, residences)+addSpace(10,""+capacity)+addSpace(20,province)+addSpace(10,covidTestStation+"");
        return tmp;
    }
  ////////////////////////////////////////////////////////////////////////////////  

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
