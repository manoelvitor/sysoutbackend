package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Cliente;
import com.projeto.model.Servico;
import com.projeto.model.Cliente;
import com.projeto.repository.ClienteRepository;

@Service
public class ClienteService implements ServiceInterface<Cliente> {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente create(Cliente obj) {
		obj.setNome(obj.getNome().toUpperCase());
		return repository.save(obj);
	}

	@Override
	public Cliente findById(Long id) {
		Optional<Cliente> _Cliente = repository.findById(id);
		return _Cliente.orElse(null);
	}

	@Override
	public List<Cliente> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}

	@Override
	public boolean update(Cliente obj) {
		if(repository.existsById(obj.getId())) {
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
	
	public List<Cliente> findByIdEmpresaAndNome(Long id, String nome){
		return repository.findByIdEmpresaAndNome(id,nome.toUpperCase());
	}
	
	
}
