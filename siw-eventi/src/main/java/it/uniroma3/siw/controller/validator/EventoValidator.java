package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Evento;
import it.uniroma3.siw.repository.EventoRepository;

@Component
public class EventoValidator implements Validator {
	@Autowired
	private EventoRepository eventoRepository;

	@Override
	public void validate(Object o, Errors errors) {
		Evento evento = (Evento)o;
		if (evento.getTitle()!=null && evento.getYear()!=null 
				&& eventoRepository.existsByTitleAndYear(evento.getTitle(), evento.getYear())) {
			errors.reject("movie.duplicate");
		}
	}
	@Override
	public boolean supports(Class<?> aClass) {
		return Evento.class.equals(aClass);
	}
}