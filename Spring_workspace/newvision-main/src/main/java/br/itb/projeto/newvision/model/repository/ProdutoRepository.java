package br.itb.projeto.newvision.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.newvision.model.entity.Produto;

@Repository
public interface ProdutoRepository 
	extends JpaRepository<Produto, Long> {
	
	List<Produto> findByStatusProd (String statusProd);}
