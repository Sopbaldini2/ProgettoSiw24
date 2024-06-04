package it.uniroma3.siw.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("/admin/indexDipendente")
	public String indexDipendente() {
		return "admin/indexDipendente.html";
	}
	
	@PostMapping("/admin/dipendente")
	public String newDipendente(@ModelAttribute("dipendente") Dipendente dipendente, Model model) {
		if (!dipendenteService.existsByNomeAndCognome(dipendente.getNome(), dipendente.getCognome())) {
			this.dipendenteService.save(dipendente); 
			model.addAttribute("dipendente", dipendente);
			return "dipendente.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo dipendente esiste già");
			return "admin/formNewDipendente.html"; 
		}
	}
	
	@GetMapping("/dipendente")
	public String getDipendenti(Model model) {
		model.addAttribute("dipendenti", this.dipendenteService.findAll());
		return "dipendente.html";
	}
	
	@GetMapping("/admin/formNewDipendente")
	public String formNewDipendente(Model model) {
		model.addAttribute("dipendente", new Dipendente());
		return "admin/formNewDipendente.html";
	}
	
	@GetMapping("/admin/manageDipendente")
	public String manageDipendente(Model model) {
		model.addAttribute("dipendenti", this.dipendenteService.findAll());
		return "admin/manageDipendente.html";
	}
	
	
	@GetMapping("/admin/dipendente/{id}")
    public String deleteDipendente(@PathVariable("id") Long id, Model model) {
        Dipendente dipendente = dipendenteService.findById(id);
        if (dipendente != null) {
            dipendenteService.delete(dipendente);
            // Redirect alla pagina dell'indice dei servizi dopo la cancellazione
            return "redirect:/dipendente";
        } else {
            // Nel caso in cui il servizio non esista
            model.addAttribute("messaggioErrore", "Servizio non trovato");
            return "admin/indexDipendente.html";
            }
        }
}
