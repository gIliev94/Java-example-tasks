package companyTaskSolutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class LetterFrequency {
	
	private static final int LIMIT=20;
	private static final int MAXIMUM_LENGTH=20;
	private static int LARGEST_LENGTH=0;
	
    public static void main(String[] args) {
    	
    Map<Character,Integer> charmap = new HashMap<>();
    
    System.out.println("Input text here:");
        
    try( Scanner sc = new Scanner(System.in) )
    { 	
 
    char[] chArray=sc.nextLine().toUpperCase().toCharArray();
        	
        for (Character c : chArray) 
        {
            Integer frequency = charmap.get(c);
            if(Character.isLetter(c)) charmap.put(c, (frequency == null) ? 1 : frequency + 1);
        }
       
    Map<Character, Integer> outputMap = sortMapByValues(charmap);
    
    Set<Character> chSet=outputMap.keySet();
    Character c=chSet.iterator().next();
    System.out.println("Curr value: "+c);
    
    //make a method isLargest to determine if it really is sorted
    LARGEST_LENGTH=outputMap.values().iterator().next();
    
    System.out.println("Length: "+LARGEST_LENGTH);
    
    System.out.println("Most frequent letters are:");
    limitedPrint(outputMap);
        
    }catch(NoSuchElementException nex){
        System.out.println("NO LINE WAS FOUND!\n");
        nex.printStackTrace(); 	
    } catch(IllegalStateException iex){
    	System.out.println("THE SCANNER IS CLOSED!\n");
        iex.printStackTrace();
        }
    
    }
    
    private static <K, V extends Comparable<? super V>>  Map<Character, Integer>  sortMapByValues( Map<Character, Integer> map ){
    	
        List<Map.Entry<Character, Integer>> list = new LinkedList<>( map.entrySet() );
        Map<Character, Integer> result = new LinkedHashMap<>();
        
        Collections.sort( list, new Comparator<Map.Entry<Character, Integer>>()
        {
            @Override
            public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue());
            }
        } );
        
        for (Map.Entry<Character, Integer> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
    	return result;
    }
    
    private static void limitedPrint(Map<Character, Integer> outMap){
    	 int printCounter=0;

         for (Map.Entry<Character, Integer> entry : outMap.entrySet()) 
         {
         	if(printCounter==LIMIT) break;
         	System.out.print(entry.getKey() + " " + entry.getValue()+" ");
         	
         	
         	int currentValue=entry.getValue().intValue();
         	for(int j=0;j<=(currentValue==LARGEST_LENGTH ? MAXIMUM_LENGTH : (currentValue*MAXIMUM_LENGTH)/LARGEST_LENGTH);j++) {
         			System.out.print("#");
         	}
         
         	System.out.println();	
             printCounter++;
         }
    }
    
}
