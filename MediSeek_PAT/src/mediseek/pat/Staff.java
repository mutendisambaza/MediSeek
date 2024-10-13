
package mediseek.pat;

/**
 *
 * @author tendi
 */
public class Staff {
    
    
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
    private String addSpace(int x, String y){
    String tmp = y;
    for(int i=y.length();i<x;i++)
    tmp = tmp+" ";
    return tmp;
    }

 ///////////////////////////////////////////////////////////////////////////////  
    @Override
    public String toString() {
        String tmp = addSpace(10, sName+"")+addSpace(10,sSurname)+addSpace(14,gender)+addSpace(6,jobDescription)+addSpace(6,specialty)+addSpace(25,residence)+addSpace(4,qualifications)+addSpace(10,contact)+addSpace(10,staff_ID);
        return tmp;
    }

    
 ////////////////////////////////////////////////////////////////////////////////   
public String toStringView() {
        String tmp = addSpace(15, sName+"")+addSpace(15,sSurname)+addSpace(15,staff_ID)+addSpace(14,gender)+addSpace(15,specialty);
        return tmp;
    }
            

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
