package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	List<Categoria> findByIdEmpresa(Long idEmpresa);

	@Query("SELECT c FROM Categoria c WHERE c.idEmpresa = ?1	AND c.nome LIKE %?2% ")
	List<Categoria> findByIdEmpresaAndNome(Long idEmpresa, String nome);
}
