package sirma.tasks.simplephonebook;

/**
 * Utility class - commonly used string values as constants.
 * 
 * @author Georgi Iliev
 *
 */
public class StringConstants {

    private StringConstants() {
    }

    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String TAB = "\t";
    public static final String LINE = System.getProperty("line.separator");

    private static final String QUOTE = "\"";

    /**
     * Quotes a text selection.
     * 
     * @param text
     * @return A quoted version of the parameter text.
     */
    public static String quote(String text) {
	return QUOTE + text + QUOTE;
    }

}