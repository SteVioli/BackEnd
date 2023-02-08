package es01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MainProject {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Es01Thread.class) ;
		log.info("ciao");
		
		Es01Thread es = new Es01Thread("*");
		Es01Thread es1 = new Es01Thread("#");
		
		es.run();
		es1.run();
	}
	
}
