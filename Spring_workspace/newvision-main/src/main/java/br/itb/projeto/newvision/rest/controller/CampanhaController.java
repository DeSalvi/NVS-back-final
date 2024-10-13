package br.itb.projeto.newvision.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.newvision.model.entity.Campanha;
import br.itb.projeto.newvision.service.CampanhaService;

@RestController
@RequestMapping("/campanha/")
public class CampanhaController {

	private CampanhaService campanhaService;

	public CampanhaController(CampanhaService campanhaService) {
		super();
		this.campanhaService = campanhaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Campanha>> findAll() {
		List<Campanha> campanhas = campanhaService.findAll();

		return new ResponseEntity<List<Campanha>>(campanhas, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Campanha> create(
			@RequestBody Campanha campanha){
		
		Campanha _campanha= 
			campanhaService.create(campanha); 
		
		return new ResponseEntity<Campanha>
			       (_campanha, HttpStatus.OK);
	}

	@PutMapping("finalizar/{id}")
	public ResponseEntity<Campanha> finalizar(
			@PathVariable long id) {
		
		Campanha _campanha = campanhaService.finalizar(id);
		
		return new ResponseEntity<Campanha>(
						_campanha, HttpStatus.OK);
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<Campanha> reativar(
			@PathVariable long id) {
		
		Campanha _campanha = campanhaService.reativar(id);
		
		return new ResponseEntity<Campanha>(
						_campanha, HttpStatus.OK);
	}
}
