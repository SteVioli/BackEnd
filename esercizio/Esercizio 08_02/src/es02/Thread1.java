package es02;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Thread1 extends Thread {
	Logger log = LoggerFactory.getLogger(Thread1.class);
	static List<Integer> array = new ArrayList<Integer>();
	
	List<Integer> arrPieno;
	
	public void arrayGenerato(List<Integer> lista1) {
			for (int i = 0; i < 12; i++) {
				//Random random = new Random(101);
				lista1.add((int)(Math.random()*100+1));	
			}
			System.out.println(lista1.toString());
			arrPieno = lista1;
	}
	
	@Override
	public void run() {
		
	}

	@Override
	public String toString() {
		return "Thread1 [log=" + log + "]";
	}
	
}
