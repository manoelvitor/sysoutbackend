package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Acessorio;
import com.projeto.model.Categoria;
import com.projeto.repository.AcessorioRepository;

@Service
public class AcessorioService implements ServiceInterface<Acessorio> {


	@Autowired
	private AcessorioRepository repository;
	
	@Override
	public Acessorio create(Acessorio obj) {
		obj.setNome(obj.getNome().toUpperCase());
		return repository.save(obj);
	}

	@Override
	public Acessorio findById(Long id) {
		Optional<Acessorio> _Acessorio = repository.findById(id);
		return _Acessorio.orElse(null);
	}

	@Override
	public List<Acessorio> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}

	@Override
	public boolean update(Acessorio obj) {
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
	
	public List<Acessorio> findByIdEmpresaAndNome(Long id, String nome){
		return repository.findByIdEmpresaAndNome(id,nome.toUpperCase());
	}

}
