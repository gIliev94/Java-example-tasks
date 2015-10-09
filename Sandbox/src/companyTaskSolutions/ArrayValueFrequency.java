package companyTaskSolutions;

import java.util.HashSet;
import java.util.Set;

public class ArrayValueFrequency {
//MEANING WHEN THERE ARE NO DUPLICATES(NEGATIVE MEANING OF FREQUENCY)
	public static void main(String[] args) {
		
		int[] array={3,4,5,6,7,10};
		
		if(hasNoDuplicates(array)) System.out.print("0");
	}

	public static boolean hasNoDuplicates(int[] arr){
		
		Set<Integer> uniques=new HashSet<>();
		
		for(int i=0;i<arr.length;i++){
			if(!uniques.add(arr[i])){
				return false;
			}
		}
		return true;
	}
	
}
