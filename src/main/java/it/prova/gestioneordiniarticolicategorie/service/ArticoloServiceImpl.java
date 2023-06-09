package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordiniarticolicategorie.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public class ArticoloServiceImpl implements ArticoloService {
	
	private ArticoloDAO articoloDAO;
	private CategoriaDAO categoriaDAO;



	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;

	}
	
	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO=categoriaDAO;
		
	}
	
	
	

	@Override
	public List<Articolo> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			articoloDAO.setEntityManager(entityManager);

			return articoloDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Articolo caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			articoloDAO.setEntityManager(entityManager);

			return articoloDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			entityManager.getTransaction().begin();
			
			// injection
			articoloDAO.setEntityManager(entityManager);

			articoloDAO.insert(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}


	@Override
	public void aggiorna(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.update(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

		
	}


	@Override
	public void rimuovi(Long idArticolo) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.delete(articoloDAO.get(idArticolo));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}


	@Override
	public Articolo caricaElementoSingoloConCategorie(Long idArticolo) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			articoloDAO.setEntityManager(entityManager);

			return articoloDAO.findByIdFetchingCategorie(idArticolo);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}


	@Override
	public void aggiungiCategoriaAArticoloEsistente(Articolo articoloEsistente, Categoria categoriaInstance)
			throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			entityManager.getTransaction().begin();
			
			// injection
			articoloDAO.setEntityManager(entityManager);
			
			articoloEsistente = entityManager.merge(articoloEsistente);

			categoriaInstance = entityManager.merge(categoriaInstance);
			
			articoloEsistente.addToCategorie(categoriaInstance);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}	
	}


	@Override
	public void rimuoviCategoriaDaArticolo(Long idArticolo, Long idCategoria) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);
			categoriaDAO.setEntityManager(entityManager);

			Articolo articoloEsistente = articoloDAO.findByIdFetchingCategorie(idArticolo);
			Categoria categoriaInstance = categoriaDAO.get(idCategoria);

			articoloEsistente.getCategorie().remove(categoriaInstance);
	
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void rimuoviArticoloEScollegaCategorie(Long idArticolo) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			entityManager.getTransaction().begin();
			
			// injection
			articoloDAO.setEntityManager(entityManager);

			articoloDAO.deleteArticoloEScollegaCategorie(idArticolo);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
		
	}

	@Override
	public Long sommaPrezzoSingoloArticoliInUnaCategoria(Long idCategoria) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			articoloDAO.setEntityManager(entityManager);

			// esecuzione metodo
			return articoloDAO.sumPrezzoArticoliInACategoria(idCategoria);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Long sommaPrezzoArticoliPerUnDestinatario(String nomeDestinatario) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			articoloDAO.setEntityManager(entityManager);

			// esecuzione metodo
			return articoloDAO.sumPrezzoArticoliForDestinatario(nomeDestinatario);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Articolo> listaArticoliConErroriInOrdine() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			articoloDAO.setEntityManager(entityManager);

			return articoloDAO.listArticoliWithErroriInOrdine();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}




	
	

	
	

}
