package classiDAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Abbonamento;
import utils.JpaUtils;

public class AbbonamentoDAO {
	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	public static Logger logger = LoggerFactory.getLogger(BigliettoDAO.class);
	
	public static void save(Abbonamento a) {
		EntityManager em = emf.createEntityManager();
		try {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
		logger.info("Abbonamento salvato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	public static Abbonamento findById(long id) {
		EntityManager em = emf.createEntityManager();
		try {	
			return em.find(Abbonamento.class, id);
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
		
	}
	
	public static void update(Abbonamento a) {
		EntityManager em = emf.createEntityManager();
		try {	
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			
			logger.info("Abbonamento aggiornato");
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
			Abbonamento a = em.find(Abbonamento.class, id);
			em.remove(a);
			em.getTransaction().commit();
			
			logger.info("Abbonamento eliminato");
		} catch (Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static Abbonamento refresh(Abbonamento a) {
		EntityManager em = emf.createEntityManager();
		try {
			em.refresh(a);
			return a;
		} catch (Exception err) {
			logger.error(err.getMessage());
			return null;
		} finally {
			em.close();
		}
	}
	
	public static Long abbonamentiInUnPeriodoDiTempo(Date di , Date df) {
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT a FROM Abbonamento a WHERE  a.dataEmissione >= :inizio AND a.dataEmissione < :fine");
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
	
	public static List<Long> abbonamentiPerPuntoDiEmissione() {
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT COUNT(*) FROM Abbonamento a GROUP BY a.puntoRilascio.idPuntoRilascio ");
			
			return q.getResultList();
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	
	public static Boolean validitaAbbonamento(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			
			Query q = em.createQuery("SELECT a.dataScadenza FROM Abbonamento a WHERE a.tessera.idTessera = :id");
			q.setParameter("id", id);
			
			Date d = (Date) q.getSingleResult();
			if(d.before(new Date())) return false;
			return true;
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	
}

