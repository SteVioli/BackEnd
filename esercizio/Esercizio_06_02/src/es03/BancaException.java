package es03;

public class BancaException extends Exception {
	
	
	
	public BancaException(String message) {
		super(message);
	}
	@Override
	public String toString() {
		return "Nuovo valore di BancaException: " + message;
	}

	
	
	
	
}
