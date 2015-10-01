package Transport;

public class Vehicles {
		int passengers=0;
		String brand;
		
		public Vehicles(int passengers, String brand){
			
			this.passengers=passengers;
			this.brand=brand;
		}
		
		public int getPassengers(){
			return passengers;
		}
		
		public String getBrand(){
			return brand;
		}
		public void setPassengers(int passengers){     
			this.passengers = passengers;   
		}
		
		public void setBrand(String brand){    
			this.brand = brand;   
		}
}