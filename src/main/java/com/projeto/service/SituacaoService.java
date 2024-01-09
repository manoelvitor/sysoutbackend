package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Situacao;
import com.projeto.repository.SituacaoRepository;

@Service
public class SituacaoService implements ServiceInterface<Situacao> {


	@Autowired
	private SituacaoRepository repository;
	
	@Override
	public Situacao create(Situacao obj) {
		obj.setNome(obj.getNome().toUpperCase());
		return repository.save(obj);
	}

	@Override
	public Situacao findById(Long id) {
		Optional<Situacao> _Situacao = repository.findById(id);
		return _Situacao.orElse(null);
	}

	@Override
	public List<Situacao> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}

	@Override
	public boolean update(Situacao obj) {
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

}
