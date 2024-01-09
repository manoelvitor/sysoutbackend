package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Situacao;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
	List<Situacao> findByIdEmpresa(Long idEmpresa);
}
