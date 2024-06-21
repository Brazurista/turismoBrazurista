package br.itb.projeto.turismo.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.turismo.model.entity.PontoRoteiro;
import br.itb.projeto.turismo.service.PontoRoteiroService;

@RestController
@RequestMapping("/pontoroteiro/")
public class PontoRoteiroController {

	private PontoRoteiroService pontoroteiroService;

	public PontoRoteiroController(PontoRoteiroService pontoroteiroService) {
		super();
		this.pontoroteiroService = pontoroteiroService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<PontoRoteiro>> findAll() {

		List<PontoRoteiro> pontoroteiro = pontoroteiroService.findAll();

		return new ResponseEntity<List<PontoRoteiro>>(pontoroteiro, HttpStatus.OK);

	}

	@PostMapping("create")
	public ResponseEntity<PontoRoteiro> create(@RequestBody PontoRoteiro pontoroteiro) {

		PontoRoteiro _pontoroteiro = pontoroteiroService.create(pontoroteiro);

		return new ResponseEntity<PontoRoteiro>(_pontoroteiro, HttpStatus.OK);

	}

	// @PutMapping("update/{id}")
	// public ResponseEntity<PontoRoteiro> update(@PathVariable long id) {

	// PontoRoteiro _PontoRoteiro = PontoRoteiroService.update(id);

	// return new ResponseEntity<PontoRoteiro>(_PontoRoteiro, HttpStatus.OK);
	// }

	// @PutMapping("reativar/{id}")
	// public ResponseEntity<Usuario> reativarSenha(@PathVariable long id,
	// @RequestBody Usuario usuario) {
	// Usuario _usuario = usuarioService.reativar(id);
	// return new ResponseEntity<Usuario>(_usuario, HttpStatus.OK);
	// }

}
