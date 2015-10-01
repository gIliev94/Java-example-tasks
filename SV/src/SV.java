import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Demonstraciq na rabota s file - Izchislqvane na perimetur na chetiriugulnik ot razstoqniq mejdu tochki sus zadadeni koordinati
public class SV {

	public static int distance(int x1,
            int y1,int x2,int y2)
                  {
		return (int)Math.sqrt((x2 - x1)*(x2 - x1)+ (y2 - y1)*(y2 - y1));
	}
	
	public static void main(String[] args) {
		File file = new File("polygon.txt");
		Scanner fileReader=null;
		try {
		fileReader = new Scanner(file);
		int coordinates[] = new int [10];
		int i = 0;
	
		while(fileReader.hasNextInt()){
			coordinates[i]= fileReader.nextInt();
			i++;
		}
		
		int strana1= distance(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		int strana2= distance(coordinates[2],coordinates[3],coordinates[4],coordinates[5]);
		int strana3= distance(coordinates[4],coordinates[5],coordinates[6],coordinates[7]);
		int strana4= distance(coordinates[6],coordinates[7],coordinates[8],coordinates[9]);
		
		int Perimeter= strana1+strana2+strana3+strana4;
		
		System.out.println("Perimetura e:"+Perimeter);
		}	
		catch (FileNotFoundException fnf) {

		    System.out.println("File not found.");
		}
		fileReader.close();
	}
		
		
}

