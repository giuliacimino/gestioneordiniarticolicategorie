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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table (name="ordine")
public class Ordine {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name = "nomedestinatario")
	private String nomeDestinatario;
	
	@Column(name="indirizzospedizione")
	private String indirizzoSpedizione;
	
	@Column (name="dataspedizione")
	private LocalDate dataSpedizione;
	
	@Column (name = "datascadenza")
	private LocalDate dataScadenza;
	
	// campi per le time info del record
		@CreationTimestamp
		@Column(name = "createdatetime")
		private LocalDateTime createDateTime;
		@UpdateTimestamp
		@Column(name = "updatedatetime")
		private LocalDateTime updateDateTime;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordine")
	private Set<Articolo> articoli= new HashSet<Articolo>();
	
	public Ordine () {
		
	}
	
	public Ordine(String nomeDestinatario, String indirizzoSpedizione, LocalDate dataSpedizione, LocalDate dataScadenza) {
		this.nomeDestinatario=nomeDestinatario;
		this.indirizzoSpedizione=indirizzoSpedizione;
		this.dataSpedizione=dataSpedizione;
		this.dataScadenza=dataScadenza;
	}
	
	public Ordine(String nomeDestinatario, String indirizzoSpedizione) {
		this.nomeDestinatario=nomeDestinatario;
		this.indirizzoSpedizione=indirizzoSpedizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(String indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public LocalDate getDataSpedizione() {
		return dataSpedizione;
	}

	public void setDataSpedizione(LocalDate dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public String toString() {
		return "Ordine [id=" + id + ", nomeDestinatario=" + nomeDestinatario + ", indirizzoSpedizione="
				+ indirizzoSpedizione + ", dataSpedizione=" + dataSpedizione + ", dataScadenza=" + dataScadenza + "]";
	}
	
	
	

}
