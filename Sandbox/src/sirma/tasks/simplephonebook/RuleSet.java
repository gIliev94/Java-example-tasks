package sirma.tasks.simplephonebook;

public class RuleSet {

    private final int NAME_CITY_MAXLENGTH = 30;
    private final int PHONE_MINLENGTH = 3;
    private final int PHONE_MAXLENGTH = 12;

    public int getNAME_CITY_MAXLENGTH() {
	return NAME_CITY_MAXLENGTH;
    }

    public int getPHONE_MINLENGTH() {
	return PHONE_MINLENGTH;
    }

    public int getPHONE_MAXLENGTH() {
	return PHONE_MAXLENGTH;
    }
}
