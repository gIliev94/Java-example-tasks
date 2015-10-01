package sirma.tasks.simplephonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/*
 * Това ти е 1 вид ContactRepository има за цел да управлява контактите, във всеки
 * проект тука са ти getAll(), getById(), save(), update(), е такива дето бачкат с 
 * базата, в случая нямаш база но идеята е същата, пак се пазат в рамта.
 */
public class SimplePhoneBook {
    private int id = 1;

    private ArrayList<Contact> contacts = new ArrayList<>();

    boolean save(Contact contact) {

	if (!contact.validate()) {
	    return false;
	} else if (!this.checkIsUniqueName(contact)) {
	    contact.getErrors().add("A record with such name already exists!");
	    return false;
	} else if (!this.checkIsUniquePhone(contact)) {
	    contact.getErrors().add("A record with such number already exists!");
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
	Stack<Contact> printStack = new Stack<>();
	printStack.addAll(this.contacts);

	for (Contact c : printStack) {
	    printContactInfo(c);
	}
    }

    public void list(String column) {

	Collections.sort(this.contacts, new Comparator<Contact>() {
	    @Override
	    public int compare(Contact c1, Contact c2) {
		int result;

		switch (column.substring(0, column.length() - 1)) {

		case "name":
		    result = (c1.getName()).compareToIgnoreCase(c2.getName());
		    break;

		case "phone":
		    result = (c1.getPhone()).compareToIgnoreCase(c2.getPhone());
		    break;

		case "city":
		    result = (c1.getCity()).compareToIgnoreCase(c2.getCity());
		    break;

		default:
		    result = 0;
		    break;
		}
		return result;
	    }
	});

	if (column.endsWith("!")) {
	    Collections.reverse(this.contacts);
	}
    }

    private boolean checkIsUniqueName(Contact con) {
	for (Contact c : this.contacts) {
	    if (c.getCity().equals(con.getCity()) && c.getName().equals(con.getName())) {
		return false;
	    }
	}
	return true;
    }

    private boolean checkIsUniquePhone(Contact con) {
	for (Contact c : this.contacts) {
	    if (c.getPhone().equals(con.getPhone()))
		return false;
	}
	return true;
    }

    void printContactInfo(Contact c) {
	System.out.format("[%d] %s %s (%s)", c.getId(), c.getPhone(), c.getName(), c.getCity());
    }

    private int generateId() {
	return id++;
    }

    public ArrayList<Contact> getContacts() {
	return contacts;
    }

    // Nqma da trqbva mai
    public void setContacts(ArrayList<Contact> contacts) {
	this.contacts = contacts;
    }

}