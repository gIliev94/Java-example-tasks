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

	try (Scanner sc = new Scanner(System.in)) {
	    do {
		System.out.println("Please select action (N, R, L, Q):");

		switch (sc.next().toUpperCase()) {

		case "N":
		    Contact contact = new Contact();

		    System.out.print("Name: ");
		    name = sc.nextLine();
		    contact.setName(name);

		    System.out.print("Phone number: ");
		    phone = sc.nextLine();
		    contact.setPhone(phone);

		    System.out.print("City: ");
		    city = sc.nextLine();
		    contact.setCity(city);

		    if (!phoneBook.save(contact)) {
			System.out.println();

			for (String errMsg : contact.getErrors()) {
			    System.out.println(errMsg);
			}
			System.out.println("----------------------");
		    } else {
			System.out.println("New record with ID " + contact.getId() + " has been created!");
			System.out.println("----------------------");
		    }

		    break;

		case "R":
		    System.out.print("Record ID: ");
		    int id = sc.nextInt();

		    if (phoneBook.delete(id)) {
			System.out.println("Record with ID " + id + " has been removed!");
		    } else {
			System.out.println("Record not found!");
		    }
		    System.out.println("----------------------");
		    break;

		case "L":
		    String sortChoice = "";
		    List<Contact> contacts = phoneBook.getContacts();

		    sortChoice = sc.next();

		    System.out.format("Records (%d):\n", contacts.size());

		    if (sortChoice.startsWith(":")) {
			phoneBook.list(sortChoice.substring(1, sortChoice.length() - 1));
		    } else {
			phoneBook.list();
		    }

		    System.out.println("----------------------");
		    break;

		case "Q":
		    exit = true;
		    break;

		default:
		    System.out.println("Make a valid choice!\n");
		    System.out.println("----------------------");
		    break;
		}
	    } while (!exit);
	} catch (Exception e) {
	    e.printStackTrace();
	}
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