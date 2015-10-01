package zadacha;

public class Zaqvleniq extends Pisma{
	
	public Zaqvleniq(Lice podatel,String vhNomer,String text,String status,Lice slujitel){
		super(podatel,vhNomer,text);
		if(podatel!=null){
			this.podatel=podatel;
		}else System.out.println("Zadaite validni danni!");
	}
}
