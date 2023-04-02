package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Dao.ElementoCatDao;
import Dao.PrestitoDao;
import Dao.UtenteDao;
import model.ElementoCatalogo;
import model.Libro;
import model.Prestito;
import model.Rivista;
import model.Utente;
import utils.JpaUtil;
import utils.Periodicita;

public class MyMain {
	
	public static void main(String[] args) {
		System.out.println("start");
		//creazioni Elementi del catalogo: 
		ElementoCatalogo el1 = new Libro("Librotitolo", 2000, 2120, "autore1", "genere1");
		ElementoCatalogo el2 = new Libro("Librotitolo2", 2020, 1120, "autore2","genere2");
		ElementoCatalogo el3 = new Rivista("Rivistatitolo1", 1999, 200, Periodicita.MENSILE);
		ElementoCatalogo el4 = new Rivista("Rivistatitolo2", 2001, 10, Periodicita.SETTIMANALE);
		ElementoCatalogo el5 = new Rivista("Rivistatitolo3", 2002, 50, Periodicita.SEMESTRALE);
		//creazione Utenti
		Utente c = new Utente("Mario", "Rossi", LocalDate.of(1990, 1, 1), 1234l);
		Utente e = new Utente("Luca", "Rossi", LocalDate.of(1992, 1, 1), 2345l);
		Utente d = new Utente("Stefano", "Rossi", LocalDate.of(1993, 1, 1), 3456l);
		//creazione istanze per usare i metodi:
		ElementoCatDao elementoCatalogoDao = new ElementoCatDao();
		UtenteDao utentedao = new UtenteDao();
		PrestitoDao prestitodao = new PrestitoDao();
		//salvatoaggio elemnti del catalogo:
//		elementoCatalogoDao.salva(el1);
//		elementoCatalogoDao.salva(el2);
//		elementoCatalogoDao.salva(el3);
//		elementoCatalogoDao.salva(el4);
//		elementoCatalogoDao.salva(el5);
		
		//salvataggio utenti:
//		utentedao.salva(c);
//		utentedao.salva(e);
//		utentedao.salva(d);
		
		//Lettura utenti per costruire prestito
		Utente letto1 =utentedao.getById(1);
		Utente letto2 = utentedao.getById(2);
		Utente letto3 = utentedao.getById(3);
		//lettura elCatalogo per costruire prestito
		ElementoCatalogo lettoC1 = elementoCatalogoDao.getByISBM(1);
		ElementoCatalogo lettoC2 = elementoCatalogoDao.getByISBM(2);
		ElementoCatalogo lettoC3 = elementoCatalogoDao.getByISBM(3);
		ElementoCatalogo lettoC4 = elementoCatalogoDao.getByISBM(4);
	
        // costruzione prestiti:
		Prestito p = new Prestito(letto2,lettoC1,LocalDate.of(2022, 1, 1),LocalDate.of(2020, 1, 20));
		Prestito p1 = new Prestito(letto3,lettoC1,LocalDate.of(2023, 1, 1),LocalDate.of(2021, 2, 20));
		Prestito p2 = new Prestito(letto1,lettoC4,LocalDate.of(2019, 1, 1),LocalDate.of(2022, 4, 20));
		Prestito p3 = new Prestito(letto1,lettoC4,LocalDate.of(2019, 1, 1),LocalDate.of(2022, 4, 20));
        // salvataggio prestiti:
//		prestitodao.salva(p);
//		prestitodao.salva(p1);
//		prestitodao.salva(p2);
//		prestitodao.salva(p3);
		
		
        // Visualizzazione in console dei vari metodi:
		//la maggiorparte dei metodi ritornato una lista o un elemento per semplicita di visualizzazione
		// li ho stampati direttamente
		System.out.println("\n\t trova tutti gli elementi nel catalogo:");
		System.out.println(elementoCatalogoDao.findAll());
		System.out.println("\n\t ricerca per anno:");
		System.out.println(elementoCatalogoDao.cercaPerAnno(2000));
		System.out.println("\n\t ricerca per autore: -- (autore1)");
		System.out.println(elementoCatalogoDao.cercaPerAutore("autore1"));
		System.out.println("\n\t ricerca per autore: -- (autore2):");
		System.out.println(elementoCatalogoDao.cercaPerAutore("autore2"));
		System.out.println("\n\t ricerca per titolo: -- (tit)");
		System.out.println(elementoCatalogoDao.cercaPerTitolo("tit"));
		System.out.println("\n\t ricerca per titolo: -- (lib)");
		System.out.println(elementoCatalogoDao.cercaPerTitolo("lib"));
		System.out.println("\n\t ricerca per titolo: -- (Riv)");
		System.out.println(elementoCatalogoDao.cercaPerTitolo("Riv"));
		System.out.println("\n\t ricerca prestiti scaduti");
		System.out.println(prestitodao.findExpired());
		System.out.println("\n\t ricerca prestito in base alla tessera del utente: ");
		System.out.println(prestitodao.findByTessera(1234l));
	}

}
