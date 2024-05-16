package it.uniroma3.siw.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Dipendente;
import it.uniroma3.siw.service.DipendenteService;

@Controller
public class DipendenteController {

	@Autowired
	private DipendenteService dipendenteService;
	
	@GetMapping("/indexDipendente")
	public String indexDipendente() {
		return "indexDipendente.html";
	}
	
	@PostMapping("/dipendente")
	public String newDipendente(@ModelAttribute("dipendente") Dipendente dipendente) {
		this.dipendenteService.save(dipendente);
		return "redirect:dipendente/"+dipendente.getId();
		}
	
	@GetMapping("/dipendente/{id}")
	public String getDipendente(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dipendente", this.dipendenteService.findById(id));
		return "dipendente.html";
	}
	
	@GetMapping("/dipendente")
	public String getDipendenti(Model model) {
		model.addAttribute("dipendenti", this.dipendenteService.findAll());
		return "dipendenti.html";
	}
	
	@GetMapping("/admin/formNewDipendente")
	public String formNewDipendente(Model model) {
		model.addAttribute("dipendente", new Dipendente());
		return "admin/formNewDipendente.html";
	}
	
	
	
}
