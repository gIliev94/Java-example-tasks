package companyTaskSolutions;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Problem description:
 * <p>
 * Determine whether there is a duplicate value in an array of Integers - print
 * '0'if a duplicate is found, do nothing if .
 * </p>
 *
 * @author Georgi Iliev
 *
 */
public class ArrayValueFrequency {

    public static final int MAX = 50;
    public static final int MIN = 0;

    public static void main(String[] args) {

	int[] array = initArray();

	if (!hasDuplicates(array)) {
	    System.out.print("0");
	}
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

    private static boolean hasDuplicates(int[] arr) {

	Set<Integer> uniques = new HashSet<>();

	for (int i = 0; i < arr.length; i++) {
	    if (!uniques.add(arr[i])) {
		return true;
	    }
	}
	return false;
    }

}
