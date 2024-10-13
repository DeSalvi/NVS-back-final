package br.itb.projeto.newvision.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.newvision.model.entity.Campanha;
import br.itb.projeto.newvision.model.repository.CampanhaRepository;
import jakarta.transaction.Transactional;

@Service
public class CampanhaService {

	private CampanhaRepository campanhaRepository;

	public CampanhaService(CampanhaRepository campanhaRepository) {
		super();
		this.campanhaRepository = campanhaRepository;
	}
	
	public List<Campanha> findAll(){
		List<Campanha> campanhas = 
				campanhaRepository.findAll();
		return campanhas;
	}
	
	@Transactional
	public Campanha create(Campanha campanha) {
		
	
		campanha.setStatusCampanha("ATIVO");
		
		return campanhaRepository.save(campanha);
	}
	
	@Transactional
	public Campanha finalizar(long id) {

		Optional<Campanha> _campanha = campanhaRepository.findById(id);

		if (_campanha.isPresent()) {
			Campanha campanhaAtualizado = _campanha.get();
			campanhaAtualizado.setStatusCampanha("Finalizada");

			return campanhaRepository.save(campanhaAtualizado);
		}
		return null;
	}
	@Transactional
	public Campanha reativar(long id) {

		Optional<Campanha> _campanha = campanhaRepository.findById(id);

		if (_campanha.isPresent()) {
			Campanha campanhaAtualizado = _campanha.get();
			campanhaAtualizado.setStatusCampanha("ATIVO");

			return campanhaRepository.save(campanhaAtualizado);
		}
		return null;
	}
}
