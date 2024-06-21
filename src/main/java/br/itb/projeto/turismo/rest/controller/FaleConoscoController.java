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

import br.itb.projeto.turismo.model.entity.FaleConosco;
import br.itb.projeto.turismo.service.FaleConoscoService;

@RestController
@RequestMapping("/faleConosco/")
public class FaleConoscoController {

	private FaleConoscoService faleconoscoService;
	// Source -> Generate Constructor using Fields...

	public FaleConoscoController(FaleConoscoService faleconoscoService) {
		super();
		this.faleconoscoService = faleconoscoService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<FaleConosco>> findAll() {
		List<FaleConosco> faleconosco = faleconoscoService.findAll();

		return new ResponseEntity<List<FaleConosco>>(faleconosco, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<FaleConosco> create(@RequestBody FaleConosco faleconosco) {

		FaleConosco _faleconosco = faleconoscoService.create(faleconosco);

		return new ResponseEntity<FaleConosco>(_faleconosco, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<FaleConosco> update(@PathVariable long id) {

		FaleConosco _faleconosco = faleconoscoService.update(id);

		return new ResponseEntity<FaleConosco>(_faleconosco, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<FaleConosco> inativar(@PathVariable long id) {

		FaleConosco _faleconosco = faleconoscoService.inativar(id);

		return new ResponseEntity<FaleConosco>(_faleconosco, HttpStatus.OK);
	}

}
