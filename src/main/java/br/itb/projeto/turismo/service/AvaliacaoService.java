package br.itb.projeto.turismo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.turismo.model.entity.Avaliacao;
import br.itb.projeto.turismo.model.repository.AvaliacaoRepository;
import jakarta.transaction.Transactional;

@Service
public class AvaliacaoService {

	private AvaliacaoRepository avaliacaoRepository;
	// Source -> Generate Constructor using Fields...

	public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
		super();
		this.avaliacaoRepository = avaliacaoRepository;
	}

	public List<Avaliacao> findAll() {
		List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
		return avaliacoes;
	}

	@Transactional
	public Avaliacao create(Avaliacao avaliacao) {
		avaliacao.setDataAvali(LocalDateTime.now());
		return avaliacaoRepository.save(avaliacao);
	}

	@Transactional
	public Avaliacao update(long id) {
		// java.util.Optional
		Optional<Avaliacao> _avaliacao = avaliacaoRepository.findById(id);
		if (_avaliacao.isPresent()) {
			Avaliacao avaliacaoAtualizada = _avaliacao.get();

			return avaliacaoRepository.save(avaliacaoAtualizada);

		}
		return null;
	}

}
