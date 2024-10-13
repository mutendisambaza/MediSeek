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
    private String medicine;
    private String usageDescription;
    private int cost;

    public Medicine(String medicine, String usageDescription, int cost) {
        this.medicine = medicine;
        this.usageDescription = usageDescription;
        this.cost = cost;
    }

    public String getMedicine() {
        return medicine;
    }

    public String getUsageDescription() {
        return usageDescription;
    }

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
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i = y.length(); i < x; i++)
    tmp = tmp+" ";
    return tmp;
    }
    
////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        String tmp = addSpace(15, medicine)+addSpace(10,cost+"")+addSpace(10,usageDescription);
        return tmp;
 
    }
    
    
    
    
    
    
    
    
    
}
