package companyTaskSolutions;

import java.util.Scanner;

/**
 * Problem Description:
 * <p>
 * Determine whether a number can be divided in 3,5 or in both -> print a
 * message accordingly.
 * </p>
 * 
 * @author Georgi Iliev
 *
 */
public class DivisionProblem {

    public static void main(String[] args) {

	System.out.println("Input number here:");

	try (Scanner sc = new Scanner(System.in)) {
	    int number = sc.nextInt();

	    fizzbuzz(number);
	}

    }

    public static void fizzbuzz(int n) {
	if ((n % 3 == 0) && (n % 5 == 0))
	    System.out.print("FIZZBUZZ");
	else if (n % 3 == 0)
	    System.out.print("FIZZ");
	else if (n % 5 == 0)
	    System.out.print("BUZZ");
    }

}
