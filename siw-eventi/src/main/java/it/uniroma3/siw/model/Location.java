package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Location {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String nome;
	private String indirizzo;
	private Integer numInvitati;
	
	@ManyToOne
	private Fornitore fornitore;

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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getNumInvitati() {
		return numInvitati;
	}

	public void setNumInvitati(Integer numInvitati) {
		this.numInvitati = numInvitati;
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, indirizzo, nome, numInvitati);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(id, other.id) && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(nome, other.nome) && Objects.equals(numInvitati, other.numInvitati);
	}
	
}
