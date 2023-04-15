package it.prova.gestioneordiniarticolicategorie.test;

import java.time.LocalDate;
import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;
import it.prova.gestioneordiniarticolicategorie.service.ArticoloService;
import it.prova.gestioneordiniarticolicategorie.service.CategoriaService;
import it.prova.gestioneordiniarticolicategorie.service.MyServiceFactory;
import it.prova.gestioneordiniarticolicategorie.service.OrdineService;

public class MyTest {
	public static void main(String[] args) {
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance= MyServiceFactory.getCategoriaServiceInstance();
		
		try {
			
//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");
//			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAll().size()+ " elementi.");
			
			System.out.println("++++++++++++ INIZIO BATTERIA DI TEST +++++++++++++++");
			
//			testInserisciNuovoOrdine(ordineServiceInstance);
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAll().size()+ " elementi.");
			
//			testAggiornaOrdine(ordineServiceInstance);
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAll().size()+ " elementi.");

//			testInserisciNuovoArticolo(articoloServiceInstance, ordineServiceInstance);
//			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");
			
//			testAggiornaArticolo(articoloServiceInstance);
//			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");
			
//			testInserisciNuovaCategoria(categoriaServiceInstance);
//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");
			
//			testAggiornaCategoria(categoriaServiceInstance);
//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");
			
//			testRimuoviArticoloCollegatoAOrdine(articoloServiceInstance, ordineServiceInstance);
//			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");
			
			testAggiungiArticoloACategoria(categoriaServiceInstance, articoloServiceInstance, ordineServiceInstance);
			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");

			
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}
	
	//
	private static void testInserisciNuovoOrdine (OrdineService ordineServiceInstance) throws Exception{
		System.out.println(".......testInserisciNuovoOrdine inizio.............");

		Ordine ordineInstance = new Ordine("via Piave 3", "Alice Bianchi", LocalDate.of(2020, 11, 12), LocalDate.of(2020, 11, 13));
		ordineServiceInstance.inserisciNuovo(ordineInstance);
		if (ordineInstance.getId() == null)
			throw new RuntimeException("testInserisciNuovoOrdine fallito ");

		System.out.println(".......testInserisciNuovoOrdine fine.............");
	}
	
	
	//
	private static void testAggiornaOrdine (OrdineService ordineServiceInstance) throws Exception{
		System.out.println(".......testAggiornaOrdine inizio.......");
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size() < 1)
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		Ordine ordineDaAggiornare = listaOrdini.get(0);
		ordineDaAggiornare.setNomeDestinatario("Maria Rossi");;
		ordineServiceInstance.aggiorna(ordineDaAggiornare);
		System.out.println(ordineDaAggiornare);
		System.out.println(".......testAggiornaOrdine fine.......");
	}
	
	//
	private static void testInserisciNuovoArticolo (ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception{
		System.out.println(".......testInserisciNuovoArticolo inizio.............");

		Ordine ordineDaCollegare = new Ordine("via torino 33", "Carla Carli", LocalDate.of(2023, 04, 10),LocalDate.of(2023, 05, 15));
		ordineServiceInstance.inserisciNuovo(ordineDaCollegare);
		Long idOrdineDaCollegare = ordineDaCollegare.getId();
		if (idOrdineDaCollegare == null) {
			throw new RuntimeException("testInserimentoNuovoArticolo FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("maglione", "46362", 50, LocalDate.of(2022,8, 10));
		nuovoArticolo.setOrdine(ordineDaCollegare);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testInserimentoNuovoArticolo FALLITO: Articolo non inserito");
		}
		if (!nuovoArticolo.getOrdine().getId().equals(idOrdineDaCollegare)) {
			throw new RuntimeException("testInserimentoNuovoArticolo FALLITO: L'ID dell'ordine non corrisponde");
		}

		System.out.println(".......testInserisciNuovoArticolo fine.............");
	}
	
	//
	private static void testAggiornaArticolo(ArticoloService articoloServiceInstance) throws Exception{
		System.out.println(".......testAggiornaArticolo inizio.......");
		List<Articolo> listaArticoli = articoloServiceInstance.listAll();
		if (listaArticoli.size() < 1)
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		Articolo articoloDaAggiornare = listaArticoli.get(0);
		articoloDaAggiornare.setDescrizione("sciarpa");
		articoloServiceInstance.aggiorna(articoloDaAggiornare);
		
		
		Articolo articoloRicaricato= articoloServiceInstance.caricaSingoloElemento(articoloDaAggiornare.getId());
		if (articoloRicaricato.getId() != articoloDaAggiornare.getId()) {
			throw new RuntimeException("errore: update non avvenuto.");
		}
		System.out.println(".......testAggiornaArticolo fine.......");
	}
	
	//
	public static void testInserisciNuovaCategoria (CategoriaService categoriaServiceInstance) throws Exception{
		System.out.println(".......testInserisciNuovaCategoria inizio.............");

		Categoria categoriaInstance = new Categoria("ACC", "accessori");
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		if (categoriaInstance.getId() == null)
			throw new RuntimeException("testInserisciNuovaCategoria fallito: non è stata inserita la nuova categoria.");

		System.out.println(".......testInserisciNuovaCategoria fine.............");
	}
	
	//
	private static void testAggiornaCategoria (CategoriaService categoriaServiceInstance) throws Exception{
		System.out.println(".......testAggiornaCategoria inizio.......");
		List<Categoria> listaCategorie = categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size() < 1)
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		Categoria categoriaDaAggiornare = listaCategorie.get(0);
		categoriaDaAggiornare.setCodice("CAS");
		categoriaServiceInstance.aggiorna(categoriaDaAggiornare);
		Categoria categoriaRicaricata= categoriaServiceInstance.caricaSingoloElemento(categoriaDaAggiornare.getId());
		if (categoriaRicaricata.getId() != categoriaDaAggiornare.getId()) {
			throw new RuntimeException ("errore: non è stato effettuato l'update.");
		}
		
		System.out.println(categoriaDaAggiornare);
		 
		System.out.println(".......testAggiornaCategoria fine.......");
	}	
	
	//
	private static void testRimuoviArticoloCollegatoAOrdine(ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception{
		System.out.println(".......testRimuoviArticolo inizio.......");
		List<Articolo> listaArticoli= articoloServiceInstance.listAll();
		if (listaArticoli.size()<1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}
		
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size() < 1)
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		
		Ordine ordineDaCollegare= listaOrdini.get(0);
		Long idOrdineDaCollegare= ordineDaCollegare.getId();
		Articolo nuovoArticolo= new Articolo("maglietta", "57362", 30, LocalDate.of(2017, 10, 05));
		nuovoArticolo.setOrdine(ordineDaCollegare);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId()== null) {
			throw new RuntimeException("errore: l'articolo non è stato aggiunto.");
		}
		if (!nuovoArticolo.getOrdine().getId().equals(idOrdineDaCollegare)) {
		throw new RuntimeException("testRimuoviArticoloCollegatoAOrdine FALLITO: L'ID dell'ordine non corrisponde");
		}
		Long idArticoloDaEliminare= nuovoArticolo.getId();
		articoloServiceInstance.rimuovi(idArticoloDaEliminare);
		Articolo articoloInEliminazione= articoloServiceInstance.caricaSingoloElemento(idArticoloDaEliminare);
		if (articoloInEliminazione != null) {
			throw new RuntimeException("testRimuoviArticoloCollegatoAOrdine fallito: articolo non rimosso");
		}
		System.out.println(".......testRimuoviArticolo fine.......");

	}
	
	//
	private static void testAggiungiArticoloACategoria (CategoriaService categoriaServiceInstance, ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception{
		System.out.println(".......aggiungiArticoloACategoria inizio.......");
		List<Categoria> listaCategorie= categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size()<1) {
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		}
		List<Articolo> listaArticoli= articoloServiceInstance.listAll();
		if (listaArticoli.size()<1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}
		
		Categoria categoriaEsistente= categoriaServiceInstance.cercaPerDescrizione("abbigliamento");
		if (categoriaEsistente==null) {
			throw new RuntimeException("errore: non è presente alcuna categoria con la decrizione fornita.");
		}
		
		Ordine nuovoOrdine = new Ordine("Sofia Sofi", "Via Parma 10", LocalDate.of(2022, 6, 14),
				LocalDate.of(2022, 10, 20));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}
		Articolo articoloDaAggiungereACategoria= new Articolo("jeans", "3282", 70, LocalDate.of(2022, 12, 07));
		articoloDaAggiungereACategoria.setOrdine(nuovoOrdine);
		
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungereACategoria);
		if (articoloDaAggiungereACategoria.getId()==null) {
			throw new RuntimeException("errore: non è stato inserito l'articolo.");
		}
		
	
		categoriaServiceInstance.aggiungiArticoloACategoriaEsistente(categoriaEsistente, articoloDaAggiungereACategoria);
		
		Categoria categoriaReloaded = categoriaServiceInstance.caricaElementoSingoloConArticoli(categoriaEsistente.getId());
		if (categoriaReloaded.getArticoli().isEmpty()) {
			throw new RuntimeException("testAssociaArticoloECategoria FALLITO: articolo non associato a categoria");
		}

		System.out.println(".......aggiungiArticoloACategoria fine.......");


	}
	
		
		

	
	
	
}

