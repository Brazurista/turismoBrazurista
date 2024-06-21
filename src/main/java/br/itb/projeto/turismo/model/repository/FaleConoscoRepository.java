package br.itb.projeto.turismo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.turismo.model.entity.FaleConosco;

@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConosco, Long> {

}
