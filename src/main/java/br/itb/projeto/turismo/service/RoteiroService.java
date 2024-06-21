package br.itb.projeto.turismo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.turismo.model.entity.Roteiro;
import br.itb.projeto.turismo.model.repository.RoteiroRepository;
import jakarta.transaction.Transactional;

@Service
public class RoteiroService {

	private RoteiroRepository roteiroRepository;

	public RoteiroService(RoteiroRepository roteiroRepository) {
		super();
		this.roteiroRepository = roteiroRepository;
	}

	public List<Roteiro> findAll() {
		List<Roteiro> roteiro = roteiroRepository.findAll();

		return roteiro;
	}

	public Roteiro findbyId(long id) {
		Roteiro roteiro = roteiroRepository.findById(id).orElseThrow();
		return roteiro;
	}

	@Transactional
	public Roteiro create(Roteiro roteiro) {

		roteiro.setDataCriado(LocalDateTime.now());
		roteiro.setStatusRoteiro("ATIVO");

		return roteiroRepository.save(roteiro);
	}

	@Transactional
	public Roteiro update(long id) {
		// java.util.Optional
		Optional<Roteiro> _roteiro = roteiroRepository.findById(id);
		if (_roteiro.isPresent()) {
			Roteiro roteiroAtualizada = _roteiro.get();
			roteiroAtualizada.setStatusRoteiro("LTDA");

			return roteiroRepository.save(roteiroAtualizada);

		}
		return null;
	}

	@Transactional
	public Roteiro inativar(long id) {
		// java.util.Optional
		Optional<Roteiro> _roteiro = roteiroRepository.findById(id);
		if (_roteiro.isPresent()) {
			Roteiro roteiroAtualizada = _roteiro.get();
			roteiroAtualizada.setStatusRoteiro("INATIVO");

			return roteiroRepository.save(roteiroAtualizada);
		}

		return null;

	}

}
