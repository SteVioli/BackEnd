package classiDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Abbonamento;
import model.Biglietto;
import model.PuntoRilascio;

import utils.JpaUtils;

public abstract class PuntoRilascioDAO {
	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	private static Logger logger = LoggerFactory.getLogger(PuntoRilascioDAO.class);
		
	public static void save(PuntoRilascio ra) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(ra);
			em.getTransaction().commit();
			
			logger.info("Punto di rilascio salvato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}
	
	public static PuntoRilascio findById(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			PuntoRilascio ra = em.find(PuntoRilascio.class, id);	
			return ra;
		}catch(Exception err) {
			logger.error("Errore find");
			return null;	
		}finally{
			em.close();
		}
	}
	
	public static void delete(long id) {
		EntityManager em = emf.createEntityManager();
		try {
			List<Biglietto> lb = getBiglietti(id);
			for(Biglietto b: lb) {
				b.setPuntoRilascio(null);
				BigliettoDAO.update(b);
			}
			
			List<Abbonamento> la = getAbbonamenti(id);
			for(Abbonamento a: la) {
				a.setPuntoRilascio(null);
				AbbonamentoDAO.update(a);
			}
			
			em.getTransaction().begin();
			PuntoRilascio ra = em.find(PuntoRilascio.class, id);
			em.remove(ra);
			em.getTransaction().commit();
			
			logger.info("Punto di rilascio eliminato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}
	
	public static void update(PuntoRilascio ra) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(ra);
			em.getTransaction().commit();
			
			logger.info("Punto di rilascio aggiornato");
		}catch(Exception err) {
			logger.error(err.getMessage());
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}
	
	public static PuntoRilascio refresh(PuntoRilascio ra) {
		EntityManager em = emf.createEntityManager();
		try {
			em.refresh(ra);
			return ra;	
		}catch(Exception err) {
			logger.error(err.getMessage());
		}finally{
			em.close();
		}
		return null;
	}
	
	public static List<Biglietto> getBiglietti(long idPuntoRilascio){
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.puntoRilascio.idPuntoRilascio = :id");
			q.setParameter("id", idPuntoRilascio);
			List<Biglietto> lista = q.getResultList();
			return lista;
		}catch(Exception err) {
			logger.error(err.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	
	public static List<Abbonamento> getAbbonamenti(long idPuntoRilascio){
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("SELECT a FROM Abbonamento a WHERE a.puntoRilascio.idPuntoRilascio = :id");
			q.setParameter("id", idPuntoRilascio);
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
