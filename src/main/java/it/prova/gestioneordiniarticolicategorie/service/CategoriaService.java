package it.prova.gestioneordiniarticolicategorie.service;

import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;

public interface CategoriaService {
	
	// per injection
				public void setOrdineDao(OrdineDAO ordineDAO);
				public void setArticoloDao(ArticoloDAO articoloDAO);
				public void setCategoriaDao (CategoriaDAO categoriDAO);

}
