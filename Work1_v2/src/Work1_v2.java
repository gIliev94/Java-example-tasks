import java.util.Scanner;

public class Work1_v2 {
	//Overload metodi za izchislqvane na distanciqta ot dadena tochka do nachaloto na KS
	public static double distance(double x1,
            double y1)
          {
		return Math.sqrt((x1*x1)+(y1*y1));
	}
	
	public static double distance(double x1,
            double y1, double z1)
          {
		return Math.sqrt((x1*x1)+(y1*y1)+(z1*z1));
	}
	

	public static void main(String[] args) {
		// Menu
		System.out.println("Tursene na razstoqniq ot:\n     1. Ravninna tochka(x,y)\n     2. Prostranstvena tochka(x,y,z) \n");
		Scanner input = new Scanner(System.in);
		int izbor = input.nextInt();
		System.out.println("\nZadaite broi tochki, koito shte uchastvat v turseneto:");
		int n = input.nextInt();

		switch (izbor){
		
		case 1 : 
			
			double tochki[] = new double[n*2];
			//Vuvejdane na koordinatite na tochkite
			for(int i=0;i<n;i++){
				System.out.println("\nTochka "+(i+1)+" :");
				System.out.print("x = ");
				double x= input.nextDouble();
				tochki[i]= x;	
				
				System.out.print("y = ");
				double y= input.nextDouble();
				tochki[i+1]= y;
				
				//Izchislqvane na razstoqniqta chrez izvikvane na metoda sus suotvetniq broi argumenti
				System.out.println("Razstoqnieto ot tochkata"+" " +"["+x+","+y+"]"+" " +" do nachaloto na KS e:"+distance(x, y)+"\n\n");
			}
        break;
        
		case 2:
			double tochki_1[] = new double[n*3];
			
			for(int i=0;i<n;i++){
				System.out.println("Tochka "+(i+1)+" :");
				System.out.print("x = ");
				double x= input.nextDouble();
				tochki_1[i]= x;	
				
				System.out.print("y = ");
				double y= input.nextDouble();
				tochki_1[i+1]= y;
				
				System.out.print("z = ");
				double z= input.nextDouble();
				tochki_1[i+2]= z;
				
				System.out.println("Razstoqnieto ot tochkata"+" " +"["+x+","+y+","+z+"]"+" " +" do nachaloto na KS e:"+distance(x,y,z)+"\n\n");
			}
        break;
        
		default: System.out.println("Napravi validen izbor! \n");
        break;
		}
		input.close();
	}

	}

