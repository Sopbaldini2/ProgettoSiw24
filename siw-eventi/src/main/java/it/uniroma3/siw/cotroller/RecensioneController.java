package it.uniroma3.siw.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.uniroma3.siw.service.RecensioneService;

@Controller
public class RecensioneController {
	@Autowired
	private RecensioneService recensioneservice;

}
