package br.itb.projeto.turismo.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.turismo.model.entity.Avaliacao;
import br.itb.projeto.turismo.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao/")
public class AvaliacaoController {

	private AvaliacaoService avaliacaoService;
	// Source -> Generate Constructor using Fields...

	public AvaliacaoController(AvaliacaoService avaliacaoService) {
		super();
		this.avaliacaoService = avaliacaoService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Avaliacao>> findAll() {
		List<Avaliacao> avaliacaos = avaliacaoService.findAll();

		return new ResponseEntity<List<Avaliacao>>(avaliacaos, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Avaliacao> create(@RequestBody Avaliacao avaliacao) {

		Avaliacao _avaliacao = avaliacaoService.create(avaliacao);

		return new ResponseEntity<Avaliacao>(_avaliacao, HttpStatus.OK);

	}
}
