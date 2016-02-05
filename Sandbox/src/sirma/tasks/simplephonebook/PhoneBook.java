package sirma.tasks.simplephonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation class of a simple phone book object.
 * 
 * @author Georgi Iliev
 *
 */
public class PhoneBook implements IPhoneBook {

    private int id;
    
    /**
     * Collection of the contacts present in the phone book.
     * 
     */
    List<Contact> contacts;

    protected PhoneBook() {
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
     * @param criteria - the criteria(filter) to be applied.
     */
    private void sortByCriteria(String criteria) {
    	Collections.sort(this.contacts, new CriteriaComparator(criteria));
    }

    private int generateId() {
	return id++;
    }
}