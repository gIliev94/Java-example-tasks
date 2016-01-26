package sirma.tasks.simplephonebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class of a contact object.
 * 
 * @author Georgi Iliev
 *
 */
public class Contact {

    private int id;
    private String name;
    private String phone;
    private String city;

    /**
     * Log collection of the errors which arose while the contact was a
     * candidate for a record in phone book.
     * 
     */
    List<String> errors;

    protected Contact() {
	errors = new ArrayList<>();
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }
}