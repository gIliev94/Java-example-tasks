package zadacha;

//Kratka realizaciq na obekti i nasledqvaniq

public class MainProgram {
	 public static void main(String[]args){
	 Slujiteli sluj=new Slujiteli("Ivan","123","poz1");
	  Klienti kli=new Klienti("Lili","222","344");
	  Dokladi dokl=new Dokladi(sluj,"1234","xmpl");
	  Jalbi jal=new Jalbi(kli,"100","Kobe","Da",sluj);
	  
	  System.out.println("Podatel na doklad: "+dokl.podatel.ime);
	  System.out.println("Vh nomer na doklad: "+dokl.vhNomer);
	  System.out.println("Sudurjanie na doklada: "+dokl.text);
	  System.out.println("Status na jalba(Podadena - DA/NE): "+jal.status);
	  System.out.println("Jalbata e podadena ot "+jal.podatel.ime+" kum  "+jal.slujitel.ime);
	 }
}
