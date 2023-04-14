package it.prova.gestioneordiniarticolicategorie.test;

import java.time.LocalDate;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
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
			
//			initCategoria(categoriaServiceInstance);

			
			
			
			
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}
	
	//
//	private static void initCategoria (CategoriaService categoriaServiceInstance) throws Exception {
//		if (categoriaServiceInstance.cercaPerDescrizione("Abbigliamento") == null)
//			categoriaServiceInstance.inserisciNuovo(new Categoria("Abbigliamento", "ABB"));
//		if (categoriaServiceInstance.cercaPerDescrizione("Casa") == null)
//			categoriaServiceInstance.inserisciNuovo(new Categoria("Casa", "CAS"));
//		if (categoriaServiceInstance.cercaPerDescrizione ("Accessori") == null)
//			categoriaServiceInstance.inserisciNuovo(new Categoria("Accessori", "ACC"));
//	}
	
	
	
	
}

