package sirma.tasks.simplephonebook;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) 
    {
	
	boolean exit = false;
	String choice = "";
	Scanner strScan = new Scanner(System.in);
	Scanner numScan = new Scanner(System.in);
	SimplePhoneBook phoneBook = new SimplePhoneBook();

	try {
	    do {
		System.out.print("Please select action (N, R, L, Q): ");
		choice = strScan.nextLine().toLowerCase();

		switch (choice) {

		case "n":
		    Contact contact = new Contact();

		    inputName(contact, phoneBook, strScan);
		    inputPhone(contact, phoneBook, strScan);
		    inputCity(contact, phoneBook, strScan);

		    addContact(phoneBook, contact);
		    break;

		case "r":
		    System.out.print("Record ID: ");
		    int id = numScan.nextInt();

		    deleteContact(phoneBook, id);
		    break;

		case "l":
		case "l:name":
		case "l:phone":
		case "l:city":
		case "l:name!":
		case "l:phone!":
		case "l:city!":
		    List<Contact> contacts = phoneBook.getContacts();

		    System.out.format("Records (%d):", contacts.size());
		    listContacts(phoneBook, choice.substring(1));
		    break;

		case "q":
		    System.out.println("Bye! ");
		    numScan.close();
		    strScan.close();
		    exit = true;
		    break;

		default:
		    System.out.println("Make a valid choice! ");
		    System.out.println("---------------------- ");
		    break;
		}
	    } while (!exit);
	} catch (InputMismatchException ime) {
	    System.out.println("Bad input: IDs are numbers!!!");
	} catch (Exception e) {
	    System.out.println("Something went wrong:" + e.getMessage());
	}
    }

    private static void inputName(Contact c, SimplePhoneBook pBook, Scanner strSc) {
	String name = "";

	do {
	    System.out.print("Name: ");
	    name = strSc.nextLine();

	} while (pBook.notUniqueName(name));

	c.setName(name);
    }

    private static void inputPhone(Contact c, SimplePhoneBook pBook, Scanner strSc) {
	String phone = "";

	do {
	    System.out.print("Phone number: ");
	    phone = strSc.nextLine();

	} while (pBook.notUniquePhone(phone));
	c.setPhone(phone);
    }

    private static void inputCity(Contact c, SimplePhoneBook pBook, Scanner strSc) {
	String city = "";

	System.out.print("City: ");
	city = strSc.nextLine();
	c.setCity(city);
    }

    private static void addContact(SimplePhoneBook phBook, Contact con) {
	if (!phBook.save(con)) {
	    System.out.println();   
	    for (String errMsg : con.getErrors()) {
		System.out.println(errMsg);
	    }
	    System.out.println("---------------------- ");
	} else {
	    System.out.println("New record with ID " + con.getId() + " has been created! ");
	    System.out.println("---------------------- ");
	}
    }

    private static void deleteContact(SimplePhoneBook phBook, int id) {
	if (phBook.delete(id)) {
	    System.out.println("Record with ID " + id + " has been removed! ");
	} else {
	    System.out.println("Record not found! ");
	}
	System.out.println("---------------------- ");
    }

    private static void listContacts(SimplePhoneBook phBook, String inputColumn) {
	if (inputColumn.startsWith(":")) {
	    phBook.listByCriteria(inputColumn.substring(1));
	} else {
	    phBook.list();
	}
	System.out.println("---------------------- ");
    }
}