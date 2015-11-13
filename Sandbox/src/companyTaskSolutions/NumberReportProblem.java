package companyTaskSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberReportProblem {

    public static void main(String[] args) {
	List<Integer> numbers = new ArrayList<>();
	List<Integer> dividables = new ArrayList<>();
	final int divider = 3;

	// Initialize list values
	initList(numbers);

	// Report for all numbers
	System.out.println("\nReport for all numbers\n" + numbers);
	System.out.println("---------------------------------");
	printReport(numbers);

	// Report for multiple by 3 numbers
	dividables = findDividables(numbers, divider);
	System.out.println("\nReport for numbers dividable by "+divider+"\n" + dividables);
	System.out.println("---------------------------------");
	printReport(dividables);
    }

    private static void printReport(List<Integer> list) {
	int average = 0;

	System.out.println("Count is: " + list.size());

	average = calculateAverage(list);
	System.out.println("Average is: " + average);

	Collections.sort(list);

	System.out.println("Minimum is: " + list.get(0));
	System.out.println("Maximum is: " + list.get(list.size() - 1));

	System.out.println("Standart deviation is: " + calculateDeviation(list, average));
    }

    private static List<Integer> findDividables(List<Integer> list, int x) {
	Set<Integer> dividableByX = new HashSet<>();

	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i) % x == 0) {
		dividableByX.add(list.get(i));
	    }
	}

	return new ArrayList<>(dividableByX);
    }
    
    private static void initList(List<Integer> list) {
	list.add(4);
	list.add(14);
	list.add(53);
	list.add(63);
	list.add(7547);
	list.add(543);
	list.add(3);
	list.add(2);
	list.add(11);
	list.add(33);
    }

    private static int calculateAverage(List<Integer> list) {
	int numbersSum = 0;

	for (int i = 0; i < list.size(); i++) {
	    numbersSum += list.get(i);
	}

	return numbersSum / list.size();
    }

    private static int calculateDeviation(List<Integer> list, int avg) {
	int deviationSum = 0;

	for (int i = 0; i < list.size(); i++) {
	    deviationSum += Math.pow((list.get(i) - avg), 2) / list.size();
	}

	return (int) Math.sqrt(deviationSum);
    }

}
