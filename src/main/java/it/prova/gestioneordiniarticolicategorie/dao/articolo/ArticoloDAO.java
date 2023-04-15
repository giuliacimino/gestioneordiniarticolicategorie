package it.prova.gestioneordiniarticolicategorie.dao.articolo;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo>{
	public Articolo findByIdFetchingCategorie(Long id) throws Exception;
	
	public void deleteArticoloEScollegaCategorie (Long idArticolo) throws Exception;


}
