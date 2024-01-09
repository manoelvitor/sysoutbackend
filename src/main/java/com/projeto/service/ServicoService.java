package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Servico;
import com.projeto.repository.ServicoRepository;

@Service
public class ServicoService implements ServiceInterface<Servico> {


	@Autowired
	private ServicoRepository repository;
	
	@Override
	public Servico create(Servico obj) {
		obj.setNome(obj.getNome().toUpperCase());
		System.out.println( "id " +obj.getId());
		System.out.println(obj.getNome());
		System.out.println(obj.getDescricao());
		System.out.println(obj.getValor());

		return repository.save(obj);
	}

	@Override
	public Servico findById(Long id) {
		Optional<Servico> _Servico = repository.findById(id);
		return _Servico.orElse(null);
	}

	@Override
	public List<Servico> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}

	@Override
	public boolean update(Servico obj) {
		System.out.println("aqui updte");
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
	
	public List<Servico> findByIdEmpresaAndNome(Long id, String nome){
		return repository.findByIdEmpresaAndNome(id,nome.toUpperCase());
	}

}
