package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface ArticoloService {
	public List<Articolo> listAll() throws Exception;
	
	public Articolo caricaSingoloElemento(Long id) throws Exception;
		
	public void inserisciNuovo (Articolo articoloInstance) throws Exception;
	
	public void aggiorna(Articolo articoloInstance) throws Exception;
	
	public void rimuovi(Long idArticolo) throws Exception;
	
	public Articolo caricaElementoSingoloConCategorie(Long id) throws Exception;
	
	public void aggiungiCategoriaAArticoloEsistente(Articolo articoloEsistente, Categoria categoriaInstance) throws Exception;



	
	
	//per injection
		public void setArticoloDAO (ArticoloDAO articoloDAO);

}
