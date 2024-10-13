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
public class Medicine {
   /**
    *Instantiation
    **/  
    private String medicine;
    private String usageDescription;
    private int cost;
 /**
     * A method that instantiates the objects and assigns the values to the fields. Receives  values as parameters
     **/
    public Medicine(String medicine, String usageDescription, int cost) {
        this.medicine = medicine;
        this.usageDescription = usageDescription;
        this.cost = cost;
    }
/**
     * Get data from the field cost from the table tblMedicine
     */
    public String getMedicine() {
        return medicine;
    }
/**
     * Get data from the field cost from the table tblMedicine
     */
    public String getUsageDescription() {
        return usageDescription;
    }
/**
     * Get data from the field cost from the table tblMedicine
     */
    public int getCost() {
        return cost;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public void setUsageDescription(String usageDescription) {
        this.usageDescription = usageDescription;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
        String tmp = addSpace(15, medicine)+addSpace(10,"R"+cost)+addSpace(10,usageDescription);
        return tmp;
 
    }
    
    
    
    
    
    
    
    
    
}
