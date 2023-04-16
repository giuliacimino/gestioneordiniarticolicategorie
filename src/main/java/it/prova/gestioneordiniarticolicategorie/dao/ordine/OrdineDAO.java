package it.prova.gestioneordiniarticolicategorie.dao.ordine;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	public Ordine getRecentOrdineByCategoria (Long idCategoria) throws Exception;
	public List<Ordine> findAllByCategoria(Long idCategoria) throws Exception;
	public List<String> findIndirizziWithStringaInNumeroSerialeArticolo (String numeroSeriale) throws Exception;

	

}
