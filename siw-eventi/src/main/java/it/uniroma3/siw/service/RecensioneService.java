package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.repository.RecensioneRepository;

@Service
public class RecensioneService {
	@Autowired 
	private RecensioneRepository recensioneRepository;
	
	public void save(Recensione recensione) {
		// TODO Auto-generated method stub
		recensioneRepository.save(recensione);
	}

	public Recensione findById(Long id) {
		return recensioneRepository.findById(id).get();
	}
	
	 public void delete(Long recensioneId) {
	        recensioneRepository.deleteById(recensioneId);
	 }

}
