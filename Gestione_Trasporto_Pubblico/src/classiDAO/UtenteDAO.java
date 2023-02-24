package classiDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Abbonamento;
import model.Biglietto;
import model.Utente;
import utils.JpaUtils;

public class UtenteDAO {
	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	private static Logger logger = LoggerFactory.getLogger(TrattaDAO.class);
	
	public static void save(Utente u){
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			
			logger.info("Utente salvato");
		}catch(Exception e) {
			logger.error(e.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	
	public static void update(Utente u){
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			
			logger.info("Utente aggiornato");
		}catch(Exception e) {
			em.getTransaction().rollback();
			logger.error(e.getMessage());
		}finally {
			em.close();
		}
	}
		
	public static void delete(long id){
		EntityManager em = emf.createEntityManager();
		try{
			List<Biglietto> lb = UtenteDAO.getBiglietti(id);
			for(Biglietto b: lb) {
				b.setUtente(null);
				BigliettoDAO.update(b);
			}
			
			em.getTransaction().begin();
			Utente u = em.find(Utente.class,id);
			
			Abbonamento a = u.getTessera().getAbbonamento();
			a.setTessera(null);
			AbbonamentoDAO.update(a);
			
			em.remove(u);
			em.getTransaction().commit();
			
			logger.info("Utente eliminato");
		}catch(Exception e) {
			logger.error(e.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	public static Utente findById(long id){
		EntityManager em = emf.createEntityManager();
		try {
			Utente u = em.find(Utente.class,id);
			return u;
		}catch(Exception e) {
			logger.error(e.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return null;
	}
	
	public static Utente refresh(Utente u) {
		EntityManager em = emf.createEntityManager();
		try {
			em.refresh(u);
			return u;
		}catch(Exception e) {
			logger.error(e.getMessage());			
		}finally {
			em.close();
		}
		return null;
	}
	
	public static List<Biglietto> getBiglietti(long idUtente){
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.utente.idUtente = :id");
			q.setParameter("id", idUtente);
			List<Biglietto> lista = q.getResultList();
			return lista;
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	
}
