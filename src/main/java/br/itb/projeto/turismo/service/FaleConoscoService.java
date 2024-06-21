package br.itb.projeto.turismo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.turismo.model.entity.FaleConosco;
import br.itb.projeto.turismo.model.repository.FaleConoscoRepository;
import jakarta.transaction.Transactional;

@Service
public class FaleConoscoService {

	private FaleConoscoRepository faleconoscoRepository;
	// Source -> Generate Constructor using Fields...

	public FaleConoscoService(FaleConoscoRepository faleconoscoRepository) {
		super();
		this.faleconoscoRepository = faleconoscoRepository;
	}

	public List<FaleConosco> findAll() {
		List<FaleConosco> faleconosco = faleconoscoRepository.findAll();
		return faleconosco;
	}

	@Transactional
	public FaleConosco create(FaleConosco faleconosco) {

		faleconosco.setDataMensagem(LocalDateTime.now());
		faleconosco.setStatusMensagem("ATIVO");

		return faleconoscoRepository.save(faleconosco);
	}

	@Transactional
	public FaleConosco update(long id) {
		// java.util.Optional
		Optional<FaleConosco> _faleconosco = faleconoscoRepository.findById(id);
		if (_faleconosco.isPresent()) {
			FaleConosco faleconoscoAtualizada = _faleconosco.get();
			faleconoscoAtualizada.setStatusMensagem("LIDA");

			return faleconoscoRepository.save(faleconoscoAtualizada);

		}
		return null;
	}

	@Transactional
	public FaleConosco inativar(long id) {
		// java.util.Optional
		Optional<FaleConosco> _faleconosco = faleconoscoRepository.findById(id);
		if (_faleconosco.isPresent()) {
			FaleConosco faleconoscoAtualizada = _faleconosco.get();
			faleconoscoAtualizada.setStatusMensagem("INATIVO");

			return faleconoscoRepository.save(faleconoscoAtualizada);
		}
		return null;
	}

}
