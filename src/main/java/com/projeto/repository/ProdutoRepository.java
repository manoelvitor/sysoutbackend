package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.Acessorio;
import com.projeto.model.Produto;
import com.projeto.model.Servico;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByIdEmpresa(Long idEmpresa);
	
	@Query("SELECT p FROM Produto p WHERE p.idEmpresa = ?1	AND p.nome LIKE %?2% ")
	List<Produto> findByIdEmpresaAndNome(Long idEmpresa, String nome);
	
	@Query("SELECT p FROM Produto p WHERE p.idEmpresa = ?1	AND p.categoria = ?2 ")
	List<Produto> findByCagoria(Long idEmpresa, String categoria);
	
	@Query("SELECT p FROM Produto p WHERE p.idEmpresa = ?1	AND p.nome LIKE %?2%  AND p.categoria LIKE %?3% ")
	List<Produto> findByIdEmpresaAndNomeAndCategoria(Long idEmpresa, String nome, String categoria);
	
	
	
}
