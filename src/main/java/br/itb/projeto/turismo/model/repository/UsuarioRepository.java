package br.itb.projeto.turismo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.turismo.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// FindAll select * from Usuario
	// FindBy, classe que vem antes é a tabela depois do By coloca o where

	Usuario findByEmail(String email);

}
