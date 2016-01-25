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

	char[] characters;
	Integer frequency;
	Map<Character, Integer> characterMap = new TreeMap<>();

	System.out.println("Input text here:");

	try (Scanner input = new Scanner(System.in)) {

	    characters = input.nextLine().toUpperCase().toCharArray();

	    for (Character c : characters) {
		frequency = characterMap.get(c);

		if (Character.isLetter(c)) {
		    characterMap.put(c, (frequency == null) ? 1 : frequency + 1);
		}
	    }

	    Map<Character, Integer> sortedMap = sortValuesDescending(characterMap);

	    System.out.println("\nMost frequent letters are:");
	    limitPrinting(sortedMap);

	} catch (NoSuchElementException nse) {
	    System.err.println("NO LINE WAS FOUND!\n");
	    nse.printStackTrace();
	} catch (IllegalStateException ise) {
	    System.err.println("THE SCANNER IS CLOSED!\n");
	    ise.printStackTrace();
	}
    }

    private static <K, V extends Comparable<? super V>> Map<Character, Integer> sortValuesDescending(
	    Map<Character, Integer> map) {
	List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

	Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
	    @Override
	    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
		return (o2.getValue()).compareTo(o1.getValue());
	    }
	});

	map = new LinkedHashMap<>();

	for (Map.Entry<Character, Integer> entry : list) {
	    map.put(entry.getKey(), entry.getValue());
	}

	return map;
    }

    private static void limitPrinting(Map<Character, Integer> outMap) {

	int printCounter = 0;
	int highestCharacterFrequency = 0;
	int currentFrequency = 0;
	int currentHashtags = 0;

	highestCharacterFrequency = outMap.values().iterator().next();

	for (Map.Entry<Character, Integer> entry : outMap.entrySet()) {

	    if (printCounter == PRINT_LIMIT) {
		break;
	    }
	    System.out.print(entry.getKey() + " " + entry.getValue() + " ");

	    currentFrequency = entry.getValue().intValue();
	    currentHashtags = (currentFrequency == highestCharacterFrequency ? MAXIMUM_HASHTAGS
		    : (currentFrequency * MAXIMUM_HASHTAGS) / highestCharacterFrequency);

	    for (int i = 1; i <= currentHashtags; i++) {
		System.out.print("#");
	    }
	    System.out.println();
	    printCounter++;
	}
    }

}
