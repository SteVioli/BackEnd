package archivio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class ArchivioMainProject {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoJPA");
	

	public static void main(String[] args) throws ParseException {
		
		//FARE UN PASSAGGIO ALLA VOLTA E COMMENTARE/DECOMMENTARE
		//FARE UN PASSAGGIO ALLA VOLTA E COMMENTARE/DECOMMENTARE
		//FARE UN PASSAGGIO ALLA VOLTA E COMMENTARE/DECOMMENTARE
		//FARE UN PASSAGGIO ALLA VOLTA E COMMENTARE/DECOMMENTARE
		//FARE UN PASSAGGIO ALLA VOLTA E COMMENTARE/DECOMMENTARE

		
		  //PROVA DATE ANNO PUBBLICAZIONE NON USARE
//		  String dateInString = "2/2/1984"; SimpleDateFormat
//		  formatter = new SimpleDateFormat("dd/MM/yyyy");
//		  l.setAnnoPubblicazione(formatter.parse(dateInString));
		 
		  // CREAZIONE ELEMENTI//CREAZIONE ELEMENTI//CREAZIONE ELEMENTI
		  // CREAZIONE ELEMENTI//CREAZIONE ELEMENTI//CREAZIONE ELEMENTI
//		  
//		 Libro l = new Libro();
//		 l.setAnnoPubblicazione(1984);
//		 l.setAutore("Stefano"); 
//		 l.setGenere("Fantasy");
//		 l.setNumeroPagine(100); 
//		 l.setTitolo("mucca");
//		 aggiungiLibroCatalogo(l);
//		 	
//		 Rivista r = new Rivista();
//		 r.setAnnoPubblicazione(2020);
//		 r.setNumeroPagine(30); 
//		 r.setPeriodicita(Periodicita.SEMESTRALE);
//		 r.setTitolo("Rivista EPICODE");
//		 aggiungiRivistaCatalogo(r);
		 

		// Catalogo c = trovaElementoByIsbn(1);
		// System.out.println(c.getTitolo() + " con ISBN code: " + c.getIsbnCode() + "
		// creato nel " + c.getAnnoPubblicazione());
		// cancellaElementoByIsbn(c);

		// CREAZIONE UTENTE

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////LANCIARE TUTTO PER RIEMPIRE DATABASE!!!!!/////////////////////////////////////////
/////////////////UTENTI, OGGETTI E PRESTITI CREATI AL FINE DI SIMULARE UNO SCENARIO PER IL METODO///////////////////////
/////////////////////////////////////trovaPrestitiScaduti() e trovaInPrestito()/////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 Utente u = new Utente();
		 u.setNome("u1"); 
		 u.setCognome("Disney");
		 u.setDataNascita(1987);
		 aggiungiUtente(u);
		 
		 Utente u1 = new Utente();
		 u1.setNome("u2"); 
		 u1.setCognome("Disney");
		 u1.setDataNascita(1987);
		 aggiungiUtente(u1);
		
		 Libro l = new Libro();
		 l.setAnnoPubblicazione(1984);
		 l.setAutore("LibroInRitardo1"); 
		 l.setGenere("Fantasy");
		 l.setNumeroPagine(100); 
		 l.setTitolo("libro01");
		 aggiungiLibroCatalogo(l);
		 Libro l1 = new Libro();
		 l1.setAnnoPubblicazione(1984);
		 l1.setAutore("Stefano"); 
		 l1.setGenere("Fantasy");
		 l1.setNumeroPagine(100); 
		 l1.setTitolo("libro02");
		 aggiungiLibroCatalogo(l1);
		 Libro l2 = new Libro();
		 l2.setAnnoPubblicazione(1984);
		 l2.setAutore("Stefano"); 
		 l2.setGenere("Fantasy");
		 l2.setNumeroPagine(100); 
		 l2.setTitolo("libro03");
		 aggiungiLibroCatalogo(l2);
		 Libro l3 = new Libro();
		 l3.setAnnoPubblicazione(1984);
		 l3.setAutore("LibroInRitardo4"); 
		 l3.setGenere("Fantasy");
		 l3.setNumeroPagine(100); 
		 l3.setTitolo("libro04");
		 aggiungiLibroCatalogo(l3);
		 Libro l4 = new Libro();
		 l4.setAnnoPubblicazione(1984);
		 l4.setAutore("Stefano"); 
		 l4.setGenere("Fantasy");
		 l4.setNumeroPagine(100); 
		 l4.setTitolo("libro05");
		 aggiungiLibroCatalogo(l4);
		 Libro l5 = new Libro();
		 l5.setAnnoPubblicazione(1984);
		 l5.setAutore("LibroInIitardo6"); 
		 l5.setGenere("Fantasy");
		 l5.setNumeroPagine(100); 
		 l5.setTitolo("libro06");
		 aggiungiLibroCatalogo(l5);
		 EntityManager em = emf.createEntityManager();
		 
		em.getTransaction().begin();
		Prestito p = new Prestito(u, l, "18-01-2023", "18-02-2023", null);
		em.merge(p);
		em.getTransaction().commit();
		em.getTransaction().begin();
		Prestito p1 = new Prestito(u, l1, "18-01-2023", "18-02-2023", "10-02-2023");
		em.merge(p1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		Prestito p2 = new Prestito(u, l2, "18-01-2023", "18-04-2023", null);
		em.merge(p2);
		em.getTransaction().commit();
		em.getTransaction().begin();
		Prestito p3 = new Prestito(u, l3, "18-01-2023", "18-02-2023", null);
		em.merge(p3);
		em.getTransaction().commit();
		em.getTransaction().begin();
		Prestito p4 = new Prestito(u1, l4, "18-01-2023", "18-03-2023", null);
		em.merge(p4);
		em.getTransaction().commit();
		em.getTransaction().begin();
		Prestito p5 = new Prestito(u1, l5, "18-01-2023", "18-02-2023", null);
		em.merge(p5);
		em.getTransaction().commit();
		
		trovaPrestitiScaduti ();
		trovaInPrestito(1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		
//		 Utente u = new Utente();
//		 u.setNome("Pippo"); 
//		 u.setCognome("Disney");
//		 u.setDataNascita(1987);
//		 aggiungiUtente(u);
		 
		
		// CREAZIONE PRESTITO
		//Impostazioni dentro il metodo
		//creaPrestito(1, 1);

		// FILTRI PER RICERCA//FILTRI PER RICERCA
		// FILTRI PER RICERCA//FILTRI PER RICERCA

		// LETTURA PER ISBN CODE - TESSERA

		
//		 List<Catalogo> lista = leggiPerIsbn(1); for (Catalogo catalogo : lista) {
//		 System.out.println("Elemento con titolo: " + catalogo.getTitolo() +
//		  " con ISBN code: " + catalogo.getIsbnCode() + " è di tipo: " +
//		  catalogo.getClass()); 
//		 }
		 

		
//		 List<Utente> ut = trovaUtente(1); for (Utente utente : ut) {
//		 System.out.println("utente trovato! :" + utente.getNome() + " " +
//		 utente.getCognome()); 
//		 }
		 

		
//		 long isbn = leggiUltimoElementoInserito();
//		 System.out.println("Ultimo codice isbn inserito all'interno del catalogo: " +isbn);
		 

		// LETTURA PER ANNO PUBBLICAZIONE
		
		

//		List<Catalogo> lista1 = leggiPerAnno(1984); 
//		for (Catalogo catalogo : lista1){ 
//		System.out.println("Elemento trovato: " + catalogo.getTitolo() +" pubblicato in data " + catalogo.getAnnoPubblicazione()); 
//		}
		 

		// LETTURA PER AUTORE

		
//		  List<Catalogo> lista2 = leggiPerAutore("Stefano");
//		  for (Catalogo catalogo :lista2) { 
//			  System.out.println("Libro trovato: " + catalogo.getTitolo() +" tramite ricerca per Autore"); 
//			  }
		 

		// LETTURA PER TITOLO

		
//		 List<Catalogo> lista3 = leggiPerTitolo("mu"); 
//		 for (Catalogo catalogo :lista3) { 
//			 System.out.println("Elemento trovato: " + catalogo.getTitolo() +" - codice ISBN: " + catalogo.getIsbnCode()); 
//			 }
		
		// LETTURA di TUTTI GLI ELEMENTI IN PRESTITO PER IL NUMERO TESSERA INSERITO
		
//		 List<Prestito> lista4 =  trovaInPrestito(1);
//		 for (Prestito prestito : lista4) {
//			System.out.println(prestito);
//		}
		
		// LETTURA PRESTITI SCADUTI e NON ANCORA RESTITUITI
		//verificare di aver inserito dati corretti nella costruzione del prestito
//		List<Prestito> lista4 =  trovaPrestitiScaduti();
//		 for (Prestito prestito : lista4) {
//			System.out.println(prestito);
//		 }
		 
		
		//METODO AGGIUNTIVO SU CHECK DEL LOCAL DATE ma FUNZIONA SU DB ma non su JAVA
		//QUESTA e' la query da java
//@NamedQuery(name = "notExpired" , query = "SELECT p FROM Prestito p WHERE p.restituzionePrevista > TO_CHAR(NOW():: DATE, 'DD-MM-YYYY');")
		//QUESTO è il search da POSTGRES
//SELECT * FROM Prestito WHERE Prestito.restituzioneprevista > TO_CHAR(NOW():: DATE, 'DD-MM-YYYY');
		//QUESTO è l'errore dato
//Cannot invoke "antlr.collections.AST.getFirstChild()" because "e_AST" is null
//		List<Prestito> lista5 = trovaPrestitiNotExpired();
//		for (Prestito prestito : lista5) {
//			System.out.println(prestito);
//		 }
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		emf.close();
	}

	////////////////////////////////////////////////////////////
	////////////////// INIZIO METODI ///////////////////////////
	////////////////////////////////////////////////////////////

	// metodi CREAZIONE ELEMENTI
	public static void aggiungiLibroCatalogo(Libro c) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			System.out.println(
					"Libro " + c.getTitolo() + " con id: " + c.getIsbnCode() + " inserito correttamente nel DB");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public static void aggiungiRivistaCatalogo(Rivista r) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
			System.out.println(
					"Rivista " + r.getTitolo() + " con id: " + r.getIsbnCode() + " inserita correttamente nel DB");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// metodo CREAZIONE UTENTE
	public static void aggiungiUtente(Utente u) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println(u.getNome() + " " + u.getCognome() + ", data di nascita: " + u.getDataNascita()
					+ ", numero di tessera: " + u.getNumeroTessera() + " aggiunto al database");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// metodo CREAZIONE PRESTITO
	// mi genero una data odierna al momento della creazione del prestito , la trasformo in stringa per poterla trattare meglio
	// la invio al database secondo il format Date, in maniera da avere effettivamente una data di tipo data sul db,
	// sucessivamente dal db tramite il select TO_DATE potrò comparare diverse String (date) tra di loro
	public static void creaPrestito(long idUtente, long isbn) throws ParseException {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			List<Utente> ulist = trovaUtente(idUtente);
			List<Catalogo> clist = leggiPerIsbn(isbn);

            Date d = Calendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String dataString = df.format(d);
            String d2 = aggiungiTrentaGiorni(dataString);
            Prestito p = new Prestito(ulist.get(0),clist.get(0));
            p.setInizioPrestito(dataString);
            p.setRestituzionePrevista(d2);
           // p.setRestituzioneEffettiva("da compilare se voglio creare una restituzione completata seguendo il metodo precedente");
           // p.setRestituzioneEffettiva("02-05-2030");
            
            System.out.println("Utente nr di tessera " + ulist.get(0).getNumeroTessera() + " ha preso in prestito oggetto ISBN " + clist.get(0).getIsbnCode());
            em.merge(p);
            em.getTransaction().commit();

        }catch(Exception e) {
            System.out.println("Errore nella richiesta del prestito");
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }

	}
	
	
	//METODO PER AGGIUNGERE 30 giorni e quindi generarmi la data di TEORICA SCADENZA
	public static String aggiungiTrentaGiorni(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        try{
           cal.setTime(sdf.parse(data));
        }catch(ParseException e){
            e.printStackTrace();
         }
        cal.add(Calendar.DAY_OF_MONTH, 30);
        String dateAfter = sdf.format(cal.getTime());
        return dateAfter;
    }

	// metodi CHECK E RIMOZIONE ELEMENTI
	
	// Metodo che mi restituisce un oggetto di tipo Catalogo al quale passo un parametro di tipo long
	// tramite il find mi trovo "visivamente" l'oggetto interessato all'interno del mio catalago
	public static Catalogo trovaElementoByIsbn(long id) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Catalogo c = em.find(Catalogo.class, id);
		em.getTransaction().commit();
		return c;
	}
	
	// Metodo per cancellare un mio elemento, ed essendo tutti di tipo Catalogo passo come parametro Catalogo c
	// tramite il remove(Catalogo c) elimino dal db esattamente l'elemento interessato, è scritto tramite BYISBN, perchè il parametro che passo 
	// è generato prima dal metodo trova elemento byIsbn, quindi è specifico
	public static void cancellaElementoByIsbn(Catalogo c) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
			System.out.println(c.getTitolo() + " con ISBN code: " + c.getIsbnCode() + " rimosso dal DataBase");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// metodi per RICERCARE ELEMENTI PER CONDIZIONE

	// RICERCA PER ISBN 2 metodi a seconda della necessità

	public static List<Catalogo> leggiPerIsbn(long id) {
		EntityManager em = emf.createEntityManager();

		try {
			Query q = em.createNamedQuery("cercaId"); //vedi query creata in Libro
			q.setParameter("isbncode", id);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public static List<Utente> trovaUtente(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createNamedQuery("cercaIdUtente"); //vedi query creata in Utente
			q.setParameter("numerotessera", id);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public static long leggiUltimoElementoInserito() {
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT MAX(a.isbncode) from Catalogo a"); //query occasionale per questo caso
		return (long) q.getSingleResult();
	}

	// RICERCA PER ANNO
	public static List<Catalogo> leggiPerAnno(Integer anno) {
		EntityManager em = emf.createEntityManager();

		try {
			Query q = em.createNamedQuery("cercaAnno");     //vedi query creata in Catalogo
			q.setParameter("annopubblicazione", anno);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	// RICERCA PER AUTORE

	public static List<Catalogo> leggiPerAutore(String autore) {
		EntityManager em = emf.createEntityManager();

		try {
			Query q = em.createNamedQuery("cercaAutore");//vedi query creata in Libro
			q.setParameter("autore", autore);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	// RICERCA PER TITOLO

	public static List<Catalogo> leggiPerTitolo(String titolo) {
		EntityManager em = emf.createEntityManager();

		try {
			String a = "%" + titolo + "%";
			Query q = em.createNamedQuery("cercaPerTitolo"); //vedi query creata in Catalogo
			q.setParameter("titolo", a);
			return q.getResultList();
		} finally {
			em.close();
		}
	}
	
	// RICERCA ELEMENTI IN PRESTITO DATO UN NUMERO DI TESSERA UTENTE
	
	public static List<Prestito> trovaInPrestito(long id) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("trovaInPrestito"); //vedi query creata in Prestito
		q.setParameter("numerotessera", id);
		System.out.println(q.getResultList());
		return q.getResultList();
	}
	
	// RICERCA DI TUTTI I PRESTITI SCADUTI E NON ANCORA RESTITUITI
	
	//questo metodo ha questa logica, faccio un search sulle date inserite,
	//mi mostra solo i prestiti che hanno una data di consegna superiore alla data di restituzione prevista
	//se nel db la restituzione è null, la intendo come se l'utente abbia ancora tempo per consegnare
	public static List<Prestito> trovaPrestitiScaduti (){
		EntityManager em = emf.createEntityManager();
		Date d = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String dataString = df.format(d);
		Query q = em.createNamedQuery("trovaPrestitoScaduto"); //vedi query creata in Prestito
		q.setParameter("data", dataString);
		System.out.println(q.getResultList());
		return q.getResultList();
	}
	
	//metodo extra per fare check sul local date ma non lo prende su java
	public static List<Prestito> trovaPrestitiNotExpired (){
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("notExpired"); //vedi query creata in Prestito
		return q.getResultList();
	}
}
