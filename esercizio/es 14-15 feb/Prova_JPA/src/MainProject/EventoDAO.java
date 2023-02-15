package MainProject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Evento;
import model.TipoEvento;



public class EventoDAO {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prova_JPA");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
	
	try {
		//List<Evento> listaEvento = refresh();
		
		Evento e = new Evento();
		e.setTitoloEvento("Evento numero 1");
		e.setDescrizioneEvento("Descrizione 1");
		e.setTipoEvento(TipoEvento.PRIVATO);
		e.setDataEvento("18-02-2022");
		e.setMaxpplEvento(10);
		
		Evento e1 = new Evento();
		e1.setTitoloEvento("Evento numero 2");
		e1.setDescrizioneEvento("Descrizione 2");
		e1.setTipoEvento(TipoEvento.PUBBLICO);
		e1.setDataEvento("01-01-2020");
		e1.setMaxpplEvento(5);
		
		//save(e1);
		//System.out.println(getById(2));
		Evento utDaCancellare = getById(2);
		delete(utDaCancellare);
		//System.out.println(refresh());
		}catch(Exception e) {
			
		}finally {
			em.close();
			emf.close();
		}
	}
	
	private static void save(Evento e){
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Evento aggiunto al database");
	};
	
	private static Evento getById(int id) {
		em.getTransaction().begin();
		Evento e = em.find(Evento.class, id);
		em.getTransaction().commit();
		return e;
	};
	
	private static void delete(Evento e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Evento Eliminato dal database");
	};
	
	private static List<Evento> refresh() {
		Query q = em.createNamedQuery("Evento.findAll");
		return q.getResultList();
		
	}
}
