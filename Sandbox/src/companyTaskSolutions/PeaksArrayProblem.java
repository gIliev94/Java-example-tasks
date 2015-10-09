package companyTaskSolutions;

public class PeaksArrayProblem {

	public static void main(String[] args) {
		
	int[] arr = {6,1,2,3,2,1};
	
	printPeaksOnly(arr);
	
	}
	
	public static void printPeaksOnly(int[] array){
	int notPeak=0;
		for(int i=0;i<array.length;i++){
		notPeak=0;
			for(int j=i+1;j<array.length;j++){
				if(array[i]<array[j]) notPeak=1;
			}
		if(notPeak==0) System.out.println("Value "+ array[i] +" is peak!");
		}
	}
}
