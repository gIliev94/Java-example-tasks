package zadacha;

public class Dokladi extends Pisma {
	
	public Dokladi(Lice podatel,String vhNomer,String text){
		super(podatel,vhNomer,text);
		if(podatel!=null){
			this.podatel=podatel;
		}else System.out.println("Zadaite validni danni!");
		if(!(podatel instanceof Slujiteli)) System.out.println("Podatelqt trqbva da e slujitel na instituciqta!");
	}
}
