package sirma.tasks.simplephonebook;

/**
 * Utility class - validates a {@link Contact}.
 * 
 * @author Georgi Iliev
 *
 */
public class ContactValidator {

    private ContactValidator() {
    }

    /**
     * Encloses all the necessary validations a contact must pass in order to be
     * saved. If even one validation fails the contact is rejected.
     * 
     * @param contact
     * @return TRUE if <b>all</b> validations pass, FALSE if <b>even one</b>
     *         fails.
     */
    protected static boolean validate(Contact contact) {
	if (!checkForNamePhone(contact)) {
	    return false;
	}

	logPhoneErrors(contact);
	logCityErrors(contact);
	logLengthErrors(contact);

	if (!contact.errors.isEmpty()) {
	    return false;
	}

	return true;
    }

    /**
     * Validates the presence of both name and phone. If one is missing the
     * validation fails
     * 
     * @param contact
     *            - the contact that is to be validated.
     * @return TRUE if <b>both</b> name and phone are present, FALSE if
     *         <b>one</b> is missing.
     */
    private static boolean checkForNamePhone(Contact contact) {
	if (contact.getName().equals(StringConstants.EMPTY) || contact.getPhone().equals(StringConstants.EMPTY)) {
	    contact.errors.add("Error: You have to input both name and phone!");
	    return false;
	}
	return true;
    }

    /**
     * Checks for problems with the <b>format of phone number</b> and logs them
     * in the {@code errors} collection of the contact.
     * 
     * @param contact
     *            - the contact that is to be validated.
     */
    private static void logPhoneErrors(Contact contact) {
	for (Character c : contact.getPhone().toCharArray()) {
	    if (!Character.isDigit(c)) {
		contact.errors.add("Error: Phone number can contain only digits!");
		break;
	    }
	}
    }

    /**
     * Checks for problems with the <b>format of city</b> name and logs them in
     * the {@code errors} collection of the contact.
     * 
     * @param contact
     *            - the contact that is to be validated.
     */
    private static void logCityErrors(Contact contact) {
	for (Character c : contact.getCity().toCharArray()) {
	    if (!Character.isAlphabetic(c)) {
		contact.errors.add("Error: City can contain only letters!");
		break;
	    }
	}
    }

    /**
     * Checks for problems with the <b>length of name or phone number</b> and
     * logs them in the {@code errors} collection of the contact.
     * 
     * @param contact
     *            - the contact that is to be validated.
     */
    private static void logLengthErrors(Contact contact) {
	if (contact.getName().length() > RuleSet.NAME_CITY_MAXLENGTH
		|| contact.getCity().length() > RuleSet.NAME_CITY_MAXLENGTH) {
	    contact.errors.add("Error: Name or city can`t be over " + RuleSet.NAME_CITY_MAXLENGTH + " characters!");
	}

	if (contact.getPhone().length() < RuleSet.PHONE_MINLENGTH
		|| contact.getPhone().length() > RuleSet.PHONE_MAXLENGTH) {
	    contact.errors.add("Error: Phone number should be between " + RuleSet.PHONE_MINLENGTH + " and "
		    + RuleSet.PHONE_MAXLENGTH + " digits!");
	}
    }

}