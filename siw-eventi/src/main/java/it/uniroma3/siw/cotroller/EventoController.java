package it.uniroma3.siw.cotroller;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.controller.validator.EventoValidator;
import it.uniroma3.siw.model.Evento;
//import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Servizio;
import it.uniroma3.siw.service.EventoService;
//import it.uniroma3.siw.service.RecensioneService;
import it.uniroma3.siw.service.ServizioService;
import jakarta.validation.Valid;

@Controller
public class EventoController {
	@Autowired
	private EventoService eventoService;
	@Autowired
	private ServizioService servizioService;
	//@Autowired
	//private RecensioneService recensioneService;
	@Autowired
	private EventoValidator eventoValidator;
	
	@GetMapping("/admin/indexEvento")
	public String indexEvento() {
		return "admin/indexEvento.html";
	}
	
	@GetMapping("/admin/manageEvento")
	public String manageEvento(Model model) {
		model.addAttribute("eventi", this.eventoService.findAll());
		return "admin/manageEvento.html";
	}
	
	@GetMapping(value="/admin/formNewEvento")
	public String formNewEvento(Model model) {
		model.addAttribute("evento", new Evento());
		return "admin/formNewEvento.html";
	}

	@GetMapping("/admin/formUpdateEvento/{id}")
	public String formUpdateEvento(@PathVariable("id") Long id, Model model) {
		model.addAttribute("evento", eventoService.findById(id));
		return "admin/formUpdateEvento.html";
	}

	@PostMapping("/admin/evento")
	public String newEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult bindingResult, Model model) {
		
		this.eventoValidator.validate(evento, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.eventoService.save(evento); 
			model.addAttribute("evento", evento);
			return "evento.html";
		} else {
			return "admin/formNewEvento.html"; 
		}
	}

	@GetMapping("/evento/{id}")
	public String getEvento(@PathVariable("id") Long id, Model model) {
		model.addAttribute("evento", this.eventoService.findById(id));
		return "evento.html";
	}

	@GetMapping("/evento")
	public String getEventi(Model model) {		
		model.addAttribute("eventi", this.eventoService.findAll());
		return "eventi.html";
	}
	
	@GetMapping("/formSearchEventi")
	public String formSearchEventi() {
		return "formSearchEventi.html";
	}

	@PostMapping("/searchEventi")
	public String searchEventi(Model model, @RequestParam String nome) {
		model.addAttribute("eventi", this.eventoService.findByNome(nome));
		return "foundEventi.html";
	}
	
	@GetMapping("/admin/updateServizi/{id}")
	public String updateServizi(@PathVariable("id") Long id, Model model) {

		List<Servizio> serviziToAdd = this.serviziToAdd(id);
		model.addAttribute("serviziToAdd", serviziToAdd);
		model.addAttribute("evento", this.eventoService.findById(id));

		return "admin/serviziToAdd.html";
	}

	@GetMapping(value="/admin/addServizioToEvento/{servizioId}/{eventoId}")
	public String addServizioToEvento(@PathVariable("servizioId") Long servizioId, @PathVariable("eventoId") Long eventoId, Model model) {
		Evento evento = this.eventoService.findById(eventoId);
		Servizio servizio= this.servizioService.findById(servizioId);
		List<Servizio> servizi = evento.getServizi();
		servizi.add(servizio);
		this.eventoService.save(evento);
		
		List<Servizio> serviziToAdd = serviziToAdd(eventoId);
		
		model.addAttribute("evento", evento);
		model.addAttribute("serviziToAdd", serviziToAdd);

		return "admin/serviziToAdd.html";
	}
	
	@GetMapping(value="/admin/removeServizioFromEvento/{servizioId}/{eventoId}")
	public String removeServizioFromEvento(@PathVariable("servizioId") Long servizioId, @PathVariable("eventoId") Long eventoId, Model model) {
		Evento evento = this.eventoService.findById(eventoId);
		Servizio servizio= this.servizioService.findById(servizioId);
		List<Servizio> servizi = evento.getServizi();
		servizi.remove(servizio);
		this.eventoService.save(evento);

		List<Servizio> serviziToAdd = serviziToAdd(eventoId);
		
		model.addAttribute("evento", evento);
		model.addAttribute("serviziToAdd", serviziToAdd);

		return "admin/serviziToAdd.html";
	}

	private List<Servizio> serviziToAdd(Long eventoId) {
		List<Servizio> serviziToAdd = new ArrayList<>();

		for (Servizio s : servizioService.findServiziNotInEvento(eventoId)) {
			serviziToAdd.add(s);
		}
		return serviziToAdd;
	}
	
	
	
	@GetMapping("/admin/evento/{id}")
    public String deleteEvento(@PathVariable("id") Long id, Model model) {
        Evento Evento = eventoService.findById(id);
        if (Evento != null) {
            eventoService.delete(Evento);
            // Redirect alla pagina dell'indice dei servizi dopo la cancellazione
            return "redirect:/evento";
        } else {
            // Nel caso in cui il Cuoco non esista
            model.addAttribute("messaggioErrore", "Evento non trovato");
            return "admin/indexEvento.html";
            }
        }
	
}
