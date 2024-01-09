package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.model.TipoPerfil;
import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;
import com.projeto.security.UserDetailsImpl;

@Service
public class UsuarioService implements ServiceInterface<Usuario> {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;

	public static UserDetailsImpl authenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return (UserDetailsImpl) auth.getPrincipal();
		}
		return null;
	}
	
	public Usuario createAdm(Usuario obj) {
		obj.setSenha(passwordEnconder.encode(obj.getSenha()));
		obj.addPerfil(TipoPerfil.ADMIN);
		obj.addPerfil(TipoPerfil.TECNICO);
		obj.setAdministrador(true);
		repository.save(obj);
		return obj;
	}

	@Override
	public Usuario create(Usuario obj) {
		obj.setSenha(passwordEnconder.encode(obj.getSenha()));
		obj.addPerfil(TipoPerfil.TECNICO);
		obj.setAdministrador(false);
		repository.save(obj);
		return obj;
	}

	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<Usuario> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}
	
	public boolean atualizarIdEmpresa(Long id, Long idEmpresa ) {
		if(repository.findById(id) != null) {
			Usuario obj = repository.findById(id).get();
			obj.setIdEmpresa(idEmpresa);
			repository.save(obj);
			return true;	
		}	
		return false;
	}
	
	public boolean atualizarDados(Long id, Usuario usuario ) {
		if(repository.findById(id) != null) {
			Usuario obj = repository.findById(id).get();
			if(usuario.getNome() != null) {
				obj.setNome(usuario.getNome());
			}
			if(usuario.getEmail() != null) {
				obj.setEmail(usuario.getEmail());
			}
			if(usuario.getLogin() != null) {
				obj.setLogin(usuario.getLogin());
			}
			if(usuario.getTelefone() != null) {
				obj.setTelefone(usuario.getTelefone());
			}
			if(usuario.getCpf() != null) {
				obj.setCpf(usuario.getCpf());
			}
			if(usuario.getRg() != null) {
				obj.setRg(usuario.getRg());
			}
			
			
			
			repository.save(obj);
			return true;	
		}	
		return false;
	}


	@Override
	public boolean update(Usuario obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
