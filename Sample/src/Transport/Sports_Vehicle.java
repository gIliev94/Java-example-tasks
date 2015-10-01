package Transport;


import java.util.Scanner;

//Realizaciq na nasleden klas sus setteri i getteri

public class Sports_Vehicle extends Vehicles {
	 int power=0;
	 int acceleration=0;
	 
	 public Sports_Vehicle(int passengers,String brand,int power){
		 super(passengers,brand);
	 }
	 
	 public void setPower(int power){
		 this.power=power;
	 }
	 
	 public void setAcceleration(int acceleration){
		 this.acceleration=acceleration;
	 }
		public int getPower(){
			return power;
		}
		
		public int getAcceleration(){
			return acceleration;
		}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		System.out.print("Vuvedete broi na prevoznite sredstva: ");
		int numOFVehicles= input.nextInt();
		Sports_Vehicle[] arrayVehicles=new Sports_Vehicle[numOFVehicles];
		
		for(int i=0;i<arrayVehicles.length;i++){
		//Vuvejdane na stoinostite
	  		System.out.print("\nVuvedete marka: ");
	  		String brand=input.next();
		    
		    System.out.print("Vuvedete broi putnici: ");
		    int passengers=input.nextInt();    
		    
		    System.out.print("Vuvedete moshtnost: ");
		    int power=input.nextInt();
		    
			System.out.print("Vuvedete uskorenie: ");
			int acceleration=input.nextInt();
		//Prisvoqvane na stoinostite kum poletata chrez sett-eri
		arrayVehicles[i]=new Sports_Vehicle(passengers,brand,power);
		
		arrayVehicles[i].setBrand(brand);
		arrayVehicles[i].setPassengers(passengers);
		arrayVehicles[i].setPower(power);
		arrayVehicles[i].setAcceleration(acceleration);

		}
		//Namirane na prevoznoto sredstvo s nai-golqmo uskorenie
		int max=arrayVehicles[0].acceleration;
		String marka=arrayVehicles[0].getBrand();
		for(int i=0;i<arrayVehicles.length;i++)
		{
		     if (arrayVehicles[i].acceleration> max)
		     {
		      max = arrayVehicles[i].acceleration;
		      marka=arrayVehicles[i].getBrand();
		     }   
	}
	     System.out.println("\nNai-golqmo uskorenie ima \t"+ marka+ "\t i to e: " + max+"   m/s^2");
	     input.close();
}
}