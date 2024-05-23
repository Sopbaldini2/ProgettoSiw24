package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Evento {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
	private String nome;
	private Float prezzo;
	private String descrizione;
	private String tipologia;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	@OneToMany(mappedBy="evento")
	private List<Recensione> recensioni;
	@ManyToMany
	private List<Dipendente> collaboratori;
	@ManyToMany
	private List<Servizio> servizi;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(collaboratori, data, descrizione, id, nome, prezzo, recensioni, servizi,
				tipologia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(collaboratori, other.collaboratori) && Objects.equals(data, other.data)
				&& Objects.equals(descrizione, other.descrizione) && Objects.equals(id, other.id)
			    && Objects.equals(nome, other.nome)
				&& Objects.equals(prezzo, other.prezzo) && Objects.equals(recensioni, other.recensioni)
				&& Objects.equals(servizi, other.servizi) && Objects.equals(tipologia, other.tipologia);
	}
	public List<Dipendente> getCollaboratori() {
		return collaboratori;
	}
	public void setCollaboratori(List<Dipendente> collaboratori) {
		this.collaboratori = collaboratori;
	}
	
	public List<Servizio> getServizi() {
		return servizi;
	}
	public void setServizi(List<Servizio> servizi) {
		this.servizi = servizi;
	}
	public List<Recensione> getRecensioni() {
		return recensioni;
	}
	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
