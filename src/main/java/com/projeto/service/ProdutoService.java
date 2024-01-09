package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Produto;
import com.projeto.repository.ProdutoRepository;

@Service
public class ProdutoService implements ServiceInterface<Produto> {

	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public Produto create(Produto obj) {
		obj.setNome(obj.getNome().toUpperCase());
		return repository.save(obj);
	}

	@Override
	public Produto findById(Long id) {
		Optional<Produto> _Produto = repository.findById(id);
		return _Produto.orElse(null);
	}

	@Override
	public List<Produto> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}

	@Override
	public boolean update(Produto obj) {
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
	
	public List<Produto> findByIdEmpresaAndNome(Long id, String nome){
		return repository.findByIdEmpresaAndNome(id,nome.toUpperCase());
	}
	
	public List<Produto> findByIdEmpresaAndNomeAndCategoria(Long id, String nome, String categoria){
		return repository.findByIdEmpresaAndNomeAndCategoria(id,nome.toUpperCase(),categoria.toUpperCase());
	}
	
	public List<Produto> findByIdEmpresaCategoria(Long id, String nome){
		return repository.findByCagoria(id,nome.toUpperCase());
	}



}
