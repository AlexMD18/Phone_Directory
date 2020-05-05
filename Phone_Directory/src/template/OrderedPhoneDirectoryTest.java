/*
PROGRAM DESCRIPTION:
This program creates a linked list phone directory where people are added
to the directory in order by last name. You can then search for a person by
name, phone number, and area code. You can also change the phone number of
a person in the list and remove a person completely
 */
package template;

/**
 * This class tests the implementation of OrderedPhoneDirectory
 */
public class OrderedPhoneDirectoryTest {

    public static void main(String[] args) {
        //create an empty ordered phone directory and test the constructor
        OrderedPhoneDirectory people = new OrderedPhoneDirectory();

        //add 2 people
        people.addInOrder("Tony", "Stark", "215-999-4523");
        people.addInOrder("Thor", "Odenson", "610-114-6698");

        //test toString()
        System.out.println("Phone Directory: \n" + people);

        //test addInOrder: both success and failure
        people.addInOrder("Peter", "Parker", "484-771-1338");
        //Fails to add person to directory becuase it is a duplicate
        people.addInOrder("Thor", "Odenson", "610-114-6698");

        System.out.println("Phone Directory After Add: \n" + people);

        //test each search method: both success and failure
        //search by name
        System.out.println("Search by Name Method: ");
        //SUCCESS
        people.search("Tony", "Stark");
        //FAILURE
        people.search("Bucky", "Barnes");
        
        //search by phone number
        System.out.println("\nSearch by Phone Number Method: ");
        //SUCCESS
        people.search("610-114-6698");
        //FAILURE
        people.search("915-938-1122");
        
        //search by area code
        System.out.println("\nSearch by Area Code: ");
        //SUCCESS
        System.out.println(people.search(484));
        //FAILURE
        //System.out.println(people.search(432));
        
        //test set method: both success and failure
        //SUCCESS
        people.set("Peter", "Parker", "484-716-1883");
        //FAILURE
        people.set("Loki", "Odenson", "915-333-5566");
        
        System.out.println("\nPhone Directory with New Number: \n" + people);
        
        //test remove method: both success and failure
        //SUCCESS
        people.remove("Thor", "Odenson");
        //FAILURE
        people.remove("Loki", "OdenSon");
        System.out.println("Phone Directory with Removed Person: \n" + people);
    }
}
