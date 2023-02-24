package classiDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Tessera;
import utils.JpaUtils;



public class TesseraDAO {
private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

private static Logger logger = LoggerFactory.getLogger(TesseraDAO.class);

public static void save(Tessera t) {
	EntityManager em = emf.createEntityManager();
	try {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
		logger.info("Tessera salvato");
	}catch(Exception err) {
		logger.info(err.getMessage());
		em.getTransaction().rollback();

	}finally {
		em.close();
	
	}
}


public static void delete( long id) {
	EntityManager em = emf.createEntityManager();
	try {
		em.getTransaction().begin();
		Tessera td = em.find(Tessera.class, id);
		em.remove(td);
		em.getTransaction().commit();
	
		logger.info("Tessera eliminata");
	}catch(Exception err) {
		logger.info(err.getMessage());
		em.getTransaction().rollback();
	}finally {
		em.close();
	}
}




public static void update( Tessera t) {
EntityManager em = emf.createEntityManager();
try {
	em.getTransaction().begin();
	em.merge(t);
	em.getTransaction().commit();
	
	logger.info("Tessera aggiornato");
}catch(Exception err) {
	logger.info(err.getMessage());
	em.getTransaction().rollback();
}finally {
	em.close();
}
}



public static Tessera findById(long id) {
EntityManager em = emf.createEntityManager();
try {
	Tessera td = em.find(Tessera.class, id);
	 return td;
}catch(Exception err) {
	logger.info(err.getMessage());
}finally {
	em.close();
}

return null;
}

public static void refresh( Tessera s) {
EntityManager em = emf.createEntityManager();
try {
	em.refresh(s);
}catch(Exception err) {
	logger.info(err.getMessage());
}finally {
	em.close();
}}














}
