package br.itb.projeto.turismo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.turismo.model.entity.PontoInteresse;
import br.itb.projeto.turismo.model.repository.PontoInteresseRepository;
import jakarta.transaction.Transactional;

@Service
public class PontoInteresseService {

	private PontoInteresseRepository pontointeresseRepository;

	public PontoInteresseService(PontoInteresseRepository pontointeresseRepository) {
		super();
		this.pontointeresseRepository = pontointeresseRepository;
	}

	public List<PontoInteresse> findAll() {
		List<PontoInteresse> pontointeresse = pontointeresseRepository.findAll();

		return pontointeresse;
	}

	public PontoInteresse findbyId(long id) {
		PontoInteresse pontointeresse = pontointeresseRepository.findById(id).orElseThrow();
		return pontointeresse;
	}

	@Transactional
	public PontoInteresse create(PontoInteresse pontointeresse) {

		pontointeresse.setDataCriacao(LocalDateTime.now());

		return pontointeresseRepository.save(pontointeresse);
	}

	// @Transactional
	// public Usuario update(long id) {
	// java.util.Optional
	// Optional<Usuario> _usuario = usuarioRepository.findById(id);
	// if (_usuario.isPresent()) {
	// Usuario usuarioAtualizada = _usuario.get();
	// usuarioAtualizada.setStatusUsuario("LTDA");

	// return usuarioRepository.save(usuarioAtualizada);
	// }

}
