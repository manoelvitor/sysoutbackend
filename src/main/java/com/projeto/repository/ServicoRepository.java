package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
	List<Servico> findByIdEmpresa(Long idEmpresa);
	
    @Query("SELECT s FROM Servico s WHERE s.idEmpresa = ?1	AND s.nome LIKE %?2% ")
	List<Servico> findByIdEmpresaAndNome(Long idEmpresa, String nome);

}
