package br.itb.projeto.newvision.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.newvision.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends
	 			    JpaRepository<Usuario, Long> {

	Usuario findByRe(String re);
	
}







