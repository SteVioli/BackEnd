package esercizio1_31_01;

public class mainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------");
		Rettangolo rUno = new Rettangolo(12,14);
		Rettangolo rDue = new Rettangolo(10,5);
		System.out.println("----------");
		System.out.println(rUno.stampaRettangolo(rUno));
		System.out.println("----------");
		rUno.stampaDueRettangoli(rUno,rDue);
		System.out.println("----------");
	}

}
