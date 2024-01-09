package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.Cliente;
import com.projeto.model.Servico;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByIdEmpresa(Long idEmpresa);

	@Query("SELECT c FROM Cliente c WHERE c.idEmpresa = ?1	AND c.nome LIKE %?2% ")
	List<Cliente> findByIdEmpresaAndNome(Long idEmpresa, String nome);
}
