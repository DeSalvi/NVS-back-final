package br.itb.projeto.newvision.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.newvision.model.entity.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}
