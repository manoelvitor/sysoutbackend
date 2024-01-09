package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.InformacoesEmpresa;
import com.projeto.repository.InformacoesEmpresaRepository;

@Service
public class InformacoesEmpresaService implements ServiceInterface<InformacoesEmpresa> {


	@Autowired
	private InformacoesEmpresaRepository repository;
	
	@Override
	public InformacoesEmpresa create(InformacoesEmpresa obj) {
		return repository.save(obj);
	}

	@Override
	public InformacoesEmpresa findById(Long id) {
		Optional<InformacoesEmpresa> _InformacoesEmpresa = repository.findById(id);
		return _InformacoesEmpresa.orElse(null);
	}

	@Override
	public List<InformacoesEmpresa> findAll(Long id) {
		return repository.findAll();
	}

	@Override
	public boolean update(InformacoesEmpresa obj) {
		if(repository.existsById(obj.getId())){
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
