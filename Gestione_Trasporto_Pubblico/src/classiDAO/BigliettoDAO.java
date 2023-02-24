package classiDAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Abbonamento;
import model.Biglietto;
import utils.JpaUtils;

public class BigliettoDAO {
	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	public static Logger logger = LoggerFactory.getLogger(BigliettoDAO.class);
	
	public static void save(Biglietto b) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			
			logger.info("Biglietto salvato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	public static Biglietto findById(long id) {
		EntityManager em = emf.createEntityManager();
		try {	
			return em.find(Biglietto.class, id);
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
		
	}
	
	public static void update(Biglietto b) {
		EntityManager em = emf.createEntityManager();
		try {	
			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();
			
			logger.info("Biglietto aggiornato");
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
			Biglietto b = em.find(Biglietto.class, id);
			em.remove(b);
			em.getTransaction().commit();
			
			logger.info("Abbonamento eliminato");
		} catch (Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static Biglietto refresh(Biglietto b) {
		EntityManager em = emf.createEntityManager();
		try {
			em.refresh(b);
			return b;
		} catch (Exception err) {
			logger.error(err.getMessage());
			return null;
		} finally {
			em.close();
		}
	}
	
	public static Long bigliettiInUnPeriodoDiTempo(Date di , Date df) {
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT b FROM Biglietto b WHERE  b.dataEmissione >= :inizio AND b.dataEmissione < :fine");
			q.setParameter("inizio", di);
			q.setParameter("fine", df);
			List<Abbonamento> lista = q.getResultList();
			return (long) lista.size();
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	public static List<Long> bigliettiPerPuntoDiEmissione() {
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT COUNT(*) FROM Biglietto b GROUP BY b.puntoRilascio.idPuntoRilascio ");
			
			return q.getResultList();
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	
	public static Long bigliettiVidimatiPerPeriodoTempo(Date di, Date df) {
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT b FROM Biglietto b WHERE  b.dataEmissione >= :inizio AND b.dataEmissione < :fine AND b.vidimazione IS NOT NULL");
			q.setParameter("inizio", di);
			q.setParameter("fine", df);
			List<Abbonamento> lista = q.getResultList();
			return (long) lista.size();
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
}

