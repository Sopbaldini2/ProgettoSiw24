package it.uniroma3.siw.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Evento;

public interface EventoRepository extends CrudRepository<Evento,Long>{

	boolean existsByNomeAndData(String nome, LocalDate data);

}
