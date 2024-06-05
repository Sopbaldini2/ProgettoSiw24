package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Dipendente;
import it.uniroma3.siw.repository.DipendenteRepository;

@Service
public class DipendenteService {

	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	public void save(Dipendente dipendente) {
		dipendenteRepository.save(dipendente);
	}

	public Dipendente findById(Long id) {
		return dipendenteRepository.findById(id).get();
	}

	public Iterable<Dipendente> findAll() {
		return dipendenteRepository.findAll();
	}

	public boolean existsByNomeAndCognome(String nome, String cognome) {
		   return dipendenteRepository.existsByNomeAndCognome(nome,  cognome);
	}

	public void delete(Dipendente dipendente) {
		dipendenteRepository.delete(dipendente);
	}
	 

}
