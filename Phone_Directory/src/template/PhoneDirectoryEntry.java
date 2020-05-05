package template;

//This class represents any entry in an ordered phone directory.
public class PhoneDirectoryEntry {

    // Data Fields
    private String firstName;
    private String lastName;
    private String phoneNumber;      //phoneNumber format: 215-204-2940

    // Constructor
    public PhoneDirectoryEntry(String firstName, String lastName,
            String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //Methods: getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Methods: Setter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return "\nPhone Directory: " + "\nFull Name: " + firstName + lastName + "\n Phone Number: " + phoneNumber;
    }
    
    //return
    //  0 if the name in this entry has same first name and last name as the other entry in the parameter
    //  1 if the name in this entry is alphabetically after the other entry in the parameter
    // -1 if the name in this entry is alphabetically before the other entry in the parameter
    public int compareTo(PhoneDirectoryEntry other) {        
        
        //to be completed by you
        if(this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName)){
            return 0;
        }
        else if(this.lastName.compareTo(other.lastName) < 0){
            return -1;
        }
        else if(this.lastName.compareTo(other.lastName) > 0){
            return 1;
        }
        else if(this.firstName.compareTo(other.firstName) < 0){
            return -1;
        }
        else{
            return 1;
        }
    }

}
