package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Servizio;
import it.uniroma3.siw.model.Servizio;
import it.uniroma3.siw.repository.ServizioRepository;
import jakarta.transaction.Transactional;

@Service
public class ServizioService {
	@Autowired
	private ServizioRepository servizioRepository;
	
	public Servizio findById(Long id) {
		return servizioRepository.findById(id).get();
	}
	
	public Iterable<Servizio> findAll() {
		return servizioRepository.findAll();
	}
	
	public Iterable<Servizio> findServiziNotInEvento(@Param("eventoId") Long id){
		 return servizioRepository.findServiziNotInEvento(id);
	}

	public void save(Servizio servizio) {
		// TODO Auto-generated method stub
		this.servizioRepository.save(servizio);
	}

	public boolean existsByNome(String nome) {
		return servizioRepository.existsByNome(nome);
	}
	
	
	 @Transactional
		public void deleteById(Long id) {
			Servizio Servizio = findById(id);
			servizioRepository.deleteReferencesInEventiServizi(id);
			servizioRepository.delete(Servizio);
		}
}
