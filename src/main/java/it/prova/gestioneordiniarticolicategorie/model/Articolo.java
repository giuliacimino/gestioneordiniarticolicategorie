package it.prova.gestioneordiniarticolicategorie.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table (name = "articolo")
public class Articolo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "descrizione")
	private String descrizione;
	
	@Column (name="numeroseriale")
	private String numeroSeriale;
	
	@Column (name="prezzosingolo")
	private int prezzoSingolo;
	
	@Column (name="datainserimento")
	private LocalDate dataInserimento;
	
	// campi per le time info del record
		@CreationTimestamp
		@Column(name = "createdatetime")
		private LocalDateTime createDateTime;
		@UpdateTimestamp
		@Column(name = "updatedatetime")
		private LocalDateTime updateDateTime;
		
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name= "ordine_id" , nullable= false)
	private Ordine ordine;
	
	@ManyToMany
	@JoinTable (name="articolo_categoria", joinColumns =  @JoinColumn(name="articolo_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="categoria_id", referencedColumnName = "id"))
	private Set<Categoria> categorie= new HashSet<Categoria>();
	
	public Articolo() {
		
	}
	
	public Articolo(String descrizione, String numeroSeriale, int prezzoSingolo, LocalDate dataInserimento) {
		
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

	public String getNumeroSeriale() {
		return numeroSeriale;
	}

	public void setNumeroSeriale(String numeroSeriale) {
		this.numeroSeriale = numeroSeriale;
	}

	public int getPrezzoSingolo() {
		return prezzoSingolo;
	}

	public void setPrezzoSingolo(int prezzoSingolo) {
		this.prezzoSingolo = prezzoSingolo;
	}

	public LocalDate getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public void addToCategorie (Categoria categoriaInstance) {
		this.categorie.add(categoriaInstance);
		categoriaInstance.getArticoli().add(this);
	}

	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", numeroSeriale=" + numeroSeriale
				+ ", prezzoSingolo=" + prezzoSingolo + ", dataInserimento=" + dataInserimento + ", createDateTime="
				+ createDateTime + ", updateDateTime=" + updateDateTime + ", ordine=" + ordine + "]";
	}
	
	
	

}
