package sirma.tasks.simplephonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class SimplePhoneBook {

    private int id = 1;
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
	return contacts;
    }

    private int generateId() {
	return id++;
    }

    boolean save(Contact contact) {
	if (!contact.validate()) {
	    return false;
	}

	contact.setId(generateId());
	this.contacts.add(contact);
	return true;
    }

    boolean delete(int id) {
	for (Contact c : this.contacts) {
	    if (c.getId() == id)
		return this.contacts.remove(c);
	}
	return false;
    }

    void list() {
	ListIterator<Contact> li = this.contacts.listIterator(this.contacts.size());

	while (li.hasPrevious()) {
	    formatContactInfo(li.previous());
	}
	System.out.println();
    }

    void listByCriteria(String column) {
	sortByCriteria(column);
	printContactsInfo();
    }

    private void printContactsInfo() {
	for (Contact c : this.contacts) {
	    formatContactInfo(c);
	}
	System.out.println();
    }

    private void formatContactInfo(Contact c) {
	String printCity = "";

	if (!c.getCity().equals("")) {
	    printCity = "(" + c.getCity() + ")";
	}
	System.out.format("\n[%d] %s %s %s", c.getId(), c.getPhone(), c.getName(), printCity);
	printCity = "";
    }

    private void sortByCriteria(String col) {
	Collections.sort(this.contacts, new Comparator<Contact>() {
	    @Override
	    public int compare(Contact c1, Contact c2) {
		int result;

		switch (col) {

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

    boolean notUniqueName(String name) {
	for (Contact c : this.contacts) {
	    if (c.getName().equalsIgnoreCase(name) || c.getName().equalsIgnoreCase(name.trim())) {
		System.out.println("Error: A record with such name already exists!");
		return true;
	    }
	}
	return false;
    }

    boolean notUniquePhone(String phone) {
	for (Contact c : this.contacts) {
	    if (c.getPhone().equalsIgnoreCase(phone) || c.getPhone().equalsIgnoreCase(phone.trim())) {
		System.out.println("Error: A record with such phone number already exists!");
		return true;
	    }
	}
	return false;
    }
}