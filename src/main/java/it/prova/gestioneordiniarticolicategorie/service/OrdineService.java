package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineService {
	public List<Ordine> listAllOrdini() throws Exception;
	
	public Ordine caricaSingoloElemento(Long id) throws Exception;
		
	public void inserisciNuovo (Ordine ordineInstance) throws Exception;
	
	public void aggiorna(Ordine ordineInstance) throws Exception;
	
	public Ordine ordinePiuRecentePerCategoria (Long idCategoria) throws Exception;

	
	
	
	//per injection
		public void setOrdineDAO (OrdineDAO ordineDAO);
		
		public void setArticoloDAO (ArticoloDAO articoloDAO);

}
