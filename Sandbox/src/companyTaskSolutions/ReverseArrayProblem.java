package companyTaskSolutions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem description:
 * <p>
 * Demonstrate easy way to reverse an array of characters.
 * </p>
 * 
 * @author Georgi Iliev
 *
 */
public class ReverseArrayProblem {

    public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.println("Input text to reverse: ");
	String text = input.nextLine();

	char[] characters = text.toCharArray();
	char[] reversed = reverseArray(characters);

	System.out.println("Reversed array: " + Arrays.toString(reversed));
	System.out.println("Reversed text: " + new String(reversed));

	input.close();
    }

    private static char[] reverseArray(char[] array) {
	char[] reversedVer = new char[array.length];
	for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
	    reversedVer[i] = array[j];
	}
	return reversedVer;
    }

}
