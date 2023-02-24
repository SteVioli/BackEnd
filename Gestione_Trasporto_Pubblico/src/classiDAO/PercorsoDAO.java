package classiDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Percorso;
import utils.JpaUtils;

public abstract class PercorsoDAO {
	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	private static Logger logger = LoggerFactory.getLogger(PercorsoDAO.class);
	
	public static void save(Percorso p) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			
			logger.info("Percorso salvato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}
	
	public static Percorso findById(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			Percorso p = em.find(Percorso.class, id);
			return p;
		}catch(Exception err) {
			logger.error(err.getMessage());
		}finally{
			em.close();
		}
		return null;
	}
	
	public static void delete(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Percorso p = em.find(Percorso.class, id);
			em.remove(p);
			em.getTransaction().commit();
			
			logger.info("Abbonamento eliminato");
		} catch (Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void update(Percorso p) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			
			logger.info("Percorso aggiornato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}
	
	public static Percorso refresh(Percorso p) {
		EntityManager em = emf.createEntityManager();
		try {
			em.refresh(p);
			return p;
		}catch(Exception err) {
			logger.error(err.getMessage());
		}finally{
			em.close();
		}
		return null;
	}
}
