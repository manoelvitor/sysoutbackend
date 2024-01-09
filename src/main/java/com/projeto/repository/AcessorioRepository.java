package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.Acessorio;
import com.projeto.model.Categoria;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
	List<Acessorio> findByIdEmpresa(Long idEmpresa);
	Acessorio findByIdAndIdEmpresa(Long id, Long idEmpresa);
	@Query("SELECT a FROM Acessorio a WHERE a.idEmpresa = ?1	AND a.nome LIKE %?2% ")
	List<Acessorio> findByIdEmpresaAndNome(Long idEmpresa, String nome);
	
}
