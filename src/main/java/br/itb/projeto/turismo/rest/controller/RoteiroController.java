package br.itb.projeto.turismo.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.turismo.model.entity.Roteiro;
import br.itb.projeto.turismo.service.RoteiroService;

@RestController
@RequestMapping("/roteiro/")
public class RoteiroController {

	private RoteiroService roteiroService;

	public RoteiroController(RoteiroService roteiroService) {
		super();
		this.roteiroService = roteiroService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Roteiro>> findAll() {

		List<Roteiro> roteiro = roteiroService.findAll();

		return new ResponseEntity<List<Roteiro>>(roteiro, HttpStatus.OK);

	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Roteiro> findById(@PathVariable long id) {

		Roteiro roteiro = roteiroService.findbyId(id);

		return new ResponseEntity<Roteiro>(roteiro, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Roteiro> create(@RequestBody Roteiro roteiro) {

		Roteiro _roteiro = roteiroService.create(roteiro);

		return new ResponseEntity<Roteiro>(_roteiro, HttpStatus.OK);

	}

	@PutMapping("update/{id}")
	public ResponseEntity<Roteiro> update(@PathVariable long id) {

		Roteiro _roteiro = roteiroService.update(id);

		return new ResponseEntity<Roteiro>(_roteiro, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<Roteiro> inativar(@PathVariable long id) {

		Roteiro _roteiro = roteiroService.inativar(id);

		return new ResponseEntity<Roteiro>(_roteiro, HttpStatus.OK);

	}

}
