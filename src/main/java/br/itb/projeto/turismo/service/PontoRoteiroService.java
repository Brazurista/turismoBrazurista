package br.itb.projeto.turismo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.turismo.model.entity.PontoRoteiro;
import br.itb.projeto.turismo.model.repository.PontoRoteiroRepository;
import jakarta.transaction.Transactional;

@Service
public class PontoRoteiroService {

	private PontoRoteiroRepository pontoroteiroRepository;

	public PontoRoteiroService(PontoRoteiroRepository pontoroteiroRepository) {
		super();
		this.pontoroteiroRepository = pontoroteiroRepository;
	}

	public List<PontoRoteiro> findAll() {
		List<PontoRoteiro> pontoroteiro = pontoroteiroRepository.findAll();

		return pontoroteiro;
	}

	public PontoRoteiro findbyId(long id) {
		PontoRoteiro pontoroteiro = pontoroteiroRepository.findById(id).orElseThrow();
		return pontoroteiro;
	}

	@Transactional
	public PontoRoteiro create(PontoRoteiro pontoroteiro) {

		return pontoroteiroRepository.save(pontoroteiro);
	}

}
