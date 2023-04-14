package it.prova.gestioneordiniarticolicategorie.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO{
	
private EntityManager entityManager;
	

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}


	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}


	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}


	@Override
	public void update(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
		
	}


	@Override
	public void insert(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
		
	}


	@Override
	public void delete(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Categoria findByDescrizione(String descrizione) throws Exception {
		TypedQuery<Categoria> query = entityManager.createQuery("from Categoria c where c.descrizione like :descrizione", Categoria.class);
		query.setParameter("descrizione", descrizione);
		return query.getResultStream().findFirst().orElse(null);
	}
	
	

}
