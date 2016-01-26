package sirma.tasks.simplephonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation class of a simple phone book object.
 * 
 * @author Georgi Iliev
 *
 */
public class SimplePhoneBook implements IPhoneBook {

    private int id;
    
    /**
     * Collection of the contacts present in the phone book.
     * 
     */
    List<Contact> contacts;

    protected SimplePhoneBook() {
	id = 1;
	contacts = new ArrayList<>();
    }

    public boolean save(Contact contact) {
	if (!ContactValidator.validate(contact)) {
	    return false;
	}

	contact.setId(generateId());
	this.contacts.add(contact);
	return true;
    }

    public boolean delete(int id) {
	for (Contact con : this.contacts) {
	    if (con.getId() == id)
		return this.contacts.remove(con);
	}
	return false;
    }

    public void list(String column) {
	if (column == null) {
	    ListIterator<Contact> listIterator = this.contacts.listIterator(this.contacts.size());

	    while (listIterator.hasPrevious()) {
		printFormatedContactInformation(listIterator.previous());
	    }
	    System.out.println();
	} else {
	    sortByCriteria(column);
	    printContactsInformation();
	}

    }

    /**
     * Prints out all the information for a {@link Contact}.
     * 
     */
    private void printContactsInformation() {
	for (Contact con : this.contacts) {
	    printFormatedContactInformation(con);
	}
	System.out.println();
    }

    /**
     * Shapes up the listing of information for a contact to a specific format.
     * 
     * @param contact - the contact to be printed.
     */
    private void printFormatedContactInformation(Contact contact) {
	String printCity = "";

	if (!contact.getCity().equals("")) {
	    printCity = "(" + contact.getCity() + ")";
	}
	System.out.format("\n[%d] %s %s %s", contact.getId(), contact.getPhone(), contact.getName(), printCity);
    }

    /**
     * Sorts the contacts in the phone book according to the provided filter column as criteria.
     * 
     * @param column - the criteria(filter) to be applied.
     */
    private void sortByCriteria(String column) {
	Collections.sort(this.contacts, new Comparator<Contact>() {
	    @Override
	    public int compare(Contact c1, Contact c2) {
		int result;

		switch (column) {

		case "name":
		    result = (c1.getName()).compareToIgnoreCase(c2.getName());
		    break;

		case "phone":
		    result = (c1.getPhone()).compareToIgnoreCase(c2.getPhone());
		    break;

		case "city":
		    result = (c1.getCity()).compareToIgnoreCase(c2.getCity());

		    if (c1.getCity().equals("")) {
			result = 1;
		    }

		    if (c2.getCity().equals("")) {
			result = -1;
		    }

		    break;

		case "name!":
		    result = (c2.getName()).compareToIgnoreCase(c1.getName());
		    break;

		case "phone!":
		    result = (c2.getPhone()).compareToIgnoreCase(c1.getPhone());
		    break;

		case "city!":
		    result = (c2.getCity()).compareToIgnoreCase(c1.getCity());
		    break;

		default:
		    result = 0;
		    break;
		}
		return result;
	    }
	});
    }

    private int generateId() {
	return id++;
    }
}