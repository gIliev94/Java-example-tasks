package companyTaskSolutions;

import java.util.Scanner;

public class FactorialSolutions {

    public static void main(String args[]) {
	System.out.println("Input number here!");
	Scanner sc = new Scanner(System.in);

	int num = sc.nextInt();
	int fact = 0;

	fact = factorialIterative(num);
	System.out.println("Factorial(iterative) of  " + num + "  is: " + fact);

	fact = factorialRecursive(num);
	System.out.println("Factorial(recursive) of  " + num + "  is: " + fact);

	sc.close();
    }

    public static int factorialIterative(int number) {
	int i, fact = 1;

	for (i = 1; i <= number; i++)
	    fact = fact * i;

	return fact;
    }

    public static int factorialRecursive(int number) {

	if (number == 0)
	    return 1;

	else
	    return (number * factorialRecursive(number - 1));
    }
}
