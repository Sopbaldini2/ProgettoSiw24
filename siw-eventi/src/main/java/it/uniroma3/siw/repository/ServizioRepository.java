package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Servizio;

public interface ServizioRepository extends CrudRepository<Servizio,Long>{

public boolean existsByNome(String nome);
	
	@Query(value="select * "
			+ "from servizio s "
			+ "where s.id not in "
			+ "(select servizi_id "
			+ "from evento_servizi "
			+ "where evento_servizi.eventi_id = :eventoId)", nativeQuery=true)
	public Iterable<Servizio> findServiziNotInEvento(@Param("eventoId") Long id);

}
