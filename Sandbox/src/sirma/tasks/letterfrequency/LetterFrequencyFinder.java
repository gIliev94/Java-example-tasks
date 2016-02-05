package sirma.tasks.letterfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Implementation that determines the frequencies of recurring characters in a
 * text input and prints out graphical representation of the tendency.
 * 
 * @author Georgi Iliev
 *
 */
public final class LetterFrequencyFinder {

    public static final int PRINT_LIMIT = 20;
    public static final int MAXIMUM_ALLOWED_HASHTAGS = 20;

    public static void main(String[] args) {

	Map<Character, Integer> charactersMap = new TreeMap<>();

	System.out.println("Input text here:");
	Scanner input = new Scanner(System.in);

	try {

	    String text = input.nextLine().toUpperCase();

	    determineFrequencies(charactersMap, text);

	    Map<Character, Integer> sortedDescMap = getSortedByValuesDescending(charactersMap);

	    System.out.println("\nMost frequent letters are:");
	    doLimitedPrinting(sortedDescMap);

	} finally {
	    input.close();
	}
    }

    private static void determineFrequencies(Map<Character, Integer> charactersMap, String text) {
	char[] characters;
	Integer frequency;
	characters = text.toCharArray();

	for (Character c : characters) {
	    frequency = charactersMap.get(c);

	    if (Character.isLetter(c)) {
		charactersMap.put(c, (frequency == null) ? 1 : frequency + 1);
	    }
	}
    }

    private static <K, V extends Comparable<? super V>> Map<Character, Integer> getSortedByValuesDescending(
	    Map<Character, Integer> map) {

	List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

	Collections.sort(list, new FrequencyDescComparator());

	map = new LinkedHashMap<>(map.size());

	for (Map.Entry<Character, Integer> entry : list) {
	    map.put(entry.getKey(), entry.getValue());
	}

	return map;
    }

    private static void doLimitedPrinting(Map<Character, Integer> outMap) {

	int printCounter = 0;
	int highestFrequency = 0;
	int currentFrequency = 0;
	int currentHashtags = 0;

	highestFrequency = outMap.values().iterator().next();

	for (Map.Entry<Character, Integer> entry : outMap.entrySet()) {

	    if (printCounter == PRINT_LIMIT) {
		break;
	    }
	    System.out.print(entry.getKey() + " " + entry.getValue() + " ");

	    currentFrequency = entry.getValue().intValue();
	    currentHashtags = (currentFrequency == highestFrequency ? MAXIMUM_ALLOWED_HASHTAGS
		    : (currentFrequency * MAXIMUM_ALLOWED_HASHTAGS) / highestFrequency);

	    for (int i = 1; i <= currentHashtags; i++) {
		System.out.print("#");
	    }
	    System.out.println();
	    printCounter++;
	}
    }

}