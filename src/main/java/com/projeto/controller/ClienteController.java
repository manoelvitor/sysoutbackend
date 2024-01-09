package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Acessorio;
import com.projeto.model.Cliente;
import com.projeto.model.Servico;
import com.projeto.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController implements ControllerInterface<Cliente> {

	@Autowired
	private ClienteService service;

	@Override
	@GetMapping("/empresa/{idEmpresa}")
	public ResponseEntity<List<Cliente>> getAll(@PathVariable("idEmpresa") Long idEmpresa) {
		return ResponseEntity.ok(service.findAll(idEmpresa));
	}
	
	@GetMapping("/empresa/{idEmpresa}/{nome}")
	public ResponseEntity<List<Cliente>> findByIdEmpresaAndNome(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("nome") String nome) {
		return ResponseEntity.ok(service.findByIdEmpresaAndNome(idEmpresa,nome));
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
	public ResponseEntity<Cliente> post(@RequestBody Cliente obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Cliente obj) {
		if (service.update(obj))
			return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel fazer a atualização");
	}

	@Override
	@DeleteMapping("{id}")
	public ResponseEntity<Cliente> delete(@PathVariable("id") Long id) {
		Cliente obj = service.findById(id);
		if (service.delete(id))
			return ResponseEntity.ok().body(obj);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
	}

}
