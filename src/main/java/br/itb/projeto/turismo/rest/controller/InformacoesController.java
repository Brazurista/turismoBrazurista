package br.itb.projeto.turismo.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.turismo.model.entity.Informacoes;
import br.itb.projeto.turismo.service.InformacoesService;

@RestController
@RequestMapping("/informacoes/")
public class InformacoesController {
	
	private InformacoesService informacoesService;
	// Source -> Generate Constructor using Fields...

	public InformacoesController(InformacoesService informacoesService) {
		super();
		this.informacoesService = informacoesService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Informacoes>> findAll() {
		List<Informacoes> informacoes = informacoesService.findAll();

		return new ResponseEntity<List<Informacoes>>(informacoes, HttpStatus.OK);
	}
	
	

	
}
