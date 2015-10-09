package sirma.tasks.simplephonebook;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private int id;
    private String name;
    private String phone;
    private String city;

    private List<String> errors = new ArrayList<>();

    boolean validate() {
	if (!checkForNamePhone()) {
	    return false;
	}

	checkPhoneIntegrity();
	checkCityIntegrity();
	checkLength();

	if (!this.errors.isEmpty()) {
	    return false;
	}
	return true;
    }

    private boolean checkForNamePhone() {
	if (this.name.equals("") || this.phone.equals("")) {
	    this.errors.add("Error: You have to input both name and phone!");
	    return false;
	}
	return true;
    }

    private boolean checkPhoneIntegrity() {
	for (Character c : this.phone.toCharArray()) {
	    if (!Character.isDigit(c)) {
		this.errors.add("Error: Phone number can contain only digits!");
		return false;
	    }
	}
	return true;
    }

    private boolean checkCityIntegrity() {
	for (Character c : this.city.toCharArray()) {
	    if (!Character.isAlphabetic(c)) {
		this.errors.add("Error: City can contain only letters!");
		return false;
	    }
	}
	return true;
    }

    private boolean checkLength() {
	RuleSet rules = new RuleSet();
	boolean isFine = true;

	if (this.name.length() > rules.getNAME_CITY_MAXLENGTH()
		|| this.city.length() > rules.getNAME_CITY_MAXLENGTH()) {
	    this.errors.add("Error: Name or city can`t be over " + rules.getNAME_CITY_MAXLENGTH() + " characters!");
	    isFine = false;
	}

	if (this.phone.length() < rules.getPHONE_MINLENGTH() || this.phone.length() > rules.getPHONE_MAXLENGTH()) {
	    this.errors.add("Error: Phone number should be between " + rules.getPHONE_MINLENGTH() + " and "
		    + rules.getPHONE_MAXLENGTH() + " digits!");
	    isFine = false;
	}
	return isFine;
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

    public List<String> getErrors() {
	return errors;
    }
}