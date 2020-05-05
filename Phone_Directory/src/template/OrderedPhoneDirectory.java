package template;

import java.util.LinkedList;

/**
 * This class represents any phone directory in the alphabetical order of names
 * (first by last name, then by first name)
 */
public class OrderedPhoneDirectory {

    //define a data field, which is a linked list of PhoneDirectoryEntry objects.
    // Data Fields
    private LinkedList<PhoneDirectoryEntry> phoneDirectory;

    //Constructor
    public OrderedPhoneDirectory() {
        this.phoneDirectory = new LinkedList<>();
    }

    //define the following methods
    //Adds people into the directory in order first by last name, then by first name
    public boolean addInOrder(String firstName, String lastName, String phoneNumber) {
        PhoneDirectoryEntry entry = new PhoneDirectoryEntry(firstName, lastName, phoneNumber);

        if (phoneDirectory.size() == 0) {
            phoneDirectory.add(0, entry);
            return true;
        }

        for (int i = 0; i < phoneDirectory.size(); i++) {
            if (entry.compareTo(phoneDirectory.get(i)) == 0) {
                return false;
            }
        }

        int i = 0;

        while (entry.compareTo(phoneDirectory.get(i)) > 0) {
            if (i == phoneDirectory.size() - 1) {
                phoneDirectory.add(i, entry);
                return true;
            }
            i++;
        }
        phoneDirectory.add(i, entry);
        return true;
    }

    //to string method
    public String toString() {
        //to be completed by you
        String result = "";

        for (int i = 0; i < phoneDirectory.size(); i++) {
            result += "" + phoneDirectory.get(i).getFirstName() + " " + phoneDirectory.get(i).getLastName() + " " + phoneDirectory.get(i).getPhoneNumber() + "\n";
        }
        return result;
    }

    //Method that searches the liked list by name
    public String search(String firstName, String lastName) {
        for (int i = 0; i < phoneDirectory.size(); i++) {
            if (phoneDirectory.get(i).getLastName().equals(lastName)) {
                if (phoneDirectory.get(i).getFirstName().equals(firstName)) {
                    System.out.println(phoneDirectory.get(i).getFirstName() + " " + phoneDirectory.get(i).getLastName() + "'s Phone Number: " + phoneDirectory.get(i).getPhoneNumber());
                    return phoneDirectory.get(i).getPhoneNumber();
                }
            }
        }
        return null;
    }

    //Method that searches liked list by phone number
    public String search(String phone) {
        for (int i = 0; i < phoneDirectory.size(); i++) {
            if (phoneDirectory.get(i).getPhoneNumber().equals(phone)) {
                System.out.println(phoneDirectory.get(i).getPhoneNumber() + " is " + phoneDirectory.get(i).getFirstName() + " " + phoneDirectory.get(i).getLastName() + "'s Phone Number.");
                return phoneDirectory.get(i).getFirstName() + phoneDirectory.get(i).getLastName();
            }
        }
        return null;
    }

    //Method that searches linked list by area code
    public LinkedList<String> search(int areaCode) {

        LinkedList<String> code = new LinkedList<String>();

        for (int i = 0; i < phoneDirectory.size(); i++) {
            if (phoneDirectory.get(i).getPhoneNumber().startsWith(areaCode + "")) {
                code.add(phoneDirectory.get(i).getFirstName() + " " + phoneDirectory.get(i).getLastName());
            }
        }
        return code;
    }

    //Method that changes the phone number of a person in the linked list
    public String set(String firstName, String lastName, String newPhoneNumber) {
        for (int i = 0; i < phoneDirectory.size(); i++) {
            if (phoneDirectory.get(i).getLastName().equals(lastName)) {
                if (phoneDirectory.get(i).getFirstName().equals(firstName)) {
                    String old = phoneDirectory.get(i).getPhoneNumber();
                    phoneDirectory.get(i).setPhoneNumber(newPhoneNumber);
                    return "Old Phone Number: " + old;
                }
            }
        }
        return null;
    }

    //Method to remove a person from the directory
    public boolean remove(String firstName, String lastName) {
        for (int i = 0; i < phoneDirectory.size(); i++) {
            if (phoneDirectory.get(i).getLastName().equals(lastName)) {
                if (phoneDirectory.get(i).getFirstName().equals(firstName)) {
                    phoneDirectory.remove(phoneDirectory.get(i));
                }
            }
        }
        return false;
    }
}
