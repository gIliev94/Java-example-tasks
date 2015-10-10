package companyTaskSolutions;

import java.util.Arrays;

public class ReverseArrayProblem {

    public static void main(String[] args) {

	char[] arr = { 'a', 'b', 'c', 'd' };

	char[] finalArr = reverseArr(arr);
	System.out.print(Arrays.toString(finalArr));

    }

    public static char[] reverseArr(char[] array) {
	char[] reversedVer = new char[array.length];
	for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
	    reversedVer[i] = array[j];
	}
	return reversedVer;
    }

}
