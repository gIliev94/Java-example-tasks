package zadacha;

public class Klienti extends Lice {
	
	String klNomer;
	
	public Klienti(String ime,String EGN,String klNomer){
		super(ime,EGN);
		if(ime==null) System.out.println("Nqma e posocheno lice!");
		this.ime=ime;
		this.EGN=EGN;
		this.klNomer=klNomer;
	}
}
