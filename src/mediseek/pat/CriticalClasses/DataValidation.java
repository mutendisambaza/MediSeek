package mediseek.pat.CriticalClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tendi
 */
public class DataValidation {
 /*
    takes a string input and checks the length to see if it contains anything
    */   
    
    public boolean isNotEmpty(String inp){
        if(inp.length()==0)
            return false;
        else return true;
    }
    
 /*
    Takes a string input and ensures that every character is not a number
    */
    public boolean allCharacters(String inp){
        boolean test = true;
        for(int i=0;i<inp.length();i++){
                if(!(Character.isLetter(inp.charAt(i))))
                    test = false;
            }
    return test;
    }
      
 /*
    Takes a string input and checks to see if the whole input can be parsed as an integer
    If not then it cathces the exception and test
    */   
    public boolean isValidNumber(String inp){
     boolean test; 
     try{
         int num = Integer.parseInt(inp);
         test = true;
     }  catch(NumberFormatException e){
                 test=false;
                 }
     return test;
        }
     
    
}
