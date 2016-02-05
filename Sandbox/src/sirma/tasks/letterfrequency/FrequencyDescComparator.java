package sirma.tasks.letterfrequency;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Comparator implementation that sorts by values(frequencies) in descending
 * order.
 * 
 * @author Georgi Iliev
 *
 */
public class FrequencyDescComparator implements Comparator<Map.Entry<Character, Integer>> {

    @Override
    public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
	return (o2.getValue()).compareTo(o1.getValue());
    }

}
