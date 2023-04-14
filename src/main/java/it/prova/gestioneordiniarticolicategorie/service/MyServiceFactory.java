package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.dao.MyDAOFactory;

public class MyServiceFactory {
	private static OrdineService ordineServiceInstance = null;
	private static ArticoloService articoloServiceInstance = null;
	private static CategoriaService categoriaServiceInstance= null;

	public static OrdineService getOrdineServiceInstance() {
		if (ordineServiceInstance == null)
			ordineServiceInstance = new OrdineServiceImpl();

		ordineServiceInstance.setOrdineDao(MyDAOFactory.getordineDaoInstance());

		return ordineServiceInstance;
	}

	public static ArticoloService getArticoloServiceInstance() {
		if (articoloServiceInstance == null)
			articoloServiceInstance = new ArticoloServiceImpl();

		articoloServiceInstance.setArticoloDao(MyDAOFactory.geArticoloDaoInstance());

		return articoloServiceInstance;
	}
	
	public static CategoriaService getCategoriaServiceInstance() {
		if (categoriaServiceInstance==null)
			categoriaServiceInstance = new CategoriaServiceImpl();
		categoriaServiceInstance.setCategoriaDao(MyDAOFactory.getCategoriaDaoInstance());
		
		return categoriaServiceInstance;
	}

}
