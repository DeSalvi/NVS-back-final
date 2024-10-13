package br.itb.projeto.newvision.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.newvision.model.entity.Mensagem;
import br.itb.projeto.newvision.model.entity.Usuario;
import br.itb.projeto.newvision.model.repository.MensagemRepository;
import jakarta.transaction.Transactional;

@Service
public class MensagemService {

	private MensagemRepository mensagemRepository;

	public MensagemService(MensagemRepository mensagemRepository) {
		super();
		this.mensagemRepository = mensagemRepository;
	}
	
	public List<Mensagem> findAll(){
		List<Mensagem> mensagems = 
				mensagemRepository.findAll();
		return mensagems;
	}

	//jakarta.transaction.Transactional
	@Transactional
	public Mensagem create(Mensagem mensagem) {
		
		mensagem.setDataMensagem(LocalDateTime.now());
		mensagem.setStatusMensagem("ATIVO");
		
		return mensagemRepository.save(mensagem);
	}
	
	@Transactional
	public Mensagem update(long id) {
		
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("LIDA");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Mensagem inativar(long id) {
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("INATIVO");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Mensagem marcarComoLida(long id) {
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("LIDA");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}

	public Mensagem findById(long id) {
		Mensagem mensagem = mensagemRepository.findById(id).orElseThrow();

		return mensagem;
	}
	
}











