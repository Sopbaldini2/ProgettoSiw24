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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Evento {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvento; 
	private String nome;
	private Float prezzo;
	private String descrizione;
	private String tipologia;
	
	@OneToMany(mappedBy="evento")
	private List<Recensione> recensioni;
	
	@ManyToMany
	private List<Cliente> collaboratori;
	
	@ManyToOne
	private Location location;
	@ManyToMany(mappedBy="eventi")
	private List<Servizio> servizi;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(collaboratori, data, descrizione, idEvento, location, nome, prezzo, recensioni, servizi,
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
				&& Objects.equals(descrizione, other.descrizione) && Objects.equals(idEvento, other.idEvento)
				&& Objects.equals(location, other.location) && Objects.equals(nome, other.nome)
				&& Objects.equals(prezzo, other.prezzo) && Objects.equals(recensioni, other.recensioni)
				&& Objects.equals(servizi, other.servizi) && Objects.equals(tipologia, other.tipologia);
	}
	public List<Cliente> getCollaboratori() {
		return collaboratori;
	}
	public void setCollaboratori(List<Cliente> collaboratori) {
		this.collaboratori = collaboratori;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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
	public List<Cliente> getClienti() {
		return collaboratori;
	}
	public void setClienti(List<Cliente> clienti) {
		this.collaboratori = clienti;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
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
