package classiDAO;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.JpaUtils;
import model.StatoMezzo;

public class StatoMezzoDAO {
private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

private static Logger logger = LoggerFactory.getLogger(StatoMezzoDAO.class);

public static void save(StatoMezzo s) {
	EntityManager em = emf.createEntityManager();
	try {
	
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
		logger.info("Stato veicolo salvato");
	}catch(Exception err) {
		logger.info(err.getMessage());
		em.getTransaction().rollback();

	}finally {
	em.close();
	
	}
}


public static void delete(long id) {
	EntityManager em = emf.createEntityManager();
	try {
		em.getTransaction().begin();
		StatoMezzo s = em.find(StatoMezzo.class, id);
		em.remove(s);
		em.getTransaction().commit();
		
		logger.info("Abbonamento eliminato");
	} catch (Exception err) {
		logger.error(err.getMessage());
		em.getTransaction().rollback();
	} finally {
		em.close();
	}
}



public static void update( StatoMezzo s) {
EntityManager em = emf.createEntityManager();
try {
	em.getTransaction().begin();
	em.merge(s);
	em.getTransaction().commit();
	
	logger.info("Stato veicolo aggiornato");
}catch(Exception err) {
	logger.info(err.getMessage());
	em.getTransaction().rollback();
}finally {
	em.close();
}}



public static StatoMezzo findById(long id) {
EntityManager em = emf.createEntityManager();
try {
	 StatoMezzo sm = em.find(StatoMezzo.class, id);
	 return sm;
}catch(Exception err) {
	logger.info(err.getMessage());
	
}finally {
	em.close();}

return null;
}


public static void refresh( StatoMezzo s) {
EntityManager em = emf.createEntityManager();
try {
	em.getTransaction().begin();
	em.refresh(s);
	em.getTransaction().commit();
}catch(Exception err) {
	logger.info(err.getMessage());
	em.getTransaction().rollback();
}finally {
	em.close();
}}













}
