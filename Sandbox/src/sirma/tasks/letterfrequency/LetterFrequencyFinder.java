package sirma.tasks.letterfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public final class LetterFrequencyFinder {

    public static final int PRINT_LIMIT = 20;
    public static final int MAXIMUM_HASHTAGS = 20;

    public static void main(String[] args) {

	char[] charArray;
	Integer frequency;
	Map<Character, Integer> outputMap;
	Map<Character, Integer> charMap = new TreeMap<>();

	System.out.println("Input text here:");

	try (Scanner sc = new Scanner(System.in)) {

	    charArray = sc.nextLine().toUpperCase().toCharArray();

	    for (Character c : charArray) {
		frequency = charMap.get(c);

		if (Character.isLetter(c)) {
		    charMap.put(c, (frequency == null) ? 1 : frequency + 1);
		}
	    }

	    outputMap = sortValuesDescending(charMap);

	    System.out.println("\nMost frequent letters are:");
	    limitPrinting(outputMap);

	} catch (NoSuchElementException nex) {
	    System.out.println("NO LINE WAS FOUND!\n");
	    nex.printStackTrace();
	} catch (IllegalStateException iex) {
	    System.out.println("THE SCANNER IS CLOSED!\n");
	    iex.printStackTrace();
	}
    }

    private static <K, V extends Comparable<? super V>> Map<Character, Integer> sortValuesDescending(
	    Map<Character, Integer> map) {

	List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
	Map<Character, Integer> resultMap = new LinkedHashMap<>();

	Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
	    @Override
	    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
		return (o2.getValue()).compareTo(o1.getValue());
	    }
	});

	for (Map.Entry<Character, Integer> entry : list) {
	    resultMap.put(entry.getKey(), entry.getValue());
	}
	return resultMap;
    }

    private static void limitPrinting(Map<Character, Integer> outMap) {

	int printCounter = 0;
	int highestCharFrequency = 0;
	int currentFrequency = 0;
	int currentHashtags = 0;

	highestCharFrequency = outMap.values().iterator().next();

	for (Map.Entry<Character, Integer> entry : outMap.entrySet()) {

	    if (printCounter == PRINT_LIMIT) {
		break;
	    }
	    System.out.print(entry.getKey() + " " + entry.getValue() + " ");

	    currentFrequency = entry.getValue().intValue();
	    currentHashtags = (currentFrequency == highestCharFrequency ? MAXIMUM_HASHTAGS
		    : (currentFrequency * MAXIMUM_HASHTAGS) / highestCharFrequency);

	    for (int i = 1; i <= currentHashtags; i++) {
		System.out.print("#");
	    }
	    System.out.println();
	    printCounter++;
	}
    }

}
