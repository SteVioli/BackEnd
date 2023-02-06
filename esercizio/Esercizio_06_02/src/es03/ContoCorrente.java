package es03;

public class ContoCorrente {
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x)throws BancaException{
		try {
		if (nMovimenti < maxMovimenti)
			saldo = saldo - x;
		
			if(saldo < 0) {
				throw new BancaException("Conto in rosso!!!!"); // nuovo messaggio personalizzato
			}
			
		else {
			saldo = saldo - x - 0.50;
		}
		}//catch (BancaException e) {
			//System.out.println(e.getMessage());} // tratto la mia eccezione con il messaggio da me scelto e lo prendo tramite il metodo getMessage();
		finally {
			nMovimenti++;  //col finally , lo fa a prescindere
		}
	}

	double restituisciSaldo() {
		return saldo;
	}
}
