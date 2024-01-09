package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Categoria;
import com.projeto.model.Cliente;
import com.projeto.repository.CategoriaRepository;

@Service
public class CategoriaService implements ServiceInterface<Categoria> {


	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public Categoria create(Categoria obj) {
		obj.setNome(obj.getNome().toUpperCase());
		return repository.save(obj);
	}

	@Override
	public Categoria findById(Long id) {
		Optional<Categoria> _Categoria = repository.findById(id);
		return _Categoria.orElse(null);
	}

	@Override
	public List<Categoria> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}

	@Override
	public boolean update(Categoria obj) {
		if(repository.existsById(obj.getId())){
			obj.setNome(obj.getNome().toUpperCase());
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
	
	public List<Categoria> findByIdEmpresaAndNome(Long id, String nome){
		return repository.findByIdEmpresaAndNome(id,nome.toUpperCase());
	}

}
