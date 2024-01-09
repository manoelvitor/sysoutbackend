package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Produto;
import com.projeto.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController implements ControllerInterface<Produto> {
	
	@Autowired
	private ProdutoService service;

	@Override
	@GetMapping("/empresa/{idEmpresa}")
	public ResponseEntity<List<Produto>> getAll(@PathVariable("idEmpresa") Long idEmpresa) {
		return ResponseEntity.ok(service.findAll(idEmpresa));
	}
	
	@GetMapping("/empresa/{idEmpresa}/{nome}")
	public ResponseEntity<List<Produto>> findByIdEmpresaAndNome(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("nome") String nome) {
		return ResponseEntity.ok(service.findByIdEmpresaAndNome(idEmpresa,nome));
	}
	
	@GetMapping("/empresa/{idEmpresa}/{nome}/{categoria}")
	public ResponseEntity<List<Produto>> findByIdEmpresaAndNomeAndCategoria(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("nome") String nome,@PathVariable("categoria") String categoria) {
		return ResponseEntity.ok(service.findByIdEmpresaAndNomeAndCategoria(idEmpresa,nome,categoria));
	}
	
	@GetMapping("/empresa/{idEmpresa}/categoria/{categoria}")
	public ResponseEntity<List<Produto>> findByIdEmpresaAndCategoria(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("categoria") String categoria) {
		return ResponseEntity.ok(service.findByIdEmpresaCategoria(idEmpresa,categoria));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		if (service.findById(id) != null) {
			return ResponseEntity.ok(service.findById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Produto obj) {
		if (service.update(obj))
			
			return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel fazer a atualização");		
	}	

	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> delete(@PathVariable("id") Long id) {
		Produto obj =  service.findById(id);
		if (service.delete(id)) {
			return ResponseEntity.ok().body(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
	}

}
