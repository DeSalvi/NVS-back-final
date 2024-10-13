package br.itb.projeto.newvision.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.itb.projeto.newvision.model.entity.Produto;
import br.itb.projeto.newvision.rest.response.MessageResponse;
import br.itb.projeto.newvision.service.ProdutoService;

@RestController
@RequestMapping("/produto/")
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtos = produtoService.findAll();

		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id) {

		Produto produto = produtoService.findById(id);

		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Produto> create(
			@RequestBody Produto produto) {

		Produto _produto = produtoService.create(produto);

		return new ResponseEntity<Produto>(
				_produto, HttpStatus.OK);
	}
	
	@PostMapping("createComFoto")
	public ResponseEntity<?> createComFoto(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute("produto") Produto produto) {

		produtoService.createComFoto(file, produto);

		return ResponseEntity.ok()
				.body(new MessageResponse("Produto cadastrado com sucesso!"));
	}
	
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Produto> inativar(
			@PathVariable long id) {
		
		Produto _produto = produtoService.inativar(id);
		
		return new ResponseEntity<Produto>(
						_produto, HttpStatus.OK);
	}
	
	@PutMapping("alterar/{id}")
	public ResponseEntity<?> alterar(@PathVariable long id,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute("produto") Produto produto) {

		produtoService.alterar(file, id, produto);

		return ResponseEntity.ok()
				.body(new MessageResponse("Produto alterado com sucesso!"));
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<Produto> reativar(
			@PathVariable long id) {
		
		Produto _produto = produtoService.reativar(id);
		
		return new ResponseEntity<Produto>(
						_produto, HttpStatus.OK);
	}

}


