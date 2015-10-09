package sirma.tasks.simplephonebook;

import java.util.ArrayList;

/*
 * ���� �� ��������� �� ���� Entity ����� 1 ��������� �������, ����� ������ 
 * �� � ORM ������ ���� �������� �� 1 �������, � ��� �������� �� ��� ������� ����
 * ������ �� �����. ��� � ������� �� �� ������ � ����� <a> ������ �� ����� ��������
 * ��������� ����� ������ � �� �������� �� ������ �� ���� �� ������������� �� ������� ��������,
 * ������ � ������������(PhoneBook),������ � ��� �� ��������� id,��� �� ��������� � �� ��������� 
 */
public class Contact {

    private int id;
    private String name;
    private String phone;
    private String city;

    // @TODO ��� ������ �� � ����� ��� � ���� name=>null ��� "Name is required",
    // ����� ������ �� � �����, � �������� �� � value

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