package br.itb.projeto.turismo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.itb.projeto.turismo.model.entity.PontoRoteiro;


public interface PontoRoteiroRepository extends JpaRepository<PontoRoteiro, Long> {

}
