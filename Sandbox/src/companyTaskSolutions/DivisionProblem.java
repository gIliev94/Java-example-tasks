package companyTaskSolutions;

import java.util.Scanner;

public class DivisionProblem {

	public static void main(String[] args) {
		
	System.out.println("Input number here:");
	
	try(Scanner sc=new Scanner(System.in)){
		int number=sc.nextInt();	
		fizzbuzz(number);
		}

	}
	
	public static void fizzbuzz(int n){
		if((n%3==0)&&(n%5==0))System.out.print("FIZZBUZZ");
		else if(n%3==0) System.out.print("FIZZ");
		else if(n%5==0) System.out.print("BUZZ");
	}

}
