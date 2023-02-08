package es01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Es01Thread extends Thread{
	
	private String simbolo;
	Logger log = LoggerFactory.getLogger(Es01Thread.class) ;
	public Es01Thread(String simbolo) {
		super();
		this.simbolo = simbolo;
	}
	
	public void ciclo(String simbolo) {
		for (int i = 0; i <= 10; i++) {
			try {
				log.info("Numero. " + simbolo );
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		ciclo(simbolo);
	}
	
}
