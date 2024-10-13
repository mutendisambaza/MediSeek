
package mediseek.pat.Tables;

/**
 *
 * @author tendi
 */
public class Staff {
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
    private String password;
    
 /**
     * A method that instantiates the objects and assigns the values to the fields. Receives  values as parameters
     **/
    public Staff(String sName, String sSurname, String gender, String jobDescription, String specialty, String residence, String qualifications, String contact, String staff_ID, String password) {
        this.sName = sName;
        this.sSurname = sSurname;
        this.gender = gender;
        this.jobDescription = jobDescription;
        this.specialty = specialty;
        this.residence = residence;
        this.qualifications = qualifications;
        this.contact = contact;
        this.staff_ID = staff_ID;
        this.password = password;
    }
/**
     * Get data from the field sName from the table tblStaff
     */
    public String getsName() {
        return sName;
    }
/**
     * Get data from the field sSurname from the table tblStaff
     */
    public String getsSurname() {
        return sSurname;
    }
/**
     * Get data from the field gender from the table tblStaff
     */
    public String getGender() {
        return gender;
    }
/**
     * Get data from the field jobDescription from the table tblStaff
     */
    public String getJobDescription() {
        return jobDescription;
    }
/**
     * Get data from the field specialty from the table tblStaff
     */
    public String getSpecialty() {
        return specialty;
    }
/**
     * Get data from the field residence from the table tblStaff
     */
    public String getResidence() {
        return residence;
    }
/**
     * Get data from the field qualifications from the table tblStaff
     */
    public String getQualifications() {
        return qualifications;
    }
/**
     * Get data from the field contact from the table tblStaff
     */
    public String getContact() {
        return contact;
    }
/**
     * Get data from the field staff_ID from the table tblStaff
     */
    public String getStaff_ID() {
        return staff_ID;
    }
/**
     * Get data from the field password from the table tblStaff
     */
    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
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
        String tmp = addSpace(10, sName+"")+addSpace(10,sSurname)+addSpace(14,gender)+addSpace(6,jobDescription)+addSpace(6,specialty)+addSpace(25,residence)+addSpace(4,qualifications)+addSpace(10,contact)+addSpace(10,staff_ID);
        return tmp;
    }

    
 ////////////////////////////////////////////////////////////////////////////////   
/**
     * Alternative to above toString()
     * Method builds the String that contains all of the fields for display purposes
     */
    public String toStringView() {
        String tmp = addSpace(15, sName+"")+addSpace(15,sSurname)+addSpace(15,staff_ID)+addSpace(14,gender)+addSpace(15,specialty);
        return tmp;
    }
            

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
