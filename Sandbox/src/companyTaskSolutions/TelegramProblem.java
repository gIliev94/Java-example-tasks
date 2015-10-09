package companyTaskSolutions;

public class TelegramProblem {
	/***
	THE IDEA IS TO PRINT AS MANY WORDS AS POSSIBLE WITHOUT GOING OVER A LIMIT FOR LENGTH OF TOTAL STRING
	 */
	public static void main(String[] args) {
		//FOR MULTIPLE LINES
		String[] veryLines={"I am noob public speaker and persecutor","There is really no explanation at all","What is done cannot be undone"};
		printLimited(veryLines,30);
		//*/
	}

	public static void printLimited(String[] lines, int limit){
		for(String line:lines){
		String[] res=line.split(" ");
		String finalOutput="";
		
		System.out.println("\n\nInput:\n"+line);
		
			for(String test:res){		
				if((finalOutput+test).length()>=30) {
					System.out.println("\nAdding "+"\""+test+"\""+" will make it over the limit( "+limit+" )... Stopping here!");
					break;
					}
				finalOutput+=" "+test;
			}	
			System.out.print("\nFinal output:\n"+finalOutput);
			System.out.print("\nLength: "+finalOutput.length());
			System.out.print("\n-----------------------------------------------------------------------------------------------");
		}
	}
}