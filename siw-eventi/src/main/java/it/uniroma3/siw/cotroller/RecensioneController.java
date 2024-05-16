package it.uniroma3.siw.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.RecensioneService;

@Controller
public class RecensioneController {
	@Autowired
	private RecensioneService recensioneService;

	@GetMapping(value="/admin/formNewRecensione")
	public String formNewRecensione(Model model) {
		model.addAttribute("recensione", new Recensione());
		return "admin/formNewRecensione.html";
	}
	
	@GetMapping(value="/admin/indexRecensione")
	public String indexRecensione() {
		return "admin/indexRecensione.html";
	}
	
	@PostMapping("/admin/recensione")
	public String newRecensione(@ModelAttribute("recensione")Recensione recensione, Model model) {
		if (!recensioneService.existsById(recensione.getId())) {
			this.recensioneService.save(recensione); 
			model.addAttribute("recensione", recensione);
			return "recensione.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo recensione esiste già");
			return "admin/formNewRecensione.html"; 
		}
	}

	@GetMapping("/recensione/{id}")
	public String getRecensione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recensione", this.recensioneService.findById(id));
		return "recensione.html";
	}

	@GetMapping("/recensione")
	public String getRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.findAll());
		return "recensioni.html";
	}
}
