package br.itb.projeto.turismo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.turismo.model.entity.Informacoes;
import br.itb.projeto.turismo.model.repository.InformacoesRepository;

@Service
public class InformacoesService {

	private InformacoesRepository informacoesRepository;
	// Source -> Generate Constructor using Fields...
	
	public InformacoesService(InformacoesRepository informacoesRepository) {
		super();
		this.informacoesRepository = informacoesRepository;
	}
	
	public List<Informacoes> findAll() {
		List<Informacoes> informacoes = informacoesRepository.findAll();
		return informacoes;
	}
	
}
