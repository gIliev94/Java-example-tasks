package companyTaskSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Problem description:
 * <p>
 * For a collection of integers print out a report containing the following:
 * - Total count
 * - Average value
 * - Minimum value
 * - Maximum value
 * - Standart deviation
 *
 * </p>
 * 
 * @author Georgi Iliev
 *
 */
public class NumberReportProblem {

    private static final int MAX_ADD = 20;
    private static final int MIN_ADD = 10;
    private static final int MAX_NUM = 1000;
    private static final int MIN_NUM = 1;

    public static void main(String[] args) {
	List<Integer> numbers = new ArrayList<>();
	List<Integer> dividables = new ArrayList<>();

	final int divider = 3;

	initList(numbers);

	System.out.println("\nReport for all numbers\n" + numbers);
	System.out.println("---------------------------------");
	printReport(numbers);

	dividables = findDividables(numbers, divider);
	System.out.println("\nReport for numbers dividable by " + divider + "\n" + dividables);
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
	Random random = new Random();

	int randomAdditions = random.nextInt((MAX_ADD - MIN_ADD) + 1) + MIN_ADD;
	int randomNumber = 0;

	for (int i = 0; i < randomAdditions; i++) {
	    randomNumber = random.nextInt((MAX_NUM - MIN_NUM) + 1) + MIN_NUM;
	    list.add(randomNumber);
	}
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
