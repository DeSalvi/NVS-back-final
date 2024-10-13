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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.newvision.model.entity.Usuario;
import br.itb.projeto.newvision.rest.exception.ResourceNotFoundException;
import br.itb.projeto.newvision.rest.response.MessageResponse;
import br.itb.projeto.newvision.service.UsuarioService;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	//Source -> Generate Constructor using Fields...

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	
	@GetMapping("findAll")
	public ResponseEntity<List<Usuario>> findAll(){
		
		List<Usuario> usuarios = 
				usuarioService.findAll();
		
		return new ResponseEntity<List<Usuario>>
						 (usuarios, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Usuario> findById(
			@PathVariable long id){
		
		Usuario usuario = 
				usuarioService.findById(id);
		
		return new ResponseEntity<Usuario>
					(usuario, HttpStatus.OK);	
	}
	
	@GetMapping("findByRe/{re}")
	public ResponseEntity<Usuario> findByRe(
			@PathVariable String re){
		
		Usuario usuario = 
				usuarioService.findByRe(re);
		
		return new ResponseEntity<Usuario>
					(usuario, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Usuario> create(
			@RequestBody Usuario usuario){
		
		Usuario _usuario = 
				usuarioService.createNew(usuario);
		
		return new ResponseEntity<Usuario>(
				_usuario, HttpStatus.OK);
	}
	/*
	@PostMapping("signin")
	public ResponseEntity<?> signin(
		 @RequestParam String re, 
		 @RequestParam String senha){  
		
	 Usuario usuario = usuarioService.signin(re, senha);
		if(usuario != null) {
			return ResponseEntity.ok().body(usuario);
		}
		return ResponseEntity.badRequest()
						.body("Dados incorretos!");
	}
	*/
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody Usuario usuario) {

		Usuario _usuario = usuarioService
				.signin(usuario.getRe(), usuario.getSenha());

		if (_usuario == null) {
			throw new ResourceNotFoundException("*** Dados Incorretos! *** ");
		}

		return ResponseEntity.ok(_usuario);
	}
	
	@PutMapping("alterar/{id}")
	public ResponseEntity<?> alterar(@PathVariable long id,
			@RequestBody Usuario usuario){
		
		Usuario _usuario = 
				usuarioService.alterar(id, usuario);
		
		return ResponseEntity.ok()
				.body(new MessageResponse("Usuário alterado com sucesso!"));
	}
	
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Usuario> inativar(
			@PathVariable long id) {
		
		Usuario _usuario = usuarioService.inativar(id);
		
		return new ResponseEntity<Usuario>(
						_usuario, HttpStatus.OK);
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<Usuario> reativar(
			@PathVariable long id) {
		
		Usuario _usuario = usuarioService.reativar(id);
		
		return new ResponseEntity<Usuario>(
						_usuario, HttpStatus.OK);
	}
	
	
	@PutMapping("alterarSenha/{id}")
	public ResponseEntity<?> alterarSenha(
			@PathVariable long id, @RequestBody Usuario usuario) {

		Usuario _usuario = usuarioService.alterarSenha(id, usuario);

		return ResponseEntity.ok()
				.body(new MessageResponse("Senha alterada com sucesso!"));
	}

}



