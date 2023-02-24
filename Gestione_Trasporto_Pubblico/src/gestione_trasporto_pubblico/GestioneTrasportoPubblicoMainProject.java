package gestione_trasporto_pubblico;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import classiDAO.AbbonamentoDAO;
import classiDAO.BigliettoDAO;
import classiDAO.MezzoDiTrasportoDAO;
import classiDAO.PercorsoDAO;
import classiDAO.PuntoRilascioDAO;
import classiDAO.StatoMezzoDAO;
import classiDAO.TesseraDAO;
import classiDAO.TrattaDAO;
import classiDAO.UtenteDAO;
import enums.ManutenzioneServizio;
import enums.StatoDistributoreAutomatico;
import enums.TipologiaAbbonamento;
import enums.TipologiaBiglietto;
import enums.TipologiaMezzi;
import model.Abbonamento;
import model.Biglietto;
import model.DistributoreAutomatico;
import model.MezzoDiTrasporto;
import model.Percorso;
import model.PuntoRilascio;
import model.RivenditoreAutorizzato;
import model.StatoMezzo;
import model.Tessera;
import model.Tratta;
import model.Utente;
import utils.JpaUtils;

public class GestioneTrasportoPubblicoMainProject {
	//private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
	private static Logger logger = LoggerFactory.getLogger(GestioneTrasportoPubblicoMainProject.class);

	public static void main(String[] args) {
		/*
		creaDistributore(1);
		creaRivenditore(1);
		*/
		//popolaDb();
		
		
		/*
		//Crea un lista contando il numero di volte che un mezzo percorre ongni tratta
		List<Long> listaMezzi = MezzoDiTrasportoDAO.percorsiPerMezzo(1);
		
		for(Long n : listaMezzi)
			logger.info(n.toString());
		
		//Lista numero abbonamenti venduti per punto di emissione
		List<Long> listaAbbonamenti = AbbonamentoDAO.abbonamentiPerPuntoDiEmissione();
		
		System.out.println(listaAbbonamenti);
		
		for(Long n : listaAbbonamenti)
			logger.info(n.toString());
		
		//Abbonamento scaduto
		logger.info("Abbonamento utente 1: " + AbbonamentoDAO.validitaAbbonamento(1));
		
		//Abbonamento valido
		logger.info("Abbonamento utente 3: " + AbbonamentoDAO.validitaAbbonamento(3));
		
		//Numero abbonaemnti venduti in un periodo di tempo
		Long numeriAbbonamentiDt = AbbonamentoDAO.abbonamentiInUnPeriodoDiTempo(creaData(2021, 2, 9), creaData(2023, 4, 9));
		logger.info(numeriAbbonamentiDt.toString());
		 

		//Numero biglietti vidimati in un periodo di tempo
		Biglietto b = BigliettoDAO.findById(3);
		Biglietto b2 = BigliettoDAO.findById(2);
		try {
			b.setParcoMezzi(MezzoDiTrasportoDAO.findById(3));
			b.setVidimazione(creaData(2022, 2, 13));
			BigliettoDAO.update(b);
			
			b2.setParcoMezzi(MezzoDiTrasportoDAO.findById(1));
			b2.setVidimazione(creaData(2022, 3, 13));
			BigliettoDAO.update(b2);
		} catch (Exception e) {
			logger.error("ERROR: "+ e.getMessage());
		}
		
		Long numeriBigliettiVid = BigliettoDAO.bigliettiVidimatiPerPeriodoTempo(creaData(2021, 2, 9), creaData(2023, 4, 9));
		logger.info(numeriBigliettiVid.toString());
		
		
		//numero niglietti vidimati per id mezzo(id)
		Long numeroBigliettiVidimatiPerIdMezzo = MezzoDiTrasportoDAO.numeroBigliettiVidimatiPerIdMezzo(1);
		logger.info("Numero b vidimati: " + numeroBigliettiVidimatiPerIdMezzo);
		
		//percorsi per mezzo
		List<Long> numPercorsiMezzo = MezzoDiTrasportoDAO.percorsiPerMezzo(1);
		
		System.out.println(numPercorsiMezzo);
		
		for(Long n : numPercorsiMezzo)
			logger.info(n.toString());	
		*/
	}

	public static void creaUtente(int i, String email, Date d) {
		try {
			Utente u = new Utente("Utente" + i, "Cognome" + i, email, d, "Località" + i);
			UtenteDAO.save(u);
			creaTessera(i, u);
		} catch (Exception e) {
			logger.error("ERROR: " + e.getMessage());
		}
	}

	public static void creaTessera(int i, Utente u) {
		Tessera t = new Tessera("CODICE" + i, new Date(), u);
		TesseraDAO.save(t);
	}

	public static void creaTratta(int i) {
		try {
			Tratta t = new Tratta("CittàPartenza" + i, "CittàArrivo" + i, 30 * (i+1));
			TrattaDAO.save(t);
		} catch (Exception e) {
			logger.error("ERROR: " + e.getMessage());
		}
	}

	public static void creaMezzo(int i) {
		MezzoDiTrasporto m = new MezzoDiTrasporto(30, TipologiaMezzi.AUTOBUS);
		MezzoDiTrasportoDAO.save(m);
		MezzoDiTrasportoDAO.refresh(m);
		creaStatoMezzo(m);
	}

	public static void creaStatoMezzo(MezzoDiTrasporto m) {
		StatoMezzo s = new StatoMezzo(new Date(), ManutenzioneServizio.SERVIZIO, m);
		StatoMezzoDAO.save(s);
	}

	public static void creaDistributore(int i) {
		DistributoreAutomatico d = new DistributoreAutomatico("Località" + i, StatoDistributoreAutomatico.ATTIVO);
		PuntoRilascioDAO.save(d);
		DistributoreAutomatico d1 = new DistributoreAutomatico("Località" + (i+1), StatoDistributoreAutomatico.FUORISERVIZIO);
		PuntoRilascioDAO.save(d1);
	}

	public static void creaRivenditore(int i) {
		RivenditoreAutorizzato r = new RivenditoreAutorizzato("Località" + i);
		PuntoRilascioDAO.save(r);
	}

	public static void creaBiglietto(Date dc, Date ds, long idUtente, long idPuntoRilascio, TipologiaBiglietto tipologia) {
		try {
			Biglietto b = new Biglietto(tipologia, dc, ds, UtenteDAO.findById(idUtente), PuntoRilascioDAO.findById(idPuntoRilascio));
			System.out.println(b);
			BigliettoDAO.save(b);
		} catch (Exception e) {
			logger.error("ERROR: " + e.getMessage());
		}
	}

	public static void creaAbbonamento(Date dc, Date ds, long idUtente, long idTratta, long idPuntoRilascio, TipologiaAbbonamento tipologia) {
		Abbonamento a = new Abbonamento(tipologia, dc, ds, TesseraDAO.findById(idUtente), TrattaDAO.findById(idTratta), PuntoRilascioDAO.findById(idPuntoRilascio));
		AbbonamentoDAO.save(a);
	}

	public static void creaPercorso(int tempo, long idMezzo, long idTratto, Date d) {
		try {
			Percorso p = new Percorso(tempo, MezzoDiTrasportoDAO.findById(idMezzo), TrattaDAO.findById(idTratto), d);
			PercorsoDAO.save(p);
		} catch (Exception e) {
			logger.error("ERROR: " + e.getMessage());
		}
	}

	public static Date creaData(int anno, int mese, int giorno) {
		Calendar d = Calendar.getInstance();
		d.set(anno, mese - 1, giorno);
		return d.getTime();
	}
	
	public static Date creaData(int anno, int mese, int giorno, int ore, int min) {
		Calendar d = Calendar.getInstance();
		d.set(anno, mese - 1, giorno, ore, min);
		return d.getTime();
	}
	
	public static void popolaDb() {
		for( int i = 1; i <= 10; i++) creaUtente(i,"gmail" + i + "@gmail.com", creaData((1950 + 20*i), 2*i, (4*i)));
		for( int i = 1; i <= 10; i++) creaTratta(i);
		for( int i = 1; i <= 10; i++) creaMezzo(i);
		
		creaBiglietto(creaData(2022, 2, 1), creaData(2022, 3, 2),1,1, TipologiaBiglietto.EXTRAURBANO);
		creaBiglietto(creaData(2022, 3, 2), creaData(2022, 4, 2),2,2, TipologiaBiglietto.EXTRAURBANO);
		creaBiglietto(creaData(2022, 4, 2), creaData(2022, 5, 2),3,3, TipologiaBiglietto.URBANO);
		creaBiglietto(creaData(2022, 4, 2), creaData(2022, 5, 2),4,3, TipologiaBiglietto.URBANO);
		
		creaAbbonamento(creaData(2022, 2, 9), creaData(2022, 5, 9),1,1,1, TipologiaAbbonamento.ANNUALE);
		creaAbbonamento(creaData(2022, 3, 9), creaData(2022, 6, 9),2,2,2, TipologiaAbbonamento.MENSILE);
		creaAbbonamento(creaData(2024, 4, 9), creaData(2024, 7, 9),3,3,3, TipologiaAbbonamento.SETTIMANALE);
		creaAbbonamento(creaData(2024, 4, 9), creaData(2024, 7, 9),4,3,3, TipologiaAbbonamento.SETTIMANALE);
		
		creaPercorso(20, 1, 1, creaData(2023, 4,9,15,30));
		creaPercorso(30, 1, 2, creaData(2023, 4,9,8,0));
		creaPercorso(30, 2, 1, creaData(2023, 4,9,10,30));
		creaPercorso(30, 1, 2, creaData(2023, 4,9,16,0));
	}
}
