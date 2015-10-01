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

	if (this.name.equals("") || this.phone.equals("")) {
	    this.errors.add("You have to input name and phone!");
	    hasNoErrors = false;
	} else {

	    if (this.name.length() > restrictions.getNAME_CITY_MAXLENGTH()
		    || this.city.length() > restrictions.getNAME_CITY_MAXLENGTH()) {
		this.errors.add("Name or city can`t be over " + restrictions.getNAME_CITY_MAXLENGTH() + " characters!");
		hasNoErrors = false;
	    }

	    if (this.phone.length() < restrictions.getPHONE_MINLENGTH()
		    || this.phone.length() > restrictions.getPHONE_MAXLENGTH()) {
		this.errors.add("Phone number should be between " + restrictions.getPHONE_MINLENGTH() + " and "
			+ restrictions.getPHONE_MAXLENGTH() + " digits!");
		hasNoErrors = false;
	    }
	}
	return hasNoErrors;
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