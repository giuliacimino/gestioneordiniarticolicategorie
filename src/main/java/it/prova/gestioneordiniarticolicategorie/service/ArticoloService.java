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
	
	public Articolo caricaElementoSingoloConCategorie(Long idArticolo) throws Exception;
	
	public void aggiungiCategoriaAArticoloEsistente(Articolo articoloEsistente, Categoria categoriaInstance) throws Exception;
	
	public void rimuoviCategoriaDaArticolo(Long idArticolo, Long idCategoria) throws Exception;
	
	public void rimuoviArticoloEScollegaCategorie (Long idArticolo) throws Exception;

	public Long sommaPrezzoSingoloArticoliInUnaCategoria (Long idCatrgoria) throws Exception;

	public Long sommaPrezzoArticoliPerUnDestinatario (String nomeDestinarario) throws Exception;

	public List<Articolo> listaArticoliConErroriInOrdine () throws Exception;
	
	
	//per injection
		public void setArticoloDAO (ArticoloDAO articoloDAO);
		public void setCategoriaDAO (CategoriaDAO categoriaDAO);

}
