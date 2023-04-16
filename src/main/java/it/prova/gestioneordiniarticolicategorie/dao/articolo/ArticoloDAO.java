package it.prova.gestioneordiniarticolicategorie.dao.articolo;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo>{
	public Articolo findByIdFetchingCategorie(Long idArticolo) throws Exception;
	
	public void deleteArticoloEScollegaCategorie (Long idArticolo) throws Exception;
	
	public Long sumPrezzoArticoliInACategoria (Long idCategoria) throws Exception;
	
	public Long sumPrezzoArticoliForDestinatario (String nomeDestinatario) throws Exception;
	
	public List<Articolo> listArticoliWithErroriInOrdine () throws Exception;
}
