package br.itb.projeto.turismo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.turismo.model.entity.Informacoes;

	@Repository
	public interface InformacoesRepository extends JpaRepository<Informacoes, Long> {

}
