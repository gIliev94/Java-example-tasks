import java.util.Scanner;
import java.util.Arrays;

//Izchislqvane na determinanta za kvadratna matrica
public class RMK {
	
	public static double Determinanta(double matrixCopy [][]){
		return matrixCopy[0][0]*matrixCopy[1][1] - matrixCopy[0][1]*matrixCopy[1][0] ;
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double [][] matrix = new double [2][2];
		
		for (int i = 0; i < matrix.length; i++) {
		  for (int j = 0; j < matrix.length; j++) {
		          System.out.printf("matrix"+"["+i+"]"+"["+j+"]"+"=");
		          matrix[i][j] = input.nextDouble();
		  }
		}
		input.close();
		System.out.println("Matricata e: " +Arrays.deepToString(matrix));
		System.out.println("Determinantata e: " + Determinanta(matrix)) ;
	}

}
