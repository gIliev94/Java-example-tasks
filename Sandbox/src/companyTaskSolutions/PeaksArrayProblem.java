package companyTaskSolutions;

import java.util.Random;

/**
 * Problem description:
 * <p>
 * Print out all the peak values in an array. Peak value is defined as - greater
 * then the all the values with bigger indexes.
 * </p>
 * 
 * @author Georgi Iliev
 *
 */
public class PeaksArrayProblem {

    public static final int MAX = 20;
    public static final int MIN = 0;

    public static void main(String[] args) {

	int[] arr = initArray();

	printPeaksOnly(arr);

    }

    private static int[] initArray() {
	Random random = new Random();

	int randomLenght = random.nextInt((MAX - MIN) + 1) + MIN;
	int[] arr = new int[randomLenght];

	int randomNumber = 0;

	for (int i = 0; i < arr.length; i++) {
	    randomNumber = random.nextInt((MAX - MIN) + 1) + MIN;
	    arr[i] = randomNumber;
	}

	return arr;
    }

    public static void printPeaksOnly(int[] array) {
	int notPeak = 0;

	for (int i = 0; i < array.length; i++) {
	    notPeak = 0;
	    for (int j = i + 1; j < array.length; j++) {
		if (array[i] < array[j])
		    notPeak = 1;
	    }
	    if (notPeak == 0)
		System.out.println("Value " + array[i] + " is peak!");
	}
    }
}
