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

	// Initialize list values
	numbers = initList(numbers);

	// Report for all numbers
	System.out.println("\nReport for all numbers\n" + numbers);
	System.out.println("---------------------------------");
	printReport(numbers);

	// Report for multiple by 3 numbers
	dividables = findDividables(numbers, 3);
	System.out.println("\nReport for numbers dividable by 3\n" + dividables);
	System.out.println("---------------------------------");
	printReport(dividables);
    }

    private static void printReport(List<Integer> list) {
	int temp = 0;
	System.out.println("Count is: " + list.size());

	temp = calcAvg(list);
	System.out.println("Average is: " + temp);

	Collections.sort(list);

	System.out.println("Minimum is: " + list.get(0));
	System.out.println("Maximum is: " + list.get(list.size() - 1));

	System.out.println("Standart deviation is: " + calcDeviation(list, temp));
    }

    private static List<Integer> findDividables(List<Integer> list, int divider) {
	Set<Integer> dividableBy3 = new HashSet<>();

	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i) % divider == 0) {
		dividableBy3.add(list.get(i));
	    }
	}

	return new ArrayList<>(dividableBy3);
    }

    private static List<Integer> initList(List<Integer> list) {
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

	return list;
    }

    private static int calcAvg(List<Integer> list) {
	int numbersSum = 0;

	for (int i = 0; i < list.size(); i++) {
	    numbersSum += list.get(i);
	}

	return numbersSum / list.size();
    }

    private static int calcDeviation(List<Integer> list, int average) {
	int deviationSum = 0;

	for (int i = 0; i < list.size(); i++) {
	    deviationSum += Math.pow((list.get(i) - average), 2) / list.size();
	}

	return (int) Math.sqrt(deviationSum);
    }

}
