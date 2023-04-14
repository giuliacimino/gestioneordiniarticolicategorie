package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;

public class ArticoloServiceImpl implements ArticoloService {
	
	private OrdineDAO ordineDAO;
	private ArticoloDAO articoloDAO;
	private CategoriaDAO categoriaDAO;

	@Override
	public void setOrdineDao(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
	}

	@Override
	public void setArticoloDao(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;

	}
	
	@Override
	public void setCategoriaDao (CategoriaDAO categoriaDAo) {
		this.categoriaDAO=categoriaDAO;
	}
	

	
	

}
