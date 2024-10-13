package mediseek.pat;

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
    
    public boolean isNotEmpty(String inp){
        if(inp.length()==0)
            return false;
        else return true;
    }
    
    public boolean allCharacters(String inp){
        boolean test = true;
        for(int i=0;i<inp.length();i++){
                if(!(Character.isLetter(inp.charAt(i))))
                    test = false;
            }
    return test;
    }
    
   //DISPLAY RECORDS TAB
   // in the search button: 
   //System.out.println(obj.isNotEmpty(txtSearchName.getText()));
   //System.out.println(obj.allCharacters(txtSearchName.getText()));
   //if(object.isNotEmpty(inp)==true & object.allCharacters(inp)==true)
   //       1stRunner.clear();
   //       getRunner("select * from tblRunner where name like '*"+txtSearchName.getText()+"*'");
   //else txtSearchName.setText("INVALID ENTRY") 
    
    
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
     
   
    
//    //DISPLAY RECORDS TAB
//   // in the search button: 
//   //System.out.println(obj.isNotEmpty(txtName.getText()));
//   //System.out.println(obj.allCharacters(txtAge.getText()));
//    
//   // if (obj.isEmpty(txtAge.getText())==true  &  obj.isValidNumber(txtAge.getText())==true)
//   // if(1stRun.getSelectIndex()==1){
//                //Adds a new record to the table and refreshes the display of the list
//                   objRun.updateTable("insert tblRunner values("+Integer.parseInt(txtID.)")")
//                //
//    
//}else{
//    objRun.updateTable("UPDATE tblRunner Set tbleRunner.Age = *"+
//                        txtAge.getText()+"WHERE RunnerID="+txtID.getText());   
//}
// tbPane.setSelectedIndex(0);
//1stRunner.clear();
//getRunner("Select* from tblRunner");
//    
//    
    
//    
//    public toRunPAT(){
//    initComponents();
    
    }
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
