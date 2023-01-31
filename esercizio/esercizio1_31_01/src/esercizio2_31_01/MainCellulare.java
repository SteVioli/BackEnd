package esercizio2_31_01;

public class MainCellulare {

	

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub

	        Sim prova = new Sim(333333333);

	        prova.simInfo(prova);
	        System.out.println("------------------------------------");
	        prova.simRecharge(prova, 30);
	        System.out.println("------------------------------------");
	        prova.chiamate[0] = new Chiamata(1, 1);
	        prova.chiamate[4] = new Chiamata(2, 1);
	        prova.simInfo(prova);


//	        System.out.println(prova.chiamate[0]);
//	        System.out.println(prova.chiamate[1]);
//	        System.out.println(prova.chiamate[2]);
//	        System.out.println(prova.chiamate[3]);
//	        System.out.println(prova.chiamate[4]);



	    }

	}
