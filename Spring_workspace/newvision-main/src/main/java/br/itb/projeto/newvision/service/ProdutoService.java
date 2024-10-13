package br.itb.projeto.newvision.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.itb.projeto.newvision.model.entity.Produto;
import br.itb.projeto.newvision.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> findAll(){
		List<Produto> produtos = produtoRepository.findByStatusProd("ATIVO");
		return produtos;
	}
	
	public Produto findById(long id) {
		
		Produto produto = produtoRepository
					.findById(id).orElseThrow();
		
		return produto;
	}
	
	@Transactional
	public Produto create(Produto produto) {
		
		produto.setUrlFoto(null);
		produto.setStatusProd("ATIVO");
		
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto createComFoto(MultipartFile file, Produto produto) {
		
		if (file != null && file.getSize() > 0) {
			try {
				produto.setFoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			produto.setFoto(null);
		}
		produto.setUrlFoto(null);
		produto.setStatusProd("ATIVO");
		
		return produtoRepository.save(produto);
	}
	
	
	@Transactional
	public Produto inativar(long id) {
		
		Optional<Produto> _produto = 
				produtoRepository.findById(id);
		
		if (_produto.isPresent()) {
			Produto produtoAtualizado = _produto.get();
			produtoAtualizado.setStatusProd("INATIVO");
			
			return produtoRepository.save(produtoAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Produto alterar(MultipartFile file, long id, Produto produto) {
		Optional<Produto> _produto = produtoRepository.findById(id);

		if (_produto.isPresent()) {
			
			Produto produtoAtualizado = _produto.get();
			produtoAtualizado.setPreco(produto.getPreco());
			produtoAtualizado.setCategoria(produto.getCategoria());
			produtoAtualizado.setNome(produto.getNome());
			produtoAtualizado.setDescricao(produto.getDescricao());
			
			if (file != null && file.getSize() > 0) {
				try {
					produtoAtualizado.setFoto(file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 

			return produtoRepository.save(produtoAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Produto reativar(long id) {

		Optional<Produto> _produto = produtoRepository.findById(id);

		if (_produto.isPresent()) {
			Produto produtoAtualizado = _produto.get();
			
			produtoAtualizado.setStatusProd("ATIVO");

			return produtoRepository.save(produtoAtualizado);
		}
		return null;
	}
	
}







