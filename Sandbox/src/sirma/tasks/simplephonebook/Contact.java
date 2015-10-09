package sirma.tasks.simplephonebook;

import java.util.ArrayList;

/*
 * Това из патерните се води Entity демек 1 логическа единица, почти винаги 
 * ти е ORM случая дето отговаря на 1 таблица, и има колоните от тая таблица като
 * полета на класа. Тук е мястото да се правят и разни <a> методи за самия контакта
 * Принципно моята логика е че контакта не трябва да знае за същестуването на другите контакти,
 * затова е репозиторито(PhoneBook),затова и там се генерират id,там се проверява и за дубликати 
 */
public class Contact {

    private int id;
    private String name;
    private String phone;
    private String city;

    // @TODO тук трябва да е някъв мап с ключ name=>null или "Name is required",
    // демек полето ти е ключа, а грешката ти е value

    // Ne vijdam zashto mi e map v sluchaq kato moje da si pazq prosto v
    // list greshkite, i bez tva sa si vurzani za konkretniq Contact taka shot
    // sa pole
    private ArrayList<String> errors = new ArrayList<>();

    boolean validate() {
	RuleSet restrictions = new RuleSet();
	boolean hasNoErrors = true;

	hasNoErrors = checkNamePhone();

	if (hasNoErrors) {
	    hasNoErrors = checkLength(restrictions);
	}
	return hasNoErrors;
    }

    private boolean checkNamePhone() {
	if (this.name.equals("") || this.phone.equals("")) {
	    this.errors.add("Error: You have to input both name and phone!");
	    return false;
	}
	return true;
    }

    private boolean checkLength(RuleSet rules) {
	if (this.name.length() > rules.getNAME_CITY_MAXLENGTH()
		|| this.city.length() > rules.getNAME_CITY_MAXLENGTH()) {
	    this.errors.add("Error: Name or city can`t be over " + rules.getNAME_CITY_MAXLENGTH() + " characters!");
	    return false;
	}

	if (this.phone.length() < rules.getPHONE_MINLENGTH() || this.phone.length() > rules.getPHONE_MAXLENGTH()) {
	    this.errors.add("Error: Phone number should be between " + rules.getPHONE_MINLENGTH() + " and "
		    + rules.getPHONE_MAXLENGTH() + " digits!");
	    return false;
	}
	return true;
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

    public ArrayList<String> getErrors() {
	return errors;
    }

    // nqma da trqbva mai
    public void setErrors(ArrayList<String> errors) {
	this.errors = errors;
    }

}