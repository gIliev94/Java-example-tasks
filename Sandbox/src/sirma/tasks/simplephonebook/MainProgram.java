package sirma.tasks.simplephonebook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

	boolean exit = false;
	String choice = "";
	Scanner strScanner = new Scanner(System.in);
	Scanner numScanner = new Scanner(System.in);
	SimplePhoneBook phoneBook = new SimplePhoneBook();

	try {
	    do {
		System.out.print("Please select action (N, R, L, Q): ");
		choice = strScanner.nextLine().toLowerCase();

		switch (choice) {

		case "n":
		    Contact contact = new Contact();

		    inputName(contact, phoneBook, strScanner);
		    inputPhone(contact, phoneBook, strScanner);
		    inputCity(contact, phoneBook, strScanner);

		    addContact(phoneBook, contact);
		    break;

		case "r":
		    System.out.print("Record ID: ");
		    int id = numScanner.nextInt();

		    deleteContact(phoneBook, id);
		    break;

		case "l":
		case "l:name":
		case "l:phone":
		case "l:city":
		case "l:name!":
		case "l:phone!":
		case "l:city!":
		    int allContacts = phoneBook.contacts.size();

		    System.out.format("Records (%d):", allContacts);
		    listContacts(phoneBook, choice.substring(1));
		    break;

		case "q":
		    System.out.println("Bye! ");
		    numScanner.close();
		    strScanner.close();
		    exit = true;
		    break;

		default:
		    System.err.println("Make a valid choice!");
		    System.out.println("---------------------- ");
		    break;
		}
	    } while (!exit);
	} catch (InputMismatchException ime) {
	    System.err.println("Bad input: IDs are numbers!!!");
	} catch (Exception e) {
	    System.err.println("Something went wrong:" + e.getMessage());
	}
    }

    private static void inputName(Contact contact, SimplePhoneBook phoneBook, Scanner strScan) {
	String name = "";

	do {
	    System.out.print("Name: ");
	    name = strScan.nextLine();

	} while (PhoneBookValidator.isNotUniqueName(name, phoneBook));

	contact.setName(name);
    }

    private static void inputPhone(Contact contact, SimplePhoneBook phoneBook, Scanner strScan) {
	String phone = "";

	do {
	    System.out.print("Phone number: ");
	    phone = strScan.nextLine();

	} while (PhoneBookValidator.isNotUniquePhone(phone, phoneBook));
	contact.setPhone(phone);
    }

    private static void inputCity(Contact contact, SimplePhoneBook phoneBook, Scanner strScan) {
	String city = "";

	System.out.print("City: ");
	city = strScan.nextLine();
	contact.setCity(city);
    }

    private static void addContact(SimplePhoneBook phoneBook, Contact contact) {
	if (!phoneBook.save(contact)) {
	    System.out.println();
	    for (String errMsg : contact.errors) {
		System.err.println(errMsg);
	    }
	    System.out.println("---------------------- ");
	} else {
	    System.out.println("New record with ID " + contact.getId() + " has been created! ");
	    System.out.println("---------------------- ");
	}
    }

    private static void deleteContact(SimplePhoneBook phoneBook, int contactId) {
	if (phoneBook.delete(contactId)) {
	    System.out.println("Record with ID " + contactId + " has been removed! ");
	} else {
	    System.err.println("Record not found! ");
	}
	System.out.println("---------------------- ");
    }

    private static void listContacts(SimplePhoneBook phoneBook, String filterColumn) {
	if (filterColumn.startsWith(":")) {
	    phoneBook.list(filterColumn.substring(1));
	} else {
	    phoneBook.list(null);
	}
	System.out.println("---------------------- ");
    }
}