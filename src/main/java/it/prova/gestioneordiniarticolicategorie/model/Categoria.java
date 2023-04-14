package it.prova.gestioneordiniarticolicategorie.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table (name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "descrizione")
	private String descrizione;
	
	@Column (name = "codice")
	private String codice;
	
	@ManyToMany (fetch = FetchType.LAZY, mappedBy = "categorie")
	private Set<Articolo> articoli= new HashSet<Articolo>();
	
	
	public Categoria() {
		
	}
	
	
	public Categoria(String descrizione, String codice) {
		this.descrizione=descrizione;
		this.codice=codice;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}


	public Set<Articolo> getArticoli() {
		return articoli;
	}


	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + "]";
	}
	
	
	

}
