package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaService {
	
	public List<Categoria> listAllCategorie() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;
	
	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;
	
	public Categoria cercaPerDescrizione (String descrizione) throws Exception;
	
	public void aggiorna (Categoria categoriaInstance) throws Exception;
	
	public void aggiungiArticoloACategoriaEsistente (Categoria categoriaEsistente, Articolo articoloInstance) throws Exception;
	
	public Categoria caricaElementoSingoloConArticoli (Long id) throws Exception;
	
	public void rimuoviCategoriaEScollegaArticoli (Long idCategoria) throws Exception;

	public List<Categoria> cercaCategorieArticoliInUnOrdine (Long idOrdine) throws Exception;

	public List<String> listaCodiciCategorieDiUnMese (int anno, int mese) throws Exception;
	
	
	// per injection
		public void setCategoriaDAO (CategoriaDAO categoriaDAO);

}
