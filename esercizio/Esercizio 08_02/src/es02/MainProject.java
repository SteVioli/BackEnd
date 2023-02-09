package es02;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Thread1.class);
		Thread1 lista = new Thread1();
		List lista1 = new ArrayList<>();
		lista.arrayGenerato(lista1);
	}

}
