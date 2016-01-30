package companyTaskSolutions;

import java.util.Scanner;
import java.util.Vector;

/**
 * Problem description:
 * <p>
 * Print out as many words as possible without going over a defined limit of
 * total string length.
 * </p>
 * 
 * @author Georgi Iliev
 *
 */
public class TelegramProblem {

    private static final int LENGTH_LIMIT = 30;

    public static void main(String[] args) {
	Vector<String> lines = new Vector<>();

	Scanner input = new Scanner(System.in);
	String currentLine;

	do {
	    System.out.print("Input line( input 'S' for stop ) : ");
	    currentLine = input.nextLine();

	    if (!currentLine.equalsIgnoreCase("S")) {
		lines.addElement(currentLine);
	    }

	} while (!currentLine.equalsIgnoreCase("S"));

	input.close();

	doLimitedPrinting(lines, LENGTH_LIMIT);
    }

    public static void doLimitedPrinting(Vector<String> lines, int limit) {
	for (String line : lines) {
	    String[] totalWords = line.split(" ");
	    String telegram = "";

	    System.out.println("\n\nInput:\n" + line);

	    for (String word : totalWords) {
		if ((telegram + word).length() >= 30) {
		    System.out.println("\nAdding " + "\"" + word + "\"" + " will make it over the limit( " + limit
			    + " )... Stopping here!");
		    break;
		}
		telegram += " " + word;
	    }
	    System.out.print("\nFinal output:\n" + telegram);
	    System.out.print("\nLength: " + telegram.length());
	    System.out.print(
		    "\n-----------------------------------------------------------------------------------------------");
	}
    }
}