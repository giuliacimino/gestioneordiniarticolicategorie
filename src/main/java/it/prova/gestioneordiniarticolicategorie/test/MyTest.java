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
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();

		try {

//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");
//			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAll().size()+ " elementi.");

			System.out.println("++++++++++++ INIZIO BATTERIA DI TEST +++++++++++++++");

//			testInserisciNuovoOrdine(ordineServiceInstance);
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAllOrdini().size()+ " elementi.");

//			testAggiornaOrdine(ordineServiceInstance);
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAllOrdini().size()+ " elementi.");

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

//			testAggiungiArticoloACategoria(categoriaServiceInstance, articoloServiceInstance, ordineServiceInstance);
//			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");

//			testAggiungiCategoriaAArticolo(articoloServiceInstance, ordineServiceInstance, categoriaServiceInstance);
//			System.out.println("in tabella Articolo sono presenti "+articoloServiceInstance.listAll().size() +" elementi.");

//			testRimuoviArticoloEScollegaCategorie(articoloServiceInstance, categoriaServiceInstance,
//					ordineServiceInstance);
//			System.out.println(	"in tabella Articolo sono presenti " + articoloServiceInstance.listAll().size() + " elementi.");

//			testRimuoviCategoriaEScollegaArticoli(categoriaServiceInstance, articoloServiceInstance, ordineServiceInstance);
//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");

//			testOrdinePiuRecentePerCategoria(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);
//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");

//			testCercaPerCategoria(categoriaServiceInstance, ordineServiceInstance, articoloServiceInstance);
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAllOrdini().size()+ " elementi.");

//			testCercaCategorieArticoliInUnOrdine(categoriaServiceInstance, ordineServiceInstance);
//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");
			
//			testSommaPrezzoSingoloArticoliInUnaCategoria(articoloServiceInstance, categoriaServiceInstance);
//			System.out.println(	"in tabella Articolo sono presenti " + articoloServiceInstance.listAll().size() + " elementi.");
			
//			testListaCodiciCategorieDiUnMese(categoriaServiceInstance, ordineServiceInstance);
//			System.out.println("in tabella Categoria sono presenti "+ categoriaServiceInstance.listAllCategorie().size()+ " elementi.");

//			testSommaPrezzoArticoliPerUnDestinatario(articoloServiceInstance, ordineServiceInstance);
//			System.out.println(	"in tabella Articolo sono presenti " + articoloServiceInstance.listAll().size() + " elementi.");

//			testCercaIndirizziConStringaInNumeroSerialeArticolo(ordineServiceInstance, articoloServiceInstance);
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAllOrdini().size()+ " elementi.");

//			testListaArticoliConErroriInOrdine(articoloServiceInstance,ordineServiceInstance,categoriaServiceInstance);
//			System.out.println(	"in tabella Articolo sono presenti " + articoloServiceInstance.listAll().size() + " elementi.");

//			testRimuoviOrdine(ordineServiceInstance, articoloServiceInstance);
//			System.out.println("in tabella Ordine sono presenti " +ordineServiceInstance.listAllOrdini().size()+ " elementi.");

			
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}

	//
	private static void testInserisciNuovoOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testInserisciNuovoOrdine inizio.............");

		Ordine ordineInstance = new Ordine("via Piave 3", "Alice Bianchi", LocalDate.of(2020, 11, 12),
				LocalDate.of(2020, 11, 13));
		ordineServiceInstance.inserisciNuovo(ordineInstance);
		if (ordineInstance.getId() == null)
			throw new RuntimeException("testInserisciNuovoOrdine fallito ");

		System.out.println(".......testInserisciNuovoOrdine fine.............");
	}

	//
	private static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testAggiornaOrdine inizio.......");
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size() < 1)
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		Ordine ordineDaAggiornare = listaOrdini.get(0);
		ordineDaAggiornare.setNomeDestinatario("Maria Rossi");
		;
		ordineServiceInstance.aggiorna(ordineDaAggiornare);
		System.out.println(ordineDaAggiornare);
		System.out.println(".......testAggiornaOrdine fine.......");
	}

	//
	private static void testInserisciNuovoArticolo(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testInserisciNuovoArticolo inizio.............");

		Ordine ordineDaCollegare = new Ordine("via torino 33", "Carla Carli", LocalDate.of(2023, 04, 10),
				LocalDate.of(2023, 05, 15));
		ordineServiceInstance.inserisciNuovo(ordineDaCollegare);
		Long idOrdineDaCollegare = ordineDaCollegare.getId();
		if (idOrdineDaCollegare == null) {
			throw new RuntimeException("testInserimentoNuovoArticolo FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("maglione", "46362", 50, LocalDate.of(2022, 8, 10));
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
	private static void testAggiornaArticolo(ArticoloService articoloServiceInstance) throws Exception {
		System.out.println(".......testAggiornaArticolo inizio.......");
		List<Articolo> listaArticoli = articoloServiceInstance.listAll();
		if (listaArticoli.size() < 1)
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		Articolo articoloDaAggiornare = listaArticoli.get(0);
		articoloDaAggiornare.setDescrizione("sciarpa");
		articoloServiceInstance.aggiorna(articoloDaAggiornare);

		Articolo articoloRicaricato = articoloServiceInstance.caricaSingoloElemento(articoloDaAggiornare.getId());
		if (articoloRicaricato.getId() != articoloDaAggiornare.getId()) {
			throw new RuntimeException("errore: update non avvenuto.");
		}
		System.out.println(".......testAggiornaArticolo fine.......");
	}

	//
	public static void testInserisciNuovaCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".......testInserisciNuovaCategoria inizio.............");

		Categoria categoriaInstance = new Categoria("ACC", "accessori");
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		if (categoriaInstance.getId() == null)
			throw new RuntimeException("testInserisciNuovaCategoria fallito: non è stata inserita la nuova categoria.");

		System.out.println(".......testInserisciNuovaCategoria fine.............");
	}

	//
	private static void testAggiornaCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".......testAggiornaCategoria inizio.......");
		List<Categoria> listaCategorie = categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size() < 1)
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		Categoria categoriaDaAggiornare = listaCategorie.get(0);
		categoriaDaAggiornare.setCodice("CAS");
		categoriaServiceInstance.aggiorna(categoriaDaAggiornare);
		Categoria categoriaRicaricata = categoriaServiceInstance.caricaSingoloElemento(categoriaDaAggiornare.getId());
		if (categoriaRicaricata.getId() != categoriaDaAggiornare.getId()) {
			throw new RuntimeException("errore: non è stato effettuato l'update.");
		}

		System.out.println(categoriaDaAggiornare);

		System.out.println(".......testAggiornaCategoria fine.......");
	}

	//
	private static void testRimuoviArticoloCollegatoAOrdine(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testRimuoviArticolo inizio.......");
		List<Articolo> listaArticoli = articoloServiceInstance.listAll();
		if (listaArticoli.size() < 1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}

		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size() < 1)
			throw new RuntimeException("errore: non sono presenti ordini sul db.");

		Ordine ordineDaCollegare = listaOrdini.get(0);
		Long idOrdineDaCollegare = ordineDaCollegare.getId();
		Articolo nuovoArticolo = new Articolo("maglietta", "57362", 30, LocalDate.of(2017, 10, 05));
		nuovoArticolo.setOrdine(ordineDaCollegare);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("errore: l'articolo non è stato aggiunto.");
		}
		if (!nuovoArticolo.getOrdine().getId().equals(idOrdineDaCollegare)) {
			throw new RuntimeException("testRimuoviArticoloCollegatoAOrdine FALLITO: L'ID dell'ordine non corrisponde");
		}
		Long idArticoloDaEliminare = nuovoArticolo.getId();
		articoloServiceInstance.rimuovi(idArticoloDaEliminare);
		Articolo articoloInEliminazione = articoloServiceInstance.caricaSingoloElemento(idArticoloDaEliminare);
		if (articoloInEliminazione != null) {
			throw new RuntimeException("testRimuoviArticoloCollegatoAOrdine fallito: articolo non rimosso");
		}
		System.out.println(".......testRimuoviArticolo fine.......");

	}

	//
	private static void testAggiungiArticoloACategoria(CategoriaService categoriaServiceInstance,
			ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......aggiungiArticoloACategoria inizio.......");
		List<Categoria> listaCategorie = categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size() < 1) {
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		}
		List<Articolo> listaArticoli = articoloServiceInstance.listAll();
		if (listaArticoli.size() < 1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}

		Categoria categoriaEsistente = categoriaServiceInstance.cercaPerDescrizione("abbigliamento");
		if (categoriaEsistente == null) {
			throw new RuntimeException("errore: non è presente alcuna categoria con la decrizione fornita.");
		}

		Ordine nuovoOrdine = new Ordine("Sofia Sofi", "Via Parma 10", LocalDate.of(2022, 6, 14),
				LocalDate.of(2022, 10, 20));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}
		Articolo articoloDaAggiungereACategoria = new Articolo("jeans", "3282", 70, LocalDate.of(2022, 12, 07));
		articoloDaAggiungereACategoria.setOrdine(nuovoOrdine);

		articoloServiceInstance.inserisciNuovo(articoloDaAggiungereACategoria);
		if (articoloDaAggiungereACategoria.getId() == null) {
			throw new RuntimeException("errore: non è stato inserito l'articolo.");
		}

		categoriaServiceInstance.aggiungiArticoloACategoriaEsistente(categoriaEsistente,
				articoloDaAggiungereACategoria);

		Categoria categoriaReloaded = categoriaServiceInstance
				.caricaElementoSingoloConArticoli(categoriaEsistente.getId());
		if (categoriaReloaded.getArticoli().isEmpty()) {
			throw new RuntimeException("testAssociaArticoloECategoria FALLITO: articolo non associato a categoria");
		}

		System.out.println(".......aggiungiArticoloACategoria fine.......");

	}

	//
	private static void testAggiungiCategoriaAArticolo(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".......testAggiungiCategoriaAArticolo inizio.......");
		List<Articolo> listaArticoli = articoloServiceInstance.listAll();
		if (listaArticoli.size() < 1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}
		Ordine nuovoOrdine = new Ordine("giulia gatta", "via milano 2", LocalDate.of(2022, 12, 10),
				LocalDate.of(2022, 12, 11));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		Articolo nuovoArticolo = new Articolo("padella", "4525", 50, LocalDate.of(2023, 2, 9));
		nuovoArticolo.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("errore: non è stato inserito l'articolo");
		}

		List<Categoria> listaCategorie = categoriaServiceInstance.listAllCategorie();
		if (listaArticoli.size() < 1) {
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		}

		Categoria categoriaDaAggiungere = listaCategorie.get(0);
		articoloServiceInstance.aggiungiCategoriaAArticoloEsistente(nuovoArticolo, categoriaDaAggiungere);

		Articolo articoloReloaded = articoloServiceInstance.caricaElementoSingoloConCategorie(nuovoArticolo.getId());
		if (articoloReloaded.getCategorie().isEmpty()) {
			throw new RuntimeException("errore: non è stata collegata la categoria all'articolo.");
		}
		System.out.println(".......testAggiungiCategoriaAArticolo fine.......");

	}

	//
	private static void testRimuoviArticoloEScollegaCategorie(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("........ testRimuoviArticoloEScollegaCategorie inizio.........");

		Categoria categoriaEsistente = categoriaServiceInstance.cercaPerDescrizione("casa");
		if (categoriaEsistente.getId() == null) {
			throw new RuntimeException("errore: categoria non presente.");
		}
		Ordine nuovoOrdine = new Ordine("Gianni Galli", "Via Palermo 2", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("divano", "46363", 500, LocalDate.of(2022, 12, 10));
		nuovoArticolo.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("errore: articolo non inserito.");
		}

		articoloServiceInstance.aggiungiCategoriaAArticoloEsistente(nuovoArticolo, categoriaEsistente);

		Articolo articoloDaRimuovere = articoloServiceInstance.caricaElementoSingoloConCategorie(nuovoArticolo.getId());
		if (articoloDaRimuovere.getId() == null) {
			throw new RuntimeException("errore: articolo non inserito.");
		}
		if (articoloDaRimuovere.getCategorie().isEmpty()) {
			throw new RuntimeException("errore: categoria non associata ad articolo");
		}
		// rimozione completa articolo
		articoloServiceInstance.rimuoviArticoloEScollegaCategorie(articoloDaRimuovere.getId());

		System.out.println("........testRimuoviArticoloEScollegaCategorie fine.......");
	}
	
	//
	private static void testRimuoviCategoriaEScollegaArticoli (CategoriaService categoriaServiceInstance, ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception{
		System.out.println(".........testRimuoviCategoriaEScollegaArticoli inizio......");
		Categoria nuovaCategoria = new Categoria("Abbigliamento", "201");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		if (nuovaCategoria.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: categoria non inserita.");
		}
		Ordine nuovoOrdine = new Ordine("giancarlo carli", "Via nuoro 1", LocalDate.of(2023, 4, 31),
				LocalDate.of(2023, 4, 05));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo1 = new Articolo("Scarpe Nike", "0001", 299, LocalDate.now());
		Articolo nuovoArticolo2 = new Articolo("Scarpe Nike", "0001", 299, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: articolo non inserito.");
		}
		nuovoArticolo2.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: articolo non inserito.");
		}

		categoriaServiceInstance.aggiungiArticoloACategoriaEsistente(nuovaCategoria, nuovoArticolo1);
		categoriaServiceInstance.aggiungiArticoloACategoriaEsistente(nuovaCategoria, nuovoArticolo2);
		Categoria categoriaReloaded = categoriaServiceInstance.caricaElementoSingoloConArticoli(nuovaCategoria.getId());
		if (categoriaReloaded.getArticoli().isEmpty()) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: articolo non associato a categoria");
		}

		// rimozione completa categoria
		categoriaServiceInstance.rimuoviCategoriaEScollegaArticoli(categoriaReloaded.getId());

		System.out.println("..........testRimuoviCategoriaEScollegaArticoli fine.......");
	
	}	
	
	
	//
	private static void testOrdinePiuRecentePerCategoria(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".........testOrdinePiuRecentePerCategoria inizio............");

		Ordine nuovoOrdine1 = new Ordine("marco rossi", "Via trento 33", LocalDate.of(2023, 4, 20),
				LocalDate.of(2023, 4, 21));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine1);
		Long idNuovoOrdine1 = nuovoOrdine1.getId();
		if (idNuovoOrdine1 == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}
		Ordine nuovoOrdine2 = new Ordine("mario rossi", "viale milano 5", LocalDate.of(2022, 4, 4),
				LocalDate.of(2022, 4, 5));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine2);
		Long idNuovoOrdine2 = nuovoOrdine2.getId();
		if (idNuovoOrdine2 == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}

		Categoria nuovaCategoria1 = new Categoria("alimentari", "ALI");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		Long idNuovaCategoria1 = nuovaCategoria1.getId();
		if (idNuovaCategoria1 == null) {
			throw new RuntimeException("errore: categoria non inserita.");
		}

		Categoria nuovaCategoria2 = new Categoria("libri", "LIB");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		Long idNuovaCategoria2 = nuovaCategoria2.getId();
		if (idNuovaCategoria2 == null) {
			throw new RuntimeException("errore: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("pasta", "37272", 5, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine1);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoriaAArticoloEsistente(nuovoArticolo1, nuovaCategoria1);
		Articolo articoloReloaded1 = articoloServiceInstance.caricaElementoSingoloConCategorie(nuovoArticolo1.getId());
		if (articoloReloaded1.getCategorie().isEmpty()) {
			throw new RuntimeException("errore: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("harry potter", "26262", 15, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoriaAArticoloEsistente(nuovoArticolo2, nuovaCategoria1);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaElementoSingoloConCategorie(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException("errore: articolo non associato a categoria");
		}

		Ordine ordinePiuRecente = ordineServiceInstance.ordinePiuRecentePerCategoria(idNuovaCategoria1);

		System.out.println(ordinePiuRecente);

		System.out.println("........testOrdinePiuRecentePerCategoria fine........");
	}
	
	
	//
	private static void testCercaPerCategoria (CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance, ArticoloService articoloServiceInstance) throws Exception{
		System.out.println("........testCercaPerCategoria inizio........");
		List<Categoria> listaCategorie= categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size()<1) {
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		}
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size()<1) {
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		}
		Long idCategoriaScelta= listaCategorie.get(0).getId();
		List<Ordine> ordiniPerCategoria= ordineServiceInstance.cercaPerCategoria(idCategoriaScelta);
		if (ordiniPerCategoria.size()<1) {
			throw new RuntimeException("errore: non sono presenti ordin per la categoria scelta.");
		}
		System.out.println(ordiniPerCategoria);
		System.out.println("........testCercaPerCategoria fine........");


	}
	
	//
	private static void testCercaCategorieArticoliInUnOrdine (CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception{
		System.out.println("........testCercaCategorieArticoliInUnOrdine inizio........");
		List<Categoria> listaCategorie= categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size()<1) {
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		}
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size()<1) {
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		}
		Long idOrdineScelto= listaOrdini.get(0).getId();
		if (idOrdineScelto==null) {
			throw new RuntimeException("errore: non è presente l'ordine scelto.");
		}
		List<Categoria> categorieInOrdineScelto= categoriaServiceInstance.cercaCategorieArticoliInUnOrdine(idOrdineScelto);
		if (categorieInOrdineScelto.size()<1) {
			throw new RuntimeException("errore: l'ordine scelto non è collegato a categorie.");
		}
		System.out.println(categorieInOrdineScelto);
		System.out.println("........testCercaCategorieArticoliInUnOrdine fine........");


	}
	
	//
	private static void testSommaPrezzoSingoloArticoliInUnaCategoria (ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception{
		System.out.println("........testSommaPrezzoSingoloArticoliInUnaCategoria inizio........");
		List<Categoria> listaCategorie= categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size()<1) {
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		}
		List<Articolo> listaArticoli= articoloServiceInstance.listAll();
		if (listaArticoli.size()<1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}
		
		Long idCategoriaScelta= categoriaServiceInstance.cercaPerDescrizione("casa").getId();
		if (idCategoriaScelta==null) {
			throw new RuntimeException("errore: non è presente la categoria scelta.");
		}
		Long sommaPrezziArticoliInCategoriaScelta= articoloServiceInstance.sommaPrezzoSingoloArticoliInUnaCategoria(idCategoriaScelta);
		System.out.println(sommaPrezziArticoliInCategoriaScelta);
		System.out.println("........testSommaPrezzoSingoloArticoliInUnaCategoria fine........");

	}
	
	//
	private static void testListaCodiciCategorieDiUnMese (CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception{
		System.out.println("........testListaCodiciCategorieDiUnMese inizio........");
		List<Categoria> listaCategorie= categoriaServiceInstance.listAllCategorie();
		if (listaCategorie.size()<1) {
			throw new RuntimeException("errore: non sono presenti categorie sul db.");
		}
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size()<1) {
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		}
		List<String> listaCodiciCategorieInUnMese= categoriaServiceInstance.listaCodiciCategorieDiUnMese(2023, 04);
		if (listaCodiciCategorieInUnMese.size()<1) {
			throw new RuntimeException("errore: non sono presenti ordini in dato mese.");
		}
		System.out.println(listaCodiciCategorieInUnMese);
		System.out.println("........testListaCodiciCategorieDiUnMese fine........");

	}
	
	//
	private static void testSommaPrezzoArticoliPerUnDestinatario (ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception{
		System.out.println("........testListaCodiciCategorieDiUnMese inizio........");
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size()<1) {
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		}
		List<Articolo> listaArticoli= articoloServiceInstance.listAll();
		if (listaArticoli.size()<1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}
		String destinatarioScelto= listaOrdini.get(0).getNomeDestinatario();
		if (destinatarioScelto == null) {
			throw new RuntimeException("errore: non è presente il destinatario scelto.");
		}
		Long sommaPrezzoArticoliDestinatarioScelto= articoloServiceInstance.sommaPrezzoArticoliPerUnDestinatario(destinatarioScelto);
		System.out.println(sommaPrezzoArticoliDestinatarioScelto);
		System.out.println("........testListaCodiciCategorieDiUnMese inizio........");
	}
	
	//
	private static void testCercaIndirizziConStringaInNumeroSerialeArticolo (OrdineService ordineServiceInstance, ArticoloService articoloServiceInstance) throws Exception{
		System.out.println("........testListaCodiciCategorieDiUnMese inizio........");
		List<Ordine> listaOrdini = ordineServiceInstance.listAllOrdini();
		if (listaOrdini.size()<1) {
			throw new RuntimeException("errore: non sono presenti ordini sul db.");
		}
		List<Articolo> listaArticoli= articoloServiceInstance.listAll();
		if (listaArticoli.size()<1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}
		String numeroSerialeScelto= "2";
		List<String> listaIndirizziConCodiceSerialeScelto= ordineServiceInstance.cercaIndirizziConStringaInNumeroSerialeArticolo(numeroSerialeScelto);
		if (listaIndirizziConCodiceSerialeScelto.size()<1) {
			throw new RuntimeException("errore: non sono presenti indirizzi con codice seriale scelto.");
		}
		System.out.println(listaIndirizziConCodiceSerialeScelto);
		System.out.println("........testListaCodiciCategorieDiUnMese fine........");

	}
	
	//
	private static void testListaArticoliConErroriInOrdine (ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance, CategoriaService categoriaServiceInstance) throws Exception{
		System.out.println("........testListaCodiciCategorieDiUnMese inizio........");
		List<Articolo> listaArticoli= articoloServiceInstance.listAll();
		if (listaArticoli.size()<1) {
			throw new RuntimeException("errore: non sono presenti articoli sul db.");
		}

		Ordine nuovoOrdine= new Ordine("alessandro magno", "via grecia 2", LocalDate.of(2022, 8, 30), LocalDate.of(2022, 8, 31));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId()==null) {
			throw new RuntimeException("errore: ordine non inserito.");
		}
		Articolo nuovoArticoloConErrore= new Articolo("mestolo", "56463", 30, LocalDate.now());
		nuovoArticoloConErrore.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticoloConErrore);
		if (nuovoArticoloConErrore.getId()==null) {
			throw new RuntimeException("errore: articolo non inserito.");
		}
		Categoria nuovaCategoria= new Categoria("cucina", "CUC");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		if (nuovaCategoria.getId()==null) {
			throw new RuntimeException("errore: categoria non inserita.");
		}
		articoloServiceInstance.aggiungiCategoriaAArticoloEsistente(nuovoArticoloConErrore, nuovaCategoria);
		Articolo articoloRicaricato= articoloServiceInstance.caricaElementoSingoloConCategorie(nuovoArticoloConErrore.getId());
		if (articoloRicaricato.getCategorie().isEmpty()) {
			throw new RuntimeException("errore: non ci sono categorie associate all'articolo.");
		}
		
		List<Articolo> listaArticoliConErrori =articoloServiceInstance.listaArticoliConErroriInOrdine();
		if (listaArticoliConErrori.size()<1) {
			throw new RuntimeException("non sono stati trovati articoli con errori.");
		}
		System.out.println(listaArticoliConErrori);
		System.out.println("........testListaCodiciCategorieDiUnMese fine........");

	}
	
	
	//
	private static void testRimuoviOrdine(OrdineService ordineServiceInstance, ArticoloService articoloServiceInstance)
			throws Exception {
		System.out.println("................testRimuoviOrdine inizio............");

		Ordine ordineDaEliminare = new Ordine("Giuseppe Peppe", "Via Firenze 52", LocalDate.of(2022, 5, 20),
				LocalDate.of(2022, 05, 15));
		ordineServiceInstance.inserisciNuovo(ordineDaEliminare);
		Long idOrdineDaInserire = ordineDaEliminare.getId();
		if (idOrdineDaInserire == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("tostapane", "46363", 70, LocalDate.now());
		nuovoArticolo.setOrdine(ordineDaEliminare);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("errore: Articolo non inserito");
		}
		if (!nuovoArticolo.getOrdine().getId().equals(idOrdineDaInserire)) {
			throw new RuntimeException("errore: l'id dell'ordine non corrisponde");
		}
		Long idOrdineDaEliminare = ordineDaEliminare.getId();
		if (idOrdineDaEliminare == null) {
			throw new RuntimeException("errore: Ordine non inserito.");
		}

		ordineServiceInstance.rimuoviOrdine(idOrdineDaEliminare);

		System.out.println("........testRimuoviOrdine fine......");

	}
}
