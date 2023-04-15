package it.prova.gestioneordiniarticolicategorie.dao.ordine;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	public Ordine getRecentOrdineByCategoria (Long idCategoria) throws Exception;

	

}
