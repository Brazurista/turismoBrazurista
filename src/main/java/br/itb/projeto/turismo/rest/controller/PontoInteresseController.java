package br.itb.projeto.turismo.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.turismo.model.entity.PontoInteresse;
import br.itb.projeto.turismo.service.PontoInteresseService;

@RestController
@RequestMapping("/pontoInteresse/")
public class PontoInteresseController {

	private PontoInteresseService pontointeresseService;
	// Source -> Generate Constructor using Fields...

	public PontoInteresseController(PontoInteresseService pontointeresseService) {
		super();
		this.pontointeresseService = pontointeresseService;
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<PontoInteresse>> findAll() {

		List<PontoInteresse> pontointeresse = pontointeresseService.findAll();

		return new ResponseEntity<List<PontoInteresse>>(pontointeresse, HttpStatus.OK);

	}
	
	@PostMapping("create")
	public ResponseEntity<PontoInteresse> create(@RequestBody PontoInteresse pontointeresse) {

		PontoInteresse _pontointeresse = pontointeresseService.create (pontointeresse);

		return new ResponseEntity<PontoInteresse>(_pontointeresse, HttpStatus.OK);

	}
	
	//@PutMapping("update/{id}")
	//public ResponseEntity<PontoInteresse> update(@PathVariable long id) {

		//PontoInteresse _pontointeresse = pontointeresseService.update(id);

		//return new ResponseEntity<PontoInteresse>(_pontointeresse, HttpStatus.OK);
	//}
	
	//@PutMapping("reativar/{id}")
	//public ResponseEntity<Usuario> reativarSenha(@PathVariable long id, @RequestBody Usuario usuario) {
		//Usuario _usuario = usuarioService.reativar(id);
		//return new ResponseEntity<Usuario>(_usuario, HttpStatus.OK);
		//}
}
