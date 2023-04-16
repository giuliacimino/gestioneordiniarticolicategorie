package it.prova.gestioneordiniarticolicategorie.categoria;


import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	public Categoria findByDescrizione (String descrizione) throws Exception;
	public Categoria findByIdFetchingArticoli (Long id) throws Exception;
	public void DeleteCategoriaEScollegaArticoli (Long idCategoria) throws Exception;
	public List<Categoria> FindAllCategorieByArticoliInAOrdine (Long idOrdine) throws Exception;
	
	public List<String> listCodiciCategoriaOrdiniOfAMese(int anno, int mese) throws Exception;
}
