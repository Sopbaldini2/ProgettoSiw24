package it.uniroma3.siw.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Evento;

public interface EventoRepository extends CrudRepository<Evento,Long>{
	
	public List<Evento> findByData(LocalDate data);
	boolean existsByNomeAndData(String nome, LocalDate data);

}
