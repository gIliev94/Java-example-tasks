package sirma.tasks.simplephonebook;

//Ideqta e da ne se meshat s poletata v drugite klasove, zatova da sa na otdelen
public class RuleSet {
    private final int NAME_CITY_MAXLENGTH = 30;
    private final int PHONE_MINLENGTH = 3;
    private final int PHONE_MAXLENGTH = 12;

    // A ideqta da sa private s public getteri e za da moje da se pravi promqna
    // ako se naloji: - t.e. na returna se promenq primerno +2 da e konstantata
    // i pak bachka bez rekompilirane na klasovete... samo sus Save-ne na toq za
    // da vlqzat v deistvie promenite na getterite
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
