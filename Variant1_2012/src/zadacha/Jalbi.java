package zadacha;


public class Jalbi extends Pisma {
	
	String status;
	Lice slujitel;
	
	public Jalbi(Lice podatel,String vhNomer,String text,String status,Lice slujitel){
		super(podatel,vhNomer,text);
		if(podatel!=null){
			this.podatel=podatel;
		}else System.out.println("Zadaite validni danni!");
		 if(!(podatel instanceof Klienti)){
			 System.out.println("Podatelqt trqbva da e klient");
		   }
		this.status=status;
		this.slujitel=slujitel;
	}
	
	public Jalbi(Lice podatel,String vhNomer,String text,String status){
		super(podatel,vhNomer,text);
		if(podatel!=null){
			this.podatel=podatel;
		}else System.out.println("Zadaite validni danni!");
		 if(!(podatel instanceof Klienti)){
			 System.out.println("Podatelqt trqbva da e klient");
		   }
		this.status=status;
	}
}
