package br.itb.projeto.newvision.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.newvision.model.entity.CampanhaProduto;

@Repository
public interface CampanhaProdutoRepository  extends
 							JpaRepository<CampanhaProduto, Long> {

}
