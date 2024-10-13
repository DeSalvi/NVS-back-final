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


import br.itb.projeto.newvision.model.entity.CampanhaProduto;
import br.itb.projeto.newvision.service.CampanhaProdutoService;


@RestController
@RequestMapping("/campanhaProduto/")
public class CampanhaProdutoController {
	
	private CampanhaProdutoService campanhaProdutoService;
	

	
	public CampanhaProdutoController(CampanhaProdutoService campanhaProdutoService) {
		super();
		this.campanhaProdutoService = campanhaProdutoService;
	}



	@GetMapping("findAll")
	public ResponseEntity<List<CampanhaProduto>> findAll(){
		
		List<CampanhaProduto> campanhaProdutos = 
				campanhaProdutoService.findAll();
		
		return new ResponseEntity<List<CampanhaProduto>>
						 (campanhaProdutos, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<CampanhaProduto> create(
			@RequestBody CampanhaProduto campanhaProduto){
		
		CampanhaProduto _campanhaProduto = 
			campanhaProdutoService.create(campanhaProduto); 
		
		return new ResponseEntity<CampanhaProduto>
			       (_campanhaProduto, HttpStatus.OK);
	}

	@PutMapping("finalizar/{id}")
	public ResponseEntity<CampanhaProduto> finalizar(
			@PathVariable long id) {
		
		CampanhaProduto _campanhaProduto = campanhaProdutoService.finalizar(id);
		
		return new ResponseEntity<CampanhaProduto>(
						_campanhaProduto, HttpStatus.OK);
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<CampanhaProduto> reativar(
			@PathVariable long id) {
		
		CampanhaProduto _campanhaProduto = campanhaProdutoService.reativar(id);
		
		return new ResponseEntity<CampanhaProduto>(
						_campanhaProduto, HttpStatus.OK);
	}
}
