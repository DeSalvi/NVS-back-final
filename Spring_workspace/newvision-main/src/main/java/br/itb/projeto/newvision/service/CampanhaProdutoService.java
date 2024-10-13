package br.itb.projeto.newvision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import br.itb.projeto.newvision.model.entity.CampanhaProduto;
import br.itb.projeto.newvision.model.repository.CampanhaProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class CampanhaProdutoService {
	
	private CampanhaProdutoRepository campanhaProdutoRepository;

	public CampanhaProdutoService(CampanhaProdutoRepository campanhaProdutoRepository) {
		super();
		this.campanhaProdutoRepository = campanhaProdutoRepository;
	}
	
	public List<CampanhaProduto> findAll(){
		List<CampanhaProduto> campanhaProdutos = 
				campanhaProdutoRepository.findAll();
		return campanhaProdutos;
	}

	@Transactional
	public CampanhaProduto create(CampanhaProduto campanhaProduto) {
		
	
		campanhaProduto.setStatusCampanhaProduto("ATIVO");
		
		return campanhaProdutoRepository.save(campanhaProduto);
	}
	
	@Transactional
	public CampanhaProduto finalizar(long id) {

		Optional<CampanhaProduto> _campanhaProduto = campanhaProdutoRepository.findById(id);

		if (_campanhaProduto.isPresent()) {
			CampanhaProduto campanhaProdutoAtualizado = _campanhaProduto.get();
			campanhaProdutoAtualizado.setStatusCampanhaProduto("Finalizada");

			return campanhaProdutoRepository.save(campanhaProdutoAtualizado);
		}
		return null;
	}
	
	@Transactional
	public CampanhaProduto reativar(long id) {

		Optional<CampanhaProduto> _campanhaProduto = campanhaProdutoRepository.findById(id);

		if (_campanhaProduto.isPresent()) {
			CampanhaProduto campanhaProdutoAtualizado = _campanhaProduto.get();
			campanhaProdutoAtualizado.setStatusCampanhaProduto("ATIVO");

			return campanhaProdutoRepository.save(campanhaProdutoAtualizado);
		}
		return null;
	}
}
