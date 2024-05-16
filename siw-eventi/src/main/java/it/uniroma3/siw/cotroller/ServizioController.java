package it.uniroma3.siw.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Servizio;
import it.uniroma3.siw.service.ServizioService;

@Controller
public class ServizioController {
	@Autowired 
	private ServizioService servizioService;

	@GetMapping(value="/admin/formNewServizio")
	public String formNewServizio(Model model) {
		model.addAttribute("servizio", new Servizio());
		return "admin/formNewServizio.html";
	}
	
	@GetMapping(value="/admin/indexServizio")
	public String indexServizio() {
		return "admin/indexServizio.html";
	}
	
	@PostMapping("/admin/servizio")
	public String newServizio(@ModelAttribute("servizio") Servizio servizio, Model model) {
		if (!servizioService.existsByNome(servizio.getNome())) {
			this.servizioService.save(servizio); 
			model.addAttribute("servizio", servizio);
			return "servizio.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo servizio esiste già");
			return "admin/formNewServizio.html"; 
		}
	}

	@GetMapping("/servizio/{id}")
	public String getServizio(@PathVariable("id") Long id, Model model) {
		model.addAttribute("servizio", this.servizioService.findById(id));
		return "servizio.html";
	}

	@GetMapping("/servizio")
	public String getServizi(Model model) {
		model.addAttribute("servizi", this.servizioService.findAll());
		return "servizi.html";
	}
}
