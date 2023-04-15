package it.prova.gestioneordiniarticolicategorie.dao.ordine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO{
	private EntityManager entityManager;
	

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}


	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();

	}


	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);

	}


	@Override
	public void update(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
		
	}


	@Override
	public void insert(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
		
	}


	@Override
	public void delete(Ordine o) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Ordine getRecentOrdineByCategoria(Long idCategoria) throws Exception {
		TypedQuery<Ordine> query = entityManager.createQuery(
				"select o from Ordine o join o.articoli a join a.categorie c where c.id = ?1 order by o.dataSpedizione desc",
				Ordine.class).setParameter(1, idCategoria);
		return query.getResultStream().findFirst().orElse(null);
	}
	


}
