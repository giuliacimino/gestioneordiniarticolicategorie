package it.prova.gestioneordiniarticolicategorie.dao;

import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAOImpl;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAOImpl;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAOImpl;

public class MyDAOFactory {
	private static OrdineDAO ordineDaoInstance = null;
	private static ArticoloDAO articoloDaoInstance = null;
	private static CategoriaDAO categoriaDaoInstance= null;

	public static OrdineDAO getordineDaoInstance() {
		if (ordineDaoInstance == null)
			ordineDaoInstance = new OrdineDAOImpl();

		return ordineDaoInstance;
	}

	public static ArticoloDAO geArticoloDaoInstance() {
		if (articoloDaoInstance == null)
			articoloDaoInstance = new ArticoloDAOImpl();

		return articoloDaoInstance;
	}
	
	public static CategoriaDAO getCategoriaDaoInstance() {
		if (categoriaDaoInstance==null)
			categoriaDaoInstance = new CategoriaDAOImpl();
		
		return categoriaDaoInstance;
	}

}
