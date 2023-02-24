package classiDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.MezzoDiTrasporto;
import utils.JpaUtils;


public class MezzoDiTrasportoDAO {
	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();	
	private static Logger logger = LoggerFactory.getLogger(MezzoDiTrasportoDAO.class);
	
	
	public static void save(MezzoDiTrasporto m) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(m);	
			em.getTransaction().commit();
			logger.info("Veicolo salvato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	public static void delete(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			MezzoDiTrasporto m = em.find(MezzoDiTrasporto.class, id);
			em.remove(m);
			em.getTransaction().commit();
			
			logger.info("Abbonamento eliminato");
		} catch (Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	public static MezzoDiTrasporto update(MezzoDiTrasporto m) {
		EntityManager em = emf.createEntityManager();
		try {
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		
		logger.info("Veicolo aggiornato");
		return m;
	}catch(Exception err) {
		logger.error(err.getMessage());
		em.getTransaction().rollback();
	}finally {
		em.close();
	}
		return null;
}
	
	public static MezzoDiTrasporto refresh(MezzoDiTrasporto m) {
		EntityManager em = emf.createEntityManager();
		try {
			em.refresh(m);
			return m;
		} catch (Exception err) {
			logger.error(err.getMessage());
			return null;
		} finally {
			em.close();
		}
	}
	
	public static MezzoDiTrasporto findById(long id) {
		EntityManager em = emf.createEntityManager();
		try{
			MezzoDiTrasporto m= em.find(MezzoDiTrasporto.class, id);
			return m;
		}catch(Exception err) {
			logger.error(err.getMessage());
		}finally {
			em.close();
		}
		return null;
	}
	
	public static Long numeroBigliettiVidimatiPerIdMezzo(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			
			Query q = em.createQuery("SELECT COUNT(*) AS c FROM Biglietto b WHERE b.parcoMezzi.idMezzoDiTrasporto = :id AND b.vidimazione IS NOT NULL");
			q.setParameter("id", id);
			return (long) q.getSingleResult();
		}catch(Exception err) {
			logger.error(err.getMessage());
		}finally {
			em.close();
		}
		
		return null;
	}
	
	public static List<Long> percorsiPerMezzo(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT COUNT(*) FROM Percorso p WHERE p.mezzoDiTrasporto.idMezzoDiTrasporto = :id GROUP BY p.tratta.idTratta ");
			q.setParameter("id", id);
			return q.getResultList();
		}catch(Exception err) {
			logger.error(err.getMessage());
		}finally {
			em.close();
		}
		
		return null;
	}
	
}
