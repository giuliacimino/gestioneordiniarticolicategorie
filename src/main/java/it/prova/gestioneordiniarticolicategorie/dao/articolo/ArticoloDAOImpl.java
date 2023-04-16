package it.prova.gestioneordiniarticolicategorie.dao.articolo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO{
	
private EntityManager entityManager;
	

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}


	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}


	@Override
	public Articolo get(Long id) throws Exception {
	return entityManager.find(Articolo.class, id);
	}


	@Override
	public void update(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
		
	}


	@Override
	public void insert(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
		
	}


	@Override
	public void delete(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
		
	}


	@Override
	public Articolo findByIdFetchingCategorie(Long id) throws Exception {
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a join fetch a.categorie c where a.id = ?1", Articolo.class);
		query.setParameter(1, id);
		return query.getResultList().stream().findFirst().orElse(null);
	}


	@Override
	public void deleteArticoloEScollegaCategorie(Long idArticolo) throws Exception {
		entityManager.createNativeQuery("delete from articolo_categoria a where a.articolo_id = ?1").setParameter(1, idArticolo).executeUpdate();
		entityManager.createNativeQuery("delete from articolo a where a.id = ?1").setParameter(1, idArticolo)
		.executeUpdate();

	}


	@Override
	public Long sumPrezzoArticoliInACategoria(Long idCategoria) throws Exception {
		Long somma = null;
		Query query = entityManager.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.categorie c where c.id=?1");
		query.setParameter(1, idCategoria);
		somma = (Long) query.getSingleResult();
		return somma;

	}


	@Override
	public Long sumPrezzoArticoliForDestinatario(Long idOrdine) throws Exception {
		Long somma = null;
		Query query = entityManager.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.ordine o where o.id=?1");
		query.setParameter(1, idOrdine);
		somma = (Long) query.getSingleResult();
		return somma;
	}

}
