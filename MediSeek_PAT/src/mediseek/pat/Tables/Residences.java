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
    
    private String residences;
    private int capacity;
    private String province;
    private String contact;
    private boolean covidTestStation;
    private String address;

    public Residences(String residences, int capacity, String province, String contact, boolean covidTestStation, String address) {
        this.residences = residences;
        this.capacity = capacity;
        this.province = province;
        this.contact = contact;
        this.covidTestStation = covidTestStation;
        this.address = address;
    }

    public String getResidences() {
        return residences;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getProvince() {
        return province;
    }

    public String getContact() {
        return contact;
    }

    public boolean isCovidTestStation() {
        return covidTestStation;
    }

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
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }

 ///////////////////////////////////////////////////////////////////////////////  
    @Override
    public String toString() {
        String tmp = addSpace(40, residences)+addSpace(10,""+capacity)+addSpace(14,province)+addSpace(6,contact)+addSpace(6,covidTestStation+"")+addSpace(25,address);
        return tmp;
    }
  ////////////////////////////////////////////////////////////////////////////////  
//    public String toStringView() {
//        String tmp = addSpace(15, residences+"")+addSpace(15,capacity+"")+addSpace(15,province)+addSpace(14,contact)+addSpace(15,specialty);
//        return tmp;
//    }
//    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
