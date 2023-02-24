package classiDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Abbonamento;
import model.Tratta;
import utils.JpaUtils;

public class TrattaDAO {
	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	private static Logger logger = LoggerFactory.getLogger(TrattaDAO.class);
	
	public static void save(Tratta t){
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			
			logger.info("Tratta salvato");
		}catch(Exception e) {
			logger.error(e.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	
	public static void update(Tratta t){
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			
			logger.info("Tratta aggiornata");
		}catch(Exception e) {
			em.getTransaction().rollback();
			logger.error(e.getMessage());
		}finally {
			em.close();
		}
	}
		
	public static void delete(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			
			List<Abbonamento> la = getAbbonamenti(id);
			for(Abbonamento a: la) {
				a.setTratta(null);
				AbbonamentoDAO.update(a);
			}
			
			em.getTransaction().begin();
			Tratta t = em.find(Tratta.class, id);
			em.remove(t);
			em.getTransaction().commit();
			
			logger.info("Abbonamento eliminato");
		} catch (Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static Tratta findById(long id){
		EntityManager em = emf.createEntityManager();
		try {
			Tratta t = em.find(Tratta.class,id);
			return t;
		}catch(Exception e) {
			logger.error(e.getMessage());			
		}finally {
			em.close();
		}
		return null;
	}
	
	public static Tratta refresh(Tratta t) {
		EntityManager em = emf.createEntityManager();
		try {
			em.refresh(t);
			return t;
		}catch(Exception e) {
			logger.error(e.getMessage());			
		}finally {
			em.close();
		}
		return null;
	}
	
	public static List<Abbonamento> getAbbonamenti(long idTratta){
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT a FROM Abbonamento a WHERE a.tratta.idTratta = :id");
			q.setParameter("id", idTratta);
			List<Abbonamento> lista = q.getResultList();
			return lista;
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	
}
