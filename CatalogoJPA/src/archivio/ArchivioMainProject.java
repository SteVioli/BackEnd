package archivio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;



public class ArchivioMainProject {

	static	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoJPA");
	static	EntityManager em = emf.createEntityManager();
	public static void main(String[] args) {
		
		/*Libro l = new Libro();
		l.setAnnoPubblicazione(2010);
		l.setAutore("Stefano");
		l.setGenere("Fantasy");
		l.setNumeroPagine(100);
		l.setTitolo("Libro di Stefano");
		
		aggiungiLibroCatalogo(l);*/
		
		/*Rivista r = new Rivista();
		r.setAnnoPubblicazione(2020);
		r.setNumeroPagine(30);
		r.setPeriodicita(Periodicita.SEMESTRALE);
		r.setTitolo("Rivista EPICODE");
	
		
		aggiungiRivistaCatalogo(r);*/
		
		//Catalogo c = trovaElementoByIsbn(1);
		//System.out.println(c.getTitolo() + " con ISBN code: " + c.getIsbnCode() + " creato nel " + c.getAnnoPubblicazione());
		//cancellaElementoByIsbn(c);
		
		
		//FILTRI PER RICERCA
		List<Catalogo> lista = leggiPerIsbn(1);
		for (Catalogo catalogo : lista) {
			System.out.println("Elemento con titolo: " + catalogo.getTitolo() + " con ISBN code: " + catalogo.getIsbnCode() + " è di tipo: " + catalogo.getClass());
		}
	}
	
	
	//metodi CREAZIONE ELEMENTI
	public static void aggiungiLibroCatalogo(Libro c) {
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			System.out.println("Libro " + c.getTitolo() +" con id: " + c.getIsbnCode() + " inserito correttamente nel DB");
		}catch (Exception e) {
			em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
	}
	
	public static void aggiungiRivistaCatalogo(Rivista r) {
		try {
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
			System.out.println("Rivista " +r.getTitolo() +" con id: " + r.getIsbnCode() + " inserita correttamente nel DB");
		}catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	
	//metodi CHECK E RIMOZIONE ELEMENTI
	
	public static Catalogo trovaElementoByIsbn(long id) {		
			em.getTransaction().begin();
			Catalogo c = em.find(Catalogo.class, id);
			em.getTransaction().commit();
			return c;
	}
	
	public static void cancellaElementoByIsbn(Catalogo c) {
		try {
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		System.out.println(c.getTitolo() + " con ISBN code: " + c.getIsbnCode() + " rimosso dal DataBase");
		}catch(Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
	
	//metodi per RICERCARE ELEMENTI PER CONDIZIONE
	
	//RICERCA PER ISBN
	
	
	public static List<Catalogo> leggiPerIsbn(long id){
		Query q = em.createQuery("SELECT a FROM Catalogo a WHERE a.isbncode = :id ");
		q.setParameter("isbncode", id);
		return q.getResultList();
		
		
	}
}
