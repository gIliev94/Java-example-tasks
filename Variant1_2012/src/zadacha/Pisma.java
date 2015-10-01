package zadacha;

public class Pisma {
	
	Lice podatel;
	String vhNomer;
	String text;
	
	public Pisma(Lice podatel,String vhNomer,String text){
		if(podatel!=null){
			this.podatel=podatel;
		}else System.out.println("Zadaite validni danni!");
		this.vhNomer=vhNomer;
		if(text.length()<2) System.out.println("Vuvedete minimum 100 simvola za text!");
		this.text=text;
	}
}
