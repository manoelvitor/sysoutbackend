package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Usuario;
import com.projeto.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements ControllerInterface<Usuario>{

	@Autowired
    UsuarioService service;
	
    @PostMapping("/adm")
    public ResponseEntity<Usuario> postAdm(@RequestBody Usuario obj) {
        service.createAdm(obj);
        return ResponseEntity.ok(obj);
    }

    @Override
	@GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<Usuario>> getAll(@PathVariable("idEmpresa") Long idEmpresa) {
		return ResponseEntity.ok(service.findAll(idEmpresa));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Usuario _Usuario = service.findById(id);
        if(_Usuario != null) {
            return ResponseEntity.ok(_Usuario);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario obj) {
        service.create(obj);
        return ResponseEntity.ok(obj);
    }

    @Override
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Usuario obj) {
        if(service.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PutMapping("/atualiza/empresa/{idUsuario}/{idEmpresa}")
    public ResponseEntity<?> atualizaEmpresa(@PathVariable Long idUsuario, @PathVariable Long idEmpresa) {
    	 if(service.atualizarIdEmpresa(idUsuario,idEmpresa)) {
             return ResponseEntity.status(HttpStatus.CREATED).build();
         }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PutMapping("/atualiza/{idUsuario}")
    public ResponseEntity<?> atualizarDados(@PathVariable Long idUsuario, @RequestBody Usuario usuario) {
    	 if(service.atualizarDados(idUsuario,usuario)) {
             return ResponseEntity.status(HttpStatus.CREATED).build();
         }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @Override
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
    	Usuario obj = service.findById(id);
        if(service.delete(id)) {
            return ResponseEntity.ok().body(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
    }
}
