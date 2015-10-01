package sirma.tasks.simplephonebook;

import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
	String name = "";
	String phone = "";
	String city = "";
	boolean exit = false;

	SimplePhoneBook phoneBook = new SimplePhoneBook();

	try (Scanner strScan = new Scanner(System.in); Scanner numScan = new Scanner(System.in)) {
	    do {
		System.out.print("Please select action (N, R, L, Q): ");

		switch (strScan.nextLine().toUpperCase()) {

		case "N":
		    Contact contact = new Contact();

		    System.out.print("Name: ");
		    name = strScan.nextLine();
		    contact.setName(name);

		    System.out.print("Phone number: ");
		    phone = strScan.nextLine();
		    contact.setPhone(phone);

		    System.out.print("City: ");
		    city = strScan.nextLine();
		    contact.setCity(city);

		    addContact(phoneBook, contact);
		    break;

		case "R":
		    System.out.println("Record ID: ");
		    // sc.reset();
		    int id = numScan.nextInt();

		    deleteContact(phoneBook, id);
		    // sc.reset();
		    break;

		case "L":
		    String sortChoice = "";
		    List<Contact> contacts = phoneBook.getContacts();

		    sortChoice = strScan.nextLine();

		    System.out.format("Records (%d):", contacts.size());
		    listContacts(phoneBook, sortChoice);
		    break;

		case "Q":
		    System.out.println("Bye! ");
		    exit = true;
		    break;

		default:
		    System.out.println("Make a valid choice! ");
		    System.out.println("---------------------- ");
		    break;
		}
	    } while (!exit);
	} catch (Exception e) {
	    e.printStackTrace();
	}
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
	    phBook.list(inputColumn.substring(1));
	} else {
	    phBook.list();
	}

	System.out.println("---------------------- ");
    }

    // това вече в истинско приложение отива към view-то
    // репото в реални случаи не трябва да има 1 стринг в него,
    // всичко там е с обекти, а декорацията се случва другаде,
    // в случая чак view няма смисъл, затова го пляскам в main
    // защото формата е специфичен да кажем за конзолното приложение
    // в случай че ни трябва да стане и java GUI phoneBook-a и Contact
    // класовете са ни напълно използваеми и валидни, а формата си стои само
    // тука
}