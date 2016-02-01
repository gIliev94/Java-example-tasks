package sirma.tasks.simplephonebook;

/**
 * Utility class - validation of contacts on a phone book level.
 * 
 * @author Georgi Iliev
 *
 */
public class PhoneBookValidator {

    private PhoneBookValidator() {
    }

    /**
     * Checks whether the contact attempting to be saved overlaps with an
     * existing one by {@code name}.
     * 
     * @param name
     *            - the name of the contact candidate for entry.
     * @param book
     *            - the phone book where the contact is being saved.
     * @return TRUE if there is overlapping, FALSE if the contact`s name is
     *         unique.
     */
    protected static boolean isNotUniqueName(String name, SimplePhoneBook book) {
	for (Contact c : book.contacts) {
	    if (c.getName().equalsIgnoreCase(name) || c.getName().equalsIgnoreCase(name.trim())) {
		System.out.println("Error: A record with such name already exists!");
		return true;
	    }
	}
	return false;
    }

    /**
     * Checks whether the contact attempting to be saved overlaps with an
     * existing one by {@code phone}.
     * 
     * @param phone
     *            - the phone of the contact candidate for entry.
     * @param book
     *            - the phone book where the contact is being saved.
     * @return TRUE if there is overlapping, FALSE if the contact`s name is
     *         unique.
     */
    protected static boolean isNotUniquePhone(String phone, SimplePhoneBook book) {
	for (Contact c : book.contacts) {
	    if (c.getPhone().equalsIgnoreCase(phone) || c.getPhone().equalsIgnoreCase(phone.trim())) {
		System.out.println("Error: A record with such phone number already exists!");
		return true;
	    }
	}
	return false;
    }

}
