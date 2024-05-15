package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Dipendente {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String nome;
	private String cognome;
	private Integer compenso;
	private String email;
	private String telefono;
	
	@Override
	public int hashCode() {
		return Objects.hash(cognome, compenso, email, id, nome, organizzati, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dipendente other = (Dipendente) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(compenso, other.compenso)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(organizzati, other.organizzati)
				&& Objects.equals(telefono, other.telefono);
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getCompenso() {
		return compenso;
	}

	public void setCompenso(Integer compenso) {
		this.compenso = compenso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Evento> getOrganizzati() {
		return organizzati;
	}

	public void setOrganizzati(List<Evento> organizzati) {
		this.organizzati = organizzati;
	}

	@ManyToMany(mappedBy="collaboratori")
	private List<Evento> organizzati;
}
